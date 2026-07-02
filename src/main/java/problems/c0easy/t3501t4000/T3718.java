package problems.c0easy.t3501t4000;

import java.util.HashSet;
import java.util.Set;

/**
 * 3718 缺失的最小倍数 https://leetcode.cn/problems/smallest-missing-multiple-of-k/description/
 * 给你一个整数数组 nums 和一个整数 k，
 * 请返回从 nums 中缺失的、最小的正整数 k 的倍数。
 * 倍数 指能被 k 整除的任意正整数。
 *
 * 示例：
 * 输入1：nums = [8,2,3,4,6], k = 2
 * 输出1：10
 *
 * 输入2：nums = [1,4,7,10,15], k = 5
 * 输出2：5
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 */
public class T3718 {
    /**
     * 自己实现：根据题意模拟
     */
    public int missingMultiple(int[] nums, int k) {
        int[] map = new int[101];
        for (int num : nums) {
            map[num] = 1;
        }

        int i = 1;
        while (i * k <= 100) {
            if (map[i * k] == 0) {
                return i * k;
            }
            i++;
        }
        return i * k;
    }

    /**
     * 社区解法：优化写法
     */
    public int missingMultiple1(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = k; ; i += k) {
            if (!set.contains(i)) {
                return i;
            }
        }
    }
}