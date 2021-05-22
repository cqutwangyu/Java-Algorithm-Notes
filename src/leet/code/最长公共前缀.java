package leet.code;

/**
 * @ClassName 最长公共前缀
 * @Description 编写一个函数来查找字符串数组中的最长公共前缀。  如果不存在公共前缀，返回空字符串 ""。  示例 1:  输入: ["flower","flow","flight"] 输出: "fl" 示例 2:  输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:  所有输入只包含小写字母 a-z 。
 * @Author cqutwangyu
 * @DateTime 2019/3/11 14:21
 * @GitHub https://github.com/cqutwangyu
 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "aa"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"", ""}));
        System.out.println(longestCommonPrefix(new String[]{"",}));
        System.out.println(longestCommonPrefix(new String[]{}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1 || strs[0].length() < 1) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minlen) {
                minlen = strs[i].length();
            }
        }
        int index = -1;
        boolean flag = true;
        while (flag && index < minlen) {
            index++;
            for (int i = 1; i < strs.length; i++) {
                if (!(index < minlen && strs[i].charAt(index) == strs[0].charAt(index))) {
                    flag = false;
                    break;
                }
            }
        }
        return strs[0].substring(0, index);
    }

    /**
     * 最优解
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        //如果strs为空，返回字符串空
        String str = "";
        if (strs.length > 0) {
            //取出下标0的字符串，用于构造最大公共前缀
            str = strs[0];
            //跳过下标0，从下标1遍历strs
            for (int i = 1; i < strs.length; i++) {
                //strs[i]不是以str为前缀
                while (!strs[i].startsWith(str)) {
                    //str的长度大于1
                    if (str.length() > 1) {
                        //例如str="abcd"，去除最后一个字符str="abc"，通过循环不断减少
                        str = str.substring(0, str.length() - 1);
                    } else {
                        return "";
                    }
                }
            }
        }
        return str;
    }
}
