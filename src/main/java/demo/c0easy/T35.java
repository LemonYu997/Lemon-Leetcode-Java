package demo.c0easy;

/**
 * 35 搜索插入位置 https://leetcode.cn/problems/search-insert-position/
 * 给定一个排序数组和一个目标值，在数组中找到目标值，返回其索引，如果不存在，就按顺序插入
 *
 * 示例1：
 * 输入：nums = [1,3,5,6], target = 5
 * 输出：2
 *
 * 示例2：
 * 输入：nums = [1,3,5,6], target = 2
 * 输出：1
 */
public class T35 {
    /**
     * 自己实现：从头遍历数组，只要当前位置的值比目标大，就将目标值插在这里
     */
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    /**
     * 二分法，用左右指针向中间排除
     */
    public int searchInsert2(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int ans = n;        //默认在最后一位，如果没找到的话

        while (left <= right) {
            //中间索引位置
            int mid = (right - left) / 2 + left;
            //中间位比目标大的时候，找左半边，更新结果
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                //中间位比目标小的时候，找右半边
                left = mid + 1;
            }
        }

        return ans;
    }
}
