package 剑指offer;

/**
 * @ClassName 替换空格
 * @Description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/14 19:56
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 替换空格 {
    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace1(new StringBuffer(" We are happy. ")));
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
