package problems.c0easy.t501t1000;

/**
 * T832 翻转图像 https://leetcode.cn/problems/flipping-an-image/
 * 给定一个 n x n 的二进制矩阵 image ，先水平翻转图像，然后反转图像并返回结果 。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。
 * 例如，水平翻转 [1,1,0] 的结果是 [0,1,1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。
 * 例如，反转 [0,1,1] 的结果是 [1,0,0]。
 *
 * 示例：
 * 输入1：image = [[1,1,0],[1,0,1],[0,0,0]]
 * 输出1：[[1,0,0],[0,1,0],[1,1,1]]
 * 备注：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 输入2：image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出2：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 备注：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 */
public class T832 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            //首先翻转每一行
            for (int j = 0; j < n / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][n - 1 - j];
                image[i][n - 1 - j] = temp;
            }

            //然后反转图片 1 -> 0, 0 -> 1
            for (int j = 0; j < n; j++) {
                image[i][j] = 1 - image[i][j];
            }
        }

        return image;
    }

    /**
     * 官方解法：模拟优化+双指针
     */
    public int[][] flipAndInvertImage1(int[][] image) {
        int n = image.length;

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                //如果两边相同，不需要翻转，直接反转
                //如果两边不同，翻转并反转之后不变
                if (image[i][left] == image[i][right]) {
                    image[i][left] ^= 1;
                    image[i][right] ^= 1;
                }
                left++;
                right--;
            }
            if (left == right) {
                image[i][left] ^= 1;
            }
        }

        return image;
    }
}
