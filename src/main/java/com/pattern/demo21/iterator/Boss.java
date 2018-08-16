package com.pattern.demo21.iterator;

/**
 * @author jinx
 * @date 2018/08/06 21:49
 * Desc:迭代器模式
 */
public class Boss {
    public static void main(String[] args) {
        IProject iProject = new Project();
        iProject.add("星球大战", 10, 100);
        iProject.add("jax", 100, 1000);
        for (int i = 3; i < 100; i++) {
            iProject.add("第" + i + "个项目", 100, 1000);
        }

        IProjectIterator iterator = iProject.iterator();
        while (iterator.hasNext()){
            IProject project = (IProject) iterator.next();
            System.out.println(project.getProjectInfo());
        }
    }
}
