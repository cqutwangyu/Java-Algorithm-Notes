package real;

/**
 * @ClassName 数组的荷兰国旗问题
 * @Description 左程云
 * @Author cqutwangyu
 * @DateTime 2019/3/22 15:38
 * @GitHub https://github.com/cqutwangyu
 */
public class 数组的荷兰国旗问题 {
    /**
     * 数组的荷兰国旗问题
     * 快速排序入口
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序递归处理
     * 数组的荷兰国旗问题 { 左边：< num  中间：==num  右边：> num }
     *
     * @param arr
     * @param left
     * @param right num
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //随机快排
//            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(arr, left, right);
            //右部分
            quickSort(arr, left, p[0] - 1);
            //中部分 p[0]-1 到 p[1]+1
            //左部分
            quickSort(arr, p[1] + 1, right);
        }
    }

    /**
     * @param arr
     * @param left  左边界
     * @param right 右边界，同时被当做中轴（num）
     * @return
     */
    private static int[] partition(int[] arr, int left, int right) {
        //0到less范围的数小于num
        int less = left - 1;
        //大值部分划分边界，将中轴划分为大值部分
        int more = right;
        //左边界小于右边界
        while (left < more) {
            //小于num
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                //大于num
                swap(arr, --more, left);
            } else {//等于num
                left++;
            }
        }
        swap(arr, more, right);
        //等于num的范围的起始下标
        return new int[]{less + 1, more};
    }

    /**
     * 交换两个数
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
