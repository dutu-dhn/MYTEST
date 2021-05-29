package 剑指offer;


import java.util.Stack;

/**
 * @author dutu
 * @date 2021-04-10 9:25
 */
public class O27 {
    public TreeNode mirrorTree(TreeNode root) {

        if(root == null) return null;

        Stack<TreeNode> stack = new Stack<TreeNode>() {{ add(root); }};

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;

    }
    public TreeNode mirrorTree1(TreeNode root) {
        //递归函数的终止条件，节点为空时返回
        if(root==null) {
            return null;
        }
        //下面三句是将当前节点的左右子树交换
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        //递归交换当前节点的 左子树
        mirrorTree(root.left);
        //递归交换当前节点的 右子树
        mirrorTree(root.right);
        //函数返回时就表示当前这个节点，以及它的左右子树
        //都已经交换完了
        return root;
    }

}
