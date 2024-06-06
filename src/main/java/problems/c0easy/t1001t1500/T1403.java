package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403 非递增顺序的最小子序列 https://leetcode.cn/problems/minimum-subsequence-in-non-increasing-order/description/
 * 给你一个数组 nums，请你从中抽取一个子序列，
 * 满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。
 * 如果存在多个解决方案，只需返回 长度最小 的子序列。
 * 如果仍然有多个解决方案，则返回 元素之和最大 的子序列。
 * 与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，
 * 也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。
 * 注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。
 *
 * 示例：
 * 输入1：nums = [4,3,10,9,8]
 * 输出1：[10,9]
 *
 * 输入2：nums = [4,4,7,6,7]
 * 输出2：[7,7,6]
 */
public class T1403 {
    /**
     * 自己实现：先排序，再计算总值，再从大到小选择
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int n = nums.length;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans.add(nums[i]);
            count += nums[i];
            // 如果满足要求就退出循环
            if (count > sum - count) {
                break;
            }
        }
        return ans;
    }
}
