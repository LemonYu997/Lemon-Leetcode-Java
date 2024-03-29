package problems.c0easy;

/**
 * 1184 公交站间的距离 https://leetcode.cn/problems/distance-between-bus-stops/description/
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。
 * 我们已知每一对相邻公交站之间的距离，distance[i]
 * 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 * 示例：
 * 输入1：distance = [1,2,3,4], start = 0, destination = 1
 * 输出1：1
 *
 * 输入2：distance = [1,2,3,4], start = 0, destination = 2
 * 输出2：3
 *
 * 输入3：distance = [1,2,3,4], start = 0, destination = 3
 * 输出3：4
 */
public class T1184 {
    /**
     * 自己实现：分别计算顺时针和逆时针两个方向行驶所需的距离，得到最短距离
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        // 顺时针行驶
        int l = 0;
        int i = start;
        while (i != destination) {
            l += distance[i];
            // 超过了就到下一轮
            i = (i + 1) % n;
        }
        // 逆时针行驶
        int r = 0;
        int j = start;
        while (j != destination) {
            // 注意索引不能为负数，加上一个轮数即可
            j = (j - 1 + n) % n;
            r += distance[j];
        }

        return Math.min(l, r);
    }

    /**
     * 官方解法：一次遍历
     */
    public int distanceBetweenBusStops1(int[] distance, int start, int destination) {
        // 如果起点在终点前边，调整一下
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < distance.length; i++) {
            // 分别计算顺时针和逆时针的长度
            if (i >= start && i < destination) {
                sum1 += distance[i];
            } else {
                sum2 += distance[i];
            }
        }
        return Math.min(sum1, sum2);
    }
}