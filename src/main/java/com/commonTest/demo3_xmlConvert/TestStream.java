package com.commonTest.demo3_xmlConvert;

import com.thoughtworks.xstream.XStream;

/**
 * Desc:
 * Created by lf on 2017/2/21
 */
public class TestStream {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("rojer");
        person.setPhoneNuber(999);
        Address address1 = new Address();
        address1.setHouseNo(888);
        address1.setStreet("newyork");
        Address address2 = new Address();
        address2.setHouseNo(76767);
        address2.setStreet("toyo");
        person.getAddresses().add(address1);
        person.getAddresses().add(address2);

        String res=toXML(person);
//        toEntity(res);
    }

    public static void toEntity(String inputXML){
        XStream xs = new XStream();
//        这句和@XStreamAlias("person")等效
//        xs.alias("person",Person.class);
//        xs.alias("address",Address.class);
        xs.setMode(XStream.NO_REFERENCES);
//      这句和@XStreamImplicit()等效
//        xs.addImplicitCollection(Person.class,"addresses");
//        这句和@XStreamAsAttribute()
//        xs.useAttributeFor(Person.class, "name");
        //注册使用了注解的VO
        xs.processAnnotations(new Class[]{Person.class,Address.class});
        Person person = (Person)xs.fromXML(inputXML);
        System.out.println(person.getAddresses().get(0).getHouseNo()+person.getName());



    }

    public static <T extends Object> String toXML(T t){
        XStream xStream = new XStream();

//        Person person = new Person();
//        person.setName("rojer");
//        person.setPhoneNuber(999);
//        Address address1 = new Address();
//        address1.setHouseNo(888);
//        address1.setStreet("newyork");
//        Address address2 = new Address();
//        address2.setHouseNo(76767);
//        address2.setStreet("toyo");
//        person.getAddresses().add(address1);
//        person.getAddresses().add(address2);

//        xStream.alias("person", Person.class);
//        xStream.alias("address",Address.class);
//        xStream.setMode(XStream.NO_REFERENCES);
//        xStream.addImplicitCollection(Person.class, "addresses");
//        xStream.useAttributeFor(Person.class,"name");
        //注册使用了注解的VO
        xStream.processAnnotations(new Class[]{Person.class,Address.class});
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+xStream.toXML(t);

        System.out.println(xml);
        return xml;
    }

}
