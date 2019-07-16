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
        People people1 = new People("ljk180", 18);
        People people2 = new People("ljk190", 19);
        People people3 = new People("ljk200", 20);
        People people4 = new People("ljk210", 21);
        People people5 = new People("ljk220", 22);
        People people6 = new People("ljk230", 23);
        People people7 = new People("ljk280", 28);
        TestMap testMap = new TestMap();
        testMap.put(180, people1);
        testMap.put(190, people2);
        testMap.put(200, people3);
        testMap.put(210, people4);
        testMap.put(220, people5);
        testMap.put(230, people6);
        testMap.put(280, people7);
        if (testMap.get(280) != null) {
            System.out.println(testMap.get(280).toString());
        }
    }

    private void put(int key, People people) {
        int hashCode = getHash(key);
        if (peopleArr[hashCode] == null) {
            peopleArr[hashCode] = new LinkedList<>();
        }
        peopleArr[hashCode].add(people);
    }

    private LinkedList<People> get(int key) {
        int arrKey = getHash(key);
        if (peopleArr[arrKey] == null) {
            return null;
        }
        return peopleArr[arrKey];
    }

    private int getHash(int age) {
        return age % 100;
    }
}
