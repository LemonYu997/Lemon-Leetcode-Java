package problems.c0easy.t3001t3500;

/**
 * 3216 交换后字典序最小的字符串 https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/description/
 * 给你一个仅由数字组成的字符串 s，在最多交换一次 相邻 且具有相同 奇偶性 的数字后，
 * 返回可以得到的字典序最小的字符串。
 * 如果两个数字都是奇数或都是偶数，则它们具有相同的奇偶性。例如，5 和 9、2 和 4 奇偶性相同，
 * 而 6 和 9 奇偶性不同。
 *
 * 示例：
 * 输入1：s = "45320"
 * 输出1："43520"
 *
 * 输入2：s = "001"
 * 输出2："001"
 */
public class T3216 {
    /**
     * 自己实现：一次遍历，如果遇到相邻且相同奇偶性，则进行比较，将小的值与前值替换
     */
    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            // 奇偶性相同
            if (chars[i] % 2 == chars[i - 1] % 2) {
                // 比较大小
                if (chars[i] < chars[i - 1]) {
                    char temp = chars[i];
                    chars[i] = chars[i - 1];
                    chars[i - 1] = temp;
                    break;
                }
            }
        }
        return new String(chars);
    }
}
