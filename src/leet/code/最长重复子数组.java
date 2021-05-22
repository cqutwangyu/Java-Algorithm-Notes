package leet.code;

import java.util.Arrays;

/**
 * @author wangyu
 * @title: 最长重复子数组
 * @projectName Java-Algorithm-Notes
 * @description: TODO
 * @date 2020/7/1 16:50
 */
public class 最长重复子数组 {

    /**
     * 动态规划
     * @param A
     * @param B
     * @return
     */
    public static int findLength(int[] A, int[] B) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (B == null || B.length == 0) {
            return 0;
        }

        int n = A.length, m = B.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 2, 1};
        int[] arrayB = {3, 2, 1, 4, 7};
        System.out.println(findLength(arrayA, arrayB));
    }
}
