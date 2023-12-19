package hello.c0datastructure.p1StackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 栈 https://www.hello-algo.com/chapter_stack_and_queue/stack/
 * 先入后出的线性数据结构。
 *
 * 常见操作：
 * 1、入栈（添加至栈顶）      push    时间复杂度O(1)
 * 2、出栈（栈顶弹出元素）     pop     时间复杂度O(1)
 * 3、访问栈顶元素             peek    时间复杂度O(1)
 */
public class Demo0Stack {
    public static void main(String[] args) {
        //初始化栈
        Stack<Integer> stack = new Stack<>();

        //元素入栈
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        System.out.println(stack);  //[1, 3, 2, 5, 4]

        //访问栈顶元素
        int peek = stack.peek();
        System.out.println(peek);   //4

        //元素出栈
        int pop = stack.pop();
        System.out.println(pop);    //4
        System.out.println(stack);  //[1, 3, 2, 5]

        //判断是否为空
        boolean b = stack.isEmpty();
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
     * 基于链表实现栈
     */
    public class LinkedListStack {
        private ListNode stackPeek; //将头结点作为栈顶
        private int stkSize = 0;    //栈的长度

        //构造
        public LinkedListStack() {
            stackPeek = null;
        }

        //获取栈的长度
        public int size() {
            return stkSize;
        }

        //判断栈是否为空
        public boolean isEmpty() {
            return stkSize == 0;
        }

        //入栈
        public void push(int num) {
            ListNode node = new ListNode(num);
            node.next = stackPeek;
            //将当前栈顶置为该元素
            stackPeek = node;
        }

        //出栈
        public int pop() {
            int num = peek();
            //栈顶向后移
            stackPeek = stackPeek.next;
            stkSize--;
            return num;
        }

        //访问栈顶元素
        public int peek() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            return stackPeek.val;
        }

        //将List转为数组
        public int[] toArray() {
            //栈顶头结点
            ListNode node = stackPeek;
            int[] res = new int[size()];
            //从栈顶开始遍历
            for (int i = res.length - 1; i >= 0; i--) {
                res[i] = node.val;
                node = node.next;
            }
            return res;
        }
    }

    /**
     * 基于数组实现栈
     */
    public class ArrayStack {
        private ArrayList<Integer> stack;

        //构造
        public ArrayStack() {
            //初始化列表，动态数组
            stack = new ArrayList<>();
        }

        //获取栈的长度
        public int size() {
            return stack.size();
        }

        //判断栈是否为空
        public boolean isEmpty() {
            return size() == 0;
        }

        //入栈
        public void push(int num) {
            stack.add(num);
        }

        //出栈
        public int pop() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            //从列表尾部弹出一个元素
            return stack.remove(size() - 1);
        }

        //访问栈顶元素
        public int peek() {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            return stack.get(size() - 1);
        }

        //转为array
        public Object[] toArray() {
            return stack.toArray();
        }
    }
}
