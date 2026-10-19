package problems.c0easy.t4001t4500;

import java.util.Arrays;

/**
 * 4056 统计相交区间对 I https://leetcode.cn/problems/number-of-intersecting-interval-pairs-i/description/
 * 给你一个包含 n 个元素的二维整数数组 intervals，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的 闭区间 。
 * 返回满足 0 <= i < j < n，且 intervals[i] 与 intervals[j] 相交 的下标对 (i, j) 的数量。
 * 如果两个区间至少有一个公共点，则称它们 相交。仅共享一个端点的情况也视为相交。
 *
 * 示例：
 * 输入1：intervals = [[1,2],[2,3],[3,4]]
 * 输出1：2
 *
 * 输入2：intervals = [[1,5],[2,4],[3,6]]
 * 输出2：3
 *
 * 输入3：intervals = [[1,2],[3,4],[5,6]]
 * 输出3：0
 */
public class T4056 {
    public int countIntersectingIntervals(int[][] intervals) {
        int intersecting = 0;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[j][0] <= intervals[i][1]) {
                    intersecting++;
                }
            }
        }
        return intersecting;
    }
}
