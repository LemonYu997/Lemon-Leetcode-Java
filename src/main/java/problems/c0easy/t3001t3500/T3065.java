package problems.c0easy.t3001t3500;

import java.util.Arrays;

/**
 * 3065 超过阈值的最少操作数 I https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-i/description/
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 一次操作中，你可以删除 nums 中的最小元素。
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 *
 * 示例：
 * 输入1：nums = [2,11,10,1,3], k = 10
 * 输出1：3
 *
 * 输入2：nums = [1,1,2,4,9], k = 1
 * 输出2：0
 *
 * 输入3：nums = [1,1,2,4,9], k = 9
 * 输出3：4
 */
public class T3065 {
    /**
     * 自己实现：排序后统计比 k 小的元素数即可
     */
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            if (num < k) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }


    /**
     * 官方解法:不需要排序直接遍历
     */
    public int minOperations1(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num < k) {
                ans++;
            }
        }
        return ans;
    }
}
