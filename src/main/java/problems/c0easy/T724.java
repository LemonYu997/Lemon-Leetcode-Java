package problems.c0easy;

import java.util.Arrays;

/**
 * 724 寻找数组的中心下标 https://leetcode.cn/problems/find-pivot-index/
 * 给定一个整数数组 nums，请计算数组的中心下标
 * 中心下标：数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。
 * 这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1
 *
 * 示例：
 * 输入1：nums = [1, 7, 3, 6, 5, 6]
 * 输出1：3
 * 备注：
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 *
 * 输入2：nums = [1, 2, 3]
 * 输出2：-1
 * 备注：数组中不存在满足此条件的中心下标。
 *
 * 输入3：nums = [2, 1, -1]
 * 输出3：0
 * 备注：
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 */
public class T724 {
    /**
     * 自己实现：双指针
     * 无法解决 [-1, -1, -1, -1, -1, 0]
     */
    public int pivotIndex(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int sumL = nums[l];
        int sumR = nums[r];

        while (l < r) {
            if (sumL > sumR) {
                r--;
                sumR += nums[r];
            } else {
                l++;
                sumL += nums[l];
            }
        }

        if (sumL == sumR) {
            return l;
        } else {
            return -1;
        }
    }

    /**
     * 自己实现：暴力求解，从左侧开始
     */
    public int pivotIndex1(int[] nums) {
        //在最左端和最右端的时候默认和为0
        for (int i = 0; i < nums.length; i++) {
            int sumL = 0;
            int sumR = 0;

            //左端所有数相加，如果 i = 0，则和为0
            for (int j = 0; j < i; j++) {
                sumL += nums[j];
            }
            //右端所有数相加，如果 i = nums.length - 1，则和为0
            for (int j = nums.length - 1; j > i; j--) {
                sumR += nums[j];
            }

            if (sumL == sumR) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 官方解法2：前缀和
     * 全部元素和为 total，左侧元素和为 sum，右侧元素和则为 total - nums[i] - sum
     * 左右元素和相等即为：sum = total - nums[i] - sum
     * 即为：sum * 2 + nums[i] = total
     * 当中心索引左侧或右侧没有元素时，即为零个项相加，这在数学上称作「空和」
     * 这里默认空和是 0
     */
    public int pivotIndex2(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }

        return -1;
    }
}
