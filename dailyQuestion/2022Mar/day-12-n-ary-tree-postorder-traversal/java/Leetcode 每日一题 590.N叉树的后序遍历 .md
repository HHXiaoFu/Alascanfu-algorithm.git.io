# 题目
>给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。

> n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。





示例1：
![image.png](https://pic.leetcode-cn.com/1647052602-sZASxi-image.png)


```txt
输入：root = [1,null,3,2,4,null,5,6]
输出：[5,6,3,2,4,1]
```

示例2：
![image.png](https://pic.leetcode-cn.com/1647052605-QOuwYt-image.png)


```txt
输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
```


## 提示
`节点总数在范围 [0, 104] 内`
`0 <= Node.val <= 104`
`n 叉树的高度小于或等于 1000`



## 📝思路📝


**本题考查知识点**
- 这里小付主要是对之前学习过得模板做下总结，总到理解别人给出的板子进行深刻记忆，或许过了很久只要思路在，自己写出来也不难。这里主要介绍两个板子，一个是递归版本的，一个是非递归版本的。

> 递归求解是一个最基础的入门模板——就不说废话啦
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
- 栈的特性是先进后出，我们由二叉树的遍历来理解板子。做到一题五刷
- [《Leetcode 144. 二叉树的前序遍历》](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)
- [《Leetcode 94. 二叉树的中序遍历》](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)
- [《Leetcode 145. 二叉树的后序遍历》](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)
- [《Leetcode 589. N 叉树的前序遍历》](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)
- 我们知道`栈的特性`：`先进后出`，我们知道`前序遍历`是 `中左右`、`中序遍历`是 `左中右` 、`后序遍历`是 `左右中`。那么就`很好理解对应的栈中入栈的顺序就是`，前序对应的`前序遍历入栈`节点顺序就是 `右左中` 。中序对应的`中序遍历入栈`节点顺序就是 `右中左`。后序对应的`后序遍历入栈`节点顺序就是 `中右左`。这样一来就可以总结出模板 `改变的位置就是中间的位置`，能`使用模板的前提就是我们遍历的顺序要与处理的顺序一致`，所以在能套模板之前我们需要对其树的遍历顺序与处理顺序做出对应的处理，总结出模板。
**这里的模板出自《代码随想录》有兴趣的同学可以去研习一下。这里小付重新赘述一下思路QwQ 如何使得咱们的 遍历顺序与处理节点顺序达成一致。**
- 在前面我们`已经根据了栈的特性`理解了`相对于树中的每个节点`需要`如何进行入栈的顺序`做出了相应分析才能`获取我们想要的出栈遍历树的顺序`。
1、我们第一步是将整棵树入栈。
2、针对于栈内非空进行处理当前理应该处理的节点`Node node = stack.pop()`
3、既然我们为了`保证自己确定遍历顺序来改变处理的节点顺序`，我们不妨针对于遍历的每个节点加入到栈中，然后根据当前这个节点是否需要进行处理进行判断，那这个判断`如何判断是当前节点就是需要进行处理呢`？我们可以在这个处理节点`加上一个Null节点作为其是否需要处理的判断`，`如果存在这个Null节点则说明当前需要进行处理`，`如果不存在则无需进行处理`。
- 这个过程是什么呢？我们必须要进行举个示例进行说明不然太抽象了。
```txt
我们以树[5,4,6,1,2]来进行举例
	1、一开始我们的 stack 进行初始化当前的root节点就会直接被加入
		那么此时我们的 stack ：
		stack[[5,4,6,1,2]]
	2、只要栈中还有元素则说明还没遍历完，此时我们无论如何都要先取出当前节点，
		后续在进行处理当前位置是否与处理顺序一致的问题。
		那么此时stack 与 我们的取出节点 node ：
		stack[] 弹出了所以就没得了
		node [5,4,6,1,2] node 是一个树节点
	3、然后就可以处理如何使得处理顺序与遍历顺序一致的问题了
		当前节点不为空，所以我们需要先进行遍历，正如栈的特性讲到 
		右 和 左 的入栈顺序固定的，反复横跳的只有 中
		因为是后续遍历嘛，所以我们的 中 需要先入栈 
		我们肯定实现要处理 右 左 最后才处理中 所以我们一直遍历加入 右 左 
		需要处理中的时候加上 null节点
		遍历一遍的stack就是如此  这是后续遍历的
		stack [[5,4,6,1,2],null,[6],[4,1,2],null,[2],[1],null]
		当然我们也可以拿着同样的树模拟前序遍历 中序遍历
		中序遍历的stack
		stack [[6],[5,4,6,1,2],null,[2],[4,1,2],null,1]
		很容易理解每次当我们 右中左 最后为左的时候就需要进行处理了所以此时左的位置就是null
		前序遍历的stack
		stack [[6],[4,1,2],[5,4,6,1,2],null] 
		很容易理解当我们 右左中 最后为中的时候进行处理所以中的位置就是null进行处理了
```
**小付简化后的模板~**
```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)return res;
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node != null){
            	/* 后序遍历 
				stack.push(node);
                stack.push(null);
				*/
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
```

## ⭐代码实现⭐
**递归求解**
```java
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null)return res;
        for (int i = 0;i<root.children.size();i++){
            postorder(root.children.get(i));
        }
        res.add(root.val);
        return res;
    }
}
```

- **时间复杂度:** `O(n)` 
- **空间复杂度:** `O(n)` 

**迭代实现**
```java
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null)return res;
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            if (node != null){
                stack.push(node);
                stack.push(null);
                for (int i = node.children.size()-1;i>=0;i--)stack.push(node.children.get(i));
            } else {
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;

    }
}
```

- **时间复杂度:** `O(n)` 
- **空间复杂度:** `O(n)` 

## 运行结果
**递归**<br>

![image.png](https://pic.leetcode-cn.com/1647052573-CFpdmB-image.png)


**迭代**<br>
![image.png](https://pic.leetcode-cn.com/1647052558-XvYGYY-image.png)


