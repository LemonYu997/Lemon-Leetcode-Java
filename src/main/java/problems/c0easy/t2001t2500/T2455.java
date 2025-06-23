package problems.c0easy.t2001t2500;

/**
 * 2455 可被三整除的偶数的平均值 https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/description/
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 *
 * 示例：
 * 输入1：nums = [1,3,6,10,12,15]
 * 输出1：9
 *
 * 输入2：nums = [1,2,4,7,10]
 * 输出2：0
 */
public class T2455 {
    /**
     * 自己实现：遍历并记录
     */
    public int averageValue(int[] nums) {
        int sum3 = 0;
        int count = 0;

        for (int num : nums) {
//            if (num % 3 == 0 && num % 2 == 0) {
            if (num % 6 == 0) {
                sum3 += num;
                count++;
            }
        }

        return count > 0 ? sum3 / count : 0;
    }
}
