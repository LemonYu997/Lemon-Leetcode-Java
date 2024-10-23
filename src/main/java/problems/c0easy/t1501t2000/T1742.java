package problems.c0easy.t1501t2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1742 盒子中小球的最大数量 https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/description/
 * 你在一家生产小球的玩具厂工作，有 n 个小球，编号从 lowLimit 开始，
 * 到 highLimit 结束（包括 lowLimit 和 highLimit ，即 n == highLimit - lowLimit + 1）。
 * 另有无限数量的盒子，编号从 1 到 infinity 。
 *
 * 你的工作是将每个小球放入盒子中，其中盒子的编号应当等于小球编号上每位数字的和。
 * 例如，编号 321 的小球应当放入编号 3 + 2 + 1 = 6 的盒子，而编号 10 的小球应当放入编号 1 + 0 = 1 的盒子。
 *
 * 给你两个整数 lowLimit 和 highLimit ，返回放有最多小球的盒子中的小球数量.
 * 如果有多个盒子都满足放有最多小球，只需返回其中任一盒子的小球数量。
 *
 * 示例：
 * 输入1：lowLimit = 1, highLimit = 10
 * 输出1：2
 *
 * 输入2：lowLimit = 5, highLimit = 15
 * 输出2：2
 *
 * 输入3：lowLimit = 19, highLimit = 28
 * 输出3：2
 */
public class T1742 {
    /**
     * 自己实现：根据题意
     * 使用map存储
     */
    public int countBalls(int lowLimit, int highLimit) {
        // 存储盒子中的棋子数
        Map<Integer, Integer> map = new HashMap<>();
        // 最少也会有1个
        int ans = 1;
        // 计算每个小青应该放入的盒子
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = i;
            int key = 0;
            while (temp > 0) {
                key += temp % 10;
                temp /= 10;
            }
            if (map.containsKey(key)) {
                int value = map.get(key) + 1;
                ans = Math.max(ans, value);
                map.put(key, value);
            } else {
                map.put(key, 1);
            }
        }

        return ans;
    }
}
