package problems.c0easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 575 分糖果 https://leetcode.cn/problems/distribute-candies/
 * 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i]。
 * 只吃掉 n / 2（ n是一个偶数）。
 * 给定一个长度为 n 的整数数组 candyType，返回可以吃到的最多种数。
 *
 * 示例：
 * 输入1：candyType = [1,1,2,2,3,3]
 * 输出1:3
 * 备注：只能吃 6 / 2 = 3枚糖，刚好只有1、2、3三种糖，可以每种一个
 *
 * 输入2：candyType = [1,1,2,3]
 * 输出2:2
 *
 * 输入3：candyType = [6,6,6,6]
 * 输出3：1
 */
public class T575 {
    /**
     * 自己实现：先排序，再吃每一个不同的糖果
     */
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int max = candyType.length / 2;
        //第一个先吃掉
        int count = 1;

        for (int i = 1; i < candyType.length; i++) {
            //已到上限就直接返回
            if (count >= max) {
                return max;
            }
            //只有遇到不同的糖才会吃掉
            if (candyType[i] != candyType[i - 1] && count < max) {
                count++;
            }
        }

        return count;
    }

    /**
     * 自己实现2：使用Set去重
     */
    public int distributeCandies1(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int max = candyType.length / 2;

        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
            //如果超过上限，就按上限
            if (set.size() >= max) {
                return max;
            }
        }

        return set.size();
    }
}
