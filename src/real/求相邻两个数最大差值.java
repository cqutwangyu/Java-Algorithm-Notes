package real;

import java.util.Arrays;

/**
 * @ClassName 求相邻两个数最大差值
 * @Description 要求时间复杂度O(n)，且不能使用非基于比较的排序
 * @Author cqutwangyu
 * @DateTime 2019/3/25 16:04
 * @GitHub https://github.com/cqutwangyu
 */
public class 求相邻两个数最大差值 {
    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 1, 7, 5};
        System.out.println(maxGep(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 时间O(n) 空间O(n)
     */
    private static int maxGep(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        //找出最大值最小值
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //如果最大最小值相同，则差距0
        if (max == min) {
            return 0;
        }

        //定义len+1个桶｛最大值，最小值，是否有数｝
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];

        //第i个数要去的桶
        int bid = 0;
        for (int i = 0; i < len; i++) {
            //判断要进那个桶
            bid = bucket(arr[i], len, min, max);
            //bid桶中最小值更新
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            //bid桶中最大值更新
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            //bid桶中有数，非空
            hasNum[bid] = true;
        }
        //结果
        int res = 0;
        //上一个桶的最大值
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            //如果有数
            if (hasNum[i]) {
                //算出当前桶的最小值减去上一个桶的最大值，并与结果比较大小
                res = Math.max(res, mins[i] - lastMax);
                //当前桶的最大值，成为上一个桶的最大值
                lastMax = maxs[i];
            }
        }
        return res;
    }

    /**
     * 确定一个数应该去几号桶
     */
    private static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
