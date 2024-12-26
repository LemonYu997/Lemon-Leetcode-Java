package problems.c0easy.t1501t2000;

import java.util.HashSet;
import java.util.Set;

/**
 * 1935 可以输入的最大单词数 https://leetcode.cn/problems/maximum-number-of-words-you-can-type/description/
 * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
 *
 * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；
 * 另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
 *
 * 输入1：text = "hello world", brokenLetters = "ad"
 * 输出1：1
 *
 * 输入2：text = "leet code", brokenLetters = "lt"
 * 输出2：1
 *
 * 输入3：text = "leet code", brokenLetters = "e"
 * 输出3：0
 */
public class T1935 {
    /**
     * 自己实现：判断每个单词里是否含有错误字符即可
     */
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int ans = 0;

        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            for (int j = 0; j < brokenLetters.length(); j++) {
                if (words[i].indexOf(brokenLetters.charAt(j)) >= 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：使用 Set 存储错误字符，遍历所有单词判断当前单词是否包含错误字符即可
     */
    public int canBeTypedWords1(String text, String brokenLetters) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }

        // 当前字符所在的单词是否可以被输入
        boolean flag = true;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // 为空格时，检查上一个单词的状态并更新数目
            if (c == ' ') {
                if (flag) {
                    ans++;
                }
                flag = true;
            } else if (flag && set.contains(c)) {
                // 如果当前单词已经错误，就不用再判断了
                // 如果当前字符为错误字符，更新当前单词状态
                flag = false;
            }
        }

        // 判断最后一个单词
        if (flag) {
            ans++;
        }

        return ans;
    }
}
