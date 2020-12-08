package com.audition.demo5;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: fans
 * @Date: 2020/12/9 00:49
 * @Desc: 请重构该类
 */
@Slf4j
public class Refactor {

    public static void main(String[] args) {
        List<Group> groups = Lists.newArrayList();
        for (int j = 0; j < 10; j++) {
            Group group = new Group();
            group.setGroupName(String.valueOf(j));
            if (j % 2 == 0) {
                group.setGroupName("SPECIAL");
            }

            List<Person> list = Lists.newArrayList();
            for (int i = 0; i < 10; i++) {
                Person p = new Person();
                p.setName(String.valueOf(i));
                p.setNickName(String.valueOf(i * 2));
                p.setFamilyName(String.valueOf(i * 3));
                if (i % 2 == 0) {
                    p.setFamilyName("PETER");
                }
                list.add(p);
            }
            group.setPersons(list);
            groups.add(group);
        }

        List<Person> result = getNotSpecialPersons(groups);
        log.info("result.size():{}",result.size());
        for (Person person : result) {
            log.info("person:{}", person.toString());
        }
    }

    public static List<Person> getNotSpecialPersons(List<Group> groups) {
        Map<String,List<Group>> map = groups.parallelStream().collect(Collectors.groupingBy(s->s.getGroupName())).entrySet().stream().filter(s->!s.getKey().equals("SPECIAL")).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        List<Group> groupList = map.values().parallelStream().flatMap(Collection::stream).collect(Collectors.toList());
        List<List<Person>> personList = groupList.stream().map(a->a.getPersons()).collect(Collectors.toList());
        List<Person> result = personList.stream().flatMap(Collection::stream).collect(Collectors.toList()).stream().filter(p->p.getFamilyName().equals("PETER")).collect(Collectors.toList());
        result.subList(0,result.size()>20?19:result.size());
        return result;
    }

   /* @Builder
    public class Group {
        private String groupName;
        private List<Person> persons;


    }

    @Getter
    @Builder
    public class Person {
        private String name;
        private String nickName;
        private String familyName;
    }

    public interface GroupMapper {
        List<Group> getGroups(int size, int page);
    }

    private GroupMapper groupMapper;*/

    // 取20个非special分组下姓PETER的人员列表
   /* public List<Person> getNotSpecialPersons() {
        List<Person> results = new ArrayList<>();
        int pageNumber = 0;
        try {
            while (results.size() < 21) {
                List<Group> expandTagPosList = groupMapper.getGroups(10, pageNumber);
                if (expandTagPosList != null && expandTagPosList.size() > 0) {
                    for (int i = 0; i < expandTagPosList.size(); i++) {
                        if (expandTagPosList.get(i).getGroupName().contains("spacial")) {
                            System.out.println();
                        } else {
                            List<Person> persons = expandTagPosList.get(i).getPersons();
                            for (int j = 0; j < persons.size(); j++) {
                                if (persons.get(j).getFamilyName().equals("PETER")) {
                                    results.add(persons.get(j));
                                }
                            }
                        }
                    }
                }
                pageNumber++;
            }

        } catch (Exception e) {
            log.error("sth bad happened");
        }
        return results;
    }*/
}
