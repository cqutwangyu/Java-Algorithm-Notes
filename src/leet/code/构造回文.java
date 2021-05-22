package leet.code;

import java.util.Scanner;

/**
 * @ClassName 构造回文
 * @Description 时间限制：1秒  空间限制：32768K  给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？ 输出需要删除的字符个数。  输入描述:  输入数据有多组，每组包含一个字符串s，且保证:1<=s.length<=1000.      输出描述:  对于每组数据，输出一个整数，代表最少需要删除的字符个数。   输入例子1: abcda google  输出例子1: 2 2
 * @Author cqutwangyu
 * @DateTime 2019/3/7 18:30
 * @GitHub https://github.com/cqutwangyu
 */
public class 构造回文 {
    public static void main(String[] args) {
        //123221
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            //逆序
            String s2 = new StringBuilder(s1).reverse().toString();
            //动态规划
            int[][] dp = new int[s1.length() + 1][s2.length() + 1];
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
//                    dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        //如果s1的第i位和s2的第j位相等，则构成回文，回文长度累加1
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        //否则
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
//            for (int i = 0; i < dp.length; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }
            //总长度减去最长的构造回文长度等于需要删除的字符数
            System.out.println(s1.length() - dp[s1.length()][s2.length()]);
        }
    }
}
