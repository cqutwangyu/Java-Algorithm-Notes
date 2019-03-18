package LogarithmicDetector;

import AlgorithmBased.MySort;

import java.util.Arrays;

/**
 * @ClassName IntArrays
 * @Description 一维 int 数组 对数器
 * @Author ChongqingWangYu
 * @DateTime 2019/3/18 20:50
 * @GitHub https://github.com/ChongqingWangYu
 */
public class IntArrays {
    public static void main(String[] args) {
        int testTime = 1;
        int maxSize = 10;
        int maxValue = 10;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int arr1[] = generateRandomArray(maxSize, maxValue);
            int arr2[] = copyArray(arr1);
            MySort.mergerSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fuched");

    }

    /**
     * 产生随机一维数组，值可能为负数，也可能为空数组
     *
     * @param size  数组最大长度
     * @param value 数组中的值，取值范围最大值
     * @return
     */
    public static int[] generateRandomArray(int size, int value) {
        int[] arr = new int[(int) ((size + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random()) - ((int) (value * Math.random()));
        }
        return arr;
    }

    /**
     * 复制一个数组
     *
     * @param arr 被复制的数组
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 判断两个数组是否相同
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.println("error index:" + i + " error");
                return false;
            }
        }
        return true;
    }

    /**
     * 输出数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
