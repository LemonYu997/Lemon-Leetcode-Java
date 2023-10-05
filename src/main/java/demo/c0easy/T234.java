package demo.c0easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 234 回文链表 https://leetcode.cn/problems/palindrome-linked-list/
 * 给定一个单链表的头结点head，判断其是否为回文链表
 * <p>
 * 示例：
 * 输入1：head = [1,2,2,1]
 * 输出1：true
 * <p>
 * 输入2：head = [1,2]
 * 输出2：false
 */
public class T234 {
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
     * 官方解法1：把链表转为数组，并使用双指针
     */
    public boolean isPalindrome1(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        //将链表的值复制到数组中
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        //使用双指针判断是否回文
        int left = 0;
        int right = vals.size() - 1;

        while (left < right) {
            if (!vals.get(left).equals(vals.get(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /**
     * 官方解法2：递归
     */
    private ListNode frontPointer;

    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
