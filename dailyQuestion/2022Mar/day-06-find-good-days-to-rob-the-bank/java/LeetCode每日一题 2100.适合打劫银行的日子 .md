# 题目
>你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。

>如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：

>第 i 天前和后都分别至少有 time 天。
>第 i 天前连续 time 天警卫数目都是`非递增的`。
>第 i 天后连续 time 天警卫数目都是`非递减的`。
>更正式的，第 i 天是一个合适打劫银行的日子当且仅当：
>`security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].`

>请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。


示例1：
```txt
输入：security = [5,3,3,3,5,6,2], time = 2
输出：[2,3]
解释：
第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
```
示例2：
```txt
输入：security = [1,1,1,1,1], time = 0
输出：[0,1,2,3,4]
解释：
因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
```
示例3：
```txt
输入：security = [1,2,3,4,5,6], time = 2
输出：[]
解释：
没有任何一天的前 2 天警卫数目是非递增的。
所以没有适合打劫银行的日子，返回空数组。
```
示例4:
```txt
输入：security = [1], time = 5
输出：[]
解释：
没有日子前面和后面有 5 天时间。
所以没有适合打劫银行的日子，返回空数组。
```

## 提示

-   `1 <= security.length <= 105`
-   `0 <= security[i], time <= 105`

## 📝思路📝


**本题考查知识点**

- 思路：和打劫沾边的LC题多半和动态规划，因为你肯定做过`打家劫舍系列和炒股股票系列`。我们先`试试能不能用动归处理本题`，动归的`难点就是在于如何找到动态转化方程`，由题咱们可以知道，我们所需要的结果日子下标一定是出现在 窗口 `[time , nums.length - time]`这个区间范围之内的，我们`只需要分别模拟出在这个窗口之间`的`当前日子下标时`其`满足左侧日子的天数`和`右边满足日子的天数`。如果满足则天数+1，我们很容易就能构造出动态转化方程。


## 代码实现
**动态规划**
```java
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        // 用于记录当前下标下左侧的满足条件的天数的值
        int []leftDay = new int[n];
        // 用于记录当前下标右侧的满足条件的天数的值
        int []rightDay = new int[n];
        // 从左往右开始记录当前日子下标符合条件的左侧日子数量
        // 从右往左开始记录当前日子下标符合条件的右侧日子数量
        for (int i = 1 ;i < n;i++){
            if (security[i] <= security[i-1])leftDay[i] = leftDay[i-1] + 1;
            if (security[n- i - 1] <= security[n-i])rightDay[n- i - 1] = rightDay[n - i] + 1;
        }
        
        List<Integer> res = new ArrayList<>();
        // 从左往右遍历窗口中的日期 比较记录日期下表对应的左侧符合条件的左侧日子数量和符合条件的右侧日子数量即可
        for (int i = time;i< n -time;i++){
            if (leftDay[i] >= time && rightDay[i] >=time)res.add(i);
        }
        return res;
    }
}
```

- **时间复杂度:**`O(n)` 单循环遍历分别左往右 和 右往左
- **空间复杂度:**`O(n)` 构建了一个List 其空间最大为n因为最多可以有n天进行打劫

## 运行结果
**dp动态规划**

![image.png](https://pic.leetcode-cn.com/1646565088-ZITNTC-image.png)
