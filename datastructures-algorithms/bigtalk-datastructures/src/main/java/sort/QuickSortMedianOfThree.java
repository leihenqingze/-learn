package sort;

import java.util.Arrays;

/**
 * 快速排序-三数取中法-优化选取枢轴
 */
public class QuickSortMedianOfThree {

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        //当前待排序的序列最小下标值bow和最大下标值high
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] numbers, int low, int high) {
        int pivot;
        if (low < high) {
            /*拆分,算出枢轴值*/
            pivot = partition(numbers, low, high);
            sort(numbers, low, pivot - 1);
            sort(numbers, pivot + 1, high);
        }
    }

    /*交换顺序表numbers中子表的记录,使枢轴记录到位,并返回其所在位置./
	/*此时在它之前(后)的记录均不大(小)于它。*/
    private static int partition(int[] numbers, int low, int high) {
        int pivotkey = pivotkey(numbers, low, high);
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

    /**
     * 三取中数法
     */
    private static int pivotkey(int[] numbers, int low, int high) {
        /*计算数组中间的元素的下标*/
        int m = low + (high - low) / 2;
        /*交换左端与右端数据,保证左端较小*/
        if (numbers[low] > numbers[high]) {
            Utils.swap(numbers, low, high);
        }
        /*交换中间与右端数据,保证中间较小*/
        if (numbers[m] > numbers[high]) {
            Utils.swap(numbers, m, high);
        }
        /*交换中间与左端数据,保证左端较小*/
        if (numbers[m] > numbers[low]) {
            Utils.swap(numbers, m, low);
        }
        /*用子表的第一个记录作枢轴记录*/
        return numbers[low];
    }

}