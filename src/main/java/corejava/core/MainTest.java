package corejava.core;

import java.util.*;

public class MainTest {
    public static void main(String[] args) {


        TreeMap<Student, String> map2 = new TreeMap<>(new Student(3, "sd"));
        TreeMap<Student, String> map = new TreeMap<>((o1, o2) ->
        {System.out.print("hey"+o1.getSid()+" "+o2.getSid()+",");return o1.getSid() - o2.getSid();});
        TreeMap<Teacher, String> mapComparable = new TreeMap<>();


        Student s1 = new Student(1, "kevin");
        Student s2 = new Student(2, "kevin");
        Student s3 = new Student(3, "www");
        Student s4 = new Student(4, "www4");
        Student s5 = new Student(5, "555");
        Student s6 = new Student(6, "666");
        Student s7 = new Student(7, "777");

        Teacher t1 = new Teacher(1, "kevin");
        Teacher t2 = new Teacher(2, "kevin");
        Teacher t3 = new Teacher(3, "www");

        map.put(s3, s3.getName());
        System.out.println();
        map.put(s2, s2.getName());
        System.out.println();
        map.put(s4, s4.getName());
        System.out.println();
        map.put(s5, s5.getName());
        System.out.println();
        map.put(s6, s6.getName());
        System.out.println();
        map.put(s7, s7.getName());
        System.out.println();
        map.put(s1, s1.getName());
        System.out.println();


        System.out.println("==============treeset=============");
        TreeSet<Teacher> set = new TreeSet<>();
        set.add(new Teacher(1,"sd"));
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(t3);
        teacherList.add(t3);
        teacherList.add(t2);
        teacherList.add(t1);
        List<Student> studentList = new ArrayList<>();
        studentList.add(s3);
        studentList.add(s3);
        studentList.add(s2);
        studentList.add(s1);
        TreeSet<Student> set2 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSid()-o2.getSid();
            }
        });
        set2.addAll(studentList);
        set2.stream().forEach(a-> System.out.println(a.getSid()));
        System.out.println("==============treeset=============");

        mapComparable.put(t3, t3.getName());
        mapComparable.put(t1, t1.getName());
        mapComparable.put(t2, t2.getName());

        mapComparable.entrySet().stream().forEach(a -> {
            System.out.println(a.getKey() + "  " + a.getValue());
        });

        System.out.println("===========");
        map.entrySet().stream().forEach(a -> {
            System.out.println(a.getKey() + "  " + a.getValue());
        });

        System.out.println("===========");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
