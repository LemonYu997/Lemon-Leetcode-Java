package problems.c0easy.t1501t2000;

/**
 * 1903 字符串中的最大奇数 https://leetcode.cn/problems/largest-odd-number-in-string/description/
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，
 * 并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * 子字符串 是字符串中的一个连续的字符序列。
 *
 * 示例：
 * 输入1：num = "52"
 * 输出1："5"
 *
 * 输入2：num = "4206"
 * 输出2：""
 *
 * 输入3：num = "35427"
 * 输出3："35427"
 */
public class T1903 {
    /**
     * 自己实现：倒序判断末尾的每一个数字是否是奇数即可
     */
    public String largestOddNumber(String num) {
        int n = num.length();

        // 倒序遍历
        for (int i = n - 1; i >= 0; i--) {
            // 如果为奇数则返回剩下的字符串
            if ((num.charAt(i) - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }
}
