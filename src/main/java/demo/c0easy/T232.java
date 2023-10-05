package demo.c0easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232 用栈实现队列 https://leetcode.cn/problems/implement-queue-using-stacks/
 * 使用两个栈实现先入先出队列，队列应当支持一般队列支持的所有操作 push、pop、peek、empty
 *
 * 示例：
 * 输入1：["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出1：[null, null, null, 1, 1, false]
 *
 * 备注：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 */
public class T232 {
    /**
     * 官方实现：使用两个栈
     * 将一个栈当做输入栈，用于push
     * 另一个栈当做输出栈，用于pop和peek
     */
    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<>();
            outStack = new ArrayDeque<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
