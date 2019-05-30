package dataStructure.map;

import java.util.LinkedList;

public class TestMap {

    LinkedList<People>[] peopleArr = new LinkedList[100];

    public static void main(String[] ljk) {
        /*
          HashMap
          解决Hash冲突的方法：
          开放地址法     -》    线性探测法、二次探测法、再Hash法、链地址法
          本案例使用链地址法
         */
        People people1 = new People("ljk18",18);
        People people2 = new People("ljk19",19);
        People people3 = new People("ljk20",20);
        People people4 = new People("ljk21",21);
        People people5 = new People("ljk22",22);
        People people6 = new People("ljk23",23);
        
    }

    public void pub(int key,People people){
        int hashCode = getHash(people.getAge());
    }

    public int getHash(int age) {
        return age % 100;
    }
}
