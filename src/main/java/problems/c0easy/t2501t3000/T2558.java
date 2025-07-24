package problems.c0easy.t2501t3000;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2558 从数量最多的堆取走礼物 https://leetcode.cn/problems/take-gifts-from-the-richest-pile/description/
 * 给你一个整数数组 gifts ，表示各堆礼物的数量。每一秒，你需要执行以下操作：
 * 选择礼物数量最多的那一堆。
 * 如果不止一堆都符合礼物数量最多，从中选择任一堆即可。
 * 将堆中的礼物数量减少到堆中原来礼物数量的平方根，向下取整。
 * 返回在 k 秒后剩下的礼物数量。
 *
 * 示例：
 * 输入1：gifts = [25,64,9,4,100], k = 4
 * 输出1：29
 *
 * 输入2：gifts = [1,1,1,1], k = 4
 * 输出2：4
 */
public class T2558 {
    /**
     * 官方解法：使用堆来维护礼物数量
     */
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            pq.offer(gift);
        }
        while (k > 0) {
            k--;
            int x = pq.poll();
            pq.offer((int) Math.sqrt(x));
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}
