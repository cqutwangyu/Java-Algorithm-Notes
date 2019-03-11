package 算法基础;

import java.util.Arrays;

/**
 * @ClassName 希尔排序
 * @Description 希尔排序
 * @Author ChongqingWangYu
 * @DateTime 2019/3/11 20:40
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 希尔排序 {
    public static void main(String[] args) {
//        int[] a = {5, 3, 1};
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        shellSrot(a);
    }

    /**
     * 希尔排序是一种有效的改进排序算法，但其中的 步长 参数的选取是个问题。
     * @param a
     */
    private static void shellSrot(int[] a) {
        for (int i = 0; i < a.length; i++) {
            ShellInsert(a, a[i]);
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     *
     * @param a
     * @param dk 步长
     */
    private static void ShellInsert(int[] a, int dk) {
        int i, j, k, temp;
        for (k = 0; k < dk; k++) {
            for (i = k + dk; i < a.length; i += dk) {
                if (a[i] < a[i - dk]) {
                    temp = a[i];
                    for (j = i - dk; j >= 0 && temp < a[j]; j -= dk) {
                        a[j + dk] = a[j];
                    }
                    a[j + dk] = temp;
                }
            }
        }
    }
}
