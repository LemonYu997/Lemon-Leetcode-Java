package problems.c0easy.t1001t1500;

/**
 * 1232 缀点成线 https://leetcode.cn/problems/check-if-it-is-a-straight-line/description/
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ，
 * [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上。
 *
 * 示例：
 * 输入1：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出1：true
 *
 * 输入2：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出2：false
 */
public class T1232 {
    /**
     * 官方解法：两点确定一条支线，计算公式，判断剩下的点
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0];
        int deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1];
        int B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }
}
