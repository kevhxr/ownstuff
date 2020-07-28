package corejava.core;

import corejava.JVM.loadorder.Animal;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Animal animal = new Animal();
        //任何一个类都有一个隐含的静态成员变量class
        Class class1 = Animal.class;

        Class class2 = animal.getClass();

        Class class3 = Class.forName("corejava.JVM.loadorder.Animal");
        Object o = class1.newInstance();
        System.out.println(o.getClass() == class1);

        //一个类只可能是Class；类的一个实例对象
        System.out.println(class1 == class2 && class2 == class3);

    }
}
