package problems.c0easy.t2501t3000;

/**
 * 2980 检查按位或是否存在尾随零 https://leetcode.cn/problems/check-if-bitwise-or-has-trailing-zeros/description/
 * 给你一个 正整数 数组 nums 。
 * 你需要检查是否可以从数组中选出 两个或更多 元素，
 * 满足这些元素的按位或运算（ OR）结果的二进制表示中 至少 存在一个尾随零。
 * 例如，数字 5 的二进制表示是 "101"，不存在尾随零，
 * 而数字 4 的二进制表示是 "100"，存在两个尾随零。
 * 如果可以选择两个或更多元素，其按位或运算结果存在尾随零，返回 true；否则，返回 false 。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,5]
 * 输出1：true
 *
 * 输入2：nums = [2,4,8,16]
 * 输出2：true
 *
 * 输入3：nums = [1,3,5,7,9]
 * 输出3：false
 */
public class T2980 {
    /**
     * 自己实现：判断其中是否有两个偶数即可
     */
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count >= 2;
    }
}
