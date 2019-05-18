package dataStructure.recursion;

public class Febonacci {
    public static void main(String[] ljk) {
        System.out.println(new Febonacci().printFebonacci(5));
    }

    /**
     * 斐波那契数列
     */
    private int printFebonacci(int index) {
        if (1 == index || 2 == index) {
            return 1;
        } else {
            return printFebonacci(index - 1) + printFebonacci(index - 2);
        }
    }
}
