package problems.c0easy.t2501t3000;

/**
 * 2729 判断一个数是否迷人 https://leetcode.cn/problems/check-if-the-number-is-fascinating/description/
 * 给你一个三位数整数 n 。
 * 如果经过以下修改得到的数字 恰好 包含数字 1 到 9 各一次且不包含任何 0 ，
 * 那么我们称数字 n 是 迷人的 ：
 * 将 n 与数字 2 * n 和 3 * n 连接 。
 * 如果 n 是迷人的，返回 true，否则返回 false 。
 * 连接 两个数字表示把它们首尾相接连在一起。比方说 121 和 371 连接得到 121371 。
 *
 * 示例：
 * 输入1：n = 192
 * 输出1：true
 *
 * 输入2：n = 100
 * 输出2：false
 */
public class T2729 {
    /**
     * 自己实现：根据题意模拟即可
     */
    public boolean isFascinating(int n) {
        // 记录 1 ~ 9 是否出现
        int[] mask = new int[10];

        // 记录每一部分的位数
        for (int i = 1; i <= 3; i++) {
            int temp = n * i;
            while (temp > 0) {
                mask[(int) (temp % 10)]++;
                temp /= 10;
            }
        }

        // 判断1~9是否都出现一次，且没有0
        for (int i = 0; i < 10; i++) {
            if ((i == 0 && mask[i] > 0) || (i != 0 && mask[i] != 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 社区解法：排除无效答案
     */
    public boolean isFascinating1(int n) {
        // 拼接结果不为 9 位数的先全部排除
        if (n < 123 || n > 329) {
            return false;
        }
        int mask = 0;
        for (char c : ("" + n + (n * 2) + (n * 3)).toCharArray()) {
            mask |= 1 << (c - '0');
        }
        // 结果的二进制表示应该为 1111111110 = 2^10 - 2
        return mask == (1 << 10) - 2;
    }

    /**
     * 社区解法：打表，实际只有 4 种可能 192,219,273,327
     */
    public boolean isFascinating2(int n) {
        return n == 192 || n == 219 || n == 273 || n == 327;
    }
}
