package leet.code;

import java.util.Arrays;

/**
 * @ClassName 无重复字符的最长子串
 * @Description 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。  示例 1:  输入: "abcabcbb" 输出: 3  解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。 示例 2:  输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。 示例 3:  输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @Author cqutwangyu
 * @DateTime 2019/2/25 15:38
 * @GitHub https://github.com/cqutwangyu
 */
public class 无重复字符的最长子串 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbbbbbbbpwwkew"));
        System.out.println(lengthOfLongestSubstring1("abc"));
    }

    /**
     * 计算无重复的最长子串长度的方法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();
        String temp;
        int startIndex=-1;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
//            System.out.println("循环开始i="+i);
            temp = s.substring(i, i + 1);
            if (sb.indexOf(temp) == -1) {
                if(startIndex==-1){
//                    System.out.println("发现不重复字符子串的开始i="+i);
                    startIndex=i;
                }
                sb.append(temp);
                if (sb.toString().length() > max) {
                    max =sb.toString().length();
                }
            } else {
//                System.out.println("发现重复字符i="+i);
                i=startIndex;
//                System.out.println("i="+i);
                startIndex=-1;
                sb = new StringBuilder();
            }
        }
//        System.out.println("最长不重复子串："+sb.toString());
        return max;
    }

    /**
     * LeetCode大神的最优解
     * 大神写的程序确实难以理解，花了半小时功夫，一边测试一边看，才勉强理解了思路。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        int ans = 0;
        //创建足以存放257个字符的值的数组
        int[] vis = new int[257];
        int len = s.length();
        //记录当前查找到的（无重复字符的最长子串）的开始下标。
        int left = -1;
        //用-1填满数组
        Arrays.fill(vis,-1);
//        System.out.println(Arrays.toString(vis));
        //从0开始循环s字符串
        for(int i = 0; i < len; i++) {
//            System.out.println("=========abcabcbbbbbbbpwwkew===========");
            //vis[s.charAt(i)的ASCII码值]的值大于left
//            System.out.println("字符："+s.charAt(i));
//            System.out.println("最大长度："+ans);
            //当前字符是否出现过，出现过的下标是否大于当前查找到的（无重复字符的最长子串）的开始下标，如果大于，则说明重复出现了。
            //当找到重复的字符之后，以当前字符为新的子串开始，也就是left = vis[s.charAt(i)]
            if(vis[s.charAt(i)] > left) {
//                System.out.println("vis["+(int)s.charAt(i)+"]>"+left);
                //用left记录当前查找到的（无重复字符的最长子串）的开始下标。
                left = vis[s.charAt(i)];
//                System.out.println("left="+left);
            }else {
//                System.out.println("vis["+(int)s.charAt(i)+"]<="+left);
            }
            //用当前i减去当前寻找到的（无重复字符的最长子串）的开始下标=当前找到的最长子串的长度，并与ans比较大小，是否比ans记录的值大
            ans = Math.max(ans,i - left);
            //表示当前字符出现在下标i
            vis[s.charAt(i)] = i;
//            System.out.println("vis["+(int)s.charAt(i)+"]="+i);
        }

        return ans;
    }
}
