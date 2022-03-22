# 题目
>总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。

>Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。

>如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
Alice 和 Bob 不能 从字符串两端删除颜色片段。
如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。




示例1：

```txt
输入：colors = "AAABABB"
输出：true
解释：
AAABABB -> AABABB
Alice 先操作。
她删除从左数第二个 'A' ，这也是唯一一个相邻颜色片段都是 'A' 的 'A' 。

现在轮到 Bob 操作。
Bob 无法执行任何操作，因为没有相邻位置都是 'B' 的颜色片段 'B' 。
因此，Alice 获胜，返回 true 。
```
示例2：

```txt
输入：colors = "AA"
输出：false
解释：
Alice 先操作。
只有 2 个 'A' 且它们都在字符串的两端，所以她无法执行任何操作。
因此，Bob 获胜，返回 false 。
```
示例3：

```txt
输入：colors = "ABBBBBBBAAA"
输出：false
解释：
ABBBBBBBAAA -> ABBBBBBBAA
Alice 先操作。
她唯一的选择是删除从右数起第二个 'A' 。

ABBBBBBBAA -> ABBBBBBAA
接下来轮到 Bob 操作。
他有许多选择，他可以选择任何一个 'B' 删除。

然后轮到 Alice 操作，她无法删除任何片段。
所以 Bob 获胜，返回 false 。
```


## 提示
- `1 <= colors.length <= 105`
- `colors 只包含字母 'A' 和 'B'`
## 📝思路📝

**本题考查知识点**
- 思路：这是一道典型的博弈题，**做过Alice与Bob的石子游戏的同学都知道**，这俩人没事就爱玩一些稀奇古怪的游戏。言归正传，我们来理解一下今天这道题，其实今天这道题是一道非常基础的博弈入门题，因为`题中已知条件时必须连续出现三个相同的颜色`片段`才可以删除相同颜色区间中间的一个颜色片段`。而`因为是Alice先出手`，所以`为了能保证游戏能继续运行`，对于Alice来说，`只要能找到一个删除片段就该Bob去头疼这个问题了`,`如果能找到两个`删除片段，就可以`为Bob设陷阱`，这里我们先跳过设陷阱，从Bob理解。我们可以很清楚的发现，**当Bob在接手游戏的同时他应该考虑什么？** Bob是一个`心思缜密的家伙`，他**想赢得比赛又想让Alice在下一步吃亏**，`Bob会怎么做？`Bob`首先考虑的是 在我Bob的回合下先找找有没有符合条件可以删除的颜色片段`，然后`才考虑如何设陷阱`，假如我们`Bob找到了好几种可以删除的方式`，那么`该选取哪一个才会影响到Alice的下一步运行呢`？这就是本题的难点，因为我们可以根据示例很清楚的知道`无论如何删除都是无法影响到Alice的`，**反之Alice也不会影响到Bob**，而`剩下的就是分别统计Alice与Bob可以进行的操作数然后判定哪个人获胜`。
## 代码实现
**博弈思想**
```java
class Solution {
    public boolean winnerOfGame(String colors) {
        int n = colors.length() ;
        boolean isAliceWin = false;
        if ( n < 3 )return isAliceWin;
        int aliceWinCnt = getDeletCnt(colors,true);
        int bobWinCnt = getDeletCnt(colors,false);
        isAliceWin = aliceWinCnt > bobWinCnt?true : false;
        return isAliceWin;

    }
    int getDeletCnt(String colors,boolean isAlice){
        int cnt = 0 ;
        char deleteChar = isAlice ? 'A' : 'B';
         for (int i = 1 ; i< colors.length()-1;i++){
             if (deleteChar == colors.charAt(i) && deleteChar == colors.charAt(i-1) && deleteChar == colors.charAt(i+1))cnt++;
         }

        return cnt ;
    }
}
```

- **时间复杂度:** O($n$)  
- **空间复杂度:** O($1$)


## 运行结果
**博弈基础**
![image.png](https://pic.leetcode-cn.com/1647916150-zccwud-image.png)

