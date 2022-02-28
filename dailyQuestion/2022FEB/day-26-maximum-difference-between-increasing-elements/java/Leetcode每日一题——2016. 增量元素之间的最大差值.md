# 题目
>给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。

>返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。

 ## 示例

示例1：

```txt
输入：nums = [7,1,5,4]
输出：4
解释：
最大差值出现在 i = 1 且 j = 2 时，nums[j] - nums[i] = 5 - 1 = 4 。
注意，尽管 i = 1 且 j = 0 时 ，nums[j] - nums[i] = 7 - 1 = 6 > 4 ，但 i > j 不满足题面要求，所以 6 不是有效的答案。
```

示例2:

```txt
输入：nums = [9,4,3,2]
输出：-1
解释：
不存在同时满足 i < j 和 nums[i] < nums[j] 这两个条件的 i, j 组合。
```
示例3：
```txt
输入：nums = [1,5,2,10]
输出：9
解释：
最大差值出现在 i = 0 且 j = 3 时，nums[j] - nums[i] = 10 - 1 = 9 。
```
## 提示
- `n == nums.length`
- `2 <= n <= 1000`
- `1 <= nums[i] <= 10^9`

## 📝思路📝


**本题考查知识点**

- 思路1：`简单的暴力模拟AC`，直接`一个双重for`循环就`可以搞定`，但是这样的时间复杂度为 `n^2`，违背了咱们的算法思想初衷，所以咱们再来进行对应优化。
- 思路2:  `尝试着优化为单次循环的思路` ， 优化为贪心的思路，由题咱们可以知道，`i < j && nums[i] < nums[j]`,这样一来我们就可以假定判断当前所处位置时，最小的`nums[i]`的值即作为`min`，这样一来我们`只需要计算当前所处位置的值 - 当前位置最小的nums[i] 的值`就可以`获取最大的差值了`~
- 思路3：小付之前刷过剑指offer中的一道题——`155. 最小栈` 思路也可以参考最小栈，多`维护一个辅助栈`来进行求解答案数据，`思路3和思路2本质相同`，但是`实现的情况有不同`，这里可以进行参考。

## 代码实现
**双重循环暴力AC**
```java
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0 ; i< n ; i++){
            for (int j = i+1;j<n;j++){
            	// 进行判定 需要进行修改最大差值的前提如题所给
                if (max < nums[j] - nums[i] && nums[i] < nums[j])
                    max = Math.max(nums[j] - nums[i],max);
            }
        }
        return max;
    }
}
```
**单层循环贪心求解**
```java
class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        // 初始化没有找到的情况下的结果
        int max = -1;
        // 进行遍历 ，并且设置初始位置的最小nums[i] 为第一个元素
        for (int i = 0 ,min = nums[0]; i< n ;i++){
        	// 如果满足 当前元素的值 大于了 当前所处位置的最小nums[i] 则进行更新我们的最大差值
            if (nums[i] > min) max = Math.max(nums[i] - min,max);
            // 更新我们 当前位置的最小nums[i] 
            min = Math.min(min,nums[i]);
        }
        return max;
    }
}
```
**辅助栈求解**
```java
class Solution {
    public int maximumDifference(int[] nums) {
    	// 初始化辅助栈
        Stack<Integer> helpStack = new Stack<>();
        helpStack.push(nums[0]);
        // 初始化数据栈
        Stack<Integer> stack = new Stack<>();
        int max = -1;

        // 初始化
        for (int num : nums){
            stack.push(num);
            helpStack.push(Math.min(num,helpStack.peek()));
        }
		
        while (!stack.isEmpty() ){
        	// 获取判断差值
            max = Math.max(stack.pop() - helpStack.pop(),max);
        }
        // 这步是为了防止i < j 时将其赋值引起的最小差值
        if (max == 0)return -1;
        return max;
    }
}
```
## 运行结果
**双重循环暴力AC**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/cdf67c03595840b5af7610265e160c56.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)


**单层循环 贪心求解**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/dbc1c71aabb3487997752eb15292d6df.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)



**辅助栈求解**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/067f4ea9e536487e97c23e5e4ace22ad.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)
