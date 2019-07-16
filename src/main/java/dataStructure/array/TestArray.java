package dataStructure.array;


import org.apache.log4j.Logger;

import java.util.Arrays;

public class TestArray {
    private static Logger logger = Logger.getLogger(TestArray.class);

    public static void main(String[] ljk) {
        int[] arr = new int[]{1, 2, 3, 6, 5, 4};
        int[] arrAdd = add(arr, 7);
        System.out.println(Arrays.toString(arr));
        System.out.println("数组添加一个元素：" + Arrays.toString(arrAdd));
        int[] arrDelete = delete(arrAdd, 13);
        System.out.println("数组删除一个元素：" + Arrays.toString(arrDelete));
    }

    /**
     * 数组添加元素
     * 数组是连续存储空间，数组添加元素即是新建一个数组，放旧数组的值，然后添加上新数组的值
     */
    private static int[] add(int[] arr, int value) {
        int[] arrNew = new int[arr.length + 1];
        int[] arrNew2 = new int[arr.length + 1];
        //实现方式一
        for (int i = 0; i < arr.length; i++) {
            arrNew[i] = arr[i];
        }
        //实现方式二
        System.arraycopy(arr, 0, arrNew2, 0, arr.length);
        arrNew2[arr.length] = value;

        arrNew[arr.length] = value;
        return arrNew2;
    }

    /**
     * 数组删除元素
     * 数组是连续存储空间，数组删除元素即是新建一个数组，放旧数组的值去除指定值
     */
    private static int[] delete(int[] arr, int index) {
        if (index >= arr.length || index < 1) {
            logger.info("index is error please check it.");
            //当输入删除索引位置错误，默认删除数组最后一个
            index = arr.length;
        }
        if (0 == arr.length) {
            logger.info("the origin array is null.");
            return null;
        }
        int[] arrNew = new int[arr.length - 1];
        for (int i = 0; i < arrNew.length; i++) {
            if (i < index) {
                arrNew[i] = arr[i];
            } else {
                arrNew[i] = arr[i + 1];
            }
        }
        return arrNew;
    }
}
