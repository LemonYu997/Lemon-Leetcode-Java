package problems.c0easy.t1501t2000;

/**
 * 1837 K 进制表示下的各位数字总和  https://leetcode.cn/problems/sum-of-digits-in-base-k/description/
 * 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
 *
 * 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
 *
 * 示例：
 * 输入1：n = 34, k = 6
 * 输出1:9
 *
 * 输入2：n = 10, k = 10
 * 输出2:1
 */
public class T1837 {
    /**
     * 自己实现：根据题意模拟
     */
    public int sumBase(int n, int k) {
        // 先转为k进制
        StringBuilder num = new StringBuilder();
        int ans = 0;
        while (n != 0) {
            num.append(n % k);
            n /= k;
        }

        // 因为只需要相加每一位数，这里不用再反转得到正确的数字
        for (int i = 0; i < num.length(); i++) {
            ans += num.charAt(i) - '0';
        }

        return ans;
    }

    /**
     * 官方解法：直接相加进制转换后的每一位即可
     */
    public int sumBase1(int n, int k) {
        int ans = 0;
        while (n != 0) {
            ans += n % k;
            n /= k;
        }

        return ans;
    }
}
