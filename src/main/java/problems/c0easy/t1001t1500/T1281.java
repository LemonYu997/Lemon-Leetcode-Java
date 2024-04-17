package problems.c0easy.t1001t1500;

/**
 * 1281 整数的各位积和之差 https://leetcode.cn/problems/subtract-the-product-and-sum-of-digits-of-an-integer/description/
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 *
 * 示例：
 * 输入1：n = 234
 * 输出1：15
 *
 * 输入2：n = 4421
 * 输出2：21
 */
public class T1281 {
    /**
     * 自己实现：模拟
     */
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;

        while (n > 0) {
            int num = n % 10;
            mul *= num;
            sum += num;
            n /= 10;
        }

        return mul - sum;
    }
}
