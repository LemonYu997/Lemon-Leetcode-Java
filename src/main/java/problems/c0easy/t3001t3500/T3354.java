package problems.c0easy.t3001t3500;

/**
 * 3354 使数组元素等于零 https://leetcode.cn/problems/make-array-elements-equal-to-zero/description/
 * 给你一个整数数组 nums
 * 开始时，选择一个满足 nums[curr] == 0 的起始位置 curr ，并选择一个移动 方向 ：向左或者向右。
 * 此后，你需要重复下面的过程：
 * 如果 curr 超过范围 [0, n - 1] ，过程结束。
 * 如果 nums[curr] == 0 ，沿当前方向继续移动：如果向右移，则 递增 curr ；如果向左移，则 递减 curr 。
 * 如果 nums[curr] > 0:
 * 将 nums[curr] 减 1 。
 * 反转 移动方向（向左变向右，反之亦然）。
 * 沿新方向移动一步。
 * 如果在结束整个过程后，nums 中的所有元素都变为 0 ，则认为选出的初始位置和移动方向 有效 。
 * 返回可能的有效选择方案数目。
 *
 * 示例：
 * 输入1：nums = [1,0,2,0,3]
 * 输出1：2
 *
 * 输入2：nums = [2,3,4,0,4,1,0]
 * 输出2：0
 */
public class T3354 {
    /**
     * 官方解法：根据题意模拟
     */
    public int countValidSelections(int[] nums) {
        int count = 0;
        int nonZeros = 0;
        int n = nums.length;
        for (int num : nums) {
            if (num > 0) {
                nonZeros++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums, nonZeros, i, -1)) {
                    count++;
                }
                if (isValid(nums, nonZeros, i, 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValid(int[] nums, int nonZeros, int start, int direction) {
        int n = nums.length, curr = start;
        int[] temp = nums.clone();
        while (nonZeros > 0 && curr >= 0 && curr < n) {
            if (temp[curr] > 0) {
                temp[curr]--;
                direction *= -1;
                if (temp[curr] == 0) {
                    nonZeros--;
                }
            }
            curr += direction;
        }
        return nonZeros == 0;
    }
}
