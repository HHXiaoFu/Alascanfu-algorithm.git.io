# 题目
>给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。

>n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。



示例1：
![image.png](https://pic.leetcode-cn.com/1646898697-nlIrNy-image.png)

```txt
输入：root = [1,null,3,2,4,null,5,6]
输出：[1,3,5,6,2,4]
```

示例2：
![image.png](https://pic.leetcode-cn.com/1646898702-OtOaRa-image.png)


```txt
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
```


## 提示
- `点总数在范围 [0, 104]内`
- `0 <= Node.val <= 10^4`
- `n 叉树的高度小于或等于 1000`



## 📝思路📝


**本题考查知识点**
- 这里小付从`二叉树的前序遍历`解法`到扩展到N叉树的前序遍历`的方法思路讲解。
- 题目在这里哦~   [Leetcode 144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

> 递归求解是一个模板——就不多bb了
```java
class Solution {
    List<Integer> res = new LinkedList<>();
    public List<Integer> traverse(TreeNode root) {
      if (root == null)return res;
      // 前序遍历 res.add(root.val);
      traverse(root.left);
      // 中序遍历 res.add(root.val);
      traverse(root.right);
      // 后续遍历 res.add(root.val);
      return res;
    }
}
```

> 利用栈迭代求解
- 栈的特性：`先进后出`，前序遍历出来的顺序是，`中左右` 以 `[1,2,3]` 这个二叉树来举例我们很容易就知道 `其前序遍历`的结果就是 `[1,2,3]` ,那我们就`可以总结出前序遍历` 是`先处理中间节点`，然后根据栈的特性先进后出，我们在栈中的当前的节点的子节点`对于同一层的树节点`我们应该先将右节点入栈，然后再将左节点入栈，这样才可以满足左节点先出栈处理，后右节点出栈处理。
- 然后就是简单地代码实现

>  [Leetcode 144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
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
```
**有了上述二叉树的前序遍历思路，那就容易了，N叉树无外乎就是多了几个子树节点，从右往左依次入栈，然后出栈依次处理就能完成中左右的前序遍历操作了。**
## 代码实现
**递归求解**
```java
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null)return res;
        res.add(root.val);
        for(Node child:root.children)preorder(child);
        return res;
    }
}
```

- **时间复杂度:** `O(n)` 
- **空间复杂度:** `O(n)` 

**迭代实现**
```java
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null)return res;
        stack.add(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1;i>=0;i--){
                stack.add(node.children.get(i));
            }
        }   
        return res;
    }
}
```

- **时间复杂度:** `O(n)` 
- **空间复杂度:** `O(n)` 

## 运行结果
**递归**

![image.png](https://pic.leetcode-cn.com/1646898683-GrxbvM-image.png)


**迭代**
![image.png](https://pic.leetcode-cn.com/1646898676-EWmjGt-image.png)
