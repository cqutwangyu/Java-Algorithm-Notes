package 笔试真题;

import java.util.Arrays;

/**
 * @ClassName 旋转矩阵
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/28 21:00
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 旋转矩阵 {
    public static void main(String[] args) {
        int size = 5;
        //生成数组
        int[][] arrs = new int[size][size];
        int count = 0;
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                arrs[i][j] = ++count;
            }
        }
        printArrays(arrs);
        rotate(arrs);
        System.out.println();
        printArrays(arrs);
    }


    private static void printArrays(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(Arrays.toString(arrs[i]));
        }
    }


    /**
     * 旋转矩阵
     */
    private static void rotate(int[][] arrs) {
        int tR = 0;
        int tC = 0;
        int dR = arrs.length - 1;
        int dC = arrs[0].length - 1;
        while (tR < dR) {
            rotateEdge(arrs, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 旋转一圈矩阵
     */
    private static void rotateEdge(int[][] arrs, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int temp = 0;
        for (int i = 0; i < times; i++) {
            //左上角数据取出
            temp = arrs[tR][tC + i];
            //左下角数据存入左上角
            arrs[tR][tC + i] = arrs[dR - i][tC];
            //右下角数据存入左下角
            arrs[dR - i][tC] = arrs[dR][dC - i];
            //右上角数据存入右下角
            arrs[dR][dC - i] = arrs[tR + i][dC];
            //左上角数据存入右上角
            arrs[tR + i][dC] = temp;
        }
    }
}
