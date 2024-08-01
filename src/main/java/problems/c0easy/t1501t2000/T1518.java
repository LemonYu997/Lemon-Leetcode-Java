package problems.c0easy.t1501t2000;

/**
 * 1518 换水问题 https://leetcode.cn/problems/water-bottles/description/
 * 超市正在促销，你可以用 numExchange 个空水瓶从超市兑换一瓶水。
 * 最开始，你一共购入了 numBottles 瓶水。
 * 如果喝掉了水瓶中的水，那么水瓶就会变成空的。
 * 给你两个整数 numBottles 和 numExchange ，返回你 最多 可以喝到多少瓶水。
 *
 * 示例：
 * 输入1：numBottles = 9, numExchange = 3
 * 输出1：13
 *
 * 输入2：numBottles = 15, numExchange = 4
 * 输出2：19
 */
public class T1518 {
    /**
     * 自己实现：模拟，numBottles / numExchange = n 可得能换几瓶水，再将 n 继续除以 numExchange
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while (numBottles >= numExchange) {
            // 记录余数(剩下的瓶子）
            int temp = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            ans += numBottles;
            // 剩瓶子也可以加入到下一波兑换之中
            numBottles += temp;
        }
        return ans;
    }
}
