# 题目
>给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。

 

示例1：

```txt
输入: n = 13, k = 2
输出: 10
解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
```
示例2：

```txt
输入: n = 1, k = 1
输出: 1
```

## 提示
`1 <= k <= n <= 10^9`

## 📝思路📝
> 这里学习了两位大佬的思路一位是 [杨兴元——本题史上最完整具体的手摸手解答](https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/ben-ti-shi-shang-zui-wan-zheng-ju-ti-de-shou-mo-sh/)

> 另一位是 Benhao总的 `dfs + bfs` 的巧妙求解 这里就不贴代码了   [Benhao总的题解](https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/solution/pythonjavajavascriptgo-di-gui-by-himymbe-5mq5/)

**本题考查知识点**
- 小付的**错误解题思路**：这道题小付一开始以为是可以通过优先队列（堆排）来解决问题的，没想到O(n)都能抄，一看数据的范围，好家伙`1e9数量级`，`直接超时`，欧后，`不行就换思路嘛`， 然后我又想到了，`是否可以用字典树来解决这道问题呢`，字典树`需要开一个1e9的数组`，好家伙不用想也知道不行了，因为这`可不兴开一个1e9数量级的数组`,不出意外`会超内存`，`带着二十分钟的沉思我已经毫无头绪了，点开了题解。`
- **杨兴元大佬的思路**：当我们了解了数字在前缀树中的排序时，这道题的难点就在于如何解决所提到的这三个问题
> 1.怎么确定一个前缀下所有子节点的个数？
2.如果第 k 个数在当前的前缀下，怎么继续往下面的子节点找？
3.如果第 k 个数不在当前的前缀，即当前的前缀比较小，如何扩大前缀，增大寻找的范围？

**按照小付所能理解的，来理解如何解决这三个问题。**
1.当我们能确定一个`前缀下所有的节点个数`，就可以确定 第k小的字典序数是否在当前前缀的所有节点内。
2.得到了上述的结果，`就可以继续向下钻取搜索找到该第k小的字典序数`。
3.如果`没有在当前前缀中找到`，就`扩大前缀右移`，再次`判断当前扩大后的前缀中的子节点个数是否满足当前上一个条件`，满足就`跳转到第二个条件`，反之`重复条件3`.
## ⭐代码实现⭐
**杨兴元大佬题解：**
```java
class Solution {
    public int findKthNumber(int n, int k) {
    	// 遍历到字典序中第p个位置的数
        int p = 1;
        // 起始前缀从1开始
        int prefix = 1;
        // 如果还没有遍历到第k个数继续查找
        while(p < k){
        	// 获取当前前缀的子节点个数
            int cnt = getCnt(n,prefix);
            // 如果包含当前前缀的节点个数 > k 则说明我们要找的 第k小的数就在这个前缀子树当中
            if (p + cnt > k){
            	// 此时我们就要向下查找
                prefix *= 10;
                // 指针指向前缀子树的第一个子节点
                p++;
            }else if (p + cnt <= k){ // 反之我们扩大前缀 进入问题3
                prefix++;
                // 指针指向扩大前缀的第一个子节点位置
                p+=cnt;
            }
        
        }
        return prefix;
    }
    // 获取我们当前前缀下的子节点个数
    int getCnt(int n , int prefix){
    	// 设置当前前缀
        long curPrefix = prefix;
        // 设置下一前缀
        long nextPrefix = prefix + 1;
        // 用于计数
        int cnt = 0 ;
        while (curPrefix <= n){
        // 下一个前缀的起点减去当前前缀的起点的值 这里需要注意 如果next 大于上界n时那么可能出现左前缀不满的情况，为了避免这种情况的发生 取上界点值 进行当前前缀的值 就是子节点数，为何n+1 因为你要包括前缀树根节点
            cnt += Math.min(n+1,nextPrefix) - curPrefix;
            curPrefix *= 10;
            nextPrefix *= 10;
        }
        return cnt;
    }
}
```




## 运行结果
**前缀树+模拟计数**

![image.png](https://pic.leetcode-cn.com/1648024877-jHdRQB-image.png)

