package real;

import java.util.Scanner;

/**
 * @ClassName 奇妙的数列
 * @Description 腾讯笔试题
 * @Author cqutwangyu
 * @DateTime 2019/3/9 19:51
 * @GitHub https://github.com/cqutwangyu
 */
public class 奇妙的数列 {
    //-1,2,-3,4,-5 求和2秒内https://www.nowcoder.com/discuss/160361?tdsourcetag=s_pctim_aiomsg

    /**
     * 4
     * 2 4 正数 正数 3
     * 2 2 正数 正数 2
     * 3 3 负数 负数 -3
     * 1 5 负数 负数 -3
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //询问q次
        int q = sc.nextInt();
        while (q-- > 0) {
            //左端点
            int l = sc.nextInt();
            //右端点
            int r = sc.nextInt();
            //区间长度（3-6+1）=4（3456）
            int d = r - l + 1;
            //奇数区间长度
            if (d % 2 == 1) {
                //奇数结束
                if (r % 2 == 1) {
                    System.out.println(d / 2 - r);
                } else {//偶数结束
                    System.out.println(r - d / 2);
                }
            } else {//偶数区间长度
                //奇数结束
                if (r % 2 == 1) {
                    System.out.println(-d / 2);
                } else {//偶数结束
                    System.out.println(d / 2);
                }
            }
        }
    }
}
