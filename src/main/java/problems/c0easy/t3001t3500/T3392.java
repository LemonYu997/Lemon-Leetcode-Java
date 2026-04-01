package problems.c0easy.t3001t3500;

/**
 * 3392 统计符合条件长度为 3 的子数组数目 https://leetcode.cn/problems/count-subarrays-of-length-three-with-a-condition/description/
 * 给你一个整数数组 nums ，请你返回长度为 3 的 子数组 的数量，满足第一个数和第三个数的和恰好为第二个数的一半。
 * 子数组 指的是一个数组中连续 非空 的元素序列。
 *
 * 示例：
 * 输入1：nums = [1,2,1,4,1]
 * 输出1：1
 *
 * 输入2：nums = [1,1,1]
 * 输出2：0
 */
public class T3392 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countSubarrays(int[] nums) {
        int ans = 0;

        for (int i = 0; i + 2 < nums.length; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                ans++;
            }
        }
        return ans;
    }
}
