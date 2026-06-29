package problems.c0easy.t3501t4000;

/**
 * 3701 计算交替和 https://leetcode.cn/problems/compute-alternating-sum/description/
 * 给你一个整数数组 nums。
 * 交替和 定义为：将 nums 中偶数下标位置的元素 相加 ，减去 奇数下标位置的元素。
 * 即：nums[0] - nums[1] + nums[2] - nums[3]...
 * 返回表示 nums 的交替和的整数。
 *
 * 示例：
 * 输入1：nums = [1,3,5,7]
 * 输出1：-4
 *
 * 输入2：nums = [100]
 * 输出2：100
 */
public class T3701 {
    /**
     * 自己实现：根据题意模拟
     */
    public int alternatingSum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                ans += nums[i];
            } else {
                ans -= nums[i];
            }
        }
        return ans;
    }
}
