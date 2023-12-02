package demo.c0easy;

/**
 * 661 图片平滑器 https://leetcode.cn/problems/image-smoother/
 * 图像平滑器 是大小为 3 x 3 的过滤器，
 * 用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
 * 平均灰度：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。
 * （即，需要计算蓝色平滑器中 9 个单元格的平均值）
 * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格
 * （即，需要计算红色平滑器中 4 个单元格的平均值）。
 * 给你一个表示图像灰度的 m x n 整数矩阵 img ，
 * 返回对图像的每个单元格平滑处理后的图像 。
 *
 * 示例：
 * 输入1：img = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出1：[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
 * 备注：对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 *
 * 输入2：img = [[100,200,100],[200,50,200],[100,200,100]]
 * 输出2：[[137,141,137],[141,138,141],[137,141,137]]
 * 备注：对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
 * 对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
 * 对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
 */
public class T661 {
    /**
     * 自己实现：按照定义
     * 注意索引越界
     */
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j];
                int count = 1;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    sum += img[i - 1][j - 1];
                    count++;
                }
                if (i - 1 >= 0) {
                    sum += img[i - 1][j];
                    count++;
                }
                if (i - 1 >= 0 && j + 1 < n) {
                    sum += img[i - 1][j + 1];
                    count++;
                }
                if (j - 1 >= 0) {
                    sum += img[i][j - 1];
                    count++;
                }
                if (j + 1 < n) {
                    sum += img[i][j + 1];
                    count++;
                }
                if (i + 1 < m && j - 1 >= 0) {
                    sum += img[i + 1][j - 1];
                    count++;
                }
                if (i + 1 < m) {
                    sum += img[i + 1][j];
                    count++;
                }
                if (i + 1 < m && j + 1 < n) {
                    sum += img[i + 1][j + 1];
                    count++;
                }
                ans[i][j] = sum / count;
            }
        }

        return ans;
    }

    /**
     * 官方解法：上述写法优化
     */
    public int[][] imageSmoother1(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                int sum = 0;

                //相比上边，这里用遍历取周围 3 * 3小矩阵的值
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        //判断越界
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            num++;
                            sum += img[x][y];
                        }
                    }
                }

                ans[i][j] = sum / num;
            }
        }

        return ans;
    }

    /**
     * 官方解法2：前缀和
     */
    public int[][] imageSmoother2(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        //存储结果
        int[][] ans = new int[m][n];
        //前缀和数组
        int[][] preSum = new int[m + 1][n + 1];

        //前缀和赋值
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //注意要减去重复计算的preSum[i - 1][j - 1]
                preSum[i][j] = img[i - 1][j - 1] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }

        // 依次遍历每个位置，计算结果：
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = getSum(preSum, m, n, i, j) / getCnt(m, n, i, j);
            }
        }

        return ans;
    }

    /**
     * 获取单元格数量
     */
    public int getCnt(int m, int n, int x, int y) {
        return (Math.min(x + 1, m - 1) - Math.max(x - 1, 0) + 1) * (Math.min(y + 1, n - 1) - Math.max(y - 1, 0) + 1);
    }

    // 以(row,col)为中心的平滑器各单元格的累加和
    private static int getSum(int[][] preSumArr, int m, int n, int x, int y) {
        x++;
        y++;
        return preSumArr[x + 1 <= m ? x + 1 : x][y + 1 <= n ? y + 1 : y] -
                preSumArr[x + 1 <= m ? x + 1 : x][y - 2 >= 0 ? y - 2 : 0] -
                preSumArr[x - 2 >= 0 ? x - 2 : 0][y + 1 <= n ? y + 1 : y] +
                preSumArr[x - 2 >= 0 ? x - 2 : 0][y - 2 >= 0 ? y - 2 : 0];
    }
}
