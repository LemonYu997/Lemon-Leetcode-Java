package problems.c0easy.t4001t4500;

/**
 * 4097 合并整数后的最小值 https://leetcode.cn/problems/minimum-value-of-merged-integers/description/
 * 给你一个长度为偶数 n 的整数数组 nums。
 * 你需要将 nums 中的元素两两合并：将 nums[0] 与 nums[1] 合并，将 nums[2] 与 nums[3] 合并，依此类推，直到将 nums[n - 2] 与 nums[n - 1] 合并。
 * 返回所有合并后得到的整数中的最小值。
 * 合并两个整数，是指将第二个整数的所有十进制数位拼接在第一个整数的所有十进制数位之后。
 *
 * 示例：
 * 输入1：nums = [23,55,42,21]
 * 输出1：2355
 *
 * 输入2：nums = [34,7,11,11]
 * 输出2：347
 *
 * 输入3：nums = [9,20]
 * 输出3：920
 */
public class T4097 {
    /**
     * 自己实现：根据题意模拟
     */
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i += 2) {
            int x = nums[i], y = nums[i + 1];
            // 注意是拼接，所以这里要根据 y 的值的位数来决定 x 要补几个0
            for (int v = y; v > 0; v /= 10) {
                x *= 10;
            }
            ans = Math.min(ans, x + y);
        }
        return ans;
    }
}
