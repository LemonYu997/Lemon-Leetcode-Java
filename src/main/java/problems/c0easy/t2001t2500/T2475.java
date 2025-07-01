package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2475 数组中不等三元组的数目 https://leetcode.cn/problems/number-of-unequal-triplets-in-array/description/
 * 给你一个下标从 0 开始的正整数数组 nums 。
 * 请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 *
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * 返回满足上述条件三元组的数目。
 *
 * 示例：
 * 输入1：nums = [4,4,2,4,3]
 * 输出1：3
 *
 * 输入2：nums = [1,1,1,1,1]
 * 输出2：0
 */
public class T2475 {
    /**
     * 自己实现：暴力
     */
    public int unequalTriplets(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] != nums[j] && nums[j] != nums[i] && nums[k] != nums[i]) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：排序，因为只统计个数，因此不用在乎实际位置
     */
    public int unequalTriplets1(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i = j) {
            // 将三元组中的中间数作为当前 i，[i, j)为一批相同元素，则这堆元素左边数量为 i，右边数量为 n - j
            while (j < n && nums[j] == nums[i]) {
                j++;
            }
            ans += i * (j - i) * (n - j);
        }

        return ans;
    }

    /**
     * 官方解法：哈希表
     */
    public int unequalTriplets2(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            // 初始值为 1，合并计数
            count.merge(num, 1, Integer::sum);
        }
        int ans = 0;
        int n = nums.length;
        int t = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            ans += t * entry.getValue() * (n - t - entry.getValue());
            t += entry.getValue();
        }
        return ans;
    }
}
