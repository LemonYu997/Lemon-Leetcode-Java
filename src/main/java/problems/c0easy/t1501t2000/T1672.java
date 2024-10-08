package problems.c0easy.t1501t2000;

/**
 * 1672 最富有客户的资产总量 https://leetcode.cn/problems/richest-customer-wealth/description/
 * 给你一个 m x n 的整数网格 accounts ，
 * 其中 accounts[i][j] 是第 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 *
 * 示例：
 * 输入1：accounts = [[1,2,3],[3,2,1]]
 * 输出1：6
 *
 * 输入2：accounts = [[1,5],[7,3],[3,5]]
 * 输出2：10
 *
 * 输入3：accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * 输出3：17
 */
public class T1672 {
    /**
     * 自己实现：遍历即可
     */
    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int[] account : accounts) {
            int temp = 0;
            for (int i : account) {
                temp += i;
            }
            max = Math.max(temp, max);
        }

        return max;
    }
}
