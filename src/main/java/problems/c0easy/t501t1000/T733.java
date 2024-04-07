package problems.c0easy.t501t1000;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 733 图像渲染 https://leetcode.cn/problems/flood-fill/
 * 有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小
 * 你也被给予三个整数 sr ,  sc 和 newColor 。你应该从像素 image[sr][sc] 开始对图像进行 上色填充
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，
 * 重复该过程。将所有有记录的像素点的颜色值改为 newColor
 *
 * 示例：
 * 输入1：image = [[1,1,1],[1,1,0],[1,0,1]]，sr = 1, sc = 1, newColor = 2
 * 输出1：[[2,2,2],[2,2,0],[2,0,1]]
 * 备注：在图像的正中间，(坐标(sr,sc)=(1,1)),在路径上所有符合条件的像素点的颜色都被更改成2。
 *
 * 输入2：image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * 输出2：[[2,2,2],[2,2,2]]
 */
public class T733 {
    /**
     * 官方解法1：递归
     */
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        //原本的颜色
        int num = image[sr][sc];

        changeColor(image, sr, sc, num, color);

        return image;
    }

    /**
     * 改变颜色
     */
    public void changeColor(int[][] image, int sr, int sc, int num, int color) {
        //排除超出边界、和目标颜色不同、或者已经为目标颜色的情况
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != num || image[sr][sc] == color) {
            return;
        }
        image[sr][sc] = color;
        changeColor(image, sr - 1, sc, num, color);
        changeColor(image, sr + 1, sc, num, color);
        changeColor(image, sr, sc - 1, num, color);
        changeColor(image, sr, sc + 1, num, color);
    }

    /**
     * 官方解法2：广度优先搜索 BFS
     * 使用队列存储要改变的方格，防止重复入队
     */
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];
        //如果初始颜色和目标颜色一致，则不用修改，直接返回即可
        if (originColor == color) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;

        //存储要修改颜色的坐标队列
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        //遍历四周
        while (!queue.isEmpty()) {
            //当前正在遍历的坐标
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            //遍历四周
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < m && my >= 0 && my < n && image[mx][my] == originColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = color;
                }
            }
        }

        return image;
    }

    /**
     * 官方解法3：深度优先搜索 DFS
     * 使用递归，如果当前遍历的颜色与初始颜色相同，则更新，否则进行回溯
     */
    public int[][] floodFill3(int[][] image, int sr, int sc, int color) {
        int originColor = image[sr][sc];
        if (originColor != color) {
            dfs(image, sr, sc, originColor, color);
        }

        return image;
    }

    public void dfs(int[][] image, int x, int y, int originColor, int color) {
        if (image[x][y] == originColor) {
            image[x][y] = color;
            //遍历四周
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, originColor, color);
                }
            }
        }
    }
}