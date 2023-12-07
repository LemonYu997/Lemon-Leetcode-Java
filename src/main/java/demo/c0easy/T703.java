package demo.c0easy;

import java.util.PriorityQueue;

/**
 * 703 数据流中的第 K 大元素 https://leetcode.cn/problems/kth-largest-element-in-a-stream/
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 * 请实现KthLargest类：
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
 *
 * 示例：
 * 输入1：["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出1：[null, 4, 5, 5, 8, 8]
 * 备注：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 */
public class T703 {
    /**
     * 官方解法：使用优先队列
     * 优先队列的队头为队列中最小的元素，也就是第 k 大的元素
     * 单次插入的操作中，我们首先将元素 val 加入到优先队列中。
     * 如果此时优先队列的大小大于 k，我们需要将优先队列的队头元素弹出，以保证优先队列的大小为 k
     */
    class KthLargest {
        //优先队列： 小 -> 大
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            //入队
            pq.offer(val);
            //维持队列的长度为k，则队头即为第 k 大元素
            if (pq.size() > k) {
                //移除多余的队头
                pq.poll();
            }
            //返回剩下k个元素队列的队头
            return pq.peek();
        }
    }
}
