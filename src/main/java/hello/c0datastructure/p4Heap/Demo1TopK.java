package hello.c0datastructure.p4Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Top-K 问题
 * 给定一个长度为 n 的无序数组 nums ，请返回数组中最大的 k 个元素。
 *
 * 使用堆来维护数据：时间复杂度 O(nlog n)
 * 1、初始化一个小顶堆，其堆顶元素最小
 * 2、先将数组的前 k 个元素依次入堆
 * 3、从第 k + 1个元素开始，若当前元素大于堆顶元素，则将堆顶出堆，并将当前元素入堆
 * 4、遍历完成后，堆中保存的就是前 k 个最大元素
 */
public class Demo1TopK {
    // 基于堆查找数组中前 k 个最大元素
    Queue<Integer> topKHeap(int[] nums, int k) {
        // 初始化小顶堆
        Queue<Integer> heap = new PriorityQueue<>();
        // 将数组的前 k 个元素入堆
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        // 从第 k + 1 个元素开始，保持堆的长度为 k
        for (int i = k; i < nums.length; i++) {
            // 如果当前元素大于堆顶元素，则将堆顶元素出堆，当前元素入堆
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        return heap;
    }

}
