package problems.c0easy.t1001t1500;

/**
 * 1290 二进制链表转整数 https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/description/
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
 * 已知此链表是一个整数数字的二进制表示形式。
 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 示例：
 * 输入1：head = [1,0,1]
 * 输出1：5
 *
 * 输入2：head = [0]
 * 输出2：0
 *
 * 输入3：head = [1]
 * 输出3：1
 *
 * 输入4：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出4：18880
 *
 * 输入5：head = [0,0]
 * 输出5：0
 */
public class T1290 {
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
     * 自己实现：遍历即可
     */
    public int getDecimalValue(ListNode head) {
        ListNode curNode = head;
        int ans = 0;
        while (curNode != null) {
            ans = ans * 2 + curNode.val;
            curNode = curNode.next;
        }
        return ans;
    }
}
