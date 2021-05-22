package leet.code;

/**
 * @ClassName 盛最多水的容器
 * @Description https://leetcode-cn.com/problems/container-with-most-water/
 * @Author cqutwangyu
 * @DateTime 2019/3/8 14:10
 * @GitHub https://github.com/cqutwangyu
 */
public class 盛最多水的容器 {
    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(arr));
    }

    static class Solution {
        //暴力法
        public int maxArea(int[] height) {
            int maxarea = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return maxarea;
        }

        /**
         * 双指针法
         * 思路：先计算出left到right的容积
         *       然后判断left低还是right低，低的一边则往中间靠拢以寻找更高的容器边缘
         *       再算出left到rigth的容积，并判断是否是目前最大，如果是目前最大则保存
         * @param height
         * @return
         */
        public int maxArea1(int[] height) {
            int maxarea = 0, left = 0, right = height.length - 1, min;
            while (left < right) {
//                maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
                //取容器最低端的值
                min = Math.min(height[left], height[right]);
                //算出容积
                min = min * (right - left);
                //比较容积取最大值
                maxarea = Math.max(maxarea, min);
                if (height[left] < height[right]) {
                    //如果左边低，则左边的下标+1
                    left++;
                } else {
                    //如果右边低，则右边的下标-1
                    right--;
                }
            }
            return maxarea;
        }
    }
}
