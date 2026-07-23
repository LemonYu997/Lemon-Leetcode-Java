package problems.c0easy.t3501t4000;

/**
 * 3813 元音辅音得分 https://leetcode.cn/problems/vowel-consonant-score/description/
 * 给你一个字符串 s，由小写英文字母、空格和数字组成。
 * 令 v 表示 s 中元音字母的数量，c 表示辅音字母的数量。
 * 元音字母是 'a'、'e'、'i'、'o' 和 'u'，而英文字母表中除元音外的其他字母均视为辅音字母。
 * 字符串 s 的 得分 定义如下：
 * 如果 c > 0，则 score = floor(v / c)，其中 floor 表示 向下取整 到最接近的整数。
 * 否则，如果 c = 0，则 score = 0。
 * 返回一个整数，表示字符串的得分。
 *
 * 示例：
 * 输入1：s = "cooear"
 * 输出1：2
 *
 * 输入2：s = "axeyizou"
 * 输出2：1
 *
 * 输入3：s = "au 123"
 * 输出3：0
 */
public class T3813 {
    /**
     * 自己实现：根据题意模拟
     */
    public int vowelConsonantScore(String s) {
        int v = 0;
        int c = 0;

        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (cc == 'a' || cc == 'e' || cc == 'i' || cc == 'o' || cc == 'u') {
                v++;
            } else if (cc >= 'a' && cc <= 'z') {
                c++;
            }
        }

        return c == 0 ? 0 : v / c;
    }
}
