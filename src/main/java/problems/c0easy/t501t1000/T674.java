package problems.c0easy.t501t1000;

/**
 * 674 最长连续递增序列 https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
 * 给定一个未经排序的整数数组，找到最长切连续递增的子序列，返回该序列的长度、
 * 由两个下标 l 和 r (l < r)确定，如果对于每个 l <= i < r，都有nums[i] < nums[i+1]
 * 那么子序列就是 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列
 *
 * 示例：
 * 输入1：nums = [1,3,5,4,7]
 * 输出1：3
 * 备注：最长连续递增序列是 [1,3,5], 长度为3
 *
 * 输入2：nums = [2,2,2,2,2]
 * 输出2：1
 */
public class T674 {
    /**
     * 自己实现：快慢指针
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;    //结果 最少也为1
        int l = 0;      //慢指针
        int r = 1;      //快指针

        while (r < nums.length) {
            //快指针一直向前，只要比上一个数小，就更新最大距离
            if (nums[r] > nums[r - 1]) {
                ans = Math.max(ans, r - l + 1);
            } else {
                //否则更新慢指针位置
                l = r;
            }
            r++;
        }

        return ans;
    }

    /**
     * 官方解法：贪心
     */
    public int findLengthOfLCIS1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}
