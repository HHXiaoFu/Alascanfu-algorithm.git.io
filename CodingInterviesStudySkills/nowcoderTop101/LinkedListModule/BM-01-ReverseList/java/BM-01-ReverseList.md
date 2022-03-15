## 📝题目📝

### 📝**newCoderTop101**

> 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
>
> 数据范围： $0\leq n\leq1000$
>
> 要求：空间复杂度 O(1)*O*(1) ，时间复杂度 O(n)*O*(*n*) 。
>
> 如当输入链表{1,2,3}时，
>
> 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
>
> 以上转换过程如下图所示：

![img](https://uploadfiles.nowcoder.com/images/20211014/423483716_1634206291971/4A47A0DB6E60853DEDFCFDF08A5CA249)

****

#### 📝思路

-  **递归** 我们可以`利用递归的反向工作来实现逆转`。对于每个结点我们`递归向下遍历到最后`，然后`往上依次逆转两个结点`，`递归终止就是后面遇到了空结点`。

时间复杂度:O(n)，相当于递归遍历链表

空间复杂度:O(n)，递归栈深度为链表长度n

-  **非递归（迭代）：** 我们`可以设置两个指针`，一个`当前结点的指针`，`一个上一个结点的指针`，我们`遍历链表的时候`，断开当前结点与后面的结点，并用临时变量记录后一个结点，然后`当前结点指向上一个结点`，`再轮换当前指针与上一个指针`。

时间复杂度:O(n)，遍历链表一次

空间复杂度:O(1)，无额外空间使用

****

#### 📝代码实现

```java
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

```

