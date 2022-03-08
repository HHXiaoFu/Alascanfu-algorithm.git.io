# 题目
>给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。

> 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。

> 比方说，s = "`||**||**|*`" ，查询 [3, 8] ，表示的是子字符串 "`*||**|`" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。


示例1：

![image.png](https://pic.leetcode-cn.com/1646714397-fCJJOE-image.png)

```txt
输入：s = "**|**|***|", queries = [[2,5],[5,9]]
输出：[2,3]
解释：
- queries[0] 有两个盘子在蜡烛之间。
- queries[1] 有三个盘子在蜡烛之间。
```

示例2：
![image.png](https://pic.leetcode-cn.com/1646714393-SOvHLB-image.png)


```txt
输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
输出：[9,0,0,0,0]
解释：
- queries[0] 有 9 个盘子在蜡烛之间。
- 另一个查询没有盘子在蜡烛之间。
```


## 提示
- `3 <= s.length <= 10^5`
- `s 只包含字符 '*' 和 '|' 。`
- `1 <= queries.length <= 10^5`
- `queries[i].length == 2`
- `0 <= lefti <= righti < s.length`



## 📝思路📝


**本题考查知识点**

- 思路：这道题`小付在凌晨的时候就尝试的做了一下`，用的是 dp 也是`统计当前盘子下标位置时的左侧的蜡烛个数与当前盘子位置下标位置时的右侧的蜡烛个数`，毫无疑问`超时了O( n*m )的时间复杂度` 同时也`开辟了3个数组空间`用于存储数据所以就只好睡觉一早起来想了。
- 第二天一早`想着前天的前缀和与预处理的方法`以及`uu们的提示`我就知道了`这道题是可以采用前缀和+预处理来解决的`，不过这里`我们的预处理的左右侧蜡烛就不再是个数` ，反而是`左右侧最近的蜡烛下标`是否`在我们的子字符串范围内`，这样一来就`只需要一次遍历就可以进行预处理`，判断`当前位置`下的`左侧最近`和`右侧最近`的`蜡烛位置下标`是否`没有重合且在子字符串的范围之内`，则`可以记录当前位置下的满足条件的盘子个数`。


## 代码实现
**前缀和 + 预处理**
```java
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int m = s.length();
        int n = queries.length;
        // 分别用于记录当前位置下其左侧最近的蜡烛下标位置，以及当前位置下右侧最近的蜡烛下标位置
        int[] leftNearestCan = new int [m+1],rightNearestCan = new int [m+1],prefix = new int[m+1];
        // 初始化边界 如果找不到最近的蜡烛 则直接返回边界位置
        leftNearestCan[0] = -1;
        rightNearestCan[m] = m;
        // 预处理
        for (int i = 1;i<=m;i++){
        	// 用来求取当前位置的盘子个数
            prefix[i] = prefix[i-1] + (s.charAt(i-1) == '*' ? 1 : 0);
            // 这里是获取当前位置下 左侧最近的蜡烛下标
            leftNearestCan[i] = (s.charAt(i-1) == '|' ? i-1 : leftNearestCan[i-1]);
            // 这里是获取当前位置下 右侧最近的蜡烛下标
            rightNearestCan[m-i] = (s.charAt(m-i) == '|'? m-i : rightNearestCan[m-i+1]);
        }

        int[] res = new int [n];
        
        for (int i = 0 ; i< n;i++){
            // 记录当前查询位置的右侧最近的Idx，以及当前查询位置的左侧最近|的 Idx
            int lIdx = rightNearestCan[queries[i][0]],  rIdx = leftNearestCan[queries[i][1] + 1];
            // 为了防止当前查询左右位置相同 也就是子字符串为1的情况下 跳过当前查询
            if(lIdx+1 >= rIdx)continue;
            // 前缀和计算当前位置的满足条件的盘子个数
            res[i] = prefix[rIdx+1] - prefix[lIdx]; 
        }
        return res;
    }
}
```

- **时间复杂度:**`O(n+m)` 
- **空间复杂度:**`O(m)`  **这里开了两个大小为m+1的记录左侧下标位置和右侧下标位置的数组 结果数组不计入**


## 运行结果
**前缀和 + 预处理**

![image.png](https://pic.leetcode-cn.com/1646714362-wiGqTm-image.png)


