# 题目
>自除数 是指可以被它包含的每一位数整除的数。

>例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
自除数 不允许包含 0 。

>给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。


示例1：

```txt
输入：left = 1, right = 22
输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
```
示例2：

```txt
输入：left = 47, right = 85
输出：[48,55,66,77]
```


## 提示
`1 <= left <= right <= 10^4`
## 📝思路📝

**本题考查知识点**
- 思路：现在做这种题看到数量级之后估算一下时间复杂度，如果不会超就直接暴力求解啦，今天的题比较简单，可以看哈代码哦~完整打卡3月！！！冲冲冲
## ⭐代码实现⭐
**模拟**
```java
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left ; i<= right;i++){
            int curNum = i;
            if (check(curNum))res.add(curNum);
        }
        return res;
    }
    boolean check(int num){
        int tmp = num;
        while (tmp > 1 ){
            int i = tmp % 10;
            if (i == 0 || num % i != 0)return false;
            tmp/= 10;
        }
        return true;
    }

}
```

- **时间复杂度:** O($nlog_{right}$)  
- **空间复杂度:** O($1$)


## 运行结果
**模拟**
![image.png](https://pic.leetcode-cn.com/1648720869-TdJdjV-image.png)

