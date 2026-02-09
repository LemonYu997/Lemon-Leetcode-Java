package problems.c0easy.t3001t3500;

/**
 * 3226 使两个整数相等的位更改次数 https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/description/
 * 给你两个正整数 n 和 k。
 * 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
 * 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
 *
 * 示例：
 * 输入1：n = 13, k = 4
 * 输出1：2
 *
 * 输入2：n = 21, k = 21
 * 输出2：0
 *
 * 输入3：n = 14, k = 13
 * 输出3：-1
 */
public class T3226 {
    /**
     * 自己实现：计算两数异或后的那个数二进制中 1 的个数即可
     * 因为题目要求只能 1 变 0 ，所以可以先判断下，当 n & k == k 时才说明可以转换
     */
    public int minChanges(int n, int k) {
        if ((n & k) != k) {
            return -1;
        }
        int num = n ^ k;
        return Integer.bitCount(num);
    }

    /**
     * 官方解法：模拟
     */
    public int minChanges1(int n, int k) {
        int ans = 0;
        while (n > 0 || k > 0) {
            // 当前为 n 为 0 且 k 为 1 时，无法从 0 变 1，返回 -1
            if ((n & 1) == 0 && (k & 1) == 1) {
                return -1;
            }
            if ((n & 1) == 1 && (k & 1) == 0) {
                ans++;
            }
            // 向后移位
            n >>= 1;
            k >>= 1;
        }
        return ans;
    }
}