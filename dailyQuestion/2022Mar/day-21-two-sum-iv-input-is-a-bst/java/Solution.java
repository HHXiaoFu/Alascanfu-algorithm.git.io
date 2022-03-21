import java.util.*;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/21 15:51
 * @description： Leetcode每日一题653两数之和4-输入BST
 * @modified By： Alascanfu
 **/
class Solution653 {
    /**
     * 功能描述
     * 方法1：BST中序遍历 + 双指针
     * @date 2022/3/21
     * @author Alascanfu
     */
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode>leftDeque = new ArrayDeque<>();
        Deque<TreeNode>rightDeque = new ArrayDeque<>();
        TreeNode node = root;
        while (node!=null){
            leftDeque.addLast(node);
            node = node.left;
        }
        node = root;
        while(node!=null){
            rightDeque.addLast(node);
            node = node.right;
        }
        
        TreeNode l = leftDeque.peekLast();
        TreeNode r = rightDeque.peekLast();
        while (l.val < r.val){
            int target = l.val + r.val;
            if (target == k)return true;
            if (target < k){
                l = getNext(leftDeque,true);
            }else {
                r = getNext(rightDeque,false);
            }
        }
        return false;
    }
    // 如果当前二者的值小于 k 则需要从左子树找到一个比当前值大的值 而大于k时则需要从右子树找到一个比当前值小的值
    TreeNode getNext(Deque<TreeNode> dq , boolean isLeft){
        TreeNode node = isLeft ? dq.pollLast().right : dq.pollLast().left;
        while (node != null){
            dq.addLast(node);
            node = isLeft ? node.left : node.right;
        }
        return dq.peekLast();
    }
    
    /**
     * 功能描述
     * 方法2 哈希+遍历
     * @date 2022/3/21
     * @author Alascanfu
     */
    Set<Integer> set = new HashSet<>();
    int k ;
    public boolean findTarget2(TreeNode root, int k) {
        this.k = k;
        return preorder(root);
    }
    // 加深一遍非递归方式的前序遍历的板子书写
    boolean preorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if (root == null )return false;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
                if(node.right != null)stack.push(node.right);
                if(node.left != null )stack.push(node.left);
                stack.push(node);
                stack.push(null);
            }else {
                node = stack.pop();
                if (set.contains(k - node.val))return true;
                set.add(node.val);
            }
        }
        return false;
    }
}
