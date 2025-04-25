package problems.c0easy.t2001t2500;

import java.util.Arrays;

/**
 * 2335 装满杯子需要的最短总时长 https://leetcode.cn/problems/minimum-amount-of-time-to-fill-cups/description/
 * 现有一台饮水机，可以制备冷水、温水和热水。每秒钟，
 * 可以装满 2 杯 不同 类型的水或者 1 杯任意类型的水。
 *
 * 给你一个下标从 0 开始、长度为 3 的整数数组 amount ，
 * 其中 amount[0]、amount[1] 和 amount[2] 分别表示需要装满冷水、
 * 温水和热水的杯子数量。返回装满所有杯子所需的 最少 秒数。
 *
 * 示例：
 * 输入1：amount = [1,4,2]
 * 输出1：4
 *
 * 输入2：amount = [5,4,4]
 * 输出2：7
 *
 * 输入3：amount = [5,0,0]
 * 输出3：5
 */
public class T2335 {
    /**
     * 官方解法：贪心 模拟计算
     * 先排序使其满足 a <= b <= c
     * 如果 a + b <= c ，则装满 c 的同时可以装满 a 和 b，因此总数为 c 次
     * 如果 a + b > c，此时总次数为 (a + b + c + 1) / 2
     */
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[1] + amount[0]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
