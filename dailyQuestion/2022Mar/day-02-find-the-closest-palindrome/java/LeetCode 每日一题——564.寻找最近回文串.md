# 题目
>给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。

> “最近的”定义为两个整数差的绝对值最小。



示例1：
```txt
输入: n = "123"
输出: "121"
```
示例2：
```txt
输入: n = "1"
输出: "0"
解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
```

## 提示
- `1 <= n.length <= 18`
- `n 只由数字组成`
- `n 不含前导 0`
- `n 代表在 [1, 10^18 - 1] 范围内的整数`

## 📝思路📝


**本题考查知识点**<br>

- 思路：小付对于这种题一般都是自己先构建示例输入,然后借助lc的输出结果来找出一定特判的规律再继续思考做题。
- 示例输入：
   - 如果当输入的数值长度为`1 && 数值n > 0`时 其返回的结果为 数值 `n-1`
   - 如果针`对于10的幂的数` ||` 10的幂+1的数` 其返回的结果也都是 数值 `n-1`
   - 如果输入的数为临界当前数位十的幂数时 则返回的值为 `n + 2` —— 例如 99、199、1999
   - 正常示例输入：我们很容易想到就是字符串折半`左右相同的思想`,但是也是需要分类进行讨论对于` n的长度为奇数个 `则我们`可以使得左侧字符串a 多获取一个字符数字`，而`右侧的数字符则需要省略掉最后一个数字字符反转进行拼接的思想`/ 而`n的长度为偶数个就无需考虑上述那么多直接反转拼接即可`。但是这只是拼接的思路，我们必须`还要根据题意来添加约束条件`，这里的目的是`为了获取最小差值的回文数字`，我们就必须设想如果是`奇数个我们只需要对最中间的那个数字字符进行改变加以与当前数值的差值进行判断就好了`。而`偶数个我们可以通过示例输入找到规律 只和最中间的两个字符数字有关系`。故我们可以总结一下，无论是奇数还是偶数，最中间的那个值或者两个值都是有字符段a影响得到的，所以我们只是需要对末位的值进行改变，-1 ，0 ，1的相关操作来使得获取当前的回文字符串 试进行滚动比较。

**这里参阅了Hippo的解题代码**<br>
 
## 代码实现<br>
**字符串模拟**<br>
```java
/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/2 15:22
 * @description： Leetcode每日一题—— 2022/03/02. 564. 寻找最近的回文数
 * @modified By： Alascanfu
 **/
class Solution564 {
    public String nearestPalindromic(String n) {
        int lenth = n.length();
        // 特判1: 如果输入的数长度 为 1 则直接返回 n-1 的值
        if (lenth == 1) return String.valueOf(Integer.parseInt(n) - 1);
        // 特判2: 如果输入的数值为 10的幂 如 10、100、1000 ... / 11、101、1001 ...
        // 其返回值为 10的幂 - 1
        // 因为这里n给的是 10^18 所以用long进行操作
        long curNum = Long.parseLong(n);
        long powOfTen = (long) Math.pow(10, lenth - 1);
        if (curNum == powOfTen || curNum == powOfTen + 1) return String.valueOf(powOfTen - 1L);
        // 特判3: 如果输入的数值为 99、199、1999 ...
        // 则返回的是 当前值 + 2
        // powOfTen * 10L - 1L 代表的就是临界 假如为 77 => 临界 99 | 99 => 临界99
        if (curNum == powOfTen * 10L - 1L) {
            return String.valueOf(curNum + 2L);
        }
        long diff = Long.MAX_VALUE;
        long res = Long.MAX_VALUE;
        // 我们将数字分为左右两段数字 a \ b
        // 如果当前为奇数个则多为 a 分一个 需要注意的是奇数个时需要拼接反转的字符需要忽略a段的最后一个数字
        long a = Long.parseLong(n.substring(0, (lenth + 1) / 2));
        // 利用 a-1 | a | a+1 构建回文数 获取与当前值最小差值的回文串数字 利用滚动变量diff、res分别记录差值和结果
        for (int i : new int[]{-1, 0, 1}) {
            String aa = (a + i) + "";
            // 将字符串进行对应的拼接
            String curResStr = new StringBuilder(lenth % 2 == 1 ? aa.substring(0, aa.length() - 1) : aa).reverse().insert(0, aa).toString();
            if (n.equals(curResStr)) continue;
            if (Math.abs(Long.parseLong(curResStr) - curNum) <= diff) {
                diff = Math.abs(Long.parseLong(curResStr) - curNum);
                res = Math.min(res, Long.parseLong(curResStr));
            }
        }
        return res + "";
    }
}
```

## 运行结果<br>
**困难的字符串拼接以及示例输入扩展**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/bb4c5601de934ef5a613a4f0c149b4ce.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)
**本地测试**<br>
```java
/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/2 17:18
 * @description： LeetCode 每日一题——564.寻找最近回文串
 * @modified By： Alascanfu
 **/
public class Test564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串数字：");
        String n = sc.nextLine();
        System.out.println("它的最近回文串为:");
        System.out.println(new Solution564().nearestPalindromic(n));
    }
}
```

![在这里插入图片描述](https://img-blog.csdnimg.cn/3b1fcd2340ba4f7ea8c0476cec761eca.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)