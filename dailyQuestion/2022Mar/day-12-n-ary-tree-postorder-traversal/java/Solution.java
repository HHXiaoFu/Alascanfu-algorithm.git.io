import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/12 10:51
 * @description： Leetcode 每日一题 590.N叉树的后序遍历
 * @modified By： Alascanfu
 **/
class Solution590 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
            
				stack.push(node);
                stack.push(null);
				
                if (node.right != null)stack.push(node.right);
                /* 中序遍历
				stack.push(node);
                stack.push(null);
				*/
                if (node.left != null)stack.push(node.left);
                /* 前序遍历
				stack.push(node);
                stack.push(null);
				*/
            }else {
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
