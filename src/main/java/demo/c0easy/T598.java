package demo.c0easy;

/**
 * 598 范围求和II https://leetcode.cn/problems/range-addition-ii/
 * 给定 m * n矩阵M，初始化时所有的0和一个操作数组ops，其中ops[i] = [ai, bi]
 * 意味着当所有的 0 <= x < ai和 0 <= y < bi时，M[x][y]应该加1
 *
 * 执行完所有操作后，计算并返回矩阵中最大整数的个数
 *
 * 示例：
 * 输入1：m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出1：4
 *
 * 输入2：m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * 输出2:4
 *
 * 输入3：m = 3, n = 3, ops = []
 * 输出3:9
 */
public class T598 {
    /**
     * 自己实现：根据题意，即求ops[i]=[ai,bi]中的 ai 最小值和 bi最小值
     * 结果为 min(ai) * min(bi)
     */
    public int maxCount(int m, int n, int[][] ops) {
        //初始为m、n
        int mina = m;
        int minb = n;

        for (int[] op : ops) {
            mina = Math.min(op[0], mina);
            minb = Math.min(op[1], minb);
        }

        return mina * minb;
    }
}
