package problems.c0easy.t1501t2000;

/**
 * 1848 到目标元素的最小距离 https://leetcode.cn/problems/minimum-distance-to-the-target-element/description/
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，
 * 请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
 *
 * 返回 abs(i - start) 。
 *
 * 题目数据保证 target 存在于 nums 中。
 *
 * 实例：
 * 输入1：nums = [1,2,3,4,5], target = 5, start = 3
 * 输出1：1
 *
 * 输入2：nums = [1], target = 1, start = 0
 * 输出2：0
 *
 * 输入3：nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
 * 输出3：0
 */
public class T1848 {
    /**
     * 自己实现：根据提议模拟
     */
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }

        return ans;
    }
}
