package problems.c0easy.t2001t2500;

/**
 * T2006 差的绝对值为 K 的数对数目 https://leetcode.cn/problems/count-number-of-pairs-with-absolute-difference-k/description/
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，
 * 满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 *
 * 示例：
 * 输入1：nums = [1,2,2,1], k = 1
 * 输出1:4
 *
 * 输入2：nums = [1,3], k = 3
 * 输出2：0
 *
 * 输入3：nums = [3,2,1,5,4], k = 2
 * 输出3:3
 */
public class T2006 {
    /**
     * 自己实现：暴力解
     */
    public int countKDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：哈希表 + 一次遍历
     */
    public int countKDifference1(int[] nums, int k) {
        // 因为 nums[i]的值为 [1,100]，可以用数组记录每个值的出现次数
        int[] arr = new int[101];
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            // 当前值
            int num = nums[i];
            // 如果当前值大于要寻找的值，则向前找，即找小的值 num - k
            if (num - k >= 1) {
                ans += arr[num - k];
            }
            // 如果当前值小于要寻找的值，则向后找，即找大的 num + k
            if (num + k <= 100) {
                ans += arr[num + k];
            }
            // 记录当前值出现的次数
            arr[num]++;
        }

        return ans;
    }
}