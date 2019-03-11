package Test;

/**
 * @ClassName Main
 * @Description 用于基本数据测试
 * @Author ChongqingWangYu
 * @DateTime 2019/3/10 15:00
 * @GitHub https://github.com/ChongqingWangYu
 */
public class Main {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;
        Integer a1 = 128;
        Integer b1 = 128;
        Integer a3 = new Integer(127);
        Integer b3 = new Integer(127);
        System.out.println(a == b);
        System.out.println(a1 == b1);
        System.out.println(a3 == b3);
        System.out.println(a == a3);
    }
}
