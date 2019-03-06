package 算法题库;

import java.math.BigInteger;

/**
 * @ClassName 字符串转换整数atoi
 * @Description 请你来实现一个 atoi 函数，使其能将字符串转换成整数。  首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。  当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。  该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。  注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。  在任何情况下，若函数不能进行有效的转换时，请返回 0。  说明：  假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。  示例 1:  输入: "42" 输出: 42 示例 2:  输入: "   -42" 输出: -42 解释: 第一个非空白字符为 '-', 它是一个负号。      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。 示例 3:  输入: "4193 with words" 输出: 4193 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。 示例 4:  输入: "words and 987" 输出: 0 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。      因此无法执行有效的转换。 示例 5:  输入: "-91283472332" 输出: -2147483648 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。       因此返回 INT_MIN (−231) 。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/6 16:31
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 字符串转换整数atoi {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("+-91283472332"));
    }

    static class Solution {
        public int myAtoi(String str) {
            if (str.length() < 1) {
                return 0;
            }
            int start = 0;
            boolean positive = true;
            for (int i = 0; i < str.length(); i++) {
                //跳过所有的空格
                if (str.charAt(i) != ' ') {
                    //除空格外的第一个字符下标
                    start = i;
                    if (str.charAt(start) == '+') {
                        //是正号
                        start++;
                    } else if (str.charAt(start) == '-') {
                        //是负号
                        positive = false;
                        start++;
                    } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                        //第一个有效字符不是数字，也不是正负号
                        return 0;
                    }
                    break;
                }
            }
            long atoi = 0;
            for (int i = start; i < str.length(); i++) {
                if (str.charAt(i) == '.' || str.charAt(i) < '0' || str.charAt(i) > '9') {
                    //是小数点（int会取掉小数点后面的值，且不做四舍五入）
                    //是非数字，停止遍历
                    break;
                } else {
                    //将char转为int并累加进位
                    atoi = atoi * 10 + (str.charAt(i) - '0');
                    if (positive && atoi > Integer.MAX_VALUE) {
//                        System.out.println("溢出最大值");
                        return Integer.MAX_VALUE;
                    } else if (!positive && -atoi < Integer.MIN_VALUE) {
//                        System.out.println("溢出最小值");
                        return Integer.MIN_VALUE;
                    }
                }
            }
            if (positive == false) {
                atoi = -atoi;
            }
            return (int) atoi;
        }


        /**
         * 最优解
         *
         * @param str
         * @return
         */
        public int myAtoi1(String str) {
            if (str == null || str.length() == 0) {
                return 0;
            }
            // 去除前面的空格
            int start = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    start = i;
                    break;
                }
            }
            long res = 0;
            boolean positive = true;
            if (str.charAt(start) == '-') {
                positive = false;
                start++;
            } else if (str.charAt(start) == '+') {
                start++;
            }
            for (int j = start; j < str.length(); j++) {
                if (str.charAt(j) == ' ' || str.charAt(j) < '0' || str.charAt(j) > '9') {
                    break;
                }
                res = res * 10 + (str.charAt(j) - '0');
                if (!positive && -res < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                if (positive && res > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            if (positive == false) {
                res = -res;
            }
            return (int) res;
        }
    }
}
