# 题目
>一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。

>给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：

>每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。




示例1：

```txt
输入：answerKey = "TTFF", k = 2
输出：4
解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
总共有四个连续的 'T' 。
```
示例2：

```txt
输入：answerKey = "TFFT", k = 1
输出：3
解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
两种情况下，都有三个连续的 'F' 。
```
示例3：

```txt
输入：answerKey = "TTFTTFTT", k = 1
输出：5
解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
两种情况下，都有五个连续的 'T' 。
```


## 提示
- n == answerKey.length
- 1 <= n <= $5 * 10^4$
- $answerKey[i]$ 要么是 'T' ，要么是 'F'
- 1 <= k <= n

## 📝思路📝

**本题考查知识点**
- 思路：如何分析，从哪里入手，是这道题的关键，小付一开始的思路是通过双指针来进行模拟`在不超过K次操作的情况下`，区间`[i,j]`，最大连续`T`或者`F`的数量。`i` 所指向的的是符合字符串的起点，`j`是指向符合字符串的终点，我们需要求得 在区间`[i,j]` 需要`修改的字符次数 <= k `使得其满足题目要求的最长连续字符字符串。有了上述思路我们就进行简单模拟一下。
- 初始位置`i 为 0` ,`j 位置为1` 需要分别统计`[i,j]` 中的`T 与 F 的数量` 以`便于`，当`我们需要进行修改时`，`是否满足最少数量修改次数 <= k 这一条件来进行判断`。我们分别计做 `cntT` 与 `cntF` ，如果`最少数量需要修改的字符数量>k` 时，我们就需要进行区间缩小，以此来满足约束条件。
## ⭐代码实现⭐
**滑窗应用**
```java
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
    	// 初始化双指针的位置
        int i = 0;
        int j = 1;
        // 用于记录当前区间[i,j]内T与F的数量
        int cntT = 0;
        int cntF = 0;
        int n = answerKey.length();
        char[] keys = answerKey.toCharArray();
        // 初始化 其实可以直接 将 j 位置也初始化为 0 这样这一步就省略了，但是为了更加清晰直白一点，就多了这一步。
        if (keys[0] == 'T'){
            cntT++;
        }else {
            cntF++;
        }
        
        while (j < n){
        	// 统计区间中的T与F的数量
            if (keys[j] == 'T'){
                cntT++;
            }else {
                cntF++;
            }
			// 满足最少数量修改次数的字符修改
            int curNeedModifyKeysCnt = Math.min(cntF,cntT);
            // 如果此时的最少数量次数的字符修改都要大于k
            //则说明此时区间中出现了k+1个需要删除的字符
            //所以此时我们需要缩小区间,使得最少数量修改依旧满足k个
            if (curNeedModifyKeysCnt > k){
                if (keys[i] == 'T')cntT--;
                else if (keys[i] == 'F')cntF--;
                i++;
            }
            j++;
        }
        // 返回符合条件的最大区间中字符的个数
        return j  - i ;
    }
}
```

- **时间复杂度:** O($n$)  
- **空间复杂度:** O($1$)


## 运行结果
**滑动窗口：**
![image.png](https://pic.leetcode-cn.com/1648522315-Wwaqyc-image.png)
