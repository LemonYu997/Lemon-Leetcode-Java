package problems.c0easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 160 相交链表 https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 给定两个单向链表，找到两个单向链表相交的起始节点
 *
 * 示例：
 * 输入1：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * 输出1：Intersected at '8'
 *
 * 输入2：intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出2：Intersected at '2'
 *
 * 输入3：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出3：null
 */
public class T160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 官方解法1：哈希集合
     * 判断两个链表是否相交，可以使用哈希集合存储链表节点
     * 将A链表每个节点都放入集合，再遍历B每个节点，判断该节点是否在哈希集合中（后面所有节点都必须一致）
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        //先遍历链表A
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            //判断该节点是否在哈希集合中
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    /**
     * 官方解法2：双指针
     * 两个指针 Pa 和 Pb 依次从头遍历两个链表A和B：
     *  1、每步操作同时更新指针 Pa 和 Pb
     *  2、Pa为不为空时，将Pa移到下一个节点，Pb不为空时，将Pb移到下一个节点
     *  3、Pa为空时，将Pa移到链表B的头结点，Pb为空时，将Pb移到链表A的头结点
     *  4、当Pa和Pb指向同一个节点或都为空时，返回它们指向的节点或者null
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
