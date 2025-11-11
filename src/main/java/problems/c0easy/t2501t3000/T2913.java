package problems.c0easy.t2501t3000;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2913 子数组不同元素数目的平方和 I https://leetcode.cn/problems/subarrays-distinct-element-sum-of-squares-i/description/
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 定义 nums 一个子数组的 不同计数 值如下：
 * 令 nums[i..j] 表示 nums 中所有下标在 i 到 j 范围内的元素构成的子数组（满足 0 <= i <= j < nums.length ），
 * 那么我们称子数组 nums[i..j] 中不同值的数目为 nums[i..j] 的不同计数。
 * 请你返回 nums 中所有子数组的 不同计数 的 平方 和。
 * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
 * 子数组指的是一个数组里面一段连续 非空 的元素序列。
 *
 * 示例：
 * 输入1：nums = [1,2,1]
 * 输出1：15
 *
 * 输入2：nums = [2,2]
 * 输出2：3
 */
public class T2913 {
    /**
     * 社区解法：暴力
     */
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        final int MOD = (int)1e9 + 7;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);
                sum += map.size() * map.size();
                sum %= MOD;
            }
        }
        return (int) sum;
    }
}
