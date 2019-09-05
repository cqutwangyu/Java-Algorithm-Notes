package 剑指offer;

/**
 * @ClassName 二维数组中的查找
 * @Description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/7 13:15
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 二维数组中的查找 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 15, 16, 17, 18, 19}};
        int target = 13;
        System.out.println(solution.Find(target, array));
    }
    /**
     * 解题思路：根据题意每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增
     *      得出矩阵中的数字左边小，下边大。从右上角开始寻找，目标数小于当前数则左移，大于当前数则下移。
     */
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length==0||array[0].length==0)
        {
            return false;
        }
        int rows=array.length,cols=array[0].length;
        int r=0,c=cols-1;
        while(r <= rows-1 && c >= 0){
            if(target==array[r][c]){
                return true;
            }
            if(target<array[r][c]){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }

    public static class Solution {
        public boolean Find(int target, int[][] array) {
            int row = array.length;
            int column = array[0].length;
            //行数列数大于0 确保数组有值
            if (row > 0 && column > 0) {
                //遍历行
                for (int i = 0; i < row; i++) {
                    //判断目标是否小于这一行的最小值
                    if (target < array[i][0]) {
                        //目标小于最小值，说明不存在
                        return false;
                    }
                    //判断目标是否小于这一行的最大值
                    if (target <= array[i][column - 1]) {
                        //遍历这一行
                        for (int j = 0; j < column; j++) {
                            //找到目标
                            if (target == array[i][j]) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
