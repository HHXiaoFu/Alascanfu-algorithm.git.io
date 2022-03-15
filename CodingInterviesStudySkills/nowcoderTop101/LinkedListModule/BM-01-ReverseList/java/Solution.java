import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/15 13:30
 * @description： BM-01-反转链表
 * @modified By： Alascanfu
 **/
class Solution {
    /** 非递归方式 反转链表*/
    public ListNode ReverseList(ListNode head){
        ListNode preNode = null;
        ListNode curNode = head ;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
    
    /** 递归方式反转链表 */
    public ListNode ReverseList1(ListNode head){
        if (head == null || head.next == null)return head;
        ListNode newHead = ReverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

class ListNode{
    int val ;
    ListNode next = null;
    
    public ListNode(int val) {
        this.val = val;
    }
}
