package 笔试真题;

import java.util.Arrays;

/**
 * @ClassName Z字型打印矩阵
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/29 21:08
 * @GitHub https://github.com/ChongqingWangYu
 */
public class Z字型打印矩阵 {
    public static void main(String[] args) {
        int size = 5;
        //生成数组
        int[][] arrs = new int[size][size];
        int count = 0;
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[i].length; j++) {
                arrs[i][j] = ++count;
            }
            System.out.println(Arrays.toString(arrs[i]));
        }
        zigPrintArrays(arrs);
    }

    private static void zigPrintArrays(int[][] arrs) {
        int tR = 0, tC = 0, dR = 0, dC = 0;
        int endR = arrs.length - 1;
        int endC = arrs[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(arrs, tR, tC, dR, dC, fromUp);
            //当上面的点移动到最后一列时，向下移动，否则行号不动。↓
            tR = tC == endC ? tR + 1 : tR;
            //当上面的点移动到最后一列时，列号不动，否则向右移动。→
            tC = tC == endC ? tC : tC + 1;
            //当下面的点移动到最后一行时，列号向右移动，否则不动。→
            dC = dR == endR ? dC + 1 : dC;
            //当下面的点移动到最后一行时，行号不动，否则向下移动↓
            dR = dR == endR ? dR : dR + 1;
            //每次打印完之后调整方向
            fromUp = !fromUp;
        }

    }

    /**
     * 每次打印一条水平线，t和b分别代表水平线上面的点和下面的点，
     *
     * @param arrs
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     * @param fromUp 打印的方向，true从上往下，false从下往上
     */
    private static void printLevel(int[][] arrs, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp) {
            while (tR != dR + 1) {
                System.out.println(arrs[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.println(arrs[dR--][dC++] + " ");
            }
        }
    }

}
