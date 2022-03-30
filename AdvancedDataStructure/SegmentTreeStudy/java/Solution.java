import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/30 20:16
 * @description： SegmentTree 的例题 Leetcode 1606.找到处理最多请求的服务器
 * @modified By： Alascanfu
 **/
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Node root = buildSegmentTree(0,k-1);
        int[] cnt = new int[k+1];
        int max = 0;
        for (int i = 0; i < arrival.length; i++) {
            // 没有空虚的服务器
            if (arrival[i] < root.endTime) {
                continue;
            }
            int pos = i % k;
            // 查询 pos 到 k-1 的区间
            int x = query(root, pos, k - 1, arrival[i]);
            if (x == -1) {
                // 查询 0 到 pos-1的区间
                x = query(root, 0, pos - 1, arrival[i]);
            }
            // 计数
            cnt[x]++;
            // 保存最大值
            max = Math.max(max, cnt[x]);
            // 更新服务器x的值
            updateTime(root, x, arrival[i] + load[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ;i< cnt.length;i++){
            if (cnt[i] == max){
                list.add(i);
            }
        }
        return list;
    }
    
    Node buildSegmentTree(int left ,int right){
        Node node = new Node(left,right);
        if (left == right){
            return node;
        }
        
        int mid = (left + right) >>> 1;
        node.left = buildSegmentTree(left,mid);
        node.right = buildSegmentTree(mid+1,right);
        return node;
    }
    
    int query(Node root ,int l , int r ,int start){
        // 此时到达叶子结点
        if(root.l == root.r){
            if (root.l >= l && root.l <= r){
                return root.l;
            }
            return -1;
        }
        
        int mid = (root.l + root.r) >>> 1;
        int val = -1;
        if (l <= mid && start >= root.left.endTime){
            val = query(root.left,l,r,start);
        }
        if (val != -1){
            return val;
        }
        if (r > mid && start >= root.right.endTime){
            val = query(root.right , l , r,start);
        }
        return val;
    }
    
    void updateTime(Node root ,int x ,int end){
        // 更新叶子节点递归终止条件
        if (root.l == root.r){
            root.endTime = end;
            return ;
        }
        
        int mid = (root.l + root.r) >>> 1;
        if (x <= mid){
            updateTime(root.left,x,end);
        }else {
            updateTime(root.right,x,end);
        }
        root.endTime= Math.min(root.left.endTime,root.right.endTime);
    }
    @Test
    public void test(){
        System.out.println(busiestServers(3,new int[]{1,2,3,4,5},new int[]{5,2,3,3,3}));
    }
}
class Node {
    int endTime ;
    int l , r ;
    Node left = null , right = null;
    public Node (int l ,int r){
        this.l = l;
        this.r = r;
    }
}
