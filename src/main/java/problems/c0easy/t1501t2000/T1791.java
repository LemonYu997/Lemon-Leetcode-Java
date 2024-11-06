package problems.c0easy.t1501t2000;

/**
 * 1791 找出星型图的中心节点 https://leetcode.cn/problems/find-center-of-star-graph/description/
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。
 * 星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 *
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。
 * 请你找出并返回 edges 所表示星型图的中心节点。
 *
 * 示例：
 * 输入1：edges = [[1,2],[2,3],[4,2]]
 * 输出1：2
 *
 * 输入2：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出2：1
 */
public class T1791 {
    /**
     * 自己实现：根据题意即找到所有坐标中均存在的数值即可
     */
    public int findCenter(int[][] edges) {
        // 答案不是 a 就是 b
        int a = edges[0][0];
        int b = edges[0][1];
        for (int[] edge : edges) {
            // 初始假设为 a，如果当前数组不存在 a，那就是 b
            if (edge[0] != a && edge[1] != a) {
                return b;
            }
        }
        // 假设正确，返回 a
        return a;
    }

    /**
     * 官方解法：计算每个节点的度，为 n - 1的即为中心节点
     */
    public int findCenter1(int[][] edges) {
        int n = edges.length + 1;
        int[] degrees = new int[n + 1];

        for (int[] edge : edges) {
            degrees[edge[0]]++;
            degrees[edge[1]]++;
        }

        for (int i = 1; ; i++) {
            if (degrees[i] == n - 1) {
                return i;
            }
        }
    }

    /**
     * 官方解法：找到任意两条边的公共节点
     */
    public int findCenter2(int[][] edges) {
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
    }
}
