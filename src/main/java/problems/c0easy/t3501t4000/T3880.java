package problems.c0easy.t3501t4000;

/**
 * 3880 两个值之间的最小绝对差值 https://leetcode.cn/problems/minimum-absolute-difference-between-two-values/description/
 * 给你一个只包含 0、1 和 2 的整数数组 nums。
 * 如果 nums[i] == 1 且 nums[j] == 2，则称下标对 (i, j) 为 有效 的。
 * 请返回所有有效下标对中 i 和 j 之间的 最小 绝对差。如果不存在有效下标对，则返回 -1。
 * 下标 i 和 j 之间的绝对差定义为 abs(i - j)。
 *
 * 示例:
 * 输入1：nums = [1,0,0,2,0,1]
 * 输出1：2
 *
 * 输入2：nums = [1,0,1,0]
 * 输出2：-1
 */
public class T3880 {
    /**
     * 社区解法：枚举右，维护左
     */
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int ans = n;
        int[] last = {-n, -n};

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x > 0) {
                x--;
                ans = Math.min(ans, i - last[x ^ 1]);
                last[x] = i;
            }
        }
        return ans == n ? -1 : ans;
    }
}
