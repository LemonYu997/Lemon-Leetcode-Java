package problems.c0easy;

/**
 * 896 单调数列 https://leetcode.cn/problems/monotonic-array/
 * 如果数组是单调递增或单调递减的，那么他是单调的
 * 单调数组返回 true，否则返回 false
 *
 * 示例：
 * 输入1：nums = [1,2,2,3]
 * 输出1：true
 *
 * 输入2：nums = [6,5,4,4]
 * 输出2：true
 *
 * 输入3：nums = [1,3,2]
 * 输出3：false
 * */
public class T896 {
    /**
     * 自己实现：
     * 判断数组首位和末位：
     * 1、如果相等，nums 所有元素需相等
     * 2、如果首位 < 末位，nums 需单调递增
     * 3、如果首位 > 末位。nums 需单调递减
     */
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;
        // 只有一个数和两个数，都是单调的
        if (n < 2) {
            return true;
        }
        int a = nums[0];
        int b = nums[n - 1];

        for (int i = 1; i < n; i++) {
            // 如果相等，nums 所有元素需相等
            if (a == b && nums[i] != nums[i - 1]) {
                return false;
            } else if (a < b && nums[i] < nums[i - 1]) {
                // 如果首位 < 末位，nums 需单调递增
                return false;
            } else if (a > b && nums[i] > nums[i - 1]) {
                // 如果首位 > 末位。nums 需单调递减
                return false;
            }
        }
        return true;
    }
}
