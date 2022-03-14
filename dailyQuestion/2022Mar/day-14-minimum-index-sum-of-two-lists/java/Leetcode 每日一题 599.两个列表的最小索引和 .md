# 题目
>假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。

>你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。


示例1：


```txt
输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
输出: ["Shogun"]
解释: 他们唯一共同喜爱的餐厅是“Shogun”。
```

示例2：


```txt
输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
输出: ["Shogun"]
解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
```


## 提示
- `1 <= list1.length, list2.length <= 1000`
- `1 <= list1[i].length, list2[i].length <= 30 `
- `list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。`
- `list1 的所有字符串都是 唯一 的。`
- `list2 中的所有字符串都是 唯一 的。`




## 📝思路📝


**本题考查知识点**
- 今天的这道题是一道双哈希表应用题，总是需要`从当前遍历的哈希表`去`找到另一个哈希表是否存在相同的元素`，然后进行一系列的判断，得出结果。
- 很容易想到的就是我们先对每个人喜欢的吃的食品添加到HashMap中其`key代表对应的食品名`，`val 代表对应在列表中的索引值`。
- 然后构建滚动变量`minIdxSum`来记录二者列表索引和值最小，初始化的值为最坏情况，当二者喜欢的相同的食品都处于列表的最后位置，那么 `minIdxSum = list1.length + list2.length - 2` 这里必须要` -2 `因为`代表的是索引和从 下标0开始的`。
- 然后获取到最短索引和之后我们就可以按照该要求，在两个哈希表中找到符合要求的食品添加到我们的结果当中啦。

**这道题就是典型的一道双哈希表的应用题——如果想熟练理解这种思路的话下面这道昨天的比赛签到题也不错哦~**

> [Leetcode284场周赛T1 . 6031. 找出数组中的所有 K 近邻下标](https://leetcode-cn.com/problems/find-all-k-distant-indices-in-an-array/)

**理解了上面这两道题没准下次遇到的时候打个周赛也能按时签到啦~**


## 代码实现
**双哈希暴力求解**
```java
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for (int i = 0 ; i< list1.length; i++ )map1.put(list1[i],i);
        for (int i = 0 ; i< list2.length; i++ )map2.put(list2[i],i);
        int minIdxSum = map1.size() + map2.size() - 2;
        for (String s :map1.keySet()){
            if(map2.containsKey(s)){
                int idxSum = map1.get(s) + map2.get(s);
                minIdxSum = Math.min(minIdxSum,idxSum);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String s : map1.keySet()){
            if (map2.containsKey(s) && map1.get(s) + map2.get(s) == minIdxSum)res.append(s+",");
        }
        return res.toString().split(",");
    }
}
```

- **时间复杂度:** `O(n+m)`  
- **空间复杂度:** `O(n+m)` 

## 运行结果
**双哈希暴力求解：**

![image.png](https://pic.leetcode-cn.com/1647246306-lQXDsx-image.png)
