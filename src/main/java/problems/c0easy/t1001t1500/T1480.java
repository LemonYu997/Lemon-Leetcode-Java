package problems.c0easy.t1001t1500;

/**
 * 1480 一维数组的动态和 https://leetcode.cn/problems/running-sum-of-1d-array/description/
 * 给你一个数组 nums 。数组「动态和」的计算公式为：
 * runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4]
 * 输出1：[1,3,6,10]
 *
 * 输入2：nums = [1,1,1,1,1]
 * 输出2：[1,2,3,4,5]
 *
 * 输入3：nums = [3,1,2,10,1]
 * 输出3：[3,4,6,16,17]
 */
public class T1480 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans[i] = sum;
        }
        return ans;
    }

    /**
     * 官方解法：原地修改
     */
    public int[] runningSum1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // nums[i] 即为前缀和
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
