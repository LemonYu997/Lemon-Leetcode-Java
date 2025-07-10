package problems.c0easy.t2501t3000;

/**
 * 2511 最多可以摧毁的敌人城堡数目 https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/description/
 * 给你一个长度为 n ，下标从 0 开始的整数数组 forts ，
 * 表示一些城堡。forts[i] 可以是 -1 ，0 或者 1 ，其中：
 * -1 表示第 i 个位置 没有 城堡。
 * 0 表示第 i 个位置有一个 敌人 的城堡。
 * 1 表示第 i 个位置有一个你控制的城堡。
 * 现在，你需要决定，将你的军队从某个你控制的城堡位置 i 移动到一个空的位置 j ，满足：
 * 0 <= i, j <= n - 1
 * 军队经过的位置 只有 敌人的城堡。正式的，对于所有 min(i,j) < k < max(i,j) 的 k ，
 * 都满足 forts[k] == 0 。
 * 当军队移动时，所有途中经过的敌人城堡都会被 摧毁 。
 *
 * 请你返回 最多 可以摧毁的敌人城堡数目。如果 无法 移动你的军队，或者没有你控制的城堡，请返回 0 。
 *
 * 示例：
 * 输入1：forts = [1,0,0,-1,0,0,0,0,1]
 * 输出1：4
 *
 * 输入2：forts = [0,0,1,-1]
 * 输出2：0
 */
public class T2511 {
    /**
     * 自己实现：找到 1 和离自己最近的 -1 之间的最大距离即可
     */
    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0;

        // 最近的 1 和 -1 的索引
        int a = -1;
        int b = -1;
        // 考虑到不确定 1 和 -1 谁在前在后，所以每次遇到 1 和 -1 都判断一次距离
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1) {
                a = i;
                if (b != -1) {
                    // 上一个位置使用过之后要清除，防止跨越情况
                    ans = Math.max(ans, a - b - 1);
                    b = -1;
                }
            }

            if (forts[i] == -1) {
                b = i;
                if (a != -1) {
                    ans = Math.max(ans, b - a - 1);
                    a = -1;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：优化实现，只需要记录上一个 1 或 -1 的索引即可
     */
    public int captureForts1(int[] forts) {
        int n = forts.length;
        int ans = 0;
        int pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }

        return ans;
    }
}
