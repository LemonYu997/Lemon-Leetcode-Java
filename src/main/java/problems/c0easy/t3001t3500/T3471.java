package problems.c0easy.t3001t3500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3471 找出最大的几近缺失整数 https://leetcode.cn/problems/find-the-largest-almost-missing-integer/description/
 * 给你一个整数数组 nums 和一个整数 k 。
 * 如果整数 x 恰好仅出现在 nums 中的一个大小为 k 的子数组中，则认为 x 是 nums 中的几近缺失（almost missing）整数。
 * 返回 nums 中 最大的几近缺失 整数，如果不存在这样的整数，返回 -1 。
 * 子数组 是数组中的一个连续元素序列。
 *
 * 示例：
 * 输入1：nums = [3,9,2,1,7], k = 3
 * 输出1：7
 *
 * 输入2：nums = [3,9,7,2,1,7], k = 4
 * 输出2：3
 *
 * 输入3：nums = [0,0], k = 1
 * 输出3：-1
 */
public class T3471 {
    /**
     * 社区解法：暴力模拟
     */
    public int largestInteger(int[] nums, int k) {
        int largest = -1;
        int n = nums.length;
        for (int num : nums) {
            int count = 0;
            for (int i = k - 1; i < n; i++) {
                if (exists(nums, i - k + 1, i, num)) {
                    count++;
                }
            }
            if (count == 1) {
                largest = Math.max(largest, num);
            }
        }
        return largest;
    }

    public boolean exists(int[] nums, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * 社区解法：分情况讨论
     */
    public int largestInteger1(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            return Arrays.stream(nums).max().getAsInt();
        }
        if (k == 1) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            int ans = - 1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    ans = Math.max(ans, entry.getKey());
                }
            }
            return ans;
        }
        // nums[0] 不能出现在其他地方，nums[n-1] 同理
        return Math.max(f(nums, 1, n, nums[0]), f(nums, 0, n - 1, nums[n - 1]));
    }

    private int f(int[] nums, int begin, int end, int x) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == x) {
                return -1;
            }
        }
        return x;
    }
}
