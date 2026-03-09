package problems.c0easy.t3001t3500;

/**
 * 3300 替换为数位和以后的最小元素 https://leetcode.cn/problems/minimum-element-after-replacement-with-digit-sum/description/
 * 给你一个整数数组 nums 。
 * 请你将 nums 中每一个元素都替换为它的各个数位之 和 。
 * 请你返回替换所有元素以后 nums 中的 最小 元素。
 *
 * 示例：
 * 输入1：nums = [10,12,13,14]
 * 输出1：1
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2：1
 *
 * 输入3：nums = [999,19,199]
 * 输出3：10
 */
public class T3300 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}
