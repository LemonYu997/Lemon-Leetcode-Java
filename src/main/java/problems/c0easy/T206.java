package problems.c0easy;

/**
 * 206 反转链表 https://leetcode.cn/problems/reverse-linked-list/
 * 给单链表的头结点head，返回反转后的链表
 *
 * 示例：
 * 输入1：head = [1,2,3,4,5]
 * 输出1：[5,4,3,2,1]
 *
 * 输入2：head = [1,2]
 * 输出2：[2,1]
 *
 * 输入3：head = []
 * 输出3：[]
 */
public class T206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 官方解法1：迭代
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * 官方解法2：递归
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
