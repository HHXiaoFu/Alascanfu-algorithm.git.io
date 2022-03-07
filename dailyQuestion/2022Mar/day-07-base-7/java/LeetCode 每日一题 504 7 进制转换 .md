# 题目
>给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。

示例1：
```txt
输入: num = 100
输出: "202"
```
示例2：
```txt
输入: num = -7
输出: "-10"
```


## 提示

`-10^7 <= num <= 10^7`

## 📝思路📝


**本题考查知识点**

- 思路1：简单模拟题模拟进制计算的方式就好啦~
- 思路2：既然模拟计算时我们是从高到低位逐位追加到字符串结果中，所以我们可以利用栈的特性：先进先出来做这道题。
- 思路3：这个应该不算是思路，是经验之谈，`在JDK 1.0 的Integer类中的一个静态方法toString(int i ,int radix)` 用于将数值进制转化，这里为了不违背做算法题的初衷，我们可以看看底层源码的实现。


## 代码实现
**模拟进制计算**
```java
class Solution {
    public String convertToBase7(int num) {
    	// 特判
        if (num == 0)return "0";
        StringBuilder res = new StringBuilder();
        // 判断当前数字是否为负数
        boolean isNegativeNum = false ;
        isNegativeNum = num < 0 ? true : false;
        num = Math.abs(num);
        // 模拟进行计算
        while (num > 0){
            res.append(num%7);
            num/=7;
        }
        // 返回模拟计算结果 注意 这里我们的逐位计算是从高到低进行计算的所以需要反转字符串
        return isNegativeNum ? "-" + res.reverse().toString(): res.reverse().toString();
    }
}
```

- **时间复杂度:** `O(log|n|)` 
- **空间复杂度:** `O(log|n|)` 

**栈的合理运用**
```java
class Solution {
    public String convertToBase7(int num) {
        if (num == 0)return "0";
        Stack<Integer> stack = new Stack<>();
        boolean isNegativeNum = false ;
        isNegativeNum = num < 0 ? true : false;
        num = Math.abs(num);
        while (num > 0){
            stack.push(num % 7);
            num /= 7;
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())res.append(stack.pop());
        return isNegativeNum ? "-"+res.toString() : res.toString();
    }
}
```
- **时间复杂度:** `O(log|n|)` 
- **空间复杂度:** `O(log|n|)`  这里额外**维护了一个存放模拟进制计算的数据的栈**，栈中数据的个数也是 `O（log|n|）`

**JDK1.0 Integer类下的静态方法toString(int i ,int radix)的理解与使用**

```java
class Solution {
    public String convertToBase7(int num) {
        return Integer.toString(num,7);
    }
}
```
- **时间复杂度:** `O(log|n|)` 
- **空间复杂度:** `O(1)`  这里源码也就额外构建了一个`长度为33的buf[] `

**Integer.toString(int i ,int radix) 贴下源码**
```java
	public static String toString(int i, int radix) {
	// 如果需要转化的进制 < 2 || 需要转化为进制 > 36 则默认转换为十进制数
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
            radix = 10;
		
		// 十进制就直接进行字符输出
        /* Use the faster version */
        if (radix == 10) {
            return toString(i);
        }
		
        char buf[] = new char[33];
        boolean negative = (i < 0);
        int charPos = 32;
		
		// 这里是先将正数转化为负数 在进行进制转换的
        if (!negative) {
            i = -i;
        }
		// 这里相当于是短除法 数学知识学过的哦
        while (i <= -radix) {
            buf[charPos--] = digits[-(i % radix)];
            i = i / radix;
        }
        buf[charPos] = digits[-i];
		// 如果是负数需要添上 符号
        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }
```

**注意这里：为什么是需要将数转换为负数，再进行进制转换呢？**

- 这里我们模拟一下一个正数的计算过程：18的2进制计算

1.将正数转换为负数 18 --> -18

2.反复使用短除法进行计算

```txt
 		buf : ...............0  ,  i : -9

        buf : ..............10  ,  i : -4

        buf : .............010  ,  i : -2

        buf : ............0010  ,  i : -1

        buf : ...........10010 
 ```
3.如果是负数的话需要加上 "-"

`如果对于正数的方法计算结果也是相同的10010`

但是这就没有意义么？

我们还欠缺了对于Java语言中的int的边界值考虑 `-2^31 ~   2^31 -1`

如果将左边界转换为正数进行进制转化那么就会超出范围了，学过计组的人都知道 

`-2^31` 的补码 为 补码取反+1所以进行计算的还是  `-2^31` 这样为的就是满足边界条件

这里来源于：`火的烙印` 给出的范例

## 运行结果
**模拟进制计算**
![image.png](https://pic.leetcode-cn.com/1646623572-PvGJaX-image.png)


**栈的合理运用**

![image.png](https://pic.leetcode-cn.com/1646623561-BQrBVs-image.png)

**JDK Integer.toString(int i ,int radix)的应用**
![image.png](https://pic.leetcode-cn.com/1646623547-dJlJEO-image.png)
