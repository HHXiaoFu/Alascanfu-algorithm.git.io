# 题目
>给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。


示例1：
```txt
输入: num = 38
输出: 2 
解释: 各位相加的过程为：
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2
由于 2 是一位数，所以返回 2。
```
示例2：
```txt
输入: num = 0
输出: 0

```

## 提示
- `0 <= num <= 2^31 - 1`


## 📝思路📝


**本题考查知识点**<br>

- 思路1——暴力模拟AC：比较`容易想到的暴力模拟AC解决`，`因为一开始我们的固化思维`，都会想着`如何快速且不计时间的想法`去解决这道题。直接暴力模拟` 先计算出各位之和`，然后对于各位之和做出判定 `只有当各位之和为一位数时才是返回的结果`，而我们可以将各位之和如题所说，`每次逐位相加到当前数字缩短一位的数字`，直至`结果为1位数字`时就是结果。
 - 思路2——递归求解：有了上面思路的解题方法之后，我们很容易就会想到 如果当前`num`为一位数时就直接返回结果，反之 `num 则逐位相加的思想` ，`num 为一位数时就是递归的跳出条件`，`递归求解逐位相加即可`。
 - 思路3——数学求解：我们很容易就知道`最后的返回结果为1 ~ 9这9个数字`，`无论给出的num数值为多少`，`最后都会返回1 ~ 9的数字`，那就容易了，这些数字的结果`都是在这九个结果集中的`，所以我们`假定该数进行对9取余就可以获得该数在9个结果集中的位置`，也就是`对于到达最后一位数字的结果`，但是我们需要考虑额外的情况，当刚好可以被9整除时我们返回的就是9 `拿19 ,90做特例即可`。
## 代码实现
**暴力模拟AC**<br>
```java
class Solution {
    public int addDigits(int num) {
    	// 滚动变量用于记录第一次num各位相加结果
        int res = 0;
        
        while (num > 0){
            res += num % 10;
            num /= 10;
        }
        
        // 我们对于滚动结果变量如果不是一位数字则需要对其逐位相加到缩短一位的数字进行处理 ， 直到剩下移位数值结果
        while (res >= 10){
            res = res%10 + res/10;
        }
        // 返回结果
        return res;
    }
}
```

- **时间复杂度:** `O(log num)`
- **空间复杂度:** `O(1)`

**递归求解**<br>
```java
class Solution258 {
    /**
     * 递归实现 就两行
     */
    public int addDigits(int num) {
        // 递归结束终止条件 当num 为各位时直接返回
        if (num < 10) return num;
        // 每次只需要递归求解 逐位相加的结果 等同于我们上面计算res
        else return addDigits1(num % 10 + num / 10);
    }
}
```
- **时间复杂度:** `O(log num)`
- **空间复杂度:** `O(1)`

**数学求解**<br>

```java
class Solution {
    public int addDigits(int num) {
        if (num > 9){
            if (num % 9 == 0)return 9;
            return num % 9;
        }
        return num;
    }
}
```
- **时间复杂度:** `O(1)`
- **空间复杂度:** `O(1)`
## 运行结果
**暴力模拟AC**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/40695cc1889f41f0941ed2e15fe88c0e.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)


**递归求解**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/dca77ae588de42338288a40932791f3a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)

**数学求解**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/f3f5ff8f7f9042769d189f9973b219c9.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)


**本地测试**<br>

```java
/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/3 12:28
 * @description： LeetCode 每日一题. 258各位相加 2022/03/03 测试类
 * @modified By： Alascanfu
 **/
public class Test258 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        System.out.println("它的各位之和一位数为：");
        System.out.println(new Solution258().addDigits(num));
    }
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/9c1a41723c2a48b0844ba0d4a5251df1.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)
