package 剑指offer;

import java.util.Arrays;

/**
 * @ClassName 跳台阶
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/12 20:00
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 跳台阶 {
    public static void main(String[] args) {
        int n = 30;
        long start = System.currentTimeMillis();
        System.out.println(JumpFloor_3(n));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(JumpFloor_2(n));
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        System.out.println(JumpFloor_1(n));
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 用数组存储每一阶的（不同跳法）次数，易于理解
     * <
     * 假设第一次跳的是一阶，那么剩下的n-1个台阶，跳法是f(n-1)
     * 假设第一次跳的是两阶，那么剩下的n-2个台阶，跳法是f(n-2)
     * 由上面两种假设可得：f(n) = f(n-1) + f(n-2)
     * 由实际情况可知：f(1) = 1，f(2) = 2
     * 最终得出的是一个斐波那契数列：
     * =================|  1，n = 1
     * f(n)   =        |  2, n = 2
     * ===============|  f(n-1) + f(n -2), n >2
     *
     * @param n
     * @return
     */
    private static int JumpFloor_3(int n) {
        int[] arr = new int[n];
        //0阶0种跳法
        arr[0] = 0;
        //1阶1种跳法
        arr[1] = 1;
        //2阶2种跳法
        arr[2] = 2;
        int i;
        for (i = 3; i < arr.length; i++) {
            //根据斐波拉契数列，后一位的跳法等于前两位的和
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println(Arrays.toString(arr));
        return arr[i - 1] + arr[i - 2];
    }

    /**
     * 跳台阶 动态规则实现
     *
     * @param n
     * @return
     */
    private static int JumpFloor_2(int n) {
        if (n <= 0) {
            return 0;
        }
        int f = 1;
        int g = 1;
        while (n-- > 0) {
            g = g + f;
            f = g - f;
        }
        return f;
    }

    /**
     * 跳台阶
     * 时间复杂度过高超过50阶就难以计算，甚至会栈溢出（弃用）
     *
     * @param n
     * @return
     */
    private static int JumpFloor_1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return JumpFloor_1(n - 1) + JumpFloor_1(n - 2);
    }
}
