package problems.c0easy.t1501t2000;

/**
 * 1941 检查是否所有字符出现次数相同 https://leetcode.cn/problems/check-if-all-characters-have-equal-number-of-occurrences/description/
 * 给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
 *
 * 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
 *
 * 示例：
 * 输入1：s = "abacbc"
 * 输出1：true
 *
 * 输入2：s = "aaabb"
 * 输出2：false
 */
public class T1941 {
    /**
     * 自己实现：使用数组统计每个字符出现的次数即可
     */
    public boolean areOccurrencesEqual(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int letter : letters) {
            // 当前字符出现次数大于0才需要判断
            if (letter > 0) {
                // 如果统一次数没更新，先更新
                if (count == 0) {
                    count = letter;
                } else if (count != letter) {
                    // 如果次数不一致，返回 false
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 优化解法：在统计次数的时候就计算好某个字符的次数
     */
    public boolean areOccurrencesEqual1(String s) {
        int[] letters = new int[26];
        int temp = 0;
        // 直接转换成 char 数组 时间效率要比 s.charAt() 高
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int k = c - 'a';
            letters[k]++;
            // 及时更新当前字符的次数
            temp = letters[k];
        }

        for (int letter : letters) {
            if (letter != 0 && letter != temp) {
                return false;
            }
        }

        return true;
    }
}
