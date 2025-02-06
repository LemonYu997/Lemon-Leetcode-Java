package problems.c0easy.t2001t2500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2089 找出数组排序后的目标下标 https://leetcode.cn/problems/find-target-indices-after-sorting-array/description/
 * 给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。
 * 目标下标 是一个满足 nums[i] == target 的下标 i 。
 * 将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。
 * 如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。
 *
 * 示例：
 * 输入1：nums = [1,2,5,2,3], target = 2
 * 输出1：[1,2]
 *
 * 输入2：nums = [1,2,5,2,3], target = 3
 * 输出2：[3]
 *
 * 输入3：nums = [1,2,5,2,3], target = 5
 * 输出3：[4]
 *
 * 输入4：nums = [1,2,5,2,3], target = 4
 * 输出4：[]
 */
public class T2089 {
    /**
     * 自己实现：根据题意模拟
     */
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();

        // 先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans.add(i);
            }
        }

        return ans;
    }

    /**
     * 官方解法：直接统计数量
     */
    public List<Integer> targetIndices1(int[] nums, int target) {
        // 小于 target 的元素数量
        int cnt1 = 0;
        // 等于 target 的元素数量
        int cnt2 = 0;

        // 由于要求统计升序数组的目标值所在索引，那么可以先统计低于目标值的个数和等于目标值的个数
        for (int num : nums) {
            if (num < target) {
                cnt1++;
            } else if (num == target) {
                cnt2++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = cnt1; i < cnt1 + cnt2; i++) {
            // 只需要把 小于目标值 的个数排在前边即可
            ans.add(i);
        }

        return ans;
    }
}