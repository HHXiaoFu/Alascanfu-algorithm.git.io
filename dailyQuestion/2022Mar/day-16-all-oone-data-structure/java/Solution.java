import java.util.HashMap;
import java.util.Set;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/16 17:26
 * @description： Leetcode每日一题 432. 全 O(1) 的数据结构
 * @modified By： Alascanfu
 **/
class Solution432 {

}

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
