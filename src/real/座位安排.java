package real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName 座位安排
 * @Description 假设班主任需要为N名学生安排座位，现在有M张桌子，每张桌子可以供一名学生单独使用，也可以供两名学生共同使用，共用一张桌子的两名学生便称为同桌。班主任为所有学生评估出淘气值，第i名学生的淘气值为Ai，如果同桌两人淘气值之和过高，便容易产生矛盾。那么班主任该如何安排座位，使得淘气值之和最大的两名同桌，其淘气值之和尽可能小？  输入 第一行包含两个整数N和M，1≤M＜N≤105且N≤M×2。  第二行包含N个整数A1到AN，0≤Ai≤109。  （数字间均以空格隔开）  输出 输出淘气值之和最大的两名同桌，其淘气值之和可能的最小值。   样例输入 5 3 4 1 8 2 6 样例输出 7  Hint 安排第1名与第4名学生共用一张桌子，两人淘气值之和为6；第2名与第5名学生共用一张桌子，两人淘气值之和为7；第3名学生单独用一张桌子。
 * @Author cqutwangyu
 * @DateTime 2019/3/7 19:26
 * @GitHub https://github.com/cqutwangyu
 */
public class 座位安排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //人数
        int N = sc.nextInt();
        //桌子
        int M = sc.nextInt();
        int count = 0;
        int[] arr = new int[N];
        while (count < N) {
            arr[count] = sc.nextInt();
            count++;
        }
        //从小到大排序
        Arrays.sort(arr);
        //单人坐
        while (M * 2 > N) {
            N--;
            M--;
        }
        //取淘气值最低的和非单人座淘气值最高的之和
        System.out.println(arr[0] + arr[N - 1]);
        sc.close();
    }
}
