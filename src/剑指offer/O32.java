package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dutu
 * @date 2021-04-12 21:51
 */
public class O32 {
    public int[] levelOrder(TreeNode root) {


        if (root==null){
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()){

            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left!=null) queue.add(node.left);
            if (node.right!=null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;

    }
}
