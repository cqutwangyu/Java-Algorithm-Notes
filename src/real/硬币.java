package real;

import java.util.Scanner;

/**
 * @ClassName 硬币
 * @Description 腾讯笔试题
 * @Author cqutwangyu
 * @DateTime 2019/3/9 19:33
 * @GitHub https://github.com/cqutwangyu
 */
public class 硬币 {

    /**
     * 拥有1~N面值的硬币，例如N为100：1，2，3，4，5，6，7，8......100。
     * 商品价格M小于N，则结果为1
     * M大于N，结果为(n+m-1)/n 例如：N=10，M=500，509/10=50.9，int型50.9=50
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //硬币最大面额（面额为1到n）
        int n = sc.nextInt();
        //商品价格
        int m = sc.nextInt();
        System.out.println((n + m - 1) / n);
    }
}
