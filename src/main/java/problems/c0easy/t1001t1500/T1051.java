package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1051 高度检查器 https://leetcode.cn/problems/height-checker/description/
 * 学生需要按照 非递减 的高度顺序排成一行。
 * 排序后的高度情况用整数数组 expected 表示，
 * 其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 * 给你一个整数数组 heights ，
 * 表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 * 示例：
 * 输入1：heights = [1,1,4,2,1,3]
 * 输出1：3
 *
 * 输入2：heights = [5,1,2,3,4]
 * 输出2：5
 *
 * 输入3：heights = [1,2,3,4,5]
 * 输出3：0
 */
public class T1051 {
    /**
     * 自己实现：先排序后比较
     */
    public int heightChecker(int[] heights) {
        int ans = 0;
        int n = heights.length;
        int[] expected = Arrays.copyOf(heights, n);
        Arrays.sort(expected);

        for (int i = 0; i < n; i++) {
            if (heights[i] != expected[i]) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 官方解法：计数排序
     * 本题中学生的高度小于等于 100，可以先对数组 heights 进行一次遍历，
     * 找出最大值 m，从而使用一个长度为 m+1 的数组
     * 然后直接在计数排序的数组上进行遍历
     */
    public int heightChecker1(int[] heights) {
        int m = Arrays.stream(heights).max().getAsInt();
        int[] cnt = new int[m + 1];
        for (int height : heights) {
            cnt[height]++;
        }
        int idx = 0;
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= cnt[i]; j++) {
                if (heights[idx] != i) {
                    ans++;
                }
                idx++;
            }
        }
        return ans;
    }
}
