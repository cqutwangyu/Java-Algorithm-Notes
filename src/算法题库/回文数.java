package 算法题库;

/**
 * @ClassName 回文数
 * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。  示例 1:  输入: 121 输出: true 示例 2:  输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。 示例 3:  输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/7 10:52
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 回文数 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome2(101));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            char[] s = String.valueOf(x).toCharArray();
            int i = -1, j = s.length;
            while (i++ < j--) {
                if (s[i] != s[j]) {
                    return false;
                }
            }
            return true;
        }

        public boolean isPalindrome1(int x) {
            //如果小于0 有负号一定不是回文数
            if (x < 0) {
                return false;
            }
            //x的原值
            int m = x;
            //逆序后的值
            int y = 0;
            while (x > 0) {
//                System.out.println("x:" + x + "y:" + y);
                y = y * 10 + x % 10;
                x = x / 10;
            }
//            System.out.println("x:" + x + "y:" + y);
//            System.out.println("m:" + m + "y:" + y);
            if (m == y) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isPalindrome2(int x) {
            // 特殊情况：
            // 如上所述，当 x < 0 时，x 不是回文数。
            // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
            // 则其第一位数字也应该是 0
            // 只有 0 满足这一属性
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x /= 10;
            }
            System.out.println(x);
            System.out.println(revertedNumber);
            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            return x == revertedNumber || x == revertedNumber / 10;
        }
    }
}
