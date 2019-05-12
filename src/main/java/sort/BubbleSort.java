package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] ljk) {
        int[] arr = new int[]{5, 8, 4, 6, 21, 1, 8, 7, 5, 9, 6, 3, 45, 2};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.print(Arrays.toString(arr));
    }

    /**
     * @param arr 需要排序的数组
     */
    private static void bubbleSort(int[] arr) {
        //控制比较多少轮
        for (int i = 0; i < arr.length - 1; i++) {
            //控制比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
