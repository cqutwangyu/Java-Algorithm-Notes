package LeetCode;

import java.util.Arrays;

/**
 * @ClassName K次取反后最大化的数组和
 * @Description 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）  以这种方式修改数组后，返回数组可能的最大和。     示例 1：  输入：A = [4,2,3], K = 1 输出：5 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。 示例 2：  输入：A = [3,-1,0,2], K = 3 输出：6 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。 示例 3：  输入：A = [2,-3,-1,5,-4], K = 2 输出：13 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。    提示：  1 <= A.length <= 10000 1 <= K <= 10000 -100 <= A[i] <= 100
 * @Author ChongqingWangYu
 * @DateTime 2019/3/10 10:31
 * @GitHub https://github.com/ChongqingWangYu
 */
public class K次取反后最大化的数组和 {
    public static void main(String[] args) {
        int[] arr = {2, -3, -1, 5, -4};
        System.out.println(largestSumAfterKNegations(arr, 2));
    }

    /**
     * @param A
     * @param K 改变次数
     * @return
     */
    public static int largestSumAfterKNegations(int[] A, int K) {
        int max = 0;
        while (K-- > 0) {
            System.out.println(K);
            Arrays.sort(A);
            A[0] = -A[0];
        }
        for (int i = 0; i < A.length; i++) {
            max += A[i];
        }
        return max;
    }
}
