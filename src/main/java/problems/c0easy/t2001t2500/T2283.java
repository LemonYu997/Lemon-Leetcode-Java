package problems.c0easy.t2001t2500;

/**
 * 2283 判断一个数的数字计数是否等于数位的值 https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/description/
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，
 * 那么请你返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：num = "1210"
 * 输出1：true
 *
 * 输入2：num = "030"
 * 输出2：false
 */
public class T2283 {
    /**
     * 自己实现：统计每个数字出现的次数即可
     */
    public boolean digitCount(String num) {
        int n = num.length();
        int[] temp = new int[10];

        // 统计每个数字出现个数
        for (int i = 0; i < n; i++) {
            temp[num.charAt(i) - '0']++;
        }

        // 判断位数值是否与出现个数一致
        for (int i = 0; i < n; i++) {
            if (num.charAt(i) - '0' != temp[i]) {
                return false;
            }
        }

        return true;
    }
}
