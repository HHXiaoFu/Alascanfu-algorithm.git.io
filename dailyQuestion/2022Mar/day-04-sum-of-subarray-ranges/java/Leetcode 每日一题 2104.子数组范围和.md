# 题目
>给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。

>返回 nums 中 所有 子数组范围的 和 。

>子数组是数组中一个`连续 非空` 的元素序列。



示例1：
```txt
输入：nums = [1,2,3]
输出：4
解释：nums 的 6 个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0 
[2]，范围 = 2 - 2 = 0
[3]，范围 = 3 - 3 = 0
[1,2]，范围 = 2 - 1 = 1
[2,3]，范围 = 3 - 2 = 1
[1,2,3]，范围 = 3 - 1 = 2
所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
```
示例2：
```txt
输入：nums = [1,3,3]
输出：4
解释：nums 的 6 个子数组如下所示：
[1]，范围 = 最大 - 最小 = 1 - 1 = 0
[3]，范围 = 3 - 3 = 0
[3]，范围 = 3 - 3 = 0
[1,3]，范围 = 3 - 1 = 2
[3,3]，范围 = 3 - 3 = 0
[1,3,3]，范围 = 3 - 1 = 2
所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
```

## 提示
- `1 <= nums.length <= 1000`
- `-10^9 <= nums[i] <= 10^9`


## 📝思路📝


**本题考查知识点**

- 思路1: 很容易想到的就是`枚举`方法，我们只需要`记录当前子数组范围`内的`最小值`和`最大值`，进行`差值计算`记录到滚动变量`res`中即可。
- 思路2：老样子，对于这类题目中都说了能否想到`O(n)`的解决办法，**所以肯定不能落下这个考察了如何优化时间复杂度的题解**，很不幸的是，`小付比较愚笨`，想不出来，所以这里参阅了 `Benhao 总` 与 `三叶姐姐`的题解。对二位`老师`表示由衷的感谢。

>[三叶姐姐的题解思路](https://leetcode-cn.com/problems/sum-of-subarray-ranges/solution/gong-shui-san-xie-yi-ti-san-jie-qu-jian-wn84z/)

>[Benhao总的题解思路](https://leetcode-cn.com/problems/sum-of-subarray-ranges/solution/pythonjavajavascriptgo-dan-diao-zhan-by-6fi1g/)

小付对于难理解的点表达一下自己的理解：对于本题`采用单调栈的方式的难点在于`，`需要获取数组中当前值在子数组范围中成为最大值和最小值的数量个数`。我们需要利用单调栈来帮助我们记录最近的这个下标是否符合当前数值条件，就拿我们`需要获取当前数值的最小值的个数为例子`，需要获取它左侧以及右侧离其最近的 不大于等于当前值的下标，来乘积计算，**为什么呢？** 因为`换句话不大于等于当前值 就是 小于 那既然都比当前数值小了`，**那么当前数值就不是最小值了**，所以`这个就是临界点`，我们`根据单调栈的特性`可以`满足这个找到最近值的特点来接替`就好了。


## 代码实现
**枚举**
```java
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        // 用于记录结果的滚动变量
        long res = 0L;
        for (int i = 0 ; i< n;i++){
        	// 记录当前子数组范围内的最大值和最小值
            int max = nums[i];
            int min = nums[i];
            // 枚举子范围区间的数值进行计算
            for (int j = i + 1;j<n;j++){
            	// 通过max和min这两个滚动变量分别记录当前子数组范围内最大值和最小值
                max = Math.max(max,nums[j]);
                min = Math.min(min,nums[j]);
                // 返回子范围数组的最大差值返回
                res += max - min;
            }
        }
        return res;
    }
}
```

- **时间复杂度:** `O(n^2)`
- **空间复杂度:** `O(1)`

**单调栈**
```java
class Solution {
    int n ;
    public long subArrayRanges(int[] nums) {
        n = nums.length;
        long[] min = getCnt(nums,true),max = getCnt(nums,false);
        long res = 0 ;
        for (int i = 0 ; i < n ;i++)res += (max[i] - min[i])*nums[i];
        return res;
    }
	// 获取数组中每个数值成为最大值或者最小值的个数
    public long[] getCnt(int [] nums,boolean isMin){
    	// 以获取最小值为例子
    	// a用于记录当前数组每个数值左侧的最近的不大于等于当前值的下标
    	// b用于记录当前数组右侧的最近的小于等于当前值的下标
    	// 说白了就是分别获取当前数值左侧/右侧最近的不大于等于当前值的下标
        int[] a = new int[n],b = new int[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        // 开始遍历
        for (int i = 0 ; i< n;i++){
        	// 如果当前队列中含有元素 并且 是获取当前值成为最小值的次数 需要满足的条件 获取最近的不大于等于当前值的下标值 如果 从队列中末位获取的最近的下标的值 大于等于了当前值 则当前下标不满足继续找 如果找不到则为 -1 
            while (!dq.isEmpty() && (isMin ? nums[dq.peekLast()] >= nums[i] : nums[dq.peekLast()] <=nums[i]))dq.pollLast();
            a[i] = dq.isEmpty() ? -1 : dq.peekLast();
            dq.addLast(i);
        }
		// 清空队列 
        dq.clear();
        // 从当前值的右侧寻找不大于等于当前值的数值的最近下标
        for (int i = n-1;i>=0;i--){
        // 如果当前队列中含有元素 并且 是获取当前值成为最小值的次数 需要满足的条件 获取最近的不大于等于当前值的下标值 如果 从队列中末位获取的最近的下标的值 大于等于了当前值 则当前下标不满足继续找最近的 如果找不到则为 当前数组长度即可
            while(!dq.isEmpty() && (isMin ? nums[dq.peekLast()] > nums[i] : nums[dq.peekLast()] < nums[i]))dq.pollLast();
            b[i] = dq.isEmpty() ? n : dq.peekLast();
            dq.addLast(i);
        }

        long[] res = new long[n];
        // 计算个数
        for (int i = 0 ; i< n ;i++)res[i] = (i - a[i]) * 1L * (b[i] - i);
        return res;
    }
}
```
- **时间复杂度:** `O(n)`
- **空间复杂度:** `O(n)`
## 运行结果

![image.png](https://pic.leetcode-cn.com/1646363741-LGgBuc-image.png)

![image.png](https://pic.leetcode-cn.com/1646363757-UZIwYx-image.png)

