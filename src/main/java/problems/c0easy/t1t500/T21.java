package problems.c0easy.t1t500;

/**
 * 21 合并两个有序链表 https://leetcode.cn/problems/merge-two-sorted-lists/
 * 将两个升序链表合成为一个新的升序链表
 *
 * 示例1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class T21 {
    //题目提供的链表类
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
     * 法一：迭代
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        //结果 初始链表
        ListNode result = new ListNode(0);
        //当前节点
        ListNode node = result;

        //只要两个链表存在数字，就一直往下排
        while (list1 != null && list2 != null) {
            //当前值谁小谁排前边
            if (list1.val < list2.val) {
                node.next = list1;
                //使用过的向后移动一位
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }

            //节点向后移动一位
            node = node.next;
        }

        //如果还有某个不为空，就直接连到结果上
        if (list1 != null) {
            node.next = list1;
        } else if (list2 != null) {
            node.next = list2;
        }

        //第一位没有放数，跳过
        return result.next;
    }

    /**
     * 法二：递归
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        //处理边界条件
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        //比较当前两个链表谁的值更小，更小的节点指向其余节点的合并结果·
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }
}
