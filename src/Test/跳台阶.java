package Test;

/**
 * @ClassName 跳台阶
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/12 20:00
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 跳台阶 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(10));
    }

    /**
     * 跳台阶
     *
     * @param n
     * @return
     */
    private static int JumpFloor(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return JumpFloor(n - 1) + JumpFloor(n - 2);
    }

    /**
     * 跳台阶 动态规则实现
     *
     * @param n
     * @return
     */
    private static int JumpFloorDp(int n) {
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
     * 变态跳台阶
     * 左移1位就是乘以一个2，在1基础上左移number-1位就是1乘以2^(number-1)
     *
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        //究极解法，用位移
//        return 1<<(target-1);
        if (target == 0) {
            return -1;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }
}
