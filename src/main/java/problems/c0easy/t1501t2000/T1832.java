package problems.c0easy.t1501t2000;

/**
 * 1832 判断句子是否为全字母句 https://leetcode.cn/problems/check-if-the-sentence-is-pangram/description/
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出1：true
 *
 * 输入2：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出2：false
 */
public class T1832 {
    /**
     * 自己实现：遍历一遍，统计不同小写英文字母出现的次数是否等于 26
     */
    public boolean checkIfPangram(String sentence) {
        // 使用一个数组来标记每个单词是否出现过，初始为 0，出现过为 1
        int[] temp = new int[26];
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (temp[c - 'a'] == 0) {
                count++;
                temp[c - 'a'] = 1;
            }
        }

        return count == 26;
    }

    /**
     * 官方解法：用二进制表示集合
     */
    public boolean checkIfPangram1(String sentence) {
        int state = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            state |= 1 << (c - 'a');
        }

        return state == (1 << 26) - 1;
    }
}
