package sort;

import java.util.Arrays;

/**
 * 冒泡算法
 * 两两比较相邻记录的关键字，如果反序则交换，直到没有反序的记录为止。
 * 与普通交换算法相比减少了不必要的交换，但是没有减少不必要的比较。
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            /* 注意j是从后往前循环 */
            for (int j = numbers.length - 2; j >= i; j--) {
                /* 注意与普通交换排序的区别 */
                if (numbers[j] > numbers[j + 1]) {
                    Utils.swap(numbers, j, j + 1);
                }
            }
        }
    }

}