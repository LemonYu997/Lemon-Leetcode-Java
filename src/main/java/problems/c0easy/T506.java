package problems.c0easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506 相对名次 https://leetcode.cn/problems/relative-ranks/
 * 给定一个长度为n的整数数组score，其中socre[i]是第i位运动员在比赛中的得分
 * 所有得分都互不相同，返回他们的获奖情况
 *
 * 运动员将根据得分决定名次，其中名次第1的运动员得分最高，以此类推
 * 名次1获奖："Gold Medal"
 * 名次2获奖："Sliver Medal"
 * 名次3获奖："Bronze Medal"
 * 其余只有名次编号
 *
 * 示例：
 * 输入1：score = [5,4,3,2,1]
 * 输出1：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 *
 * 输入2：score = [10,3,8,9,4]
 * 输出2：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 */
public class T506 {
    public static void main(String[] args) {
        int[] score = {10, 3, 8, 9, 4};
        findRelativeRanks(score);
    }

    /**
     * 官方解法：排序
     */
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int[][] arr = new int[n][2];

        //一个存储原值，一个存储索引
        for (int i = 0; i < n; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }

        //根据arr[i][0] 即原值的大小进行排序
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        String[] ans = new String[n];

        //按照原先的索引顺序arr[i][1]，使用排序后的索引顺序(i + 1)即其名次
        for (int i = 0; i < n; i++) {
            if (i >= 3) {
                ans[arr[i][1]] = Integer.toString(i + 1);
            } else {
                ans[arr[i][1]] = desc[i];
            }
        }

        return ans;
    }

    /**
     * 参考解法：使用Map，便于理解
     */
    public static String[] findRelativeRanks1(int[] score) {
        String[] ans = new String[score.length];

        //key为原始值，value为索引
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }
        //对原始数组进行排序
        Arrays.sort(score);

        //遍历
        for (int i = 0; i < score.length; i++) {
            //得到其原始索引
            Integer j = map.get(score[i]);
            if (i == score.length - 1) {
                ans[j] = "Gold Medal";
            } else if (i == score.length - 2) {
                ans[j] = "Silver Medal";
            } else if (i == score.length - 3) {
                ans[j] = "Bronze Medal";
            } else {
                ans[j] = String.valueOf(score.length - i);
            }
        }

        return ans;
    }
}
