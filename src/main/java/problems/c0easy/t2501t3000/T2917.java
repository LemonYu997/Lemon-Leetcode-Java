package problems.c0easy.t2501t3000;

/**
 * 2917 找出数组中的 K-or 值 https://leetcode.cn/problems/find-the-k-or-of-an-array/description/
 * 给你一个整数数组 nums 和一个整数 k 。让我们通过扩展标准的按位或来介绍 K-or 操作。在 K-or 操作中，
 * 如果在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值是 1 。
 * 返回 nums 的 K-or 值。
 *
 * 示例：
 * 输入1：nums = [7,12,9,8,9,15], k = 4
 * 输出1：9
 *
 * 输入2：nums = [2,12,1,11,4,5], k = 6
 * 输出2：0
 *
 * 输入3：nums = [10,8,5,9,11,6,8], k = 1
 * 输出3：15
 */
public class T2917 {
    /**
     * 官方解法：遍历
     */
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (((num >> i) & 1) != 0) {
                    cnt++;
                }
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }
}
