package 算法题库;

/**
 * @ClassName 只出现一次的数字
 * @Description 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。  说明：  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？  示例 1:  输入: [2,2,1] 输出: 1 示例 2:  输入: [4,1,2,1,2] 输出: 4
 * @Author ChongqingWangYu
 * @DateTime 2019/3/4 13:43
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 4, 1, 2};
        System.out.println(singleNumber1(arr));
//        System.out.println(2 ^ 3);
    }

    public static int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i != j) {
//                    System.out.println(nums[i] + "==" + nums[j]);
                    break;
                } else if (j == nums.length - 1) {
//                    System.out.println(nums[i] + "!=" + nums[j]);
                    return nums[i];
                }
            }
            if (i == nums.length - 1) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 利用^异或,相同为0，不同为1
     * 相同的成对出现，不同的只有一个，成对的为0，不同的为1，最后只剩下不同的
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        for (int i = 1, len = nums.length; i < len; i += 2) {
            nums[0] ^= nums[i] ^ nums[i + 1];
//            System.out.println("========" + i + "=======");
//            System.out.println("nums[0]=" + nums[0]);
//            System.out.println(nums[i] + "^" + nums[i + 1] + "=" + (nums[i] ^ nums[i + 1]));
//            System.out.println(nums[0] + "^" + (nums[i] ^ nums[i + 1]) + "=" + (nums[0] ^ (nums[i] ^ nums[i + 1])));
        }
        return nums[0];
    }
}
