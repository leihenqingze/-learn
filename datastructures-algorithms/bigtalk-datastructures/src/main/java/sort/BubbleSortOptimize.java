package sort;

import java.util.Arrays;

/**
 * 冒泡算法-优化比较次数
 * 避免因已经有序的情况下的无意义循环判断。
 */
public class BubbleSortOptimize {

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] numbers) {
        //如果为true表示发生过交换就需要继续排序,如果为false表示已经是有序状态了
        boolean flag = true;
        /* 若flag为true则退出循环 */
        for (int i = 0; i < numbers.length - 1 && flag; i++) {
            /* 初始为false */
            flag = false;
            for (int j = numbers.length - 2; j >= i; j--) {
                if (numbers[j] > numbers[j + 1]) {
                    Utils.swap(numbers, j, j + 1);
                    /* 如果有数据交换,则flag为true */
                    flag = true;
                }
            }
        }
    }

}