package sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] numbers) {
        int i, j, increment = numbers.length - 1, sentinel;
        do {
            /*增量序列*/
            increment = increment / 3 + 1;
            for (i = increment; i < numbers.length; i++) {
                /* 需要将 numbers[i] 插入有序子表*/
                if (numbers[i] < numbers[i - increment]) {
                    sentinel = numbers[i];
                    for (j = i - increment; j > -1 && numbers[j] > sentinel; j -= increment) {
                        /*记录后移*/
                        numbers[j + increment] = numbers[j];
                    }
                    /*插入到正确位置*/
                    numbers[j + increment] = sentinel;
                }
            }

        } while (increment > 1);
    }

}