package problems.c0easy.t3001t3500;

/**
 * 3340 检查平衡字符串 https://leetcode.cn/problems/check-balanced-string/description/
 * 给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，
 * 则认为该数字字符串是一个 平衡字符串。
 * 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
 *
 * 示例：
 * 输入1：num = "1234"
 * 输出1：false
 *
 * 输入2：num = "24123"
 * 输出2：true
 */
public class T3340 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean isBalanced(String num) {
        char[] chars = num.toCharArray();
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i] - '0';
            if (i % 2 == 0) {
                sum1 += n;
            } else {
                sum2 += n;
            }
        }
        return sum1 == sum2;
    }

    /**
     * 官方解法：优化写法
     */
    public boolean isBalanced1(String num) {
        int diff = 0;
        // 使用一个标志位来加减总数
        int sign = 1;
        for (int i = 0; i < num.length(); i++) {
            int d = num.charAt(i) - '0';
            diff += d * sign;
            sign = -sign;
        }
        return diff == 0;
    }

}
