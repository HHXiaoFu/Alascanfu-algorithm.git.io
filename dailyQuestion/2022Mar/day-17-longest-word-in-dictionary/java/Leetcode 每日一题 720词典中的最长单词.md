# 题目
>给出一个字符串数组 words 组成的一本英语词典。返回 words 中最长的一个单词，该单词是由 words 词典中其他单词逐步添加一个字母组成。

> 若其中有多个可行的答案，则返回答案中字典序最小的单词。若无答案，则返回空字符串。




示例1：

```txt
输入：words = ["w","wo","wor","worl", "world"]
输出："world"
解释： 单词"world"可由"w", "wo", "wor", 和 "worl"逐步添加一个字母组成。
```
示例2：

```txt
输入：words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
输出："apple"
解释："apply" 和 "apple" 都能由词典中的单词组成。但是 "apple" 的字典序小于 "apply" 
```


## 提示
`1 <= words.length <= 1000`
`1 <= words[i].length <= 30`
`所有输入的字符串 words[i] 都只包含小写字母。`

## 📝思路📝

**本题考查知识点**
> 学习之前先老样子标注出小付的学习来源——尊重每一位算法工程师的题解思路

> [《三叶姐姐——实现前缀树数据结构》](https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-er-we-esm9/)

> [《***——835.Trie字符串统计》](https://www.***.com/problem/content/837/)

> [《前缀树——模板使用-三叶姐姐》](https://mp.weixin.qq.com/s?__biz=MzU4NDE3MTEyMA==&mid=2247488490&idx=1&sn=db2998cb0e5f08684ee1b6009b974089&chksm=fd9cb8f5caeb31e3f7f67dba981d8d01a24e26c93ead5491edb521c988adc0798d8acb6f9e9d&token=1006889101&lang=zh_CN&scene=21#wechat_redirect)

>[《前缀树》——模板使用-y总》](https://www.***.com/blog/content/404/)


- **思路1**：小付今天凌晨时直接做题的思路，因为`前不久才复习了Java基础所以对Arrays API 还是比较熟悉`的，因为这道题`涉及到了字典序`，很容易就是为了将给出的`字符串数组按照字典序进行排序`。既然字典序都这个最麻烦的都解决了，这道题`就如题标所示一样为简单题了`。

![image.png](https://pic.leetcode-cn.com/1647520431-pNMWfl-image.png)


- 思路2：就是字典树啦~`这里就不再赘述了，上述的几位大佬已经讲得很明白了`，小付这里贴个模板，基础的前缀树问题，**这个模板稍加变换都能解决哦**。 前缀树一般 **用于高效存储和查找字符串集合的数据结构。示例为字符串补全，拼写检查等。**
```java
class Trie{
    int N = 100010;
    int[][] trie;
    int[] count ;
    int idx ;
    
    public Trie(){
        trie = new int[N][26];
        count = new int[N];
        idx = 0;
    }
    
    public void insert(String s){
        int p = 0;
        for (int i = 0 ; i< s.length();i++){
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0)trie[p][u] = ++idx;
            p = trie[p][u];
        }
        count[p]++;
    }
    
    public boolean search(String s){
        int p = 0;
        for (int i = 0 ;i< s.length();i++){
            int u = s.charAt(i)-'a';
            if (trie[p][u] == 0)return false;
            p = trie[p][u] ;
        }
        return count[p] != 0;
    }
    
    public boolean startsWith(String s){
        int p = 0;
        for (int i = 0 ; i< s.length();i++){
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0)return false;
            p = trie[p][u];
        }
        return true;
    }
}
```
**这里唯一需要理解的就是各个数组的含义：**
- 使用二维数组$trie[p][u]$  来表示当前 $p$ 这个节点有没有 $u$ 这个儿子。(`即当前字符串的当前字符的下一个字符是否对应存在`)
- $idx$ 代表的是每个节点的编号，  $index$ 的下标是0的点，**既是根节点 ，又是空节点。**
- 使用 $count[p]$ 数组记录**此时的p节点位置就是当前构成字符串的最后一个字符位置，如果是则记录+1。**
## 代码实现
**字符数组字典序排序 + 哈希**
```java
class Solution {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        // 对字符串数组进行字典序排序
        Arrays.sort(words);
        String res = "";
        // 遍历字符串数组
        for (String s :words){
			// 如果当前字符串长度为1 则说明这个字符串肯定由空串而来， 而set记录当前前面是否含有了组成当前字符串的前一个子字符串是否存在于当前字符串哈希当中
            if (s.length() == 1||set.contains(s.substring(0,s.length()-1))){
            	// 如果当前满足了上述条件 且当前字符串长度较长则替换
                res = s.length() > res.length() ? s : res;
                // 将已经遍历的字符串加入到Set当中
                set.add(s);
            }
        }
        return res;
    }
}
```

- **时间复杂度:** O($log_n+n$)  
- **空间复杂度:** O($n$)

**字典树**
```java
class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String s : words)trie.insert(s);

        String res = "";
        for (String s : words){
            int m = res.length();
            int n = s.length();
            // 判断条件 如果当前字符串的长度比结果字符串长度都小就没必要计算了
            if (n < m)continue;
            // 如果二者长度相等则需要比较字典序
            if (m == n && s.compareTo(res) > 0)continue;
            // 如果当前字典序能按位逐位找到每个字符都存在于字典树当中就将其赋值给结果返回
            if (trie.search(s))res = s;
        }
        return res;
    }
}
// 套模板
class Trie {
    int N =30030;
    int[][] trie ;
    int [] cnt ;
    int idx;
    public Trie(){
        trie = new int [N][26];
        cnt = new int [N];
        idx = 0;
    }

    public void insert(String s){
        int p = 0 ;
        for (int i = 0 ;i< s.length();i++){
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0)trie[p][u] = ++ idx;
            p = trie[p][u];
        }
        cnt[p]++ ;
    }


    public boolean search(String s ){
        int p = 0 ;
        for (int i = 0 ;i< s.length();i++){
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0)return false;
            p = trie[p][u]; 
            // 唯一需要注意的点是这里，本题这里如果当前字符串数组中不存在当前节点的字符则无法构成后一个字符串
            if (cnt[p]==0) return false;
        }
        return true;
    }

}
```
## 运行结果
`字符串数组按字典序排序 + 哈希`

![image.png](https://pic.leetcode-cn.com/1647520381-GKvOFi-image.png)



`字典树`

![image.png](https://pic.leetcode-cn.com/1647520401-GtUIac-image.png)

