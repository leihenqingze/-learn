package sort;

/**
 * 排序相关公共方法
 */
public class Utils {

    /**
     * 交换数组中两个元素的位置
     *
     * @param numbers 集合
     * @param left    待交换元素
     * @param right   待交换元素
     */
    public static void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

}