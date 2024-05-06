package problems.c0easy.t1001t1500;

/**
 * 1323 6 和 9 组成的最大数字 https://leetcode.cn/problems/maximum-69-number/description/
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * 请返回你可以得到的最大数字。
 *
 * 示例：
 * 输入1：num = 9669
 * 输出1：9969
 *
 * 输入2：num = 9996
 * 输出2：9999
 *
 * 输入3：num = 9999
 * 输出3：9999
 */
public class T1323 {
    /**
     * 自己实现：将其转为字符串并从前往后遍历，将遇到的第一个6转为9即可
     */
    public int maximum69Number(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    /**
     * 官方解法：使用 Java 相关 API
     */
    public int maximum69Number1(int num) {
        return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
    }
}
