package corejava.core;


public class Teacher implements Comparable<Teacher> {

    private int sid;
    private String name;

    public Teacher(int sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Teacher student = (Teacher) obj;
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
    public String toString() {
        return "Teacher{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Teacher o) {
        return -(this.sid - o.sid);
    }
}
