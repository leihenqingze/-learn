package sort;

import java.util.Arrays;

/**
 * 两路归并法--迭代方式
 */
public class IterateMergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        // 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        int k = 1;
        while (k < arr.length) {
            mergePass(arr, temp, k, arr.length);
            k = 2 * k;
        }
    }

    //MergePass方法负责将数组中的相邻的有k个元素的字序列进行归并
    private static void mergePass(int[] arr, int[] temp, int start, int end) {
        int i = 0;
        //从前往后,将2个长度为k的子序列合并为1个
        while (i < end - 2 * start + 1) {
            merge(arr, i, i + start - 1, i + 2 * start - 1, temp);
            i += 2 * start;
        }
        //这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
        if (i < end - start) {
            merge(arr, i, i + start - 1, end - 1, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

}