package problems.c0easy.t2001t2500;

import java.util.*;

/**
 * 2347 最好的扑克手牌 https://leetcode.cn/problems/best-poker-hand/description/
 * 给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，
 * 第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
 *
 * 下述是从好到坏你可能持有的 手牌类型 ：
 *
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 *
 * 注意：返回的字符串 大小写 需与题目描述相同。
 *
 * 示例：
 * 输入1：ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
 * 输出1："Flush"
 *
 * 输入2：ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
 * 输出2："Three of a Kind"
 *
 * 输入3：ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
 * 输出3："Pair"
 */
public class T2347 {
    /**
     * 自己实现：根据题意模拟
     */
    public String bestHand(int[] ranks, char[] suits) {
        // 判断是否所有花色都相等
        boolean isFlush = true;
        for (char suit : suits) {
            if (suit != suits[0]) {
                isFlush = false;
                break;
            }
        }

        if (isFlush) {
            return "Flush";
        }

        // 判断是否有对子或三条
        Arrays.sort(ranks);
        boolean isKing = false;
        boolean isPair = false;
        int count = 1;
        for (int i = 1; i < ranks.length; i++) {
            if (ranks[i] == ranks[i - 1]) {
                count++;
                if (count == 3) {
                    isKing = true;
                    break;
                } else {
                    isPair = true;
                }
            } else {
                // 重置计数
                count = 1;
            }
        }

        if (isKing) {
            return "Three of a Kind";
        } else if (isPair) {
            return "Pair";
        } else {
            return "High Card";
        }
    }

    /**
     * 官方解法：使用 set 优化代码
     */
    public String bestHand1(int[] ranks, char[] suits) {
        // 统计花色
        Set<Character> suitSet = new HashSet<>();
        for (char suit : suits) {
            suitSet.add(suit);
        }
        if (suitSet.size() == 1) {
            return "Flush";
        }

        // 统计次数
        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int rank : ranks) {
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
        if (rankMap.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : rankMap.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }
}
