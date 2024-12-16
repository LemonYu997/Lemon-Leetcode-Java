package problems.c0easy.t1501t2000;

/**
 * 1893 检查是否区域内所有整数都被覆盖 https://leetcode.cn/problems/check-if-all-the-integers-in-a-range-are-covered/description/
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。
 * 每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 *
 * 示例：
 * 输入1：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出1：true
 *
 * 输入2：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出2：false
 */
public class T1893 {
    /**
     * 自己实现：遍历目标数组，是否每个数都在区间内
     */
    public boolean isCovered(int[][] ranges, int left, int right) {
        for (int i = left; i <= right; i++) {
            boolean flag = false;
            // 判断是否有区间包含该元素
            for (int j = 0; j < ranges.length; j++) {
                if (i >= ranges[j][0] && i <= ranges[j][1]) {
                    flag = true;
                    break;
                }
            }
            // 如果所有区间都没有该元素，返回false
            if (!flag) {
                return false;
            }
        }

        return true;
    }
}