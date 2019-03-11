package 算法基础;

import java.util.Arrays;

/**
 * @ClassName 插入排序
 * @Description 优点：思路清晰 程序简洁 易于实现 空间复杂度低
 * @Author ChongqingWangYu
 * @DateTime 2019/3/11 19:45
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 插入排序 {
    /**
     * 效率 O(n*n)
     * 当数组完全逆序时比较次数达到最大，效率最低，完全逆序时比较次数=(n+2)*(n-1)/2
     * 在需要排序 数据较大时，插入排序 算法的时间 复杂度较高，花费时间较长，可以考虑改用 折半查找 或 快速查找
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        insertsortMinToMax(a);
        insertsortMaxToMin(a);
    }

    /**
     * 从小到大插入排序
     * 思路清晰 程序简洁 易于实现 空间复杂度低
     * @param a
     */
    private static void insertsortMinToMax(int[] a) {
        int temp, i, j;
        int count = 0;
        //从下标1开始依次取出所有数
        for (i = 1; i < a.length; i++) {
            //如果第i个数小于左边的数则进行插入排序
            if (a[i] < a[i - 1]) {
                count++;
                //取出待插入的数
                temp = a[i];
                //从i-1的下标开始往左遍历到下标0，temp需小于a[j]，也就是说遇到temp>a[j]时，结束循环
                for (j = i - 1; j >= 0 && temp < a[j]; j--) {
                    a[j + 1] = a[j];
                    count++;
                }
                //将待插入的数放入j+1的位置
                a[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("比较次数:" + count);
    }

    /**
     * 从大到小插入排序
     *
     * @param a
     */
    private static void insertsortMaxToMin(int[] a) {
        int temp, i, j;
        int count = 0;
        //从下标1开始依次取出所有数
        for (i = 1; i < a.length; i++) {
            //如果第i个数小于左边的数则进行插入排序
            if (a[i] > a[i - 1]) {
                count++;
                //取出待插入的数
                temp = a[i];
                //从i-1的下标开始往左遍历到下标0，temp需小于a[j]，也就是说遇到temp>a[j]时，结束循环
                for (j = i - 1; j >= 0 && temp > a[j]; j--) {
                    count++;
                    a[j + 1] = a[j];
                }
                //将待插入的数放入j+1的位置
                a[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("比较次数:" + count);
    }
}
