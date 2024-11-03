package problems.c0easy.t1501t2000;

/**
 * 1779 找到最近的有相同 X 或 Y 坐标的点
 * 给你两个整数 x 和 y ，表示你在一个笛卡尔坐标系下的 (x, y) 处。
 * 同时，在同一个坐标系下给你一个数组 points ，
 * 其中 points[i] = [ai, bi] 表示在 (ai, bi) 处有一个点。
 * 当一个点与你所在的位置有相同的 x 坐标或者相同的 y 坐标时，我们称这个点是 有效的 。
 *
 * 请返回距离你当前位置 曼哈顿距离 最近的 有效 点的下标（下标从 0 开始）。
 * 如果有多个最近的有效点，请返回下标 最小 的一个。如果没有有效点，请返回 -1 。
 *
 * 两个点 (x1, y1) 和 (x2, y2) 之间的 曼哈顿距离 为 abs(x1 - x2) + abs(y1 - y2) 。
 *
 * 示例：
 * 输入1：x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
 * 输出1：2
 *
 * 输入2：x = 3, y = 4, points = [[3,4]]
 * 输出2：0
 *
 * 输入3：x = 3, y = 4, points = [[2,3]]
 * 输出3：-1
 */
public class T1779 {
    /**
     * 自己实现：根据题意模拟
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        // 默认 -1
        int ans = -1;
        int minLen = Integer.MAX_VALUE;
        int n = points.length;

        // 找到所有有效点
        for (int i = 0; i < n; i++) {
            // 当前点为有效点
            if (points[i][0] == x || points[i][1] == y) {
                // 判断其是否为最短曼哈顿距离
                int len = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                // 更新最小索引，如果后边即使遇到相等的，也不会更新，所以这里就是最小索引
                if (len < minLen) {
                    minLen = len;
                    ans = i;
                }
            }
        }

        return ans;
    }
}
