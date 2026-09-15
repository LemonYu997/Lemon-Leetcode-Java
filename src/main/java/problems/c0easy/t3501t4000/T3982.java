package problems.c0easy.t3501t4000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3982 最大数字范围的整数之和 https://leetcode.cn/problems/sum-of-integers-with-maximum-digit-range/description/
 * 给你一个整数数组 nums。
 * 一个整数的 数字范围 定义为其 最大 数字与 最小 数字之间的差。
 * 例如，5724 的数字范围为 7 - 2 = 5。
 * 返回 nums 中所有 数字范围 等于数组中 最大数字范围 的整数之和。
 *
 * 示例：
 * 输入1：nums = [5724,111,350]
 * 输出1：6074
 *
 * 输入2：nums = [90,900]
 * 输出2：990
 */
public class T3982 {
    public static void main(String[] args) {
        int[] nums = new int[]{76207, 65921};
        int ans = maxDigitRange(nums);
        System.out.println(ans);
    }

    /**
     * 自己实现：根据题意模拟
     */
    public static int maxDigitRange(int[] nums) {
        // 统计各个数字范围出现对应的元素
        Map<Integer, List<Integer>> map = new HashMap<>();

        int maxRange = 0;
        for (int num : nums) {
            int temp = num;
            int max = -1;
            int min = 10;
            while (temp > 0) {
                int digit = temp % 10;
                temp /= 10;
                if (max < digit) {
                    max = digit;
                }
                if (min > digit) {
                    min = digit;
                }
            }
            System.out.println(num + ":" + min);
            System.out.println(num + ":" + max);
            int range = max - min;

            List<Integer> list = map.getOrDefault(range, new ArrayList<>());
            list.add(num);
            map.put(range, list);
            if (range > maxRange) {
                maxRange = range;
            }
        }

        int ans = 0;
        for (Integer n : map.get(maxRange)) {
            ans += n;
        }
        return ans;
    }

    /**
     * 社区解法：优化写法，更新最大索引的时候重新累加，不需要map
     */
    public int maxDigitRange1(int[] nums) {
        int maxRange = 0;
        int ans = 0;

        for (int num : nums) {
            int min = 9;
            int max = 0;
            for (int v = num; v > 0; v /= 10) {
                int d = v % 10;
                min = Math.min(min, d);
                max = Math.max(max, d);
            }

            int r = max - min;
            // 更新最大索引的时候重新累加
            if (r > maxRange) {
                maxRange = r;
                ans = num;
            } else if (r == maxRange) {
                ans += num;
            }
        }

        return ans;
    }
}
