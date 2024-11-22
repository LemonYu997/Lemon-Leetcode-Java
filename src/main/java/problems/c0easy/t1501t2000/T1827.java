package problems.c0easy.t1501t2000;

/**
 * 1827 最少操作使数组递增 https://leetcode.cn/problems/minimum-operations-to-make-the-array-increasing/description/
 * 给你一个整数数组 nums （下标从 0 开始）。
 * 每一次操作中，你可以选择数组中一个元素，并将它增加 1 。
 * 比方说，如果 nums = [1,2,3] ，你可以选择增加 nums[1] 得到 nums = [1,3,3] 。
 * 请你返回使 nums 严格递增 的 最少 操作次数。
 * 我们称数组 nums 是 严格递增的 ，当它满足对于所有的 0 <= i < nums.length - 1 都有 nums[i] < nums[i+1] 。
 * 一个长度为 1 的数组是严格递增的一种特殊情况。
 *
 * 示例：
 * 输入1：nums = [1,1,1]
 * 输出1:3
 *
 * 输入2：nums = [1,5,2,4,1]
 * 输出2：14
 *
 * 输入3：nums = [8]
 * 输出3:0
 */
public class T1827 {
    /**
     * 自己实现：遍历并判断是否比前边大，否则更改为前边值 + 1
     */
    public int minOperations(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            // 如果需要改变，计算需要增加的次数
            if (nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return count;
    }

    /**
     * 官方解法：贪心
     */
    public int minOperations1(int[] nums) {
        int pre = nums[0] - 1;
        int res = 0;

        for (int num : nums) {
            // 如果当前值就是最大的（比前一个大就是最大的），就不会增加计数，否则增加差值
            // 注意因为要求严格递增，这里要保留最少为 1 的差值
            pre = Math.max(pre + 1, num);
            res += pre - num;
        }

        return res;
    }
}
