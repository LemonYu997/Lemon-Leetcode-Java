package hello.c0datastructure.p1StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列 https://www.hello-algo.com/chapter_stack_and_queue/queue/
 *
 * 常见操作：
 * 1、入队（添加至队尾）  offer   时间复杂度O(1)
 * 2、出队（队首出）    pop     时间复杂度O(1)
 * 3、访问队首元素     peek    时间复杂度O(1)
 */
public class Demo1Queue {
    public static void main(String[] args) {
        //初始化队列
        Queue<Integer> queue = new LinkedList<>();

        //元素入队
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);
        queue.offer(5);
        queue.offer(4);
        System.out.println(queue);  //[1, 3, 2, 5, 4]

        //访问队首元素
        Integer peek = queue.peek();
        System.out.println(peek);   //1

        //元素出队
        Integer poll = queue.poll();
        System.out.println(poll);   //1

        //获取队列的长度
        int size = queue.size();
        System.out.println(size);   //4

        //判断队列是否为空
        boolean b = queue.isEmpty();
        System.out.println(b);      //false
    }

    /**
     * 链表节点类
     */
    public class ListNode {
        int val;        //节点值
        ListNode next;  //指向下一节点的引用
        //构造函数
        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 链表实现队列
     */
    public class LinkedListQueue {
        private ListNode front;     //头结点
        private ListNode rear;      //尾结点
        private int queSize = 0;    //长度

        //初始化
        public LinkedListQueue() {
            front = null;
            rear = null;
        }

        //获取长度
        public int size() {
            return queSize;
        }

        //判断队列长度是否为空
        public boolean isEmpty() {
            return size() == 0;
        }

        //入队
        public void push(int num) {
            //尾结点后添加 num
            ListNode node = new ListNode(num);
            //如果队列为空，则令头、尾节点都指向该节点
            if (front == null) {
                front = node;
                rear = node;
            } else {
                //如果队列为空，则将该节点添加至尾结点后
                rear.next = node;
                rear = node;
            }
            queSize++;
        }

        //出队
        public int pop() {
            int num = peek();
            //删除头结点
            front = front.next;
            queSize--;
            return num;
        }

        //访问队首元素
        public int peek() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            return front.val;
        }

        //转化为array
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
     * 基于环形数组实现队列
     */
    public class ArrayQueue {
        private int[] nums;     //存储队列元素的数组
        private int front;      //队首指针，指向队首元素
        private int queSize;    //队列长度

        //初始化
        public ArrayQueue(int capacity) {
            nums = new int[capacity];
            front = queSize = 0;
        }

        //队列的容量
        public int capacity() {
            return nums.length;
        }

        //队列的长度
        public int size() {
            return queSize;
        }

        //判断队列是否为空
        public boolean isEmpty() {
            return queSize == 0;
        }

        //入队
        public void push(int num) {
            if (queSize == capacity()) {
                System.out.println("队列已满");
                return;
            }
            //计算尾指针，指向队尾索引 + 1
            //通过取余操作，实现 rear 越过数组尾部回到头部
            int rear = (front + queSize) % capacity();
            //将num添加至队尾
            nums[rear] = num;
            queSize++;
        }

        //出队
        public int pop() {
            int num = peek();
            //队首指针向后移动一位，如果越过数组结尾则返回头部
            front = (front + 1) % capacity();
            queSize--;
            return num;
        }

        //方位队首元素
        public int peek() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            return nums[front];
        }

        //转为数组
        public int[] toArray() {
            //仅转换有效长度范围内的列表元素
            int[] res = new int[queSize];
            for (int i = 0, j = front; i < queSize; i++, j++) {
                res[i] = nums[j % capacity()];
            }

            return res;
        }
    }
}
