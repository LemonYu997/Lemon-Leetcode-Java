package problems.c0easy.t1t500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225 用队列实现栈 https://leetcode.cn/problems/implement-stack-using-queues/
 * 使用两个队列实现一个后入先出LIFO的栈，并支持普通栈的四种操作
 *
 * 示例：
 * 输入：["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 */
public class T225 {
    /**
     * 官方解法1：使用两个队列
     * 入栈时，先将元素入队到Q2，再将Q1内元素全部入队到Q1，然后将Q1和Q2互换
     * 即把本应入队到队尾的元素放到了队首
     */
    class MyStack1 {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack1() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        //入栈
        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()) {
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        //出栈
        public int pop() {
            return queue1.poll();
        }

        //得到栈顶(并没有出栈）
        public int top() {
            return queue1.peek();
        }

        //判断栈是否为空
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    /**
     * 官方解法2：使用一个队列
     */
    class MyStack2 {
        Queue<Integer> queue;

        public MyStack2() {
            queue = new LinkedList<>();
        }

        //入栈
        public void push(int x) {
            int n = queue.size();
            queue.offer(x);
            //队尾变队首
            for (int i = 0; i < n; i++) {
                queue.offer(queue.poll());
            }
        }

        //出栈
        public int pop() {
            return queue.poll();
        }

        //得到栈顶(并没有出栈）
        public int top() {
            return queue.peek();
        }

        //判断栈是否为空
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
