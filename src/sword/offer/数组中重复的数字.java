package sword.offer;

/**
 * @ClassName 数组中重复的数字
 * @Description 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。 请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * @Author cqutwangyu
 * @DateTime 2019/9/5 14:03
 * @GitHub https://github.com/cqutwangyu
 */
public class 数组中重复的数字 {
    /**
     * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     *
     * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到下标 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复。
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        //判空处理
        if (numbers == null || length <= 0) {
            return false;
        }
        //循环数组
        for (int i = 0; i < length; i++) {
            //如果当前数组下标的值不等于下标则寻找重复数
            while (numbers[i] != i) {
                //如果找到重复数
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                //如果没有重复，则将当前数字与相应等下标交换。（例如：数字3放入下标3）
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    //交换方法
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
