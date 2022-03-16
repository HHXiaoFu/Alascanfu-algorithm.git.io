> 📖本篇内容：Leetcode每日一题432. 全 O(1) 的数据结构 双向链表+数据结构的巧妙合理设计 完成O(1)搜索 <br>
> 📑 文章专栏：[leetcode每日一题《打卡日常》](https://blog.csdn.net/fuijiawei/category_11553903.html) <br>
> 📆 最近更新：2022 年 3 月 15 日  [Leetcode每日一题 2044. 统计按位或能得到最大值的子集数目 DFS深搜](https://blog.csdn.net/fuijiawei/article/details/123496951) <br>
> 🌇算法仓库：小付的算法之路——[Alascanfu-algorithm.git.io](https://github.com/HHXiaoFu/Alascanfu-algorithm.git.io)  <br>
> 🙊个人简介：一只二本院校在读的大三程序猿，本着注重基础，打卡算法，分享技术作为个人的经验总结性的博文博主，虽然可能有时会犯懒，但是还是会坚持下去的，如果你很喜欢博文的话，建议看下面一行~（疯狂暗示QwQ）<br>
> 🌇 点赞 👍 收藏 ⭐留言 📝 一键三连 ~关爱程序猿，从你我做起~



# 🙊写在前面🙊

今天设计题小付只会O(1)的插入，不会O(1)的搜索，通过 15/16 所以还是要继续努力呀。来看看三叶姐姐的设计思路~

# 题目
>请你设计一个用于存储字符串计数的数据结构，并能够返回计数最小和最大的字符串。

>实现 AllOne 类：

>AllOne() 初始化数据结构的对象。
inc(String key) 字符串 key 的计数增加 1 。如果数据结构中尚不存在 key ，那么插入计数为 1 的 key 。
dec(String key) 字符串 key 的计数减少 1 。如果 key 的计数在减少后为 0 ，那么需要将这个 key 从数据结构中删除。测试用例保证：在减少计数前，key 存在于数据结构中。

>`getMaxKey() 返回任意一个计数最大的字符串`。如果没有元素存在，返回一个空字符串 "" 
>
>`getMinKey() 返回任意一个计数最小的字符串。`如果没有元素存在，返回一个空字符串 "" 


示例1：

```txt
输入
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
输出
[null, null, null, "hello", "hello", null, "hello", "leet"]

解释
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // 返回 "hello"
allOne.getMinKey(); // 返回 "hello"
allOne.inc("leet");
allOne.getMaxKey(); // 返回 "hello"
allOne.getMinKey(); // 返回 "leet"
```


## 提示
- 1 <= key.length <= 10
- key 由小写英文字母组成
- 测试用例保证：在每次调用 dec 时，数据结构中总存在 key
- 最多调用 inc、dec、getMaxKey 和 getMinKey 方法 $5 * 10^4$ 次

## 📝思路📝

**本题考查知识点**
- 思路：这题小付只能想到用HashMap完成O(1)的插入，但是无法完成O(1)的搜索最大数量与最小数量的字符串个数查询。完成了 15/16。所以今天就参阅的就是三叶姐姐的思路啦。
>[三叶姐姐的设计  Leetcode—— 全O(1) 的数据结构](https://leetcode-cn.com/problems/all-oone-data-structure/solution/by-ac_oier-t26d/)
- 小付这里追加一些自己的看法：
- 三叶姐姐设计巧妙之处，妙就妙在`把双向链表的单个节点追加了标记当前数量的字符串Set`，同时`利用双向链表特点`根据头尾指针分别`右指向`、`左指向` 就是其字符串个数`最少与最多存储的节点`，相比LRU多了一个Set，这样追加我怕这小脑袋瓜子这辈子都想不出来，所以还是缺乏练习，今日加餐 也再次练习啦，🍭🍭🍭护体。

- `其实解决了数据结构的设计 后面就是对双向链表，追加cnt + 1 / cnt -1 值节点的节点指向，同时把当前数量个字符串的字符串追加到当前数量的set中 （考察了哈希表结构），同时也考察了链表的熟悉使用（数据结构的应用）`
- 也考察了O(1)的搜索 这题绝了，感谢三叶姐姐，小付学到啦~
## 代码实现
```java
class AllOne {
    static class Node {
        Node left, right;
        int cnt;
        Set<String> set;
        
        public Node(int cnt) {
            this.cnt = cnt;
        }
    }
    
    HashMap<String, Node> map;
    Node head, tail;
    
    public AllOne() {
        map = new HashMap<>();
        head = new Node(-1);
        tail = new Node(-1);
        head.right = tail;
        tail.left = head;
    }
    
    void clear(Node node){
        if (node.set.size() == 0){
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }
    
    public void inc(String key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.set.remove(key);
            int cnt = node.cnt;
            Node nextNode = null;
            if (node.right.cnt == cnt+1)nextNode = node.right;
            else {
                nextNode = new Node(cnt + 1);
                nextNode.right = node.right;
                nextNode.left = node;
                node.right.left = nextNode;
                node.right = nextNode;
            }
            nextNode.set.add(key);
            map.put(key,nextNode);
            clear(node);
        }else {
            Node node = null;
            if (head.right.cnt == 1){
                node = head.right;
            }else {
                node = new Node(1);
                node.right = head.right;
                node.left = head;
                head.right.left = node;
                head.right = node;
            }
            node.set.add(key);
            map.put(key,node);
        }
    }
    
    public void dec(String key) {
        Node node = map.get(key);
        node.set.remove(key);
        int cnt = node.cnt;
        if (cnt == 1)map.remove(key);
        else {
            Node preNode = null;
            if (node.left.cnt == cnt - 1){
                preNode = node.left;
            }else {
                preNode = new Node(cnt-1);
                preNode.right = node;
                preNode.left = node.left;
                node.left.right = preNode;
                node.left = preNode;
            }
            preNode.set.add(key);
            map.put(key,preNode);
        }
        clear(node);
    }
    
    public String getMaxKey() {
        Node node = tail.left;
        for (String s:node.set){
            return s;
        }
        return "";
    }
    
    public String getMinKey() {
        Node node  = head.right;
        for(String s:node.set){
            return s;
        }
        return "";
    }
}

```

- **搜索复杂度:** O(1)  
- **插入复杂度:** O(1)


## 运行结果

![image.png](https://pic.leetcode-cn.com/1647428538-WUvFef-image.png)


