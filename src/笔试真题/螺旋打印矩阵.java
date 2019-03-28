package 笔试真题;

import java.util.Arrays;

/**
 * @ClassName 螺旋打印矩阵
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/28 20:13
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 螺旋打印矩阵 {
    public static void main(String[] args) {
        int[][] arrs = new int[5][3];
        //生成数组
        createArrays(arrs);
        //螺旋输出矩阵
        rotaryPrint(arrs);
    }

    private static void createArrays(int[][] arrs) {
        int count = 0;
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                arrs[i][j] = ++count;
            }
            System.out.println(Arrays.toString(arrs[i]));
        }
    }

    private static void rotaryPrint(int[][] arrs) {
        //左上 行列
        int tR = 0;
        int tC = 0;
        //右下 行列
        int dR = arrs.length - 1;
        int dC = arrs[0].length - 1;
        //循环输出矩形每一层框的数字，包括最中间的值
        while (tR <= dR && tR <= dC) {
            System.out.println("(" + tR + "," + tC + ")" + "(" + dR + "," + dC + ")");
            printEdge(arrs, tR++, tC++, dR--, dC--);
            System.out.println();
        }
    }

    /**
     * 给定左上角的点（tR,tC）和右下角的点（dR,dC），输出一个矩形框的数字
     *
     * @param arrs
     * @param tR   左上角行
     * @param tC   左上角列
     * @param dR   右下角行
     * @param dC   右下角列
     */
    private static void printEdge(int[][] arrs, int tR, int tC, int dR, int dC) {
        //只有一行或一列的情况
        if (tR == dR) {
            //只有一行
            for (int i = tC; i <= dC; i++) {
                System.out.print(arrs[tR][i] + " ");
            }
        } else if (tC == dC) {
            //只有一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(arrs[i][tC] + " ");
            }
        } else {
            int curC = tC;
            int curR = tR;
            //向右打印行→
            while (curC != dC) {
                System.out.print(arrs[tR][curC++] + " ");
            }
            //向下打印列↓
            while (curR != dR) {
                System.out.print(arrs[curR++][dC] + " ");
            }
            //向左打印行←
            while (curC != tC) {
                System.out.print(arrs[dR][curC--] + " ");
            }
            //向上打印列↑
            while (curR != tR) {
                System.out.print(arrs[curR--][tC] + " ");
            }
        }
    }

}
