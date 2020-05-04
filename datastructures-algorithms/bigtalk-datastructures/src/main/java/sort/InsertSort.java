package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 将一个记录插入到已经排好序的有序表中，从而得到一个新的、记录数增1的有序表。
 * 比冒泡、简单选择排序的性能要好一些。
 * 可以通过哨兵模式优化比较。
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sort(int[] numbers) {
        int i, j, sentinel;
        //从第二个元素开始排序,每次之后,i之前的元素一定是有序的
        //每次在有序的列表中找到位置,向后移动大于该元素的数据,插入该元素
        for (i = 1; i < numbers.length; i++) {
            /* 需要将 numbers[i] 插入有序子表*/
            if (numbers[i] < numbers[i - 1]) {
                sentinel = numbers[i];
                for (j = i - 1; j > -1 && numbers[j] > sentinel; j--) {
                    /*记录后移*/
                    numbers[j + 1] = numbers[j];
                }
                /*插入到正确位置*/
                numbers[j + 1] = sentinel;
            }
        }
    }

}