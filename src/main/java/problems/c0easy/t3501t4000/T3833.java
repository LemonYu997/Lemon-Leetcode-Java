package problems.c0easy.t3501t4000;

/**
 * 3833 统计主导元素下标数 https://leetcode.cn/problems/count-dominant-indices/description/
 * 给你一个长度为 n 的整数数组 nums。
 * 当下标 i 满足以下条件时，该下标处的元素被称为 主导元素：nums[i] > average(nums[i + 1], nums[i + 2], ..., nums[n - 1])
 * 你的任务是统计数组中 主导元素 的下标数。
 * 平均值 是指一组数的总和除以该组数的个数得到的值。
 * 注意：数组的 最右边元素 不算作 主导元素 。
 *
 * 示例：
 * 输入1：nums = [5,4,3]
 * 输出1：2
 *
 * 输入2：nums = [4,1,2]
 * 输出2：1
 */
public class T3833 {
    /**
     * 自己实现：倒序一次遍历即可
     */
    public int dominantIndices(int[] nums) {
        // 已遍历元素数
        int count = 0;
        int sum = 0;
        int ans = 0;

        // 倒序求和，然后每次计算平均数
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count != 0 && nums[i] > (sum / count)) {
                ans++;
            }
            sum += nums[i];
            count++;
        }

        return ans;
    }
}
