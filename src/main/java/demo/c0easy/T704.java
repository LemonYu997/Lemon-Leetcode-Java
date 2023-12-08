package demo.c0easy;

/**
 * 704 二分查找 https://leetcode.cn/problems/binary-search/
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 示例：
 * 输入1：nums = [-1,0,3,5,9,12], target = 9
 * 输出1：4
 *
 * 输入2：nums = [-1,0,3,5,9,12], target = 2
 * 输出2：-1
 */
public class T704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else  {
                r = mid - 1;
            }
        }

        return -1;
    }
}
