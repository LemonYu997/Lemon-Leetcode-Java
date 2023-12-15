package problems.c0easy;

/**
 * 485 最大连续1的数 https://leetcode.cn/problems/max-consecutive-ones/
 * 给定一个二进制数组nums，计算其中最大连续1的个数
 *
 * 示例：
 * 输入1：nums = [1,1,0,1,1,1]
 * 输出1:3
 * 备注：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * 输入2：nums = [1,0,1,1,0,1]
 * 输出2:2
 */
public class T485 {
    /**
     * 自己实现：根据定义
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            //处理临界条件，最后一位是1时，也要统计上
            if (i == nums.length - 1 && nums[i] == 1) {
                count++;
                if (max < count) {
                    max = count;
                }
            }

            //遇到0就比较一下
            if (nums[i] == 0) {
                if (max < count) {
                    max = count;
                }
                count = 0;
            } else {
                count++;
            }
        }

        return max;
    }

    /**
     * 官方解法：上述代码的优化
     */
    public int findMaxConsecutiveOnes1(int[] nums) {
        int maxCount = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }

        //如果最后一位是1，结束循环后要重新比较一下
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
