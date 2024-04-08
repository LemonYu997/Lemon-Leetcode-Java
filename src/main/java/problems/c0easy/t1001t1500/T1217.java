package problems.c0easy.t1001t1500;

/**
 * 1217 玩筹码 https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/description/
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 *
 * 示例：
 * 输入1：position = [1,2,3]
 * 输出1：1
 *
 * 输入2：position = [2,2,2,3,3]
 * 输出2：2
 *
 * 输入3：position = [1,1000000000]
 * 输出3：1
 */
public class T1217 {
    /**
     * 官方解法：贪心算法
     * 偶数位置到偶数位置，奇数位置到奇数位置，移动数都为 2N，cost 为 0
     * 偶数位置到奇数位置，奇数位置到偶数位置，移动数都为 2N + 1，cost 为 1
     */
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        // 先统计偶数位和奇数位的个数
        for (int pos : position) {
            if (pos % 2 != 0) {
                odd++;
            } else {
                even++;
            }
        }
        // 最小花费就是 偶其他数位置移动到某个奇数位置，或者从其他奇数位置移动到某个偶数位置
        return Math.min(odd, even);
    }
}
