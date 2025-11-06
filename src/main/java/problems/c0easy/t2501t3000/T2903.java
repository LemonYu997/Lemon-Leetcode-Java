package problems.c0easy.t2501t3000;

/**
 * 2903 找出满足差值条件的下标 I https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。
 * 你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：
 * abs(i - j) >= indexDifference 且
 * abs(nums[i] - nums[j]) >= valueDifference
 * 返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；
 * 否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。
 *
 * 注意：i 和 j 可能 相等
 *
 * 示例：
 * 输入1：nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
 * 输出1：[0,3]
 *
 * 输入2：nums = [2,1], indexDifference = 0, valueDifference = 0
 * 输出2：[0,0]
 *
 * 输入3：nums = [1,2,3], indexDifference = 2, valueDifference = 4
 * 输出3：[-1,-1]
 */
public class T2903 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference && Math.abs(i - j) >= indexDifference) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    /**
     * 官方解法：一次遍历
     */
    public int[] findIndices1(int[] nums, int indexDifference, int valueDifference) {
        int minIndex = 0, maxIndex = 0;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
            if (nums[j] - nums[minIndex] >= valueDifference) {
                return new int[]{minIndex, j};
            }
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            if (nums[maxIndex] - nums[j] >= valueDifference) {
                return new int[]{maxIndex, j};
            }
        }
        return new int[]{-1, -1};
    }
}