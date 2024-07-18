package problems.c0easy.t1001t1500;

/**
 * 1470 重新排列数组 https://leetcode.cn/problems/shuffle-the-array/description/
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 * 示例：
 * 输入1：nums = [2,5,1,3,4,7], n = 3
 * 输出1：[2,3,5,4,1,7]
 *
 * 输入2：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出2：[1,4,2,3,3,2,4,1]
 *
 * 输入3：nums = [1,1,2,2], n = 2
 * 输出3：[1,2,1,2]
 */
public class T1470 {
    /**
     * 自己实现：生成一个新数组
     */
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[n + i];
        }
        return ans;
    }
}
