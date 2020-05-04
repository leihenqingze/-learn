package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每一趟选取最小的记录作为有序序列的第i个记录。
 * 冒泡排序的思想就是不断地在交换，通过交换完成最终的排序，性能上略优于冒泡排序。
 * 最大的特点就是交换移动数据次数相当少，这样也就节约了相应的时间。
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] numbers) {
        int min;
        for (int i = 0; i < numbers.length - 1; i++) {
            min = getMinIndex(numbers, i);
            if (i != min) {
                Utils.swap(numbers, i, min);
            }
        }
    }

    /**
     * 获取最小值的下标
     */
    private static int getMinIndex(int[] numbers, int start) {
        int min = start;
        for (int j = start + 1; j < numbers.length; j++) {
            if (numbers[min] > numbers[j]) {
                min = j;
            }
        }
        return min;
    }

}