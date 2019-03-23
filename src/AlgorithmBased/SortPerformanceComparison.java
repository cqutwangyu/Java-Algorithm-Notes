package AlgorithmBased;

import LogarithmicDetector.IntArrays;

import java.util.Arrays;

/**
 * @ClassName SortPerformanceComparison
 * @Description 同一组数据比较各种排序之间的性能
 * @Author ChongqingWangYu
 * @DateTime 2019/3/23 16:29
 * @GitHub https://github.com/ChongqingWangYu
 */
public class SortPerformanceComparison {
    public static void main(String[] args) {
        String[] strs = {"Arrays.sort", "mergerSort", "heapSrot", "quickSort", "selectionSort", "insertSort", "bubbleSort"};
        int testTime = 100;
        int maxSize = 10000;
        int maxValue = 10;
        long[] times = new long[strs.length];
//        int[] arr = {};
//        testAllSort(arr,times,strs, maxSize, maxValue);
//        testAllSort(times,strs, maxSize, maxValue);
        batchTestAllSorts(strs, testTime, maxSize, maxValue, times);
        printAllTestResult(strs, times);
    }

    /**
     * 批量测试所有排序方法
     *
     * @param strs     测试的排序方法
     * @param testTime 测试次数
     * @param maxSize  测试数组最大长度
     * @param maxValue 测试数组最大值
     * @param times    测试用时存储
     */
    private static void batchTestAllSorts(String[] strs, int testTime, int maxSize, int maxValue, long[] times) {
        for (int i = 0; i < testTime; i++) {
            testAllSort(times, strs, maxSize, maxValue);
        }
    }

    /**
     * 输出测试结果
     *
     * @param strs  测试的所有方法名
     * @param times 测试的所有结果
     */
    private static void printAllTestResult(String[] strs, long[] times) {
        for (int i = 0; i < strs.length; i++) {
            System.out.println(i + " " + strs[i] + ":" + times[i]);
        }
    }

    /**
     * 单次测试所有排序方法
     */
    private static long[] testAllSort(long[] times, String[] strs, int maxSize, int maxValue) {
        int[] arr1 = IntArrays.generateRandomArray(maxSize, maxValue);
        for (int i = 0; i < strs.length; i++) {
            times[i] += sortingTest(strs[i], arr1);
        }
        return times;
    }

    /**
     * 自定义测试用例，单次测试所有方法
     *
     * @param arr1 自定义的数组
     */
    private static long[] testAllSort(int[] arr1, long[] times, String[] strs, int maxSize, int maxValue) {
        for (int i = 0; i < strs.length; i++) {
            times[i] += sortingTest(strs[i], arr1);
        }
        return times;
    }

    /**
     * 测试方法
     *
     * @param str  待测试的排序方法名
     * @param arr1 待测试的数据
     * @return 测试用时
     */
    private static long sortingTest(String str, int[] arr1) {
        int[] arr2 = IntArrays.copyArray(arr1);
        long start = System.currentTimeMillis();
        switch (str) {
            case "Arrays.sort":
                Arrays.sort(arr2);
                break;
            case "bubbleSort":
                MySort.bubbleSort(arr2);
                break;
            case "selectionSort":
                MySort.selectionSort(arr2);
                break;
            case "insertSort":
                MySort.insertSort(arr2);
                break;
            case "mergerSort":
                MySort.mergerSort(arr2);
                break;
            case "quickSort":
                MySort.quickSort(arr2);
                break;
            case "heapSrot":
                MySort.heapSrot(arr2);
                break;
            default:
                System.out.println("switch：无效的方法名！");
                break;
        }
        return System.currentTimeMillis() - start;
    }
}
