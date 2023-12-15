package problems.c0easy;

/**
 * T136 只出现一次的数字 https://leetcode.cn/problems/single-number/description/
 * 给定一个非空整数数组nums，除了某个元素只出现一次以外，其余每个元素均出现两次，找出只出现一次的数字
 *
 * 示例：
 * 输入1：nums = [2,2,1]
 * 输出1：1
 *
 * 输入2：nums = [4,1,2,1,2]
 * 输出2：4
 *
 * 输入3：nums = [1]
 * 输出3:1
 */
public class T136 {
    /**
     * 官方解法：位运算 异或运算
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }

        return single;
    }
}
