package problems.c0easy.t3501t4000;

/**
 * 3512 使数组和能被 K 整除的最少操作次数 https://leetcode.cn/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/
 * 给你一个整数数组 nums 和一个整数 k。你可以执行以下操作任意次：
 * 选择一个下标 i，并将 nums[i] 替换为 nums[i] - 1。
 * 返回使数组元素之和能被 k 整除所需的最小操作次数。
 *
 * 示例：
 * 输入1：nums = [3,9,7], k = 5
 * 输出1：4
 *
 * 输入2：nums = [4,1,3], k = 4
 * 输出2：0
 *
 * 输入3：nums = [3,2], k = 6
 * 输出3：5
 */
public class T3512 {
    /**
     * 自己实现：根据题意，求和取模即可，余数即为需要操作的次数
     */
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
