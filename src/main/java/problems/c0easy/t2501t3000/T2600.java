package problems.c0easy.t2501t3000;

/**
 * 2600 K 件物品的最大和 https://leetcode.cn/problems/k-items-with-the-maximum-sum/description/
 * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * 袋子最初包含：
 * numOnes 件标记为 1 的物品。
 * numZeros 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。
 * 返回所有可行方案中，物品上所标记数字之和的最大值。
 *
 * 示例：
 * 输入1：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出1：2
 *
 * 输入2：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
 * 输出2：3
 */
public class T2600 {
    /**
     * 自己实现：优先选 1 即可
     */
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            // 如果 0 和 1 都不满足，则取剩下 -1 的数
            return numOnes - (k - (numOnes + numZeros));
        }
    }
}
