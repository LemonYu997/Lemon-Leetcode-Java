package problems.c0easy.t3001t3500;

/**
 * 3158 求出出现两次数字的 XOR 值 https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/description/
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
 *
 * 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 *
 * 示例：
 * 输入1：nums = [1,2,1,3]
 * 输出1：1
 *
 * 输入2：nums = [1,2,3]
 * 输出2：0
 *
 * 输入3：nums = [1,2,2,1]
 * 输出3：3
 *
 * 提示：
 *
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * nums 中每个数字要么出现过一次，要么出现过两次。
 */
public class T3158 {
    /**
     * 根据题意模拟：统计所有数字出现次数
     */
    public int duplicateNumbersXOR(int[] nums) {
        int[] temp = new int[51];
        for (int num : nums) {
            temp[num] ++;
        }

        int ans = 0;
        for (int i = 0; i < 51; i++) {
            if (temp[i] == 2) {
                ans ^= i;
            }
        }
        return ans;
    }
}
