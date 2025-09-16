package problems.c0easy.t2501t3000;

/**
 * 2778 特殊元素平方和 https://leetcode.cn/problems/sum-of-squares-of-special-elements/description/
 * 给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 * 对 nums 中的元素 nums[i] 而言，如果 n 能够被 i 整除，
 * 即 n % i == 0 ，则认为 num[i] 是一个 特殊元素 。
 * 返回 nums 中所有 特殊元素 的 平方和 。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4]
 * 输出1：21
 *
 * 输入2：nums = [2,7,1,19,18,3]
 * 输出2：63
 */
public class T2778 {
    /**
     * 自己实现：根据题意模拟
     */
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 题目数组下标从 1 开始，所以这里要 + 1
            if (n % (i + 1) == 0) {
                ans += nums[i] * nums[i];
            }
        }
        return ans;
    }
}
