package problems.c0easy.t3501t4000;

/**
 * 3736 最小操作次数使数组元素相等 III https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-iii/description/
 * 给你一个整数数组 nums。
 * 在一步操作中，你可以将任意单个元素 nums[i] 的值 增加 1。
 * 返回使数组中的所有元素都 相等 所需的 最小总操作次数 。
 *
 * 示例：
 * 输入1：nums = [2,1,3]
 * 输出1：3
 *
 * 输入2：nums = [4,4,5]
 * 输出2：2
 */
public class T3736 {
    /**
     * 自己实现：计算其余元素与最大值的差之和即可
     */
    public int minMoves(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int ans = 0;
        for (int num : nums) {
            ans += max - num;
        }
        return ans;
    }

    /**
     * 优化解法：只遍历一次
     */
    public int minMoves1(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        // 假如每个元素都为 max 时的整体和 - 当前和  即为所有数与max之间的差值
        return max * nums.length - sum;
    }
}