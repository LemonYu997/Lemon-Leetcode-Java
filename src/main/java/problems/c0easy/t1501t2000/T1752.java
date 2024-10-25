package problems.c0easy.t1501t2000;

/**
 * 1752 检查数组是否经排序和轮转得到 https://leetcode.cn/problems/check-if-array-is-sorted-and-rotated/description/
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 * 源数组中可能存在 重复项 。
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 *
 * 示例：
 * 输入1：nums = [3,4,5,1,2]
 * 输出1：true
 *
 * 输入2：nums = [2,1,3,4]
 * 输出2：false
 *
 * 输入3：nums = [1,2,3]
 * 输出3：true
 */
public class T1752 {
    /**
     * 自己实现：根据题意分析，有以下可能
     * 1、出现两次及以上递减情况，直接返回 false
     * 2、没有递减，返回 true
     * 3、出现两次以下递减，判断整个数组的末位置 <= 初始值，返回 true，否则返回 false
     */
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;  // 递减次数
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count >= 2) {
                    return false;
                }
            }
        }

        if (count == 0) {
            return true;
        }

        // 出现1次递减，判断数组末尾值 < 初始值
        return nums[n - 1] <= nums[0];
    }
}
