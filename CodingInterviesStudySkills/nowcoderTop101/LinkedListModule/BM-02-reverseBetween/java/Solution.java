/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/15 18:48
 * @description： BM-02-reverseBetween
 * @modified By： Alascanfu
 **/
class SolutionBM02 {
    /** 非递归（迭代）实现*/
    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preNode = dummy;
        for (int i = 1 ;i< m;i++)preNode = preNode.next;
        ListNode curNode = preNode.next;
        for (int i = m ;i< n;i++){
            ListNode nextNode = curNode.next;
            curNode.next = nextNode.next;
            nextNode.next = preNode.next;
            preNode.next = nextNode;
        }
        return dummy.next;
    }
    
    /** 迭代实现 */
    
}
