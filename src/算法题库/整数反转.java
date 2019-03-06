package 算法题库;

/**
 * @ClassName 整数反转
 * @Description 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。  示例 1:  输入: 123 输出: 321  示例 2:  输入: -123 输出: -321 示例 3:  输入: 120 输出: 21 注意:  假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/6 16:02
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 整数反转 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
    }

    static class Solution {
        public int reverse(int x) {
            if (x > 0) {
                return reverseInt(x);
            } else {
                return 0 - reverseInt(-x);
            }
        }

        private int reverseInt(int n) {
            int pop;
            int rev = 0;
            while (n > 0) {
                pop = n % 10;
                n /= 10;
                if (rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }
}
