package corejava.designmodel.cglib;

public class Person {
    private Integer pid;
    private String name;

    public Person(Integer pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
