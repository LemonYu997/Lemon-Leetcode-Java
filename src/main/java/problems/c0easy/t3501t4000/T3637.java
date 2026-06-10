package problems.c0easy.t3501t4000;

/**
 * 3637 三段式数组 I https://leetcode.cn/problems/trionic-array-i/description/
 * 给你一个长度为 n 的整数数组 nums。
 * 如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
 * nums[0...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...n − 1] 严格 递增。
 * 如果 nums 是三段式数组，返回 true；否则，返回 false。
 *
 * 示例：
 * 输入1：nums = [1,3,5,4,2,6]
 * 输出1：true
 *
 * 输入2：nums = [2,1,3]
 * 输出2：false
 */
public class T3637 {
    /**
     * 官方解法：判断边界的合理性
     */
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int p = i - 1;
        while (i < n && nums[i - 1] > nums[i]) {
            i++;
        }
        int q = i - 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        int flag = i - 1;
        return (p != 0) && (q != p) && (flag == n - 1 && flag != q);
    }

    /**
     * 官方解法2：统计拐弯点数量
     */
    public boolean isTrionic2(int[] nums) {
        int n = nums.length;
        if (nums[0] >= nums[1]) {
            return false;
        }
        int count = 1;
        for (int i = 2; i < n; i++) {
            if (nums[i - 1] == nums[i]) {
                return false;
            }
            if ((nums[i - 2] - nums[i - 1]) * (nums[i - 1] - nums[i]) < 0) {
                count++;
            }
        }
        return count == 3;
    }
}