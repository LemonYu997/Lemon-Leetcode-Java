package problems.c0easy.t501t1000;

/**
 * 876 链表的中间节点 https://leetcode.cn/problems/middle-of-the-linked-list/
 * 给定单链表的头结点 head，返回链表的中间节点
 * 如果有两个中间节点，则返回第二个中间节点
 *
 * 示例：
 * 输入1：head = [1,2,3,4,5]
 * 输出1：[3,4,5]
 *
 * 输入2：head = [1,2,3,4,5,6]
 * 输出2：[4,5,6]
 */
public class T876 {
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
     * 官方解法1：链表转数组
     */
    public ListNode middleNode1(ListNode head) {
        ListNode[] A = new ListNode[100];
        int t = 0;
        while (head != null) {
            A[t++] = head;
            head = head.next;
        }
        return A[t / 2];
    }

    /**
     * 官方解法2：单指针法
     * 遍历两次，第一统计个数，第二次遍历到 N / 2个元素即返回
     */
    public ListNode middleNode2(ListNode head) {
        // 元素个数
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        // 遍历到中间节点就返回
        while (k < n / 2) {
            k++;
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 官方解法3：快慢指针
     * 用两个指针同时遍历，slow 一次走一步，fast 一次走两步
     * 当 fast 走到结尾时，slow 刚好在中间
     */
    public ListNode middleNode3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
