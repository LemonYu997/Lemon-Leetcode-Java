package problems.c0easy.t2001t2500;

import java.util.HashSet;
import java.util.Set;

/**
 * 2395 和相等的子数组 https://leetcode.cn/problems/find-subarrays-with-equal-sum/description/
 * 给你一个下标从 0 开始的整数数组 nums ，判断是否存在 两个 长度为 2 的子数组且
 * 它们的 和 相等。注意，这两个子数组起始位置的下标必须 不相同 。
 *
 * 如果这样的子数组存在，请返回 true，否则返回 false 。
 *
 * 子数组 是一个数组中一段连续非空的元素组成的序列。
 *
 * 示例：
 * 输入1：nums = [4,2,4]
 * 输出1：true
 *
 * 输入2：nums = [1,2,3,4,5]
 * 输出2：false
 *
 * 输入3：nums = [0,0,0]
 * 输出3：true
 */
public class T2395 {
    /**
     * 自己实现：根据题意遍历
     */
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;

        for (int i = 0; i + 2 < n; i++) {
            // 第一个子数组
            int temp = nums[i] + nums[i + 1];
            for (int j = i + 1; j + 1 < n; j++) {
                // 第二个子数组
                if (nums[j] + nums[j + 1] == temp) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 官方解法：哈希表
     */
    public boolean findSubarrays1(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        // 遍历所有长度为2的子数组
        for (int i = 0; i + 1 < n; i++) {
            int temp = nums[i] + nums[i + 1];
            // 如果已出现过该和，则返回true
            if (!set.add(temp)) {
                return true;
            }
        }

        return false;
    }
}