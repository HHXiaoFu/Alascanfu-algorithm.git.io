# :bookmark_tabs:线段树(Segment Tree)的学习

> 什么是线段树？

- 线段树（Segment Tree）也称之为`区间树`，是`一种二叉搜索树`，它将`一个区间划分成一些单元区间`，**每个单元区间对应线段树中的一个叶子结点**。

- 事实上，一棵线段树的`根结点表示的是“整体”区间`，而`它的左右子树也是一棵线段树`，分别`表示区间的左半边和右半边`。树中的每个结点表示一个区间`[a,b]`。

- 对于`每一个非叶结点所表示的结点[a,b]`，其`左孩子表示的区间为[a,(a+b)/2]`，右孩子表示的区间为`[(a+b)/2,b]`。 **用T(a, b)表示一棵线段树**，**参数a,b表示区间[a,b]**，**其中b-a称为区间的长度，记为L。**

- 线段树可以在 的时间复杂度$O(log_2N)$内`实现单点修改`、`区间修改`、`区间查询`（**区间求和，求区间最大值，求区间最小值**）等操作。

## :book: 例题为例

> #### [1606. 找到处理最多请求的服务器](https://leetcode-cn.com/problems/find-servers-that-handled-most-number-of-requests/)

> **以k = 3, arrival = [1,2,3,4,5], load = [5,2,3,3,3] 为例子**

![image.png](https://pic.leetcode-cn.com/1648614873-XoqUoP-image.png)

### :bookmark_tabs: 构建线段树

- 构建一个线段树,值域为`[0,2]`,即`[0, k-1]`
- 线段树的`每个子节点包含左右子节点`,`子服务器的最小任务结束时间`, `服务器ID范围`

- 注意: 线段树叶子节点的ID范围相等,即$l=r$

![image.png](https://pic.leetcode-cn.com/1648614879-FiEfjM-image.png)

```java
static class Node{
    // 任务结束时间
    int endTime = 0 ;
    // 记录服务器ID的范围
    int l , r;
    Node left=null,right=null;
    public Node(int l ,int r){
        this.l = l;
        this.r = r;
    }
}
```

> 通过递归构建线段树

```java
Node buildSegmentTree(int left ,int right){
     Node node = new Node(left,right);
     if (left == right){
        return node;
     }

     int mid = left + right >> 1;
     node.left = buildSegmentTree(left,mid);
     node.right = buildSegmentTree(mid+1,right);
     return node;
}
```

### :bookmark_tabs: 更新线段树

> **当消息1到达时**

- 更新当前服务器任务的结束时间：$endTime = arrival(i) + load(i)$

![image.png](https://pic.leetcode-cn.com/1648615099-qUCHlr-image.png)

> **当消息2到达时**

- 更新父结点的任务结束时间 $endTime = Math.min(left.endTime , right.endTime)$

![image.png](https://pic.leetcode-cn.com/1648615505-zUGXfs-image.png)

### :bookmark_tabs: 查询线段树

- 查询时，需要找到 $i \% k $往后的服务器(如果需要从0开始)
- 设置 $pos = i \%k ,range1 =[pos , k- 1],range2 = [0,pos-1]$ 

- **优先查询range1的范围,没有满足条件的,再查询range2的范围**
- **遍历顺序相当于先序遍历(根左右)**

![image.png](https://pic.leetcode-cn.com/1648615600-HYKrog-image.png)

### :bookmark_tabs: 代码实现

```java
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Node root = buildTree(0, k - 1);
        int[] cnt = new int[k];
        int max = 0;
        for (int i = 0; i < arrival.length; i++) {
            // 没有空虚的服务器
            if (arrival[i] < root.end) {
                continue;
            }
            int pos = i % k;
            // 查询 pos 到 k-1 的区间
            int x = query(root, pos, k - 1, arrival[i]);
            if (x == -1) {
                // 查询 0 到 pos-1的区间
                x = query(root, 0, pos - 1, arrival[i]);
            }
            // 计数
            cnt[x]++;
            // 保存最大值
            max = Math.max(max, cnt[x]);
            // 更新服务器x的值
            update(root, x, arrival[i] + load[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                list.add(i);
            }
        }
        return list;
    }

    private int query(Node root, int l, int r, int start) {
        if (root.l == root.r) {
            if (root.l >= l && root.l <= r) {
                return root.l;
            }
            return -1;
        }
        int mid = (root.l + root.r) >>> 1;
        int val = -1;
        // 访问左子树
        if (l <= mid && start >= root.left.end) {
            val = query(root.left, l, r, start);
        }
        if (val != -1) {
            return val;
        }
        // 访问右子树
        if (r > mid && start >= root.right.end) {
            val = query(root.right, l, r, start);
        }
        return val;
    }

    private void update(Node root, int x, int end) {
        if (root.l == root.r) {
            // 更新叶子节点
            root.end = end;
            return;
        }
        int mid = (root.l + root.r) >>> 1;
        if (x <= mid) {
            update(root.left, x, end);
        } else {
            update(root.right, x, end);
        }
        // 父节点的结束时间是左右子节点结束时间的小值
        root.end = Math.min(root.left.end, root.right.end);
    }
    
    private Node buildTree(int left, int right) {
        Node node = new Node(left, right);
        if (left == right) {
            return node;
        }
        int mid = (left + right) >>> 1;
        node.left = buildTree(left, mid);
        node.right = buildTree(mid + 1, right);
        return node;
    }

    static class Node {
        // 任务结束时间
        int end = 0;
        // 记录服务器ID,范围
        int l, r;
        // 服务器左右子节点
        Node left = null, right = null;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
```

