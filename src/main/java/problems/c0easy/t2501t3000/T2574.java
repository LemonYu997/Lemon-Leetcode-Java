package problems.c0easy.t2501t3000;

import java.util.Arrays;
import java.util.Map;

/**
 * 2574 左右元素和的差值 https://leetcode.cn/problems/left-and-right-sum-differences/description/
 * 给你一个下标从 0 开始的长度为 n 的整数数组 nums。
 * 定义两个数组 leftSum 和 rightSum，其中：
 * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回长度为 n 数组 answer，其中 answer[i] = |leftSum[i] - rightSum[i]|。
 *
 * 示例：
 * 输入1：nums = [10,4,8,3]
 * 输出1：[15,1,11,22]
 *
 * 输入2：nums = [1]
 * 输出2：[0]
 */
public class T2574 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int sum = 0;
        // 前缀和
        int preSum = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < n; i++) {
            sum -= nums[i];
            ans[i] = Math.abs(sum - preSum);
            preSum += nums[i];
        }

        return ans;
    }
}
