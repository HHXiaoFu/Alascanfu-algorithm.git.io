> ðæ¬ç¯åå®¹ï¼Leetcodeæ¯æ¥ä¸é¢432. å¨ O(1) çæ°æ®ç»æ ååé¾è¡¨+æ°æ®ç»æçå·§å¦åçè®¾è®¡ å®æO(1)æç´¢ <br>
> ð æç« ä¸æ ï¼[leetcodeæ¯æ¥ä¸é¢ãæå¡æ¥å¸¸ã](https://blog.csdn.net/fuijiawei/category_11553903.html) <br>
> ð æè¿æ´æ°ï¼2022 å¹´ 3 æ 15 æ¥  [Leetcodeæ¯æ¥ä¸é¢ 2044. ç»è®¡æä½æè½å¾å°æå¤§å¼çå­éæ°ç® DFSæ·±æ](https://blog.csdn.net/fuijiawei/article/details/123496951) <br>
> ðç®æ³ä»åºï¼å°ä»çç®æ³ä¹è·¯ââ[Alascanfu-algorithm.git.io](https://github.com/HHXiaoFu/Alascanfu-algorithm.git.io)  <br>
> ðä¸ªäººç®ä»ï¼ä¸åªäºæ¬é¢æ ¡å¨è¯»çå¤§ä¸ç¨åºç¿ï¼æ¬çæ³¨éåºç¡ï¼æå¡ç®æ³ï¼åäº«ææ¯ä½ä¸ºä¸ªäººçç»éªæ»ç»æ§çåæåä¸»ï¼è½ç¶å¯è½ææ¶ä¼ç¯æï¼ä½æ¯è¿æ¯ä¼åæä¸å»çï¼å¦æä½ å¾åæ¬¢åæçè¯ï¼å»ºè®®çä¸é¢ä¸è¡~ï¼ç¯çæç¤ºQwQï¼<br>
> ð ç¹èµ ð æ¶è â­çè¨ ð ä¸é®ä¸è¿ ~å³ç±ç¨åºç¿ï¼ä»ä½ æåèµ·~



# ðåå¨åé¢ð

ä»å¤©è®¾è®¡é¢å°ä»åªä¼O(1)çæå¥ï¼ä¸ä¼O(1)çæç´¢ï¼éè¿ 15/16 æä»¥è¿æ¯è¦ç»§ç»­åªååãæ¥ççä¸å¶å§å§çè®¾è®¡æè·¯~

# é¢ç®
>è¯·ä½ è®¾è®¡ä¸ä¸ªç¨äºå­å¨å­ç¬¦ä¸²è®¡æ°çæ°æ®ç»æï¼å¹¶è½å¤è¿åè®¡æ°æå°åæå¤§çå­ç¬¦ä¸²ã

>å®ç° AllOne ç±»ï¼

>AllOne() åå§åæ°æ®ç»æçå¯¹è±¡ã
inc(String key) å­ç¬¦ä¸² key çè®¡æ°å¢å  1 ãå¦ææ°æ®ç»æä¸­å°ä¸å­å¨ key ï¼é£ä¹æå¥è®¡æ°ä¸º 1 ç key ã
dec(String key) å­ç¬¦ä¸² key çè®¡æ°åå° 1 ãå¦æ key çè®¡æ°å¨åå°åä¸º 0 ï¼é£ä¹éè¦å°è¿ä¸ª key ä»æ°æ®ç»æä¸­å é¤ãæµè¯ç¨ä¾ä¿è¯ï¼å¨åå°è®¡æ°åï¼key å­å¨äºæ°æ®ç»æä¸­ã

>`getMaxKey() è¿åä»»æä¸ä¸ªè®¡æ°æå¤§çå­ç¬¦ä¸²`ãå¦ææ²¡æåç´ å­å¨ï¼è¿åä¸ä¸ªç©ºå­ç¬¦ä¸² "" 
>
>`getMinKey() è¿åä»»æä¸ä¸ªè®¡æ°æå°çå­ç¬¦ä¸²ã`å¦ææ²¡æåç´ å­å¨ï¼è¿åä¸ä¸ªç©ºå­ç¬¦ä¸² "" 


ç¤ºä¾1ï¼

```txt
è¾å¥
["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]
è¾åº
[null, null, null, "hello", "hello", null, "hello", "leet"]

è§£é
AllOne allOne = new AllOne();
allOne.inc("hello");
allOne.inc("hello");
allOne.getMaxKey(); // è¿å "hello"
allOne.getMinKey(); // è¿å "hello"
allOne.inc("leet");
allOne.getMaxKey(); // è¿å "hello"
allOne.getMinKey(); // è¿å "leet"
```


## æç¤º
- 1 <= key.length <= 10
- key ç±å°åè±æå­æ¯ç»æ
- æµè¯ç¨ä¾ä¿è¯ï¼å¨æ¯æ¬¡è°ç¨ dec æ¶ï¼æ°æ®ç»æä¸­æ»å­å¨ key
- æå¤è°ç¨ incãdecãgetMaxKey å getMinKey æ¹æ³ $5 * 10^4$ æ¬¡

## ðæè·¯ð

**æ¬é¢èæ¥ç¥è¯ç¹**
- æè·¯ï¼è¿é¢å°ä»åªè½æ³å°ç¨HashMapå®æO(1)çæå¥ï¼ä½æ¯æ æ³å®æO(1)çæç´¢æå¤§æ°éä¸æå°æ°éçå­ç¬¦ä¸²ä¸ªæ°æ¥è¯¢ãå®æäº 15/16ãæä»¥ä»å¤©å°±åéçå°±æ¯ä¸å¶å§å§çæè·¯å¦ã
>[ä¸å¶å§å§çè®¾è®¡  Leetcodeââ å¨O(1) çæ°æ®ç»æ](https://leetcode-cn.com/problems/all-oone-data-structure/solution/by-ac_oier-t26d/)
- å°ä»è¿éè¿½å ä¸äºèªå·±ççæ³ï¼
- ä¸å¶å§å§è®¾è®¡å·§å¦ä¹å¤ï¼å¦å°±å¦å¨`æååé¾è¡¨çåä¸ªèç¹è¿½å äºæ è®°å½åæ°éçå­ç¬¦ä¸²Set`ï¼åæ¶`å©ç¨ååé¾è¡¨ç¹ç¹`æ ¹æ®å¤´å°¾æéåå«`å³æå`ã`å·¦æå` å°±æ¯å¶å­ç¬¦ä¸²ä¸ªæ°`æå°ä¸æå¤å­å¨çèç¹`ï¼ç¸æ¯LRUå¤äºä¸ä¸ªSetï¼è¿æ ·è¿½å ææè¿å°èè¢çå­è¿è¾å­é½æ³ä¸åºæ¥ï¼æä»¥è¿æ¯ç¼ºä¹ç»ä¹ ï¼ä»æ¥å é¤ ä¹åæ¬¡ç»ä¹ å¦ï¼ð­ð­ð­æ¤ä½ã

- `å¶å®è§£å³äºæ°æ®ç»æçè®¾è®¡ åé¢å°±æ¯å¯¹ååé¾è¡¨ï¼è¿½å cnt + 1 / cnt -1 å¼èç¹çèç¹æåï¼åæ¶æå½åæ°éä¸ªå­ç¬¦ä¸²çå­ç¬¦ä¸²è¿½å å°å½åæ°éçsetä¸­ ï¼èå¯äºåå¸è¡¨ç»æï¼ï¼åæ¶ä¹èå¯äºé¾è¡¨ççæä½¿ç¨ï¼æ°æ®ç»æçåºç¨ï¼`
- ä¹èå¯äºO(1)çæç´¢ è¿é¢ç»äºï¼æè°¢ä¸å¶å§å§ï¼å°ä»å­¦å°å¦~
## ä»£ç å®ç°
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

- **æç´¢å¤æåº¦:** O(1)  
- **æå¥å¤æåº¦:** O(1)


## è¿è¡ç»æ

![image.png](https://pic.leetcode-cn.com/1647428538-WUvFef-image.png)


