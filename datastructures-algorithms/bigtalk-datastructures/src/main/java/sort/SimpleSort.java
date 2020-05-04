package sort;

import java.util.Arrays;

/**
 * 普通交换算法
 * 不满足"两两比较相邻记录"，效率非常低。
 */
public class SimpleSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void sort(int[] numbers) {
        //最外层控制迭代,第二层控制比较和交换
        //i < numbers.length - 1,是因为numbers[numbers.length - 1]已经没有了后续元素可以比较了,已经是最大值了
        for (int i = 0; i < numbers.length - 1; i++) {
            //j = i + 1,与当前位置之后的所有元素进行比较
            //如果小于当前元素numbers[i]则进行交换
            //在迭代过程中,如果发生过交换,则后续元素的比较是和交换之后的元素进行比较的
            //最终的效果是将[i..numbers.length - 1)中最小的元素交换到当前位置
            //第二层循环主要是为了将最小元素交换到当前位置,但是在此过程中进行了很多不必要的交换
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    Utils.swap(numbers, i, j);
                }
            }
        }
    }

}
