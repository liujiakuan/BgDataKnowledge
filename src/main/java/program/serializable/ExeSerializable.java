package program.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ExeSerializable {
    public static void main(String[] ljk) {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\AAAAAAASoft\\IDEA\\BgDataKnowledge\\src\\main\\java\\program\\serializable\\Employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(e);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.print("D:\\AAAAAAASoft\\IDEA\\BgDataKnowledge\\src\\main\\java\\program\\serializable\\Employee.ser");
        } catch (IOException exeception) {
            exeception.printStackTrace();
        }
    }
}
