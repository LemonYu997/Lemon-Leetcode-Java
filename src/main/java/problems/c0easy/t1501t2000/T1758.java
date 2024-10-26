package problems.c0easy.t1501t2000;

/**
 * 1758 生成交替二进制字符串的最少操作数 https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/description/
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。
 * 一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，
 * 那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 *
 * 示例：
 * 输入1：s = "0100"
 * 输出1：1
 *
 * 输入2：s = "10"
 * 输出2:0
 *
 * 输入3：s = "1111"
 * 输出3：2
 */
public class T1758 {
    /**
     * 自己实现：遍历一次，下一个字符与上一个字符相等时改变一下即可
     * 注意字符串可能为 1 开头或 0 开头，两种情况的最小次数加起来为 s 长度
     * 所以最后要从两个结果中选择最小的
     */
    public int minOperations(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                ans++;
                if (chars[i] == '1') {
                    chars[i] = '0';
                } else {
                    chars[i] = '1';
                }
            }
        }

        return Math.min(ans, chars.length - ans);
    }
}
