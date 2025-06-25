package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2465 不同的平均值数目 https://leetcode.cn/problems/number-of-distinct-averages/description/
 * 给你一个下标从 0 开始长度为 偶数 的整数数组 nums 。
 * 只要 nums 不是 空数组，你就重复执行以下步骤：
 * 找到 nums 中的最小值，并删除它。
 * 找到 nums 中的最大值，并删除它。
 * 计算删除两数的平均值。
 * 两数 a 和 b 的 平均值 为 (a + b) / 2 。
 *
 * 比方说，2 和 3 的平均值是 (2 + 3) / 2 = 2.5 。
 * 返回上述过程能得到的 不同 平均值的数目。
 *
 * 注意 ，如果最小值或者最大值有重复元素，可以删除任意一个。
 *
 * 示例：
 * 输入1：nums = [4,1,4,0,3,5]
 * 输出1：2
 *
 * 输入2：nums = [1,100]
 * 输出2：1
 */
public class T2465 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 4, 0, 3, 5};
        distinctAverages(nums);
    }

    /**
     * 自己实现：根据题意模拟
     */
    public static int distinctAverages(int[] nums) {
        // 使用 Set 统计平均值种类
        Set<Double> set = new HashSet<>();
        // 先排序，排序后则最大值和最小值从两端取值即可
        Arrays.sort(nums);

        int n = nums.length;
        // 统计平均值种类
        for (int i = 0; i < n / 2; i++) {
            set.add((double) (nums[i] + nums[n - 1 - i]) / 2);
        }

        return set.size();
    }

    /**
     * 官方解法：直接统计两者之和种类即可
     */
    public static int distinctAverages1(int[] nums) {
        // 使用 Set 统计两者之和种类
        Set<Integer> set = new HashSet<>();
        // 先排序，排序后则最大值和最小值从两端取值即可
        Arrays.sort(nums);

        int n = nums.length;
        // 统计两者之和种类
        for (int i = 0; i < n / 2; i++) {
            set.add(nums[i] + nums[n - 1 - i]);
        }

        return set.size();
    }
}