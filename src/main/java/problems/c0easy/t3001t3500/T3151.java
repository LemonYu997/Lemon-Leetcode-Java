package problems.c0easy.t3001t3500;

/**
 * 3151 特殊数组 I https://leetcode.cn/problems/special-array-i/description/
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组。
 * 换句话说，每一对中的元素 必须 有一个是偶数，另一个是奇数。
 * 你有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 *
 * 示例：
 * 输入1：nums = [1]
 * 输出1：true
 *
 * 输入2：nums = [2,1,4]
 * 输出2：true
 *
 * 输入3：nums = [4,3,1,6]
 * 输出3：false
 */
public class T3151 {
    /**
     * 自己实现：根据题意判断
     */
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            // 如果相邻数奇偶性相同，则false
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false;
            }
        }
        return true;
    }
}
