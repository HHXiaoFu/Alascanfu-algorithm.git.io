# 题目
>给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。

>如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。

>对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。



示例1：


```txt
输入：nums = [3,1]
输出：2
解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
- [3]
- [3,1]
```

示例2：
```txt
输入：nums = [2,2,2]
输出：7
解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集。
```
示例3：
```txt
输入：nums = [3,2,1,5]
输出：6
解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
- [3,5]
- [3,1,5]
- [3,2,5]
- [3,2,1,5]
- [2,5]
- [2,1,5]
```


## 提示

- `1 <= nums.length <= 16`
- `1 <= nums[i] <= 105`



## 📝思路📝

**本题考查知识点**
- 思路：最近做了很多关于dfs和bfs的题，看到这道题的第一次尝试就是深搜。
- 但是深搜之前我们`必须要知道当前数组的按位或的最大值`，这个很容易求出来，`只需要逐位对该数组元素或运算即可获得最大的按位或最大值`。

**📝得到这个最大值了我们就可以进行深搜了**

- 深搜的`前提是要先找到递归的跳出条件`，很容易知道当咱们的元素起始坐标`深搜到数组最后一个元素的时候`就可以终止递归了，然后`就是对当前子集是否满足其最大按位或值进行判定`，记录结果值。
- 既然如此，我们就需要知道深搜的到底是啥，然后才能写出递归深搜方向，对于`每次按位或运算`，可以`对当前位进行或运算或者不进行或运算两种情况`(**即子集中是否包含该元素或者不包含该元素**)，对这些情况进行深搜判断，记录搜或不搜的或运算值与递归终止条件中的最大或运算值进行比较记录。
****
> [三叶姐姐的状压思路](https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/solution/by-ac_oier-dos6/)

状压DP真的很难，会慢慢掌握的~
## ⭐代码实现⭐
**DFS深搜处理间接返回结果值**
```java
class Solution {
    int res = 0 ;
    public int countMaxOrSubsets(int[] nums) {
        int maxOfBitOr = nums[0];
        for (int i : nums)maxOfBitOr |= i;
        dfs(nums,0,0,maxOfBitOr);
        return res;
    }

    void dfs(int[] nums,int u,int val,int maxOfBitOr){
    	// 递归终止条件 跳出递归的时候
        if (nums.length == u){
        	// 对按位或运算的最大值进行判定 如果符合条件结果+1
            if (val == maxOfBitOr)
                res ++;
            // 如果不符合最大值 那说明当前子集可以直接淘汰不记录
            return ;
        }
        // 对下一个元素进行或运算 或者不进行或运算的深搜情况 即是否添加该元素到当前子集中 符合按位或运算最大值的符合条件
        dfs(nums,u+1,val,maxOfBitOr);
        dfs(nums,u+1,val|nums[u],maxOfBitOr);
    }
}
```

- **时间复杂度:** O($n + 2^n$)  
- **空间复杂度:** `O(1)`  忽略递归额外空间消耗。

**DFS深搜直接返回结果值**
```java
class Solution {
    int dfs(int u ,int val,int[] nums,int maxOfBitOr){
        if (u == nums.length){
            if (val == maxOfBitOr)return 1;
            return 0;
        }
        return dfs(u+1,val,nums,maxOfBitOr)+dfs(u+1,val | nums[u] ,nums,maxOfBitOr);
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOfBitOr = 0;
        for (int i: nums)maxOfBitOr|=i;
        return dfs(0,0,nums,maxOfBitOr);
    }
}
```

- **时间复杂度:** O($n + 2^n$)  
- **空间复杂度:** `O(1)`  忽略递归额外空间消耗。


## 运行结果
**DFS深搜**

![G3\]XTO4RT1OK0HD2T_N5I6Y.png](https://pic.leetcode-cn.com/1647316027-ZiyCvV-G3%5DXTO4RT1OK0HD2T_N5I6Y.png)

