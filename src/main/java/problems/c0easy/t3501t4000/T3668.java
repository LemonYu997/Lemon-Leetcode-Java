package problems.c0easy.t3501t4000;

import java.util.Arrays;

/**
 * 3668 重排完成顺序 https://leetcode.cn/problems/restore-finishing-order/description/
 * 给你一个长度为 n 的整数数组 order 和一个整数数组 friends。
 * order 包含从 1 到 n 的每个整数，且 恰好出现一次 ，表示比赛中参赛者按照 完成顺序 的 ID。
 * friends 包含你朋友们的 ID，按照 严格递增 的顺序排列。friends 中的每个 ID 都保证出现在 order 数组中。
 * 请返回一个数组，包含你朋友们的 ID，按照他们的 完成顺序 排列。
 *
 * 示例：
 * 输入1：order = [3,1,2,5,4], friends = [1,3,4]
 * 输出1：[3,1,4]
 *
 * 输入2：order = [1,4,5,3,2], friends = [2,5]
 * 输出2：[5,2]
 */
public class T3668 {
    /**
     * 自己实现：根据题意模拟，记录每个值对应的位置
     */
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        int[] lc = new int[n + 1];

        for (int i = 0; i < n; i++) {
            // 记录每个整数对应的所属位置
            lc[order[i]] = i;
        }

        int m = friends.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            // 先找到friends[i]在order[]中对应的索引，根据索引排序再取其值
            ans[i] = lc[friends[i]];
        }
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = order[ans[i]];
        }

        return ans;
    }

    /**
     * 社区解法：优化写法，给目标值打上标记，再顺序遍历原数组抽出其中的目标值
     */
    public int[] recoverOrder2(int[] order, int[] friends) {
        int n = order.length;
        boolean[] isFriend = new boolean[n + 1];
        for (int friend : friends) {
            isFriend[friend] = true;
        }

        int[] ans = new int[friends.length];
        int idx = 0;
        for (int x : order) {
            if (isFriend[x]) {
                ans[idx++] = x;
            }
        }
        return ans;
    }
}