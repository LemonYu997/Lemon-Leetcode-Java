package hello.c0datastructure.p0ArrayAndLinked;

/**
 * 链表 https://www.hello-algo.com/chapter_array_and_linkedlist/linked_list/
 *
 * 常用操作：
 * 1、初始化
 * 2、插入节点
 * 3、删除节点
 * 4、访问节点
 * 5、查找节点
 */
public class Demo1LinkedList {
    public static void main(String[] args) {
        //初始化链表 1 --> 3 --> 2 --> 5 --> 4
        // 初始化各个节点
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);

        //构建节点之间的引用
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        //插入节点 时间复杂度 O(1)
        ListNode p = new ListNode(99);
        insert(n2, p);

        //删除节点 时间复杂度 O(1)
        remove(n3);

        //访问节点 时间复杂度 O(n)
        ListNode access = access(n0, 3);
        System.out.println(access.val); //99

        //查找节点 时间复杂度 O(n)
        int i = find(n0, 99);
        System.out.println(i);  //3
    }

    /**
     * 链表节点类
     */
    public static class ListNode {
        int val;        //节点值
        ListNode next;  //指向下一节点的引用
        //构造函数
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 插入节点 时间复杂度 O(1)
     * 只需改变两个节点引用（指针）即可
     */
    public static void insert(ListNode n0, ListNode p) {
        //在 n0 后边插入 p
        ListNode n1 = n0.next;
        p.next = n1;
        n0.next = p;
    }

    /**
     * 删除节点 时间复杂度 O(1)
     * 只需改变一个节点的引用（指针）即可
     */
    public static void remove(ListNode n0) {
        if (n0.next == null) {
            return;
        }
        // 删除 n0 之后的节点 p
        // n0 -> p -> n1
        ListNode p = n0.next;
        ListNode n1 = p.next;
        n0.next = n1;
    }

    /**
     * 访问节点 时间复杂度 O(n)
     * 访问链表中索引为 index 的节点
     */
    public static ListNode access(ListNode head, int index) {
        for (int i = 0; i < index; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        return head;
    }

    /**
     * 查找节点 时间复杂度 O(n)
     * 遍历链表，查找其中值为 target 的节点
     */
    public static int find(ListNode head, int target) {
        int index = 0;
        while (head != null) {
            if (head.val == target) {
                return index;
            }
            head = head.next;
            index++;
        }
        return -1;
    }
}
