package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1005  K 次取反后最大化的数组和 https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 *
 * 示例：
 * 输入1：nums = [4,2,3], k = 1
 * 输出1：5
 * 备注：选择下标 1 ，nums 变为 [4,-2,3] 。
 *
 * 输入2：nums = [3,-1,0,2], k = 3
 * 输出2：6
 * 备注：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 *
 * 输入3：nums = [2,-3,-1,5,-4], k = 2
 * 输出3：13
 * 备注：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 */
public class T1005 {
    /**
     * 自己实现：先排序再遍历，有负数先转负数，
     * 如果是正数或 0，将 k 的次数全部用在较小的数字上
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        int i = 0;
        while (k > 0) {
            // 遇到负数，取反，向下遍历
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
                // 如果 i 即将超出范围，将剩余次数全部用在当前数上
                if (i + 1 >= nums.length) {
                    // 当剩余次数为奇数时，取反，剩余次数为偶数时，不变
                    if (k % 2 == 1) {
                        nums[i] = -nums[i];
                    }
                    k = 0;
                }
                i++;
            } else {
                // 当剩余次数为奇数时，取反，剩余次数为偶数时，不变
                if (k % 2 == 1) {
                    // 如果当前遍历结果是正数或 0，比较和上一个数谁更小（如果上一个数之前是负数，那反转之后可能比现在的小）
                    if (i > 0 && nums[i - 1] < nums[i]) {
                        nums[i - 1] = -nums[i - 1];
                    } else {
                        nums[i] = -nums[i];
                    }
                }
                k = 0;
            }
        }

        return Arrays.stream(nums).sum();
    }
}
