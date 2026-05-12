package problems.c0easy.t3001t3500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3487 删除后的最大子数组元素和 https://leetcode.cn/problems/maximum-unique-subarray-sum-after-deletion/description/
 * 给你一个整数数组 nums 。
 * 你可以从数组 nums 中删除任意数量的元素，但不能将其变为 空 数组。执行删除操作后，选出 nums 中满足下述条件的一个子数组：
 * 子数组中的所有元素 互不相同 。
 * 最大化 子数组的元素和。
 * 返回子数组的 最大元素和 。
 * 子数组 是数组的一个连续、非空 的元素序列。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,5]
 * 输出1：15
 *
 * 输入2：nums = [1,1,0,1,1]
 * 输出2：1
 *
 * 输入3：nums = [1,2,-1,-2,1,0,-1]
 * 输出3：3
 *
 * 提示：
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class T3487 {
    /**
     * 官方解法：对正数去重
     */
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        // 如果没有正数则返回一个最大值
        if (set.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return set.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * 社区解法：简化写法
     */
    public int maxSum2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int s = 0;
        int mx = Integer.MIN_VALUE;
        for (int x : nums) { // 一次遍历
            if (x < 0) {
                mx = Math.max(mx, x); // 计算最大负数
            } else if (set.add(x)) { // x 不在 set 中
                s += x; // 相同元素只留一个，累加元素和
            }
        }
        return set.isEmpty() ? mx : s;
    }
}
