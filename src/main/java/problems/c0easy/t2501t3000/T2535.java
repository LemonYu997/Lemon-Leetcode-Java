package problems.c0easy.t2501t3000;

/**
 * 2535 数组元素和与数字和的绝对差v https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
 * 给你一个正整数数组 nums 。
 * 元素和 是 nums 中的所有元素相加求和。
 * 数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
 * 返回 元素和 与 数字和 的绝对差。
 * 注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
 *
 * 示例：
 * 输入1：nums = [1,15,6,3]
 * 输出1：9
 *
 * 输入2：nums = [1,2,3,4]
 * 输出2：0
 */
public class T2535 {
    /**
     * 自己实现：根据题意模拟
     */
    public int differenceOfSum(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;

        for (int num : nums) {
            sum1 += num;
            while (num > 0) {
                sum2 += num % 10;
                num /= 10;
            }
        }

        return Math.abs(sum1 - sum2);
    }
}
