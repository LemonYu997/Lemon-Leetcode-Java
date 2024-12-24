package problems.c0easy.t1501t2000;

/**
 * 1929 数组串联 https://leetcode.cn/problems/concatenation-of-array/description/
 * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，
 * 数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
 * ans[i] == nums[i]
 * ans[i + n] == nums[i]
 * 具体而言，ans 由两个 nums 数组 串联 形成。
 *
 * 返回数组 ans 。
 *
 * 示例：
 * 输入1：nums = [1,2,1]
 * 输出1：[1,2,1,1,2,1]
 *
 * 输入2：nums = [1,3,2,1]
 * 输出2：[1,3,2,1,1,3,2,1]
 */
public class T1929 {
    /**
     * 自己实现：直接拼接即可
     */
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            ans[i] = nums[i % n];
        }

        return ans;
    }

    /**
     * 社区解法：使用API
     */
    public int[] getConcatenation1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);

        return ans;
    }
}
