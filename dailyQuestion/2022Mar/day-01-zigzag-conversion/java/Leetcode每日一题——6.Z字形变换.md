# 题目
>将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

>比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
>
**P   A   H   N
A P L S I I G
Y   I   R**

>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："**PAHNAPLSIIGYIR**"。

>请你实现这个将字符串进行指定行数变换的函数：

>`string convert(string s, int numRows);`



示例1：
```txt
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
```
示例2：
```txt
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
```
示例3：
```txt
输入：s = "A", numRows = 1
输出："A"
```
## 提示
- `1 <= s.length <= 1000`
- `s 由英文字母（小写和大写）、',' 和 '.' 组成`
- `1 <= numRows <= 1000`

## 📝思路📝


**本题考查知识点**<br>

- 思路：对于这种题小付的第一思路都是**如何暴力模拟进行求解**，我们`必须先理解明白题意之后`，**才能更好地写出题解**，正所谓，题读懂了，那么也就对一半了。我们可以看到示例 2 ，根据题意 ,小付设置一个`字符行下标idx`,我们`从第一列开始看起`，`从上到下`，字符行下标一直向下遍历，如果字符还有剩余，则`会在最后一行`(**下标为 numRows - 1**)转向 `向上` 开始`遍历下一个字符`，随后当我们字符行下标 `idx` 还能再次上升到 字符行下标0时，则又会发生转向，直至字符遍历完，思路理解剩下就是实现，这里参阅了`K神的题解思路`，自己写了一种差不多的不同实现方式的。

## 代码实现
**字符串模拟**<br>
```java
class Solution {
    public String convert(String s, int numRows) {
    	// 这个当字符行只有一行时 直接进行返回即可
        if (numRows == 1)return s;
        // 我们利用列表来存储每行的字符数据
        List<StringBuilder> list = new ArrayList<>();
        // 初始化字符数据
        for (int i = 0 ;i< numRows;i++){
            list.add(new StringBuilder());
        }
		// 设置方向 因为我们当刚进入的时候 字符下标idx = 0 此时不需要转向所以为了防止转向 设置为 -1
        int isDown = -1;

        int n = s.length();
        // 模拟
        for (int i = 0 ,idx = 0 ;i < n;i++){
        	// 如果字符行下标到达0或者numRows-1则需要进行转向
            if (idx == 0 || idx == numRows - 1){
                isDown = -isDown;
            }
            // 往当前字符行中添加字符数据
            list.get(idx).append(s.charAt(i));
            // 位移
            idx += isDown;
        }
        // 用于记录结果的
        StringBuilder res = new StringBuilder();
        // 将每个字符行数据集逐行合并拼接就是结果数据
        for (int i = 0 ;i<numRows;i++){
            res.append(list.get(i).toString());
        }
        return res.toString();
    }
}
```

## 运行结果
**字符模拟**<br>
![在这里插入图片描述](https://img-blog.csdnimg.cn/6d6b51124fae49919c354ffb692ffef9.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA54y_5bCP5LuY,size_20,color_FFFFFF,t_70,g_se,x_16)

