# 题目
>你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

>空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。





示例1：

```txt
输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
```
示例2：

```txt
输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

输出: "1(2()(4))(3)"

解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
```

## 📝思路📝

**本题考查知识点**
- 思路：**题读明白了就容易了 难点在这个题的问题转换问题:**

- DFS深搜 遍历到底部的时候就可以跳出搜索了进行回溯搜索右子树，右子树存在时其左兄弟对应的空值节点也需要进行括号处理。
- 而右子树不为空时重复上述操作
## ⭐代码实现⭐
**DFS深搜**
```java
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(root,res);
        return res.toString().substring(1,res.length()-1);
    }
    public void dfs(TreeNode node ,StringBuilder res){
        if (node == null )return ;
        res.append("(");
        res.append(node.val);
        // 这里满足的是如果当前节点不存在左子树，但是存在右子树则需要为其左子树加上 ()
        if(node.left != null)dfs(node.left,res);
        else if (node.right != null) res.append("()");
        if(node.right != null)dfs(node.right,res);
        res.append(")");
    }
}
```

- **时间复杂度:** O($节点数+边数$)  
- **空间复杂度:** O($节点数$)


## 运行结果
**DFS深搜**

![image.png](https://pic.leetcode-cn.com/1647660151-BlrJYC-image.png)



