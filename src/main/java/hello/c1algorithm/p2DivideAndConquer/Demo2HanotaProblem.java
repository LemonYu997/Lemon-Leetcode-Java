package hello.c1algorithm.p2DivideAndConquer;

import java.util.List;

/**
 * 汉诺塔问题
 * 给定三根柱子，记为 A、B 和 C 。起始状态下，柱子 A 上套着 n 个圆盘，
 * 它们从上到下按照从小到大的顺序排列。我们的任务是要把这 n 个圆盘移到柱子 C 上，
 * 并保持它们的原有顺序不变。在移动圆盘的过程中，需要遵守以下规则：
 * 1、圆盘只能从一根柱子顶部拿出，从另一根柱子顶部放入。
 * 2、每次只能移动一个圆盘。
 * 3、小圆盘必须时刻位于大圆盘之上。
 *
 * 时间复杂度 O(2^n)
 * 空间复杂度 O(n)
 */
public class Demo2HanotaProblem {
    /**
     * 拆分子问题解决：将 f(n) 拆解为 f(n-1) 和 f(1)
     * 1、将 n - 1 个圆盘借助 C 从 A 移至 B
     * 2、将剩余 1 个圆盘从 A 直接移至 C
     * 3、将 n - 1 个圆盘借助 A 从 B 移动至 C
     */
    void solveHanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        // 将 A 顶部 n 个圆盘借助 B 移动至 C
        dfs(n, A, B, C);
    }

    /**
     * 求解汉诺塔问题 f(i)
     * src：源数据
     * buf：缓存数据
     * tar：目标
     */
    void dfs(int i, List<Integer> src, List<Integer> buf, List<Integer> tar) {
        // 若 src 只剩一个圆盘，则将其直接移动到 tar
        if (i == 1) {
            move(src, tar);
            return;
        }
        // 子问题 f(i - 1)：将 src 顶部 i-1 个圆盘借助 tar 移到 buf
        dfs(i - 1, src, tar, buf);
        // 子问题 f(1)：将 src 剩余的一个圆盘移到 tar
        move(src, tar);
        // 子问题 f(i - 1)：将 buf 顶部 i-1 个圆盘借助 src 移到 tar
        dfs(i - 1, buf, src, tar);
    }

    /**
     * 移动一个圆盘
     */
    void move(List<Integer> src, List<Integer> tar) {
        // 从 src 顶部拿出一个圆盘
        Integer pan = src.remove(src.size() - 1);
        // 将圆盘放入 tar
        tar.add(pan);
    }
}
