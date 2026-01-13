package problems.c0easy.t3001t3500;

import java.util.HashSet;
import java.util.Set;

/**
 * 3136 有效单词 https://leetcode.cn/problems/valid-word/description/
 * 有效单词 需要满足以下几个条件：
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 * 注意：
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 *
 * 示例：
 * 输入1：word = "234Adas"
 * 输出1：true
 *
 * 输入2：word = "b3"
 * 输出2：false
 *
 * 输入3：word = "a3$e"
 * 输出3：false
 */
public class T3136 {
    /**
     * 自己实现：根据题意模拟
     */
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean haveVowel = false;
        boolean haveConsonant = false;

        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                continue;
            } else if (Character.isLetter(c)) {
                if (vowels.contains(Character.toLowerCase(c))) {
                    haveVowel = true;
                } else {
                    haveConsonant = true;
                }
            } else {
                return false;
            }
        }

        return haveVowel && haveConsonant;
    }

    /**
     * 官方解法：优化写法
     */
    public boolean isValid1(String word) {
        if (word.length() < 3) {
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = Character.toLowerCase(c);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return hasVowel && hasConsonant;
    }
}