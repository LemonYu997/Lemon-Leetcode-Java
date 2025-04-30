package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2357 使数组中所有元素都等于零 https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/description/
 * 给你一个非负整数数组 nums 。在一步操作中，你必须：
 * 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
 * nums 中的每个正整数都减去 x。
 * 返回使 nums 中所有元素都等于 0 需要的 最少 操作数.
 *
 * 示例：
 * 输入1：nums = [1,5,0,3,5]
 * 输出1：3
 *
 * 输入2：nums = [0]
 * 输出2：0
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class T2357 {
    /**
     * 自己实现：根据题意模拟，每次都找到大于零的最小元素进行相减
     * 因为只要知道操作数，相当于只需要知道有多少个不同的数即可
     */
    public int minimumOperations(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        if (nums[0] > 0) {
            ans++;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] != nums[i - 1]) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：优化，使用 Set 去重
     */
    public int minimumOperations1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        return set.size();
    }

    /**
     * 社区解法：再优化，使用数组记录所有数是否出现
     * 0 <= nums[i] <= 100
     */
    public int minimumOperations2(int[] nums) {
        boolean[] flag = new boolean[101];
        // 默认数字 0 已出现过，不再记录次数
        flag[0] = true;
        int ans = 0;
        for (int num : nums) {
            // 记录所有第一次出现的非 0 数的 次数
            if (!flag[num]) {
                ans++;
            }
            flag[num] = true;
        }

        return ans;
    }
}