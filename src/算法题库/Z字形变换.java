package 算法题库;

import javax.management.StringValueExp;
import java.util.Arrays;

/**
 * @ClassName Z字形变换
 * @Description 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。  比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：  L   C   I   R E T O E S I I G E   D   H   N 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。  请你实现这个将字符串进行指定行数变换的函数：  string convert(string s, int numRows); 示例 1:  输入: s = "LEETCODEISHIRING", numRows = 3 输出: "LCIRETOESIIGEDHN" 示例 2:  输入: s = "LEETCODEISHIRING", numRows = 4 输出: "LDREOEIIECIHNTSG" 解释:  L     D     R E   O E   I I E C   I H   N T     S     G
 * @Author ChongqingWangYu
 * @DateTime 2019/3/5 10:36
 * @GitHub https://github.com/ChongqingWangYu
 */
public class Z字形变换 {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRINGGDGADSGDASGAGDSAG", 6));
    }

    /**
     * 我的解法
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        int n = s.length();
        System.out.println(n);
        if (n < numRows || numRows < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        char[][] arrs = new char[numRows][n];
        //行
        int x = 0;
        //列
        int y = 0;
        //方向
        int y1 = 1;
        //列标是否移动
        int x1 = 0;
        //按照规则将value放入二维数组中
        for (int i = 0; i < n; i++) {
            arrs[y][x] = chars[i];
            //若到了数组的底部，则改变方向，向上走，向上走的同时x递增
            if (y == numRows - 1) {
                y1 = -1;
                x1 = 1;
            } else if (y == 0) {
                //若到了数组的顶部，则改变方向，向下走，同时停止x的递增
                y1 = 1;
                x1 = 0;
            }
            y += y1;
            x += x1;
        }
        int index = 0;
        int maxj = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n; j++) {
                //未赋值的char为'\0'，跳过
                if (arrs[i][j] != '\0') {
                    //将结果存入chars中
                    chars[index++] = arrs[i][j];
                    maxj=maxj<j?j:maxj;
                }
            }
            System.out.println(Arrays.toString(arrs[i]));
        }
        System.out.println(maxj);
        //返回结果
        return String.valueOf(chars);
    }

    /**
     * 最优解
     * @param s
     * @param numRows
     * @return
     */
    public static String convert1(String s, int numRows) {
        if ("".equals(s)) {
            return "";
        }
        if(numRows==0||numRows==1){
            return s;
        }
        char[] totalChars = s.toCharArray();
        int length = totalChars.length;
        /*每列加后面的弯弯算做一个chunk，一个chunk包含chunkNums个char*/
        int chunkNums = numRows * 2 - 2;
        /*一共有多少个chunk*/
        int chunks = length / chunkNums + 1;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            if (j == 0) {
                /*第一种情况：*/
                for (int i = 0; i < chunks; i++) {
                    int index = i * chunkNums;
                    if (index < length) {
                        sb.append(totalChars[index]);
                    }
                }
            } else if (j == numRows - 1) {
                /*这两种情况只有一个*/
                for (int i = 0; i < chunks; i++) {
                    int index = i * chunkNums + (numRows - 1);
                    if (index < length) {
                        sb.append(totalChars[index]);
                    }
                }
            } else {
                /*否则有两个*/
                for (int i = 0; i < chunks; i++) {
                    int firstIndex = i * chunkNums + j;
                    int secondIndex = i * chunkNums + (chunkNums - j);
                    if (firstIndex < length) {
                        sb.append(totalChars[firstIndex]);
                    }
                    if (secondIndex < length) {
                        sb.append(totalChars[secondIndex]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
