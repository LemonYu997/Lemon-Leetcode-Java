package problems.c0easy.t4001t4500;

/**
 * 4024 最近的可用无人机 https://leetcode.cn/problems/nearest-available-drone/description/
 * 给你一个二维整数数组 drones，其中 drones[i] = [xi, yi, rangei] 表示第 ith 架无人机的横坐标、纵坐标和飞行范围。
 * 另给你一个整数数组 target = [tx, ty]，表示目标的坐标。
 * 如果无人机 drones[i] 的坐标与目标坐标之间的曼哈顿距离小于或等于其 rangei，则该无人机能够到达目标。
 * 返回能够到达目标且与目标之间曼哈顿距离最小的无人机的下标。如果存在多个符合条件的无人机，则返回其中最小的下标。如果没有无人机能够到达目标，则返回 -1。
 * 两个坐标 (xi, yi) 和 (xj, yj) 之间的曼哈顿距离为 |xi - xj| + |yi - yj|。
 *
 * 示例：
 * 输入1：drones = [[0,0,8],[2,2,9]], target = [3,4]
 * 输出1：1
 *
 * 输入2：drones = [[2,1,5],[4,4,5],[6,6,8]], target = [5,5]
 * 输出2：1
 *
 * 输入3：drones = [[4,4,5]], target = [8,6]
 * 输出3：-1
 */
public class T4024 {
    /**
     * 社区解法：模拟
     */
    public int nearestDrone(int[][] drones, int[] target) {
        int tx = target[0];
        int ty = target[1];
        int minDis = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < drones.length; i++) {
            int[] d = drones[i];
            int dis = Math.abs(d[0] - tx) + Math.abs(ty - d[1]);
            if (dis < minDis && dis <= d[2]) {
                minDis = dis;
                ans = i;
            }
        }
        return ans;
    }
}
