package problems.c0easy.t3001t3500;

/**
 * 3238 求出胜利玩家的数目 https://leetcode.cn/problems/find-the-number-of-winning-players/description/
 * 给你一个整数 n ，表示在一个游戏中的玩家数目。同时给你一个二维整数数组 pick ，
 * 其中 pick[i] = [xi, yi] 表示玩家 xi 获得了一个颜色为 yi 的球。
 * 如果玩家 i 获得的球中任何一种颜色球的数目 严格大于 i 个，那么我们说玩家 i 是胜利玩家。换句话说：
 * 如果玩家 0 获得了任何的球，那么玩家 0 是胜利玩家。
 * 如果玩家 1 获得了至少 2 个相同颜色的球，那么玩家 1 是胜利玩家。
 * ...
 * 如果玩家 i 获得了至少 i + 1 个相同颜色的球，那么玩家 i 是胜利玩家。
 * 请你返回游戏中 胜利玩家 的数目。
 *
 * 注意，可能有多个玩家是胜利玩家。
 *
 * 示例：
 * 输入1：n = 4, pick = [[0,0],[1,0],[1,0],[2,1],[2,1],[2,0]]
 * 输出1：2
 *
 * 输入2：n = 5, pick = [[1,1],[1,2],[1,3],[1,4]]
 * 输出2：0
 *
 * 输入3：n = 5, pick = [[1,1],[2,4],[2,4],[2,4]]
 * 输出3：1
 *
 * 提示：
 * 2 <= n <= 10
 * 1 <= pick.length <= 100
 * pick[i].length == 2
 * 0 <= xi <= n - 1
 * 0 <= yi <= 10
 */
public class T3238 {
    /**
     * 自己实现：统计每个玩家每个颜色球的数量
     */
    public int winningPlayerCount(int n, int[][] pick) {
        int ans = 0;
        // 统计每个玩家每个颜色球的数量，玩家的数量为 n，球的颜色数量最多为 10
        int[][] count = new int[n][11];
        for (int[] p : pick) {
            // p[0] 为玩家，p[1] 为颜色
            count[p[0]][p[1]]++;
        }

        // 获取每个玩家某个颜色的球数量最多的值是否大于玩家数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10; j++) {
                // 如果存在球的数量 > 玩家索引，则获胜
                if (count[i][j] > i) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}