package problems.c0easy.t1001t1500;

/**
 * 1266 访问所有点的最小时间 https://leetcode.cn/problems/minimum-time-visiting-all-points/description/
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi] 。
 * 请你计算访问所有这些点需要的 最小时间（以秒为单位）。
 * 你需要按照下面的规则在平面上移动：
 * 每一秒内，你可以：
 * 沿水平方向移动一个单位长度，或者
 * 沿竖直方向移动一个单位长度，或者
 * 跨过对角线移动 sqrt(2) 个单位长度（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 * 在访问某个点时，可以经过该点后面出现的点，但经过的那些点不算作有效访问。
 *
 * 示例：
 * 输入1：points = [[1,1],[3,4],[-1,0]]
 * 输出1：7
 * 备注：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * 从 [1,1] 到 [3,4] 需要 3 秒
 * 从 [3,4] 到 [-1,0] 需要 4 秒
 * 一共需要 7 秒
 *
 * 输入2：points = [[3,2],[-2,2]]
 * 输出2：5
 */
public class T1266 {
    /**
     * 官方解法：切比雪夫距离
     */
    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        int len = points.length;

        for (int i = 0; i < len - 1; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];

            sum += Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        }

        return sum;
    }
}
