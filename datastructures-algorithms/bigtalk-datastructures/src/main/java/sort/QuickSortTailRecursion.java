package sort;

import java.util.Arrays;

/**
 * 快速排序-尾递归-减少递归操作
 */
public class QuickSortTailRecursion {

    private static final int MAX_LENGTH_INSERT_SORT = 7;

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        //当前待排序的序列最小下标值bow和最大下标值high
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] numbers, int low, int high) {
        int pivot;
        if ((high - low) > MAX_LENGTH_INSERT_SORT) {
            while (low < high) {
                /*算出枢轴值*/
                pivot = partition(numbers, low, high);
                /*对低子表递归排序*/
                sort(numbers, low, pivot - 1);
                /*尾递归*/
                low = pivot + 1;
            }
        } else {
            InsertSort.sort(numbers);
        }
    }

    /*交换顺序表numbers中子表的记录,使枢轴记录到位,并返回其所在位置./
	/*此时在它之前(后)的记录均不大(小)于它。*/
    private static int partition(int[] numbers, int low, int high) {
        /*用子表的第一个记录作枢轴记录*/
        int pivotkey = numbers[low];
        /*从表的两端交替向中间扫描*/
        while (low < high) {
            /*将比枢轴记录小的记录交换到低端*/
            while (low < high && numbers[high] >= pivotkey) {
                high--;
            }
            Utils.swap(numbers, low, high);
            /*将比枢轴记录大的记录交换到高端*/
            while (low < high && numbers[low] <= pivotkey) {
                low++;
            }
            Utils.swap(numbers, low, high);
        }
        /*返回枢轴所在位置*/
        return low;
    }

}