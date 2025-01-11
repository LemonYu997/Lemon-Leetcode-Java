package problems.c0easy.t2001t2500;

/**
 * 2016 增量元素之间的最大差值 https://leetcode.cn/problems/maximum-difference-between-increasing-elements/description/
 * 给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，
 * 请你计算 nums[j] - nums[i] 能求得的 最大差值 ，其中 0 <= i < j < n 且 nums[i] < nums[j] 。
 * 返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。
 *
 * 示例：
 * 输入1：nums = [7,1,5,4]
 * 输出1:4
 *
 * 输入2：nums = [9,4,3,2]
 * 输出2：-1
 *
 * 输入3：nums = [1,5,2,10]
 * 输出3:9
 */
public class T2016 {
    /**
     * 自己实现：暴力解法
     */
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    ans = Math.max(ans, nums[j] - nums[i]);
                }
            }
        }

        return ans;
    }

    /**
     * 官方优化解法：前缀最小值
     * 在遍历的时候找到已经遍历过得最小值，并找到未来遍历的每一个值与其的差最大的情况
     */
    public int maximumDifference1(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int min = nums[0];

        for (int i = 1; i < n; i++) {
            // 如果当前值大于最小值，则进行判断获取最大差值
            if (nums[i] > min) {
                ans = Math.max(ans, nums[i] - min);
            } else {
                // 如果当前值小于最小值，则更新最小值
                min = nums[i];
            }
        }

        return ans;
    }
}
