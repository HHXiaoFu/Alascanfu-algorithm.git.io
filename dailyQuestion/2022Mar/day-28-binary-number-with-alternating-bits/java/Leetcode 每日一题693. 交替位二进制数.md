# 题目
>给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。



示例1：

```txt
输入：n = 5
输出：true
解释：5 的二进制表示是：101
```
示例2：

```txt
输入：n = 7
输出：false
解释：7 的二进制表示是：111.
```
示例3：

```txt
输入：n = 11
输出：false
解释：11 的二进制表示是：1011.
```


## 提示
- 1 <= n <= $2^{31} - 1$

## 📝思路📝

**本题考查知识点**
- 思路：简单模拟/位运算
- **模拟的话，可以算出二进制的每一位然后逐位比较，这是比较清晰的一种遍历解法。**
- 这里不再赘述位运算的思路了，其它uu讲的很清楚了。
## ⭐代码实现⭐
**遍历**
```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder str = new StringBuilder();
        while(n > 0){
            str.append(n%2);
            n/=2;
        }
        String s = str.toString();
        for (int i = 0 ;i < s.length()-1;i++){
            if (s.charAt(i) == s.charAt(i+1))return false;
        }
        return true;
    }
}
```

- **时间复杂度:** O($log_2n$)  
- **空间复杂度:** O($1$)

**位运算**
```java
class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);
        return (x & (x + 1)) == 0;
    }
}
```

- **时间复杂度:** O($1$)  
- **空间复杂度:** O($1$)

## 运行结果
**遍历**




**位运算**
![image.png](https://pic.leetcode-cn.com/1648451196-TMROAR-image.png)


