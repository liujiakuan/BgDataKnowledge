package dataStructure.recursion;

public class Hanoi {
    public static void main(String[] ljk) {
        hanoiFunc(2, 'a', 'b', 'c');
    }

    /**
     * 汉诺塔问题可以看为两种情况
     * 只有一个盘子的情况和多个盘子的情况
     * n:共有n个盘子
     * from:开始的柱子
     * in:中间的柱子
     * to:目标柱子
     */
    private static void hanoiFunc(int n, char from, char in, char to) {
        //只有一个盘子的情况
        if (1 == n) {
            System.out.println("第1个盘子从" + from + "移动到" + to);
        } else {
            //无论有多少盘子，都认为只有两个。上面所有盘子和最下面一个盘子
            //移动上面所有盘子到中间
            hanoiFunc(n - 1, from, to, in);
            //移动下面盘子
            System.out.println("第" + n + "个盘子从" + from + "移动到" + to);
            //把上面所有盘子从中间位置移动到目标位置
            hanoiFunc(n - 1, in, from, to);
        }
    }
}
