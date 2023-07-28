package demo.c0easy;

/**
 * 83  删除排序链表中的重复元素  https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * 给定一个已排序的链表，删除其中的重复元素，并按原顺序返回
 * 求有多少种方法可以爬到楼顶
 * <p>
 * 示例1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * <p>
 * 示例2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 */
public class T83 {
    //题目定义的链表
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
     * 官方实现：一次遍历，将重复的元素节点跳过
     */
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        //当前遍历到的节点，引用head，防止丢失头节点
        ListNode cur = head;

        while (cur.next != null) {
            //如果下个节点和当前节点相等，就跳过
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
