package AlgorithmBased;

import LogarithmicDetector.IntArrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

/**
 * @ClassName MySort
 * @Description 排序算法集合
 * @Author cqutwangyu
 * @DateTime 2019/3/18 21:09
 * @GitHub https://github.com/cqutwangyu
 */
public class MySort {

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //每次循环将最大的数放到end的最后一位，然后end--
        for (int end = arr.length - 1; end > 0; end--) {
            //下标小于end
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    //将小数放在左边，大的数放在右边
                    swap(arr, j, j + 1);
                }
            }
        }
        return;
    }


    /**
     * 选择排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //记录最小值的下标
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //找到最小的数的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            //将最小的数放到i位置
            swap(arr, i, minIndex);
        }
        return;
    }


    /**
     * 插入排序
     * 常数量小于60，插入排序性能最优
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~i的位置为有序区
        for (int i = 1; i < arr.length; i++) {
            //从i-1到0遍历，将数有序插入左边已排序的序列中。类似扑克牌整牌。
            for (int j = i - 1; j >= 0; j--) {
                //如果当前数比下一个数大
                if (arr[j] > arr[j + 1]) {
                    //将当前数与下一个数交换
                    swap(arr, j, j + 1);
                }
            }
        }
        return;
    }

    /**
     * 归并排序入口
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)     使用内部缓存法可使空间复杂度变为O(1)，相当复杂
     */
    public static void mergerSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergerSortProcess(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序递归处理
     */
    private static void mergerSortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        //L和R中点的位置 (L+R)/2
        int mid = L + ((R - L) >> 1);
        //左半部分排序 复杂度 T(n/2)
        mergerSortProcess(arr, L, mid);
        //右半部分排序 复杂度 T(n/2)
        mergerSortProcess(arr, mid + 1, R);
        //两部分合并 O(N)
        merge(arr, L, mid, R);
        //T(n)=2*T(n/2)+O(n)
    }

    /**
     * 将左部分与右部分合并
     */
    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        //p1=0
        int p1 = L;
        //p2=(0+length-1)/2
        int p2 = mid + 1;
        //p1到中轴，p2到最后一个
        while (p1 <= mid && p2 <= R) {
            //p1与p2下标的值，谁小填谁到help[i]，并且填入和被填入的下标++，没填入的下标不变
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p1与p2必有且只有一个越界。
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    /**
     * 快速排序入口
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快排递归程序
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //取一个枢轴（中心点）
            int pivot = partition(arr, left, right);
            //小于pivot部分排序
            quickSort(arr, left, pivot - 1);
            //大于pivot部分排序
            quickSort(arr, pivot, right);
        }
    }

    /**
     * 快排划分程序
     * 小于等于pivot的放左边，大于pivot的放右边
     */
    private static int partition(int[] arr, int left, int right) {
        //待排序范围的中轴
        int mid = (left + right) / 2;
        //中轴的值
        int pivot = arr[mid];
        //没有越界
        while (left <= right) {
            //从左往右找到大于等于pivot的值
            while (arr[left] < pivot) {
                ++left;
            }
            //从右往左找到小于等于pivot的值
            while (pivot < arr[right]) {
                --right;
            }
            //没有越界
            if (left <= right) {
                //小于等于pivot的放左边，大于pivot的放右边
                swap(arr, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    /**
     * 堆排序
     */
    public static void heapSrot(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0~i的位置形成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //0~heapSize为大根堆的有效区域
        int heapSize = arr.length;
        //将堆顶的最大值，放到数组最后
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            //将被改变后的堆，重新形成大根堆
            heapify(arr, 0, heapSize);
            //将堆顶的最大值放到大根堆有效范围的最后一个位置
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 形成大根堆，堆的存储结构为数组
     * 父节点：(i-1)/2
     * 左孩子：i*2+1
     * 右孩子：i*2+2
     */
    private static void heapInsert(int[] arr, int i) {
        //如果当前数比其根节点大，则与根节点交换，直到不大于根节点，形成大根堆
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 堆调整
     *
     * @param arr
     * @param i        当前数下标
     * @param heapSize 大根堆的有效区域
     */
    private static void heapify(int[] arr, int i, int heapSize) {
        //左孩子（left+1为右孩子）
        int left = i * 2 + 1;
        while (left < heapSize) {
            //如果存在右孩子，则取左右孩子之间的最大值下标
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //最大的子节点值与根节点的值取最大值下标
            largest = arr[largest] > arr[i] ? largest : i;
            //如果根节点值是最大，则不交换
            if (largest == i) {
                break;
            }
            //如果子节点比根节点大，则交换
            swap(arr, largest, i);
            //交换后更新根节点和左孩子的下标
            i = largest;
            left = i * 2 + 1;
        }
    }

    /**
     * 交换两个数
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 交换两个对象
     */
    public static void swap(Object[] arr, int i, int j) {
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
