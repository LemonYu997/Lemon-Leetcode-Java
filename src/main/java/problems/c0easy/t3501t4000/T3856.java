package problems.c0easy.t3501t4000;

/**
 * 3856 移除尾部元音字母 https://leetcode.cn/problems/trim-trailing-vowels/description/
 * 给定一个由小写英文字母组成的字符串 s。
 * 返回移除字符串 s 尾部 所有元音字母 后得到的字符串。
 * 元音字母包括字符 'a'、'e'、'i'、'o' 和 'u'。
 *
 * 示例：
 * 输入1：s = "idea"
 * 输出1："id"
 *
 * 输入2：s = "day"
 * 输出2："day"
 *
 * 输入3：s = "aeiou"
 * 输出3：""
 */
public class T3856 {
    /**
     * 自己实现：倒序遍历，找到第一个非元音字母所在的索引位置即可
     */
    public String trimTrailingVowels(String s) {
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            } else {
                return s.substring(0, i + 1);
            }
        }
        return "";
    }

    /**
     * 社区解法：优化写法
     */
    public String trimTrailingVowels1(String s) {
        int i = s.length() - 1;
        while (i >= 0 && "aeiou".indexOf(s.charAt(i)) != -1) {
            i--;
        }
        return s.substring(0, i + 1);
    }
}