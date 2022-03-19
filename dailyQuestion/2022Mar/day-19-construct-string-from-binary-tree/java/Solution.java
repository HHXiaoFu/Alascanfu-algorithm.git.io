import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/19 11:29
 * @description： Leetcode 每日一题 606 根据二叉树创建字符串
 * @modified By： Alascanfu
 **/
class Solution606 {
    // 递归实现
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root, res);
        return res.toString().substring(1, res.length() - 1);
    }
    
    public void dfs(TreeNode node, StringBuilder res) {
        if (node == null) return;
        res.append("(");
        res.append(node.val);
        // 这里满足的是如果当前节点不存在左子树，但是存在右子树则需要为其左子树加上 ()
        if (node.left != null) dfs(node.left, res);
        else if (node.right != null) res.append("()");
        if (node.right != null) dfs(node.right, res);
        res.append(")");
    }
    
    /**非递归实现*/
    public String tree2str2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (set.contains(node)){
                res.append(")");
            }else {
                stack.push(node);
                res.append("(");
                res.append(node.val);
                if (node.right != null)stack.push(node.right);
                if (node.left != null)stack.push(node.left);
                else if (node.right != null)res.append("()");
                set.add(node);
            }
        }
        return res.toString().substring(1,res.length()-2);
    }
}

