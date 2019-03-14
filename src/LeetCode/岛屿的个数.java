package LeetCode;

/**
 * @ClassName 岛屿的个数
 * @Description 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。  示例 1:  输入: 11110 11010 11000 00000  输出: 1 示例 2:  输入: 11000 11000 00100 00011  输出: 3
 * @Author ChongqingWangYu
 * @DateTime 2019/2/27 13:13
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 岛屿的个数 {
    /**
     * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，
     * 并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
     * 示例 1:
     * 输入:
     * 11110
     * 11010
     * 11000
     * 00000
     * 输出: 1
     * 示例 2:
     * 输入:
     * 11000
     * 11000
     * 00100
     * 00011
     * 输出: 3
     *
     * @param args
     */
    public static void main(String[] args) {
        char[][] arr = {{1}, {1}};
        System.out.println(numIslands(arr));
    }

    /**
     * 将一块岛屿的延伸部分删除，变为0，避免第再次扫到同一个岛屿
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int count = 0;
        boolean isJoined = false;
        char centre, top, left, bottom, rigth;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                centre = grid[i][j];
                top = i > 0 ? grid[i - 1][j] : 0;
                left = j > 0 ? grid[i][j - 1] : 0;
                bottom = i + 1 < grid.length ? grid[i + 1][j] : 0;
                rigth = j + 1 < grid[i].length ? grid[i][j + 1] : 0;
                if ((top + left + bottom + rigth) == 0) {
                    isJoined = false;
                }
                if (centre == '1') {
                    if (isJoined == false) {
                        count++;
                        isJoined = true;
                    }
                }
            }
        }
        return count;
    }
}
