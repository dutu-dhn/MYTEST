package leetcode;

public class L100 {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode());
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode());
        boolean sameTree = isSameTree(p, q);
        System.out.println(isSameTree(q,p));
    }
}
