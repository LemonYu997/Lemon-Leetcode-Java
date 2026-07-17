package problems.c0easy.t3501t4000;

/**
 * 3783 整数的镜像距离 https://leetcode.cn/problems/mirror-distance-of-an-integer/description/
 * 给你一个整数 n。
 * 定义它的 镜像距离 为：abs(n - reverse(n))，其中 reverse(n) 表示将 n 的数字反转后形成的整数。
 * 返回表示 n 的镜像距离的整数。
 * 其中，abs(x) 表示 x 的绝对值。
 *
 * 示例：
 * 输入1：n = 25
 * 输出1：27
 *
 * 输入2：n = 10
 * 输出2：9
 *
 * 输入3：n = 7
 * 输出3：0
 */
public class T3783 {
    /**
     * 自己实现：根据题意模拟
     */
    public int mirrorDistance(int n) {
        StringBuilder sb = new StringBuilder(n + "");
        sb.reverse();
        int n2 = Integer.parseInt(sb.toString());

        return Math.abs(n - n2);
    }

    /**
     * 官方解法：优化
     */
    public int mirrorDistance2(int n) {
        int rev = 0;
        int temp = n;
        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp /= 10;
        }

        return Math.abs(rev - n);
    }
}