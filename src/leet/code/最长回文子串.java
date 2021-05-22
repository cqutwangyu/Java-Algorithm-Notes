package leet.code;

/**
 * @ClassName 最长回文子串
 * @Description 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。  示例 1：  输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：  输入: "cbbd" 输出: "bb"
 * @Author cqutwangyu
 * @DateTime 2019/3/4 20:17
 * @GitHub https://github.com/cqutwangyu
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    private static int maxLen = 0;
    private static String sub = "";

    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            //单核回文 aba abcba
            findLongestPalindrome(s, i, i);
            //双核回文 abba abccba
            findLongestPalindrome(s, i, i + 1);
        }
        return sub;
    }

    public static void findLongestPalindrome(String s, int low, int high) {
        while (low >= 0 && high <= s.length() - 1) {
            //首尾相同
            if (s.charAt(low) == s.charAt(high)) {
//                System.out.println(s.substring(low, high + 1));
                //长度大于maxlen
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    sub = s.substring(low, high + 1);
                }
                //向两边扩散找当前字符为中心的最大回文子串
                low--;
                high++;
            } else {
                //axb 首尾不同
                //bxxa 首尾不同
                break;
            }
        }
    }

    public static String longestPalindrome1(String s) {
        int n = s.length();
        //用于存储最长回文的下标
        int[] range = new int[2];
        for (int i = 0; i < n; i++) {
            i = helper(s, range, i);
        }
        return s.substring(range[0], range[1]);
    }

    public static int helper(String s, int[] range, int i) {
        int lo = i;
        int hi = i;
        while (hi < s.length() - 1 && s.charAt(hi) == s.charAt(hi + 1)) {
            hi++;
        }

        int ret = hi;
        while (lo > 0 && hi < s.length() - 1 && s.charAt(lo - 1) == s.charAt(hi + 1)) {
            lo--;
            hi++;
        }

        if (hi - lo + 1 > range[1] - range[0]) {
            range[0] = lo;
            range[1] = hi + 1;
        }

        return ret;
    }


}
