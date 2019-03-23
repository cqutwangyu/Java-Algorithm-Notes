package 剑指offer;

import LeetCode.先序遍历构造二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName 重建二叉树
 * @Description 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/21 19:24
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 重建二叉树 {

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    /**
     * 根据前序遍历和中序遍历还原二叉树
     * @param pre 前序遍历
     * @param in 中序遍历
     * @return 递归得出原二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
