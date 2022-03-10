import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/10 20:42
 * @description： 二叉树的遍历（递归或迭代方式模板）
 * @modified By： Alascanfu
 **/
public class TraversalOfBinaryTree {
    List<Integer> res = new ArrayList<>();
    /**
     *功能描述
     * 递归实现前序遍历
     * @date 2022/3/10
     *  @author Alascanfu
     */
    public List<Integer> preorderTraversalByRecursion (TreeNode root) {
        if (root == null )return res;
        res.add(root.val);
        preorderTraversalByRecursion(root.left);
        preorderTraversalByRecursion(root.right);
        return res;
    }
    /**
     *功能描述
     * 递归实现中序遍历
     * @date 2022/3/10
     *  @author Alascanfu
     */
    public List<Integer> inorderTraversalByRecursion (TreeNode root) {
        if (root == null )return res;
        inorderTraversalByRecursion(root.left);
        res.add(root.val);
        inorderTraversalByRecursion(root.right);
        return res;
    }
    /**
     *功能描述
     * 递归实现后序遍历
     * @date 2022/3/10
     *  @author Alascanfu
     */
    public List<Integer> postorderTraversalByRecursion (TreeNode root ){
        if (root == null )return res;
        postorderTraversalByRecursion(root.left);
        postorderTraversalByRecursion(root.right);
        res.add(root.val);
        return res;
    }
    /**
     *功能描述
     * 迭代实现前序遍历
     * @date 2022/3/10
     *  @author Alascanfu
     */
    public List<Integer> preorderTraversalByIterate (TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                if (node.right != null)stack.push(node.right);
                if (node.left != null)stack.push(node.left);
                stack.push(node);
                stack.push(null);
            }else {
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
    
    /**
     *功能描述
     * 迭代实现中序遍历
     * @date 2022/3/10
     *  @author Alascanfu
     */
    public List<Integer> inorderTraversalByIterate (TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                if (node.right != null)stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null)stack.push(node.left);
            }else {
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
    
    /**
     *功能描述
     * 迭代实现后序遍历
     * @date 2022/3/10
     *  @author Alascanfu
     */
    public List<Integer> postOrderTraversalByIterate (TreeNode root){
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
                if (node.left != null)stack.push(node.left);
            }else {
                node = stack.pop();
                res.add(node.val);
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