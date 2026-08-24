package problems.c0easy.t3501t4000;

/**
 * 3925 连接逆序数组 https://leetcode.cn/problems/concatenate-array-with-reverse/description/
 * 给你一个长度为 n 的整数数组 nums。
 * 构造一个新的长度为 2 * n 的数组 ans，其中前 n 个元素与 nums 相同，后 n 个元素为 nums 的逆序。
 * 具体而言，对于 0 <= i <= n - 1：
 *
 * ans[i] = nums[i]
 * ans[i + n] = nums[n - i - 1]
 * 返回整数数组 ans。
 *
 * 示例：
 * 输入1：nums = [1,2,3]
 * 输出1：[1,2,3,3,2,1]
 *
 * 输入2：nums = [1]
 * 输出2：[1,1]
 */
public class T3925 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[n + i] = nums[n - i - 1];
        }

        return ans;
    }
}
