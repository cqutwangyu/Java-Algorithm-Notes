package leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 螺旋矩阵
 * @Description 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。  示例 1:  输入: [  [ 1, 2, 3 ],  [ 4, 5, 6 ],  [ 7, 8, 9 ] ] 输出: [1,2,3,6,9,8,7,4,5] 示例 2:  输入: [   [1, 2, 3, 4],   [5, 6, 7, 8],   [9,10,11,12] ] 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * @Author cqutwangyu
 * @DateTime 2019/2/27 16:55
 * @GitHub https://github.com/cqutwangyu
 */
public class 螺旋矩阵 {
    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * 示例 1:
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     * 输入:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}};
        int[][] arr1 = {{3}, {2}};
        int[][] arr2 = {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        System.out.println(spiralOrder(arr));
        System.out.println("================================");
        System.out.println(spiralOrder(arr1));
        System.out.println("================================");
        System.out.println(spiralOrder(arr2));
    }

    /**
     * 这题实在有难度，做了很长时间，大概三四个小时。思路并不清晰，反复尝试，勉强做出来了。
     *
     * 做完后看了评论，有大神的思路是，取首行，然后删除首行，再将矩阵旋转，取首行。。。递归直到数组为[]，这样似乎是思路最清晰的方法了。
     * @param m
     * @return
     */
    public static List<Integer> spiralOrder(int[][] m) {
        List<Integer> list = new ArrayList<>();
        if (m.length == 0) {
            return list;
        }
        int n1 = m.length;
        int n2 = m[0].length;
        //圈数
        int x = 0;
        //横轴j，竖轴i
        int i = 0, j = 0;
        int n = n1 * n2;
        //如果只有一列，则不需要转圈
        if (n2 < 2) {
            for (int k = 0; k < n1; k++) {
                list.add(m[k][0]);
            }
            return list;
        }
        //转圈直至把所有数遍历完
        while (list.size() < n) {
            //→从左往右
            for (; j < n2 - x; ) {
                list.add(m[i][j]);
                if (j + 1 < n2) {
                    j++;
                }
                if (j == n2 - 1 - x) {
                    break;
                }
            }
            if (list.size() >= n) {
                break;
            }
            //↓从上往下
            for (; i < n1 - x; ) {
                list.add(m[i][j]);
                i++;
                if (i == n1 - 1 - x) {
                    break;
                }
            }
            if (list.size() >= n) {
                break;
            }
            //←从左到右
            for (; j >= x; ) {
                list.add(m[i][j]);
                j--;
                if (j == x) {
                    break;
                }
            }
            if (list.size() >= n) {
                break;
            }
            //到这里算是过了一圈，因为不能回到m[0][0]，所以在从下往上之前
            x++;
            //↑从下到上
            for (; i >= x; ) {
                list.add(m[i][j]);
                i--;
                if (i == x) {
                    break;
                }
            }
//            System.out.println("i=" + i + ",j=" + j + ",x=" + x + "list.size=" + list.size() + "," + list.toString());
        }
        return list;
    }

}
