package 算法题库;

import java.util.Arrays;

/**
 * @ClassName 寻找两个有序数组的中位数
 * @Description 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。  请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。  你可以假设 nums1 和 nums2 不会同时为空。  示例 1:  nums1 = [1, 3] nums2 = [2]  则中位数是 2.0 示例 2:  nums1 = [1, 2] nums2 = [3, 4]  则中位数是 (2 + 3)/2 = 2.5
 * @Author ChongqingWangYu
 * @DateTime 2019/2/26 10:26
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 寻找两个有序数组的中位数 {
    /**
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * 示例 1:
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * 示例 2:
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * LeetCode提交通过，编码耗时23分钟。感觉这道题不应该是困难，而是简单。
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] tempArr = new int[n1 + n2];
        int n3 = tempArr.length;
        for (int i = 0; i < n3; i++) {
            if (i < n1) {
                tempArr[i] = nums1[i];
            } else {
                tempArr[i] = nums2[i - n1];
            }
        }
        Arrays.sort(tempArr);
        System.out.println(Arrays.toString(tempArr));
        int median = n3 / 2;
//        System.out.println(median);
//        System.out.println(tempArr[median-1]);
//        System.out.println(tempArr[median]);
//        System.out.println(tempArr[median] + tempArr[median-1 ]);
        double i = n3 % 2 == 1 ? tempArr[n3 / 2] : (tempArr[median] + tempArr[median - 1]) / 2.0;
        return i;
    }

    /**
     * 大神最优解
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int nums2length = nums2.length;
        int[] r = new int[nums1.length + nums2length];

        int index = 0;
        int j = 0;
        for (int num : nums1) {
            while (j < nums2length && num > nums2[j]) {
                r[index] = nums2[j];
                j++;
                index++;
            }
            r[index] = num;
            index++;
        }
        for (; j < nums2length; j++) {
            r[index] = nums2[j];
            index++;
        }

        int mi = r.length / 2;
        return r.length % 2 == 1 ? r[mi] : (r[mi - 1] + r[mi]) / 2.0;
    }
}
