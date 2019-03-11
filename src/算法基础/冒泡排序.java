package 算法基础;

import java.util.Arrays;

/**
 * @ClassName 冒泡排序
 * @Description 最简单的排序
 * @Author ChongqingWangYu
 * @DateTime 2019/3/11 20:57
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        bubbleSort(a);
    }

    /**
     * 冒泡排序
     * 速度慢，移动次数更多，比插入排序性能更差
     * 算法效率O(n*n)
     *
     * @param a
     */
    private static void bubbleSort(int[] a) {
        int i, j, temp;
        int n = a.length;
        //检测一次排序中是否发生交换，若无交换，则序列有序，仅需一次排序
        int change = 0;
        for (i = n - 1; i >= 0 && change == 0; i--) {
            //假设只需要一次排序
            change = 1;
            for (j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    //需要进一步排序
                    change = 0;
                    //将大的向后移
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
