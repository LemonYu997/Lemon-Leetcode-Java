package problems.c0easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1128 等价多米诺骨牌对的数量 https://leetcode.cn/problems/number-of-equivalent-domino-pairs/description/
 * 给你一组多米诺骨牌 dominoes 。
 * 形式上，dominoes[i] = [a, b] 与 dominoes[j] = [c, d] 等价
 * 当且仅当 (a == c 且 b == d) 或者 (a == d 且 b == c) 。
 * 即一张骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌。
 * 在 0 <= i < j < dominoes.length 的前提下，
 * 找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 * 示例：
 * 输入1：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出1：1
 *
 * 输入2：dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
 * 输出2：3
 */
public class T1128 {
    /**
     * 官方解法：二元组表示 + 计数
     * 每个 int[] 都使用指定格式，int[0] < int[1]
     * 因为每一个数都不大于 9，可以将其拼为一个两个数的正整数 即 10 * int[0] + int[1]
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] num = new int[100];
        int ans = 0;
        for (int[] dominoe : dominoes) {
            int val = dominoe[0] < dominoe[1] ? dominoe[0] * 10
                    + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            // 如果有两张及以上，这里计数就会统计到，该牌型总共只有 1 张的话，这里只会加 0
            ans += num[val];
            num[val]++;
        }
        return ans;
    }
}
