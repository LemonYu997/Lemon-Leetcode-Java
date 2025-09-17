package problems.c0easy.t2501t3000;

/**
 * 2784 检查数组是否是好的 https://leetcode.cn/problems/check-if-array-is-good/description/
 * 给你一个整数数组 nums ，如果它是数组 base[n] 的一个排列，我们称它是个 好 数组。
 * base[n] = [1, 2, ..., n - 1, n, n] （换句话说，它是一个长度为 n + 1 且包含 1 到 n - 1 恰好各一次，包含 n  两次的一个数组）。
 * 比方说，base[1] = [1, 1] ，base[3] = [1, 2, 3, 3] 。
 * 如果数组是一个好数组，请你返回 true ，否则返回 false 。
 * 注意：数组的排列是这些数字按任意顺序排布后重新得到的数组。
 *
 * 示例:
 * 输入1：nums = [2, 1, 3]
 * 输出1：false
 *
 * 输入2：nums = [1, 3, 3, 2]
 * 输出2：true
 *
 * 1 <= nums.length <= 100
 * 1 <= num[i] <= 200
 */
public class T2784 {
    /**
     * 自己实现：统计即可
     */
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] temp = new int[n + 2];

        // 统计各个数字出现的次数，1~n-1只有1次，n有两次
        for (int num : nums) {
            // 如果 1~n-1出现过重复，直接返回false
            if (num < n && temp[num] > 0) {
                return false;
            }
            temp[num]++;
        }

        // 判断1~n-1只有1次，n有两次
        for (int i = 1; i < n; i++) {
            if (temp[i] != 1) {
                return false;
            }
        }
        return temp[n] == 2;
    }
}
