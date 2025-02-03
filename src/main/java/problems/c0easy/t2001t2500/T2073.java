package problems.c0easy.t2001t2500;

/**
 * 2073 买票需要的时间 https://leetcode.cn/problems/time-needed-to-buy-tickets/description/
 * 有 n 个人前来排队买票，其中第 0 人站在队伍 最前方 ，第 (n - 1) 人站在队伍 最后方 。
 * 给你一个下标从 0 开始的整数数组 tickets ，数组长度为 n ，其中第 i 人想要购买的票数为 tickets[i] 。
 * 每个人买票都需要用掉 恰好 1 秒 。一个人 一次只能买一张票 ，如果需要购买更多票，
 * 他必须走到  队尾 重新排队（瞬间 发生，不计时间）。如果一个人没有剩下需要买的票，那他将会 离开 队伍。
 * 返回位于位置 k（下标从 0 开始）的人完成买票需要的时间（以秒为单位）。
 *
 * 示例：
 * 输入1：tickets = [2,3,2], k = 2
 * 输出1：6
 *
 * 输入2：tickets = [5,1,1,1], k = 0
 * 输出2：8
 */
public class T2073 {
    /**
     * 自己实现：根据题意统计
     */
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        // 目标需要买的次数
        int count = tickets[k];

        // 遍历计算每个人的所需时间
        for (int i = 0; i < tickets.length; i++) {
            // 如果当前人在目标的前方，则其最多买 count 张票
            if (i <= k) {
                ans += Math.min(count, tickets[i]);
            } else {
                // 如果在目标后方，在 k 买完 count前，最多可以买 count - 1 张
                ans += Math.min(count - 1, tickets[i]);
            }
        }

        return ans;
    }
}
