package problems.c0easy.t1001t1500;

/**
 * 1437 是否所有 1 都至少相隔 k 个元素 https://leetcode.cn/problems/check-if-all-1s-are-at-least-length-k-places-away/description/
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。
 * 如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 *
 * 示例：
 * 输入1：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出1：true
 *
 * 输入2：nums = [1,0,0,1,0,1], k = 2
 * 输出2：false
 *
 * 输入3：nums = [1,1,1,1,1], k = 0
 * 输出3：true
 *
 * 输入4：nums = [0,1,0,1], k = 1
 * 输出4：true
 */
public class T1437 {
    /**
     * 自己实现：遍历一次 遇到 1 开始判断
     */
    public boolean kLengthApart(int[] nums, int k) {
        int pre = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre != -1 && i - pre - 1 < k) {
                    return false;
                }
                pre = i;
            }
        }

        return true;
    }
}
