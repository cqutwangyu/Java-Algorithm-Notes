package leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 存在重复
 * @Description 给定一个整数数组，判断是否存在重复元素。  如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。  示例 1:  输入: [1,2,3,1] 输出: true 示例 2:  输入: [1,2,3,4] 输出: false 示例 3:  输入: [1,1,1,3,3,4,3,2,4,2] 输出: true
 * @Author cqutwangyu
 * @DateTime 2019/3/3 20:26
 * @GitHub https://github.com/cqutwangyu
 */
public class 存在重复 {

    public static void main(String[] args) {
        int[] nums={1,2,3,4,1};
        System.out.println(containsDuplicate(nums));
    }

    /**
     * 有重复返回true 否则false
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                return true;
            } else {
                list.add(nums[i]);
            }
        }
        return false;
    }
}
