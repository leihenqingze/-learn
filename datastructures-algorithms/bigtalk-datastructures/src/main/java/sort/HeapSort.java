package sort;

import java.util.Arrays;

/**
 * 堆排序
 * 利用了树的性质5
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{50, 10, 90, 30, 70, 40, 80, 60, 20};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] numbers) {
        /* 之所以从numbers.length / 2 - 1开始,是因为numbers.length / 2 - 1前的结点都有子结点 */
        /* 从最后一个非叶子结点构建堆,则对于其父结点来说其子结点已经是堆了 */
        for (int i = numbers.length / 2 - 1; i > -1; i--) {
            heapAdjust(numbers, i, numbers.length - 1);
        }

        for (int i = numbers.length - 1; i > 0; i--) {
            Utils.swap(numbers, 0, i);
            heapAdjust(numbers, 0, i - 1);
        }
    }

    /*已知numbers[start..end]中记录的关键字numbers[start]之外均满足堆的定义*/
    /*本函数调整numbers[start]的关键子,使numbers[start..end]成为一个大顶堆*/
    static void heapAdjust(int[] numbers, int start, int end) {
        int temp = numbers[start];
        /*沿关键字较大的孩子结点向下筛选*/
        for (int j = (2 * start + 1); j <= end; j *= 2 + 1) {
            if (j < end && numbers[j] < numbers[j + 1])
                /*j为关键字中较大的记录的下标*/
                ++j;
            if (temp >= numbers[j])
                break;
            /*如果当前结点小于孩子结点则将孩子结点交换到当前结点的位置*/
            numbers[start] = numbers[j];
            start = j;
        }
        /*当numbers[start]的孩子结点调整完成之后,将其插入*/
        numbers[start] = temp;
    }

}