package hello.c0datastructure.p1StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双向队列 https://www.hello-algo.com/chapter_stack_and_queue/deque/
 * 头部和尾部均能执行元素的添加或删除操作
 *
 * 常见操作：
 * 1、元素添加至队首    offerFirst      时间复杂度O(1)
 * 2、元素添加至队尾    offerLast       时间复杂度O(1)
 * 3、删除队首元素     popFirst        时间复杂度O(1)
 * 4、删除队尾元素     popLast         时间复杂度O(1)
 * 5、访问队首元素     peekFirst       时间复杂度O(1)
 * 6、访问队尾元素     peekLast        时间复杂度O(1)
 */
public class Demo2Deque {
    public static void main(String[] args) {
        //初始化双向队列
        Deque<Integer> deque = new LinkedList<>();

        //元素入队
        deque.offerLast(2);     //添加至队尾
        deque.offerLast(5);
        deque.offerLast(4);
        deque.offerFirst(3);    //添加至队首
        deque.offerFirst(1);

        System.out.println(deque);  //[1, 3, 2, 5, 4]

        //访问元素
        Integer peekFirst = deque.peekFirst();      //访问队首
        Integer peekLast = deque.peekLast();        //访问队尾
        System.out.println(peekFirst);  //1
        System.out.println(peekLast);   //4

        //元素出队
        Integer pollFirst = deque.pollFirst();       //队首出队
        Integer pollLast = deque.pollLast();        //队尾出队
        System.out.println(pollFirst);  //1
        System.out.println(pollLast);   //4

        //获取双向队列长度
        int size = deque.size();
        System.out.println(size);       //3

        //判断双向队列是否为空
        boolean isEmpty = deque.isEmpty();
        System.out.println(isEmpty);    //false
    }

    /**
     *  双向链表节点
     * */
    public class ListNode {
        int val;        // 节点值
        ListNode next; // 后继节点引用
        ListNode prev; // 前驱节点引用

        ListNode(int val) {
            this.val = val;
            prev = next = null;
        }
    }

    /**
     * 双向链表实现双向队列
     */
    public class LinkedListDeque {
        private ListNode front;     //头结点
        private ListNode rear;      //尾结点
        private int queSize = 0;    //长度

        //构造 初始化
        public LinkedListDeque() {
            front = rear = null;
        }

        //双向队列长度
        public int size() {
            return queSize;
        }

        //判断是否为空
        public boolean isEmpty() {
            return size() == 0;
        }

        //入队 isFront true 表示队首入队，烦着队尾入队
        private void push(int num, boolean isFront) {
            ListNode node = new ListNode(num);
            //链表为空时，令 front 和 rear 都指向 node
            if (isEmpty()) {
                front = rear = node;
            } else if (isFront) {
                //队首入队 将 node 添加到链表头部
                front.prev = node;
                node.next = front;
                front = node;   //更新头结点
            } else {
                //队尾入队 将 node 添加至链表尾部
                rear.next = node;
                node.prev = rear;
                rear = node;        //更新尾结点
            }
            queSize++;  //更新队列长度
        }

        //队首入队
        public void publishFirst(int num) {
            push(num, true);
        }

        //队尾入队
        public void publishLast(int num) {
            push(num, false);
        }

        //出队操作
        private int pop(boolean isFront) {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            int val;
            //队首出队
            if (isFront) {
                val = front.val;    //暂存头结点
                //删除头结点
                ListNode fNext = front.next;
                if (fNext != null) {
                    fNext.prev = null;
                    front.next = null;
                }
                front = fNext;  //更新头结点
            } else {
                //队尾出队
                val = rear.val; //暂存尾结点值
                //删除尾结点
                ListNode rPrev = rear.prev;
                if (rPrev != null) {
                    rPrev.next = null;
                    rear.prev = null;
                }
                rear = rPrev;   //更新尾结点
            }
            queSize--;
            return val;
        }

        //队首出队
        public int popFirst() {
            return pop(true);
        }

        //队尾出队
        public int popLast() {
            return pop(false);
        }

        //访问队首元素
        public int peekFirst() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            return front.val;
        }

        //访问队尾元素
        public int peekLast() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            return rear.val;
        }

        //返回数组用于打印
        public int[] toArray() {
            ListNode node = front;
            int[] res = new int[size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = node.val;
                node = node.next;
            }
            return res;
        }
    }

    /**
     * 基于环形数组实现双向队列
     */
    public class ArrayDeque {
        private int[] nums;     // 存储元素的数组
        private int front;      // 队首指针，指向队首元素
        private int queSize;    // 双向队列长度

        //构造方法
        public ArrayDeque(int capacity) {
            this.nums = new int[capacity];
            front = queSize = 0;
        }

        //获取队列容量
        public int capacity() {
            return nums.length;
        }

        //获取队列长度
        public int size() {
            return queSize;
        }

        //判断双向队列是否为空
        public boolean isEmpty() {
            return queSize == 0;
        }

        //计算环形数组索引
        private int index(int i) {
            // 通过取余操作实现数组首尾相连
            // 当 i 越过数组尾部时，回到头部
            // 当 i 越过数组头部时，回到尾部
            return (i + capacity()) % capacity();
        }

        //队首入队
        public void pushFirst(int num) {
            if (queSize == capacity()) {
                System.out.println("双向队列已满");
                return;
            }
            // 队首指针向左移动一位
            // 通过取余操作，实现 front 越过数组头部后回到尾部
            front = index(front - 1);
            // 将 num 添加至队首
            nums[front] = num;
            queSize++;
        }

        //队尾入队
        public void pushLast(int num) {
            if (queSize == capacity()) {
                System.out.println("双向队列已满");
                return;
            }
            // 计算尾指针，指向队尾索引 + 1
            int rear = index(front + queSize);
            // 将 num 添加至队尾
            nums[rear] = num;
            queSize++;
        }

        //队首出队
        public int popFirst() {
            int num = peekFirst();
            // 队首指针向后移动一位
            front = index(front + 1);
            queSize--;
            return num;
        }

        //队尾出队
        public int popLast() {
            int num = peekLast();
            queSize--;
            return num;
        }

        //访问队首元素
        public int peekFirst() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            return nums[front];
        }

        //访问队尾元素
        public int peekLast() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            //计算尾元素索引
            int last = index(front + queSize - 1);
            return nums[last];
        }

        //返回数组
        public int[] toArray() {
            // 仅转换有效长度范围内的列表元素
            int[] res = new int[queSize];
            for (int i = 0, j = front; i < queSize; i++, j++) {
                res[i] = nums[index(j)];
            }
            return res;
        }
    }
}
