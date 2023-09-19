package demo.c0easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 141 环形链表 https://leetcode.cn/problems/linked-list-cycle/
 * 给定一个链表，判断其中是否有环
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 示例：
 * 输入1：head = [3,2,0,-4], pos = 1
 * 输出1：true
 *
 * 输入2：head = [1,2], pos = 0
 * 输出2：true
 *
 * 输入3：head = [1], pos = -1
 * 输出3：false
 */
public class T141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 官方解法1：哈希表
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        //遍历链表，将其加入set中，如果有重复元素，就会添加失败
        while (head != null) {
            if (!seen.add(head)) {
                return true;
            }
            head = head.next;
        }

        return false;
    }

    /**
     * 官方解法2：快慢指针
     * 慢指针一次一步，快指针一次两步，如果有循环，快指针就能追上慢指针
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}