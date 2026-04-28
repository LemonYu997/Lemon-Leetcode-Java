package problems.c0easy.t3001t3500;

/**
 * 3452 好数字之和 https://leetcode.cn/problems/sum-of-good-numbers/description/
 * 给定一个整数数组 nums 和一个整数 k，如果元素 nums[i] 严格 大于下标 i - k 和 i + k 处的元素（如果这些元素存在），
 * 则该元素 nums[i] 被认为是 好 的。如果这两个下标都不存在，那么 nums[i] 仍然被认为是 好 的。
 * 返回数组中所有 好 元素的 和。
 *
 * 示例：
 * 输入1：nums = [1,3,2,1,5,4], k = 2
 * 输出1：12
 *
 * 输入2：nums = [2,1], k = 1
 * 输出2：2
 */
public class T3452 {
    /**
     * 自己实现：根据题意遍历
     */
    public int sumOfGoodNumbers(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if ((i < k || x > nums[i - k]) && (i + k >= n || x > nums[i + k])) {
                ans += x;
            }
        }
        return ans;
    }
}
