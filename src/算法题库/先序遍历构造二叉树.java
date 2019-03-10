package 算法题库;

/**
 * @ClassName 先序遍历构造二叉树
 * @Description 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。  (回想一下，二叉搜索树是二叉树的一种，其每个节点都满足以下规则，对于 node.left 的任何后代，值总 < node.val，而 node.right 的任何后代，值总 > node.val。此外，先序遍历首先显示节点的值，然后遍历 node.left，接着遍历 node.right。）     示例：  输入：[8,5,1,7,10,12] 输出：[8,5,10,1,7,null,12]     提示：  1 <= preorder.length <= 100 先序 preorder 中的值是不同的。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/10 11:31
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 先序遍历构造二叉树 {
    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 7, 10, 12};
        bstFromPreorder(arr);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode temp = root;
        TreeNode n;
        for (int i = 1; i < preorder.length; i++) {
            n = new TreeNode(preorder[i]);
            setNode(root, n);
        }
        return root;
    }

    private static void setNode(TreeNode root, TreeNode n) {
        if (n.val < root.val) {
            if (root.left != null) {
                setNode(root.left, n);
            } else {
                root.left = n;
            }
        } else if (n.val > root.val) {
            if (root.right != null) {
                setNode(root.right, n);
            } else {
                root.right = n;
            }
        }
    }

    public static class TreeNode {
        int val;
        //左子树值小于node.val
        TreeNode right;
        //左子树值大于node.val
        TreeNode left;

        TreeNode(int x) {
            val = x;
        }
    }
}
