package 算法基础;

import java.util.Arrays;

/**
 * @ClassName 快速排序
 * @Description 冒泡排序的改进
 * @Author ChongqingWangYu
 * @DateTime 2019/3/11 21:06
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        quickSort(a);
    }

    /**
     * 快速排序
     * 快速排序算法是目前公认性能最好的排序方法
     * 算法效率 O(nlogn)
     *
     * @param a
     */
    private static void quickSort(int[] a) {
        QSort(a, a.length, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序，递归调用
     *
     * @param a
     * @param n
     * @param low
     * @param high
     */
    private static void QSort(int[] a, int n, int low, int high) {
        int pivotloc;
        if (low < high) {
            pivotloc = partition(a, low, high);
            QSort(a, n, low, pivotloc - 1);
            QSort(a, n, pivotloc + 1, high);
        }
    }

    /**
     * 一次快速排序，利用枢轴玩移位排序
     * 前后两路查找
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] a, int low, int high) {
        int pivotloc = a[low];
        int temp;
        while (low < high) {
            //循环直到找到第一个小的值
            while (low < high && a[high] >= pivotloc) {
                high--;
            }
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            //循环直到找到第一个大的值
            while (low < high && a[low] <= pivotloc) {
                low++;
            }
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
        }
        return low;
    }
}
