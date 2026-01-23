package problems.c0easy.t3001t3500;

/**
 * 3178 找出 K 秒后拿着球的孩子 https://leetcode.cn/problems/find-the-child-who-has-the-ball-after-k-seconds/description/
 * 给你两个 正整数 n 和 k。有 n 个编号从 0 到 n - 1 的孩子按顺序从左到右站成一队。
 * 最初，编号为 0 的孩子拿着一个球，并且向右传球。每过一秒，拿着球的孩子就会将球传给他旁边的孩子。
 * 一旦球到达队列的 任一端 ，即编号为 0 的孩子或编号为 n - 1 的孩子处，传球方向就会 反转 。
 * 返回 k 秒后接到球的孩子的编号。
 *
 * 示例：
 * 输入1：n = 3, k = 5
 * 输出1：1
 *
 * 输入2：n = 5, k = 6
 * 输出2：2
 *
 * 输入3：n = 4, k = 2
 * 输出3：2
 */
public class T3178 {
    /**
     * 社区解法：根据题意模拟
     */
    public int numberOfChild(int n, int k) {
        int num = 0, direction = 1;
        while (k > 0) {
            if (num + direction < 0 || num + direction >= n) {
                direction *= -1;
            }
            num += direction;
            k--;
        }
        return num;
    }
}
