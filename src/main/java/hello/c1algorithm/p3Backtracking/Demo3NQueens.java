package hello.c1algorithm.p3Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 * 根据国际象棋的规则，皇后可以攻击与同处一行、一列或一条斜线上的棋子。
 * 给定 n 个皇后和一个 n * n 大小的棋盘，寻找使得所有皇后之间无法相互攻击的摆放方案。
 */
public class Demo3NQueens {
    /**
     * 求解 N 皇后
     * 时间复杂度 O(n!)
     * 空间复杂度 O(n^2)
     */
    List<List<List<String>>> nQueens(int n) {
        // 初始化 n * n 大小的棋盘，其中 'Q' 代表皇后 '#' 表示空位
        List<List<String>> state = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("#");
            }
            state.add(row);
        }
        // 记录列是否有皇后
        boolean[] cols = new boolean[n];
        // 记录主对角线上是否有皇后
        boolean[] diags1 = new boolean[2 * n - 1];
        // 记录次对角线上是否有皇后
        boolean[] diags2 = new boolean[2 * n - 1];
        List<List<List<String>>> res = new ArrayList<>();

        backtrack(0, n, state, res, cols, diags1, diags2);

        return res;
    }

    /**
     * 回溯算法-按行遍历
     * @param row 当前行
     * @param n 棋盘大小
     * @param state 当前状态
     * @param res 结果集
     * @param cols 记录列是否有皇后
     * @param diags1 记录主对角线上是否有皇后
     * @param diags2 记录次对角线上是否有皇后
     */
    private void backtrack(int row, int n, List<List<String>> state, List<List<List<String>>> res, boolean[] cols, boolean[] diags1, boolean[] diags2) {
        // 当放置完所有行后，记录解
        if (row == n) {
            List<List<String>> copyState = new ArrayList<>();
            for (List<String> sRow : state) {
                copyState.add(new ArrayList<>(sRow));
            }
            res.add(copyState);
            return;
        }

        // 遍历所有列
        for (int col = 0; col < n; col++) {
            // 计算该格子对应的主对角线和次对角线
            int diag1 = row - col + n - 1;
            int diag2 = row + col;
            // 剪枝：不允许该格子所在列、主对角线、次对角线上存在皇后
            if (!cols[col] && !diags1[diag1] && diags2[diag2]) {
                // 尝试：将皇后放置在该格子
                state.get(row).set(col, "Q");
                cols[col] = diags1[diag1] = diags2[diag2] = true;
                // 放置下一行
                backtrack(row + 1, n, state, res, cols, diags1, diags2);
                // 回退：将该格子恢复空位
                state.get(row).set(col, "#");
                cols[col] = diags1[diag1] = diags2[diag2] = false;
            }
        }
    }
}
