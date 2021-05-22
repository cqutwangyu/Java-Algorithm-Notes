package sword.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 替换空格
 * @Description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author cqutwangyu
 * @DateTime 2019/3/14 19:56
 * @GitHub https://github.com/cqutwangyu
 */
public class 替换空格 {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace1(new StringBuffer(" We are happy. ")));
        System.out.println(replaceSpace(new StringBuffer(" We are happy. ")));
    }

    /**
     * 在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，需要在尾部填充两个任意字符。
     *
     * 令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
     *
     * 从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
     */
    public static String replaceSpace(StringBuffer str) {
        //p1获取str原本的长度
        int p1=str.length()-1;
        //遍历
        for(int i=0;i<=p1;i++){
            //如果找到空格
            if(str.charAt(i)==' '){
                //因为一个空格要替换成三个字符（%20）
                //所以发现一个空格则任意追加两个字符
                str.append("12");
            }
        }
        //p2获取str追加空格数*2个字符后的长度，p1!=p2;  p!<p2;  (p2-p1)/2=空格数
        int p2=str.length()-1;
        //循环替换空格
        while(p1 >= 0 && p2 >= p1){
            //下标p1负责从尾到头寻找空格
            char c = str.charAt(p1--);
            if (c == ' ') {
                //p2--为先取值后-1
                //要求替换为%20所以逆序依次为02%
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                //如果不是空格，则将c放到p2的位置（后移）
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }

    public static class Solution {
        public String replaceSpace(StringBuffer str) {
            for (int i = 0; i < str.length(); i++) {
                if (str.substring(i, i + 1).equals(" ")) {
                    str.delete(i, i + 1);
                    str.insert(i, "%20");
                }
            }
            return str.toString();
        }

        public String replaceSpace1(StringBuffer str) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    sb.append(str.substring(start, i) + "%20");
                    start = i + 1;
                }
            }
            sb.append(str.substring(start, str.length()));
            return sb.toString();
        }

        public String replaceSpace2(StringBuffer str) {
            return str.toString().replaceAll(" ", "%20");
        }
    }
}
