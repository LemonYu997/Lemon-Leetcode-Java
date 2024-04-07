package problems.c0easy.t501t1000;

/**
 * 997 找到小镇的法官 https://leetcode.cn/problems/find-the-town-judge/
 * 小镇里有 n 个人，按从 1 到 n 的顺序编号。这些人中可能有一个暗地里是小镇法官。
 * 如果小镇法官真的存在，那么：
 * 1、小镇法官不会信任任何人。
 * 2、每个人（除了小镇法官）都信任这位小镇法官。
 * 3、只有一个人同时满足属性 1 和属性 2 。
 * 给你一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * 如果小镇法官存在并且可以确定他的身份，请返回该法官的编号；否则，返回 -1 。
 *
 * 示例：
 * 输入1：n = 2, trust = [[1,2]]
 * 输出1：2
 *
 * 输入2：n = 3, trust = [[1,3],[2,3]]
 * 输出2：3
 *
 * 输入3：n = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出3：-1
 */
public class T997 {
    /**
     * 官方解法：使用有向图
     * trust[i]是图的有向边，从 trust[i][0] 指向 trust[i][1]
     * 遍历 trust，统计每个节点的出度和入度，存储在 inDegrees 和 outDegrees 中
     * 根据题意，法官的入度应为 n - 1，出度应为 0
     */
    public int findJudge(int n, int[][] trust) {
        int[] inDegress = new int[n + 1];
        int[] outDegress = new int[n + 1];
        for (int[] edge : trust) {
            int x = edge[0];
            int y = edge[1];
            inDegress[y]++;
            outDegress[x]--;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegress[i] == n - 1 && outDegress[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
