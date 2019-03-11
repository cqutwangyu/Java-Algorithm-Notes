package 算法基础;

import java.util.Arrays;

/**
 * @ClassName 选择排序
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/11 21:26
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 选择排序 {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        selectionSort(a);
    }

    /**
     * 选择排序
     * 算法效率 O(n*n)
     *
     * @param a
     */
    private static void selectionSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[i]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
