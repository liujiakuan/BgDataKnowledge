package program.serializable;

public class Employee implements java.io.Serializable {
    public String name;
    String address;
    //transient 修饰的变量不能被序列化
    transient int SSN;
    int number;

    void mailCheck() {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}