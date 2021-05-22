package sword.offer;

/**
 * @ClassName 跳台阶
 * @Description
 * @Author cqutwangyu
 * @DateTime 2019/3/12 20:00
 * @GitHub https://github.com/cqutwangyu
 */
public class 变态跳台阶 {
    public static void main(String[] args) {
        System.out.println(JumpFloorII(4));
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
        return 1 << (target - 1);
//        if (target == 0) {
//            return -1;
//        }
//        if (target == 1) {
//            return 1;
//        }
//        return 2 * JumpFloorII(target - 1);
    }

}
