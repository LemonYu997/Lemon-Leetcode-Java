package problems.c0easy.t1001t1500;

/**
 * 1309 解码字母到整数映射 https://leetcode.cn/problems/decrypt-string-from-alphabet-to-integer-mapping/description/
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 *
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 *
 * 题目数据保证映射始终唯一
 *
 * 示例：
 * 输入1：s = "10#11#12"
 * 输出1："jkab"
 *
 * 输入2：s = "1326#"
 * 输出2："acz"
 */
public class T1309 {
    /**
     * 自己实现：倒序遍历，遇到 # 退 3 位，普通字母退 1 位
     */
    public String freqAlphabets(String s) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                int temp = Integer.parseInt(s.substring(i - 2, i));
                sb.append(letters.charAt(temp - 1));
                i -= 2;
            } else {
                int temp = Integer.parseInt(String.valueOf(s.charAt(i)));
                sb.append(letters.charAt(temp - 1));
            }
        }

        return sb.reverse().toString();
    }

    /**
     * 官方解法：正序遍历，遍历每一个 i 位置时 先看 i+2 处是否为 #
     */
    public String freqAlphabets1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '1') + 'a'));
                i += 2;
            } else {
                sb.append((char) (s.charAt(i) - '1' + 'a'));
            }
        }

        return sb.toString();
    }
}
