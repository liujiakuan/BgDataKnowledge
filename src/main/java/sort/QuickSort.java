package sort;

public class QuickSort {
    public static void main(String[] ljk) {
        int[] arr = new int[]{1, 2, 3, 6, 5, 4, 7, 8, 9, 12, 11, 10};
        System.out.println("排序前");
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println("\n排序后");
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //把数组中的第0个元素作为标准数
            int strand = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                //右边数字比标准数大则下标向前移动
                while (low < high && strand <= arr[high]) {
                    high--;
                }
                //使用右边的数字替换左边的数字
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low < high && arr[low] <= strand) {
                    low++;
                }
                arr[high] = arr[low];
            }
            //把标准数赋给低或者高所在位置的元素
            arr[low] = strand;
            //处理所有小的数字
            quickSort(arr, start, low);
            //处理所有大的数字
            quickSort(arr, low + 1, end);
        }
    }
}
