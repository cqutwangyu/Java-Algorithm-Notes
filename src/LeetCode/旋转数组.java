package LeetCode;

import java.util.Arrays;

/**
 * @ClassName 旋转数组
 * @Description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。  示例 1:  输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步: [7,1,2,3,4,5,6] 向右旋转 2 步: [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4] 示例 2:  输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释:  向右旋转 1 步: [99,-1,-100,3] 向右旋转 2 步: [3,99,-1,-100] 说明:  尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 要求使用空间复杂度为 O(1) 的原地算法。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/3 19:19
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 旋转数组 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 8;
//        rotate(arr, k);
//        System.out.println(Arrays.toString(arr));
        rotate1(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        //如果小于2个长度或者偏移为0则直接返回
        if (n < 2 || k == 0) {
            return;
        }
        int[] arr = nums.clone();
        //判定下标0存储值的起始位置
        int x = n - k;
        //如果小于0，则在队尾+(负数)
        if (x < 0) {
            x = n + x;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = arr[x];
            x++;
            //如果x已经到了队尾，则从0开始
            if (x > n - 1) {
                x = 0;
            }
        }
    }

    /**
     * 大神的解法
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        //n = nums.length
        //k % n 确保不为负数，减少偏移次数
        k = k % nums.length;
        //克隆nums
        int[] tmp = nums.clone();
        //System.arraycopy 参数（源数组，源起始下标，目标数组，目标起始下标，长度）
        //设nums={1,2,3,4,5},k=8; k % n=3;
        //将3,4,5存入0,1,2的下标
        System.arraycopy(tmp, tmp.length - k, nums, 0, k);
        //将1，2存入3,4的下标
        System.arraycopy(tmp, 0, nums, k, tmp.length - k);
    }
}
