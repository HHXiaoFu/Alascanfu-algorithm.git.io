## 🎓数组中重复的数字

> #### [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

> 《剑指Offer——名企面试官精讲典型编程题》—— P37

**面试考察要求——来自`自来火`大哥的热评~：**

- 考察的是程序猿的沟通能力，对于简单题，我们需要询问面试考官的 `时间` / `空间`需求！！！
- 如果是时间优先就需要用到 `哈希字典` 求解
- 空间需求 需要用到`指针+原地排序数组`
- 如果要求空间复杂度为O(1)并且不能修改原数组，使用`二分法`

**排序 + 指针**<br>

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        // 排序之后
        Arrays.sort(nums);
        // 如果相邻元素相同的话就返回当前值
        for (int i = 0 ; i< nums.length-1;i++){
            if (nums[i] == nums[i+1])return nums[i];
        }
        return -1;
    }
}
```

`时间复杂度分析：O(nlogn)`——排序一个长度为n的数组时间间复杂度为`O(nlogn)`

`空间复杂度分析：O(1)`——在原来的基础上并没有额外的占用数组空间

**哈希字典求解**<br>

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 对于数组中的每个数依次进行添加
        for (int i: nums){
            // 如果在添加的时候遇到了之前添加过的元素就将该值返回
            if (!set.contains(i))set.add(i);
            else 
                return i;
        }
        // 否则没有找到
        return -1;
    }
}
```

`时间复杂度分析：O(1)`——这里用到了哈希表存储结构来判断是否包含该数字

`空间复杂度分析：O(n)`——但是以一个大小为`O(n)`的哈希表为代价

**指针 + 原地排序数组——K神题解**<br>

**题解思路：**<br>

- 遍历中，第一次遇到数字 x 时，将其交换至索引 x 处；而当第二次遇到数字 x 时，一定有 `nums[x] = x ` ，**此时即可得到一组重复数字。**

![Picture0.png](https://pic.leetcode-cn.com/1618146573-bOieFQ-Picture0.png)

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int idx = 0 ;
        while (idx < nums.length){
            // 判断当前加入的数据是否等于坐标位置
            if (nums[idx] == idx){
                // 下标后移
                idx ++ ;
                // 跳出当前循环
                continue ;
            }
            // 如果当前加入的数剧的索引下标 = 索引下标中的值就找到了一组相同值
            if (nums[idx] == nums[nums[idx]])return nums[idx];
            // 否则进行交换索引下标i位置与数据索引下标位置
            int tmp = nums[idx] ;
            nums[idx] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
```

`时间复杂度分析：O(n)`——这里就进行了一次数组遍历故时间复杂度为`O(n)`

`空间复杂度分析：O(1)`——这里并没有用到额外的空间 除了 `tmp和idx`变量所以空间复杂度为`O(1)`

****

> `是否能深入想到不修改原数组找到重复的数字？` 这是对程序猿的深入思维扩展，问题解决思路发散的考察。

**二分搜索**<br>

- 针对于本题在原书上的描述是：一个长度为`n`的数组，数字在`1 ~ n-1`的情况下,此时数组中至少是存在一组重复数据的。

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n-1;
        while(left<right){
            int mid = left+(right-left)/2;
            int cnt = 0;
            // 找到中间数
            for(int i=0; i<n; i++){
                if(nums[i]<=mid){
                    cnt++;
                }
            }
            // 从1到mid最多有mid个元素，超过它说明有重复元素
            // 缩小范围再次查找
            if(cnt>mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
```

`时间复杂度分析：O(nlogn)`—— 二分搜索每次折半搜索故外部循环时间复杂度为`O(logn)` 而内部每次都需要`O(n)`的时间 故时间复杂度为`O(nlogn)`

`空间复杂度分析：O(1)`——这里并没有用到额外的空间 ,典型的用时间换空间

## 本题需要考虑的测试用例

- 长度为n的数组中包含一个或者多个重复的数字
- 数组中不包含重复的数字
- 错误无效的输入测试用例（数组为空|数组的数组不在可选范围内）