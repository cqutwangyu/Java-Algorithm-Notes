package Test;

import java.util.jar.JarEntry;

/**
 * @ClassName 跳台阶
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/12 20:00
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 跳台阶 {
    public static void main(String[] args) {
        System.out.println(jumpFloor(20));

    }

    public static int jumpFloor(int target) {
        if (target == 0) {
            return -1;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * jumpFloor(target - 1);
    }
}
