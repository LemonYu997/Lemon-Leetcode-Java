package demo.c0easy;

/**
 * 203 移除链表元素 https://leetcode.cn/problems/remove-linked-list-elements/
 * 给定一个链表的头节点head和一个整数val，删除链表中所有满足Node.val == val的节点，并返回新的头节点
 *
 * 示例：
 * 输入1：head = [1,2,6,3,4,5,6], val = 6
 * 输出1：[1,2,3,4,5]
 *
 * 输入2：head = [], val = 1
 * 输出2：[]
 *
 * 输入3：head = [7,7,7,7], val = 7
 * 输出3：[]
 */
public class T203 {
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
     * 官方解法1：递归
     */
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = removeElements1(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * 官方解法2：迭代
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode temp = dummyHead;

        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return dummyHead.next;
    }
}
