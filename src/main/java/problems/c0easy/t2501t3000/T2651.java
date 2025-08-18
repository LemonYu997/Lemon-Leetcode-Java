package problems.c0easy.t2501t3000;

/**
 * 2651 计算列车到站时间 https://leetcode.cn/problems/calculate-delayed-arrival-time/description/
 * 给你一个正整数 arrivalTime 表示列车正点到站的时间（单位：小时），
 * 另给你一个正整数 delayedTime 表示列车延误的小时数。
 * 返回列车实际到站的时间。
 * 注意，该问题中的时间采用 24 小时制。
 *
 * 示例：
 * 输入1：arrivalTime = 15, delayedTime = 5
 * 输出1：20
 *
 * 输入2：arrivalTime = 13, delayedTime = 11
 * 输出2：0
 */
public class T2651 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int temp = arrivalTime + delayedTime;
        if (temp < 24) {
            return temp;
        } else if (temp == 24) {
            return 0;
        } else {
            return temp - 24;
        }
    }

    /**
     * 官方解法：优化写法
     */
    public int findDelayedArrivalTime1(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}