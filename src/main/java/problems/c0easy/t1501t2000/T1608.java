package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1608 特殊数组的特征值 https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/description/
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，
 * 使得 nums 中恰好有 x 个元素 大于或者等于 x ，
 * 那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 *
 * 注意： x 不必 是 nums 的中的元素。
 *
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。
 * 否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 *
 * 示例：
 * 输入1：nums = [3,5]
 * 输出1：2
 *
 * 输入2：nums = [0,0]
 * 输出2：-1
 *
 * 输入3：nums = [0,4,3,0,4]
 * 输出3：3
 *
 * 输入4：nums = [3,6,7,7,0]
 * 输出4：-1
 */
public class T1608 {
    /**
     * 自己实现：双重循环
     */
    public int specialArray(int[] nums) {
        int n = nums.length;
        int ans = -1;

        // 遍历每一种可能，判断是否满足
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] >= i) {
                    count++;
                }
            }
            if (count == i) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 官方解法：降序排序+一次遍历
     */
    public int specialArray1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        // 倒序排序
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // nums[i - 1] 必须大于等于 i
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }
        return -1;
    }
}
