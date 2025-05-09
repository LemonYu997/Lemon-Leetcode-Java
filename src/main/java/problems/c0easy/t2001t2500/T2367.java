package problems.c0easy.t2001t2500;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2367 等差三元组的数目 https://leetcode.cn/problems/number-of-arithmetic-triplets/description/
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。
 * 如果满足下述全部条件，则三元组 (i, j, k) 就是一个 等差三元组 ：
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 等差三元组 的数目。
 *
 * 示例：
 * 输入1：nums = [0,1,4,6,7,10], diff = 3
 * 输出1：2
 * 解释：(1, 2, 4) 是等差三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是等差三元组：10 - 7 == 3 且 7 - 4 == 3 。
 *
 * 输入2：nums = [4,5,6,7,8,9], diff = 2
 * 输出2：2
 * 解释：(0, 2, 4) 是等差三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是等差三元组：9 - 7 == 2 且 7 - 5 == 2 。
 *
 * 提示：
 * 3 <= nums.length <= 200
 * 0 <= nums[i] <= 200
 * 1 <= diff <= 50
 * nums 严格 递增
 */
public class T2367 {
    /**
     * 自己实现：暴力解法，遍历三次
     */
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] - nums[j] == diff && nums[j] - nums[i] == diff) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：使用哈希
     */
    public int arithmeticTriplets1(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num : nums) {
            if (set.contains(num + diff) && set.contains(num + 2 * diff)) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 三指针
     */
    public int arithmeticTriplets2(int[] nums, int diff) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0, j = 1, k = 2; i < n - 2 && j < n - 1 && k < n; i++) {
            // 以 i 为起始向前找符合条件的 j 和 k
            j = Math.max(j, i + 1);
            while (j < n - 1 && nums[j] - nums[i] < diff) {
                j++;
            }
            if (j >= n - 1 || nums[j] - nums[i] > diff) {
                continue;
            }
            k = Math.max(k, j + 1);
            while (k < n && nums[k] - nums[j] < diff) {
                k++;
            }
            if (k < n && nums[k] - nums[j] == diff) {
                ans++;
            }
        }

        return ans;
    }
}
