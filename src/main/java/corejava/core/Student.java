package corejava.core;

import java.util.Comparator;

public class Student implements Comparator<Student> {

    private int sid;
    private String name;

    public Student(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.sid == student.sid;
    }


    public int getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o1.sid-o2.sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
