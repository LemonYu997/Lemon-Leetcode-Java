package problems.c0easy.t2001t2500;

/**
 * 2022 将一维数组转变成二维数组 https://leetcode.cn/problems/convert-1d-array-into-2d-array/description/
 * 给你一个下标从 0 开始的一维整数数组 original 和两个整数 m 和  n 。
 * 你需要使用 original 中 所有 元素创建一个 m 行 n 列的二维数组。
 * original 中下标从 0 到 n - 1 （都 包含 ）的元素构成二维数组的第一行，
 * 下标从 n 到 2 * n - 1 （都 包含 ）的元素构成二维数组的第二行，依此类推。
 * 请你根据上述过程返回一个 m x n 的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。
 *
 * 示例：
 * 输入1：original = [1,2,3,4], m = 2, n = 2
 * 输出1：[[1,2],[3,4]]
 *
 * 输入2：original = [1,2,3], m = 1, n = 3
 * 输出2：[[1,2,3]]
 *
 * 输入3：original = [1,2], m = 1, n = 1
 * 输出3：[]
 *
 * 输入4：original = [3], m = 1, n = 2
 * 输出4：[]
 */
public class T2022 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public int[][] construct2DArray(int[] original, int m, int n) {
        // 先判断数量是否满足
        if (m * n != original.length) {
            return new int[0][0];
        }

        int[][] ans = new int[m][n];
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[index];
                index++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：优化上述解法，一次遍历
     */
    public int[][] construct2DArray1(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][];
        }

        int[][] ans = new int[m][n];
        for (int i = 0; i < original.length; i += n) {
            System.arraycopy(original, i, ans[i / n], 0, n);
        }

        return ans;
    }
}
