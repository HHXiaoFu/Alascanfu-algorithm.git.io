import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/10 22:54
 * @description： Leetcode 589.N叉树的前序遍历
 * @modified By： Alascanfu
 **/
class Solution589 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)return res;
        stack.add(root);
        // 如果栈内还有节点就可以继续遍历
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            // 如果当前遍历的节点还有右节点就将其将入栈
            if (node.right != null){
                stack.add(node.right);
            }
            // 如果当前遍历节点还有左节点就将其入栈
            if (node.left != null){
                stack.add(node.left);
            }
        }
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}