package problems.c0easy.t1501t2000;

/**
 * 1662 检查两个字符串数组是否相等 https://leetcode.cn/problems/check-if-two-string-arrays-are-equivalent/description/
 * 给你两个字符串数组 word1 和 word2 。
 * 如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 * 示例：
 * 输入1：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出1：true
 *
 * 输入2：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出2：false
 *
 * 输入3：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出3：true
 */
public class T1662 {
    /**
     * 自己实现：拼接字符串并比较
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }

        return sb1.toString().equals(sb2.toString());
    }

    /**
     * 官方解法：直接对比
     */
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        // p1 和 p2 是 word对应的索引，i 和 j 是 word中每个字符对应的索引
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        int j = 0;
        while (p1 < word1.length && p2 < word2.length) {
            if (word1[p1].charAt(i) != word2[p2].charAt(j)) {
                return false;
            }
            i++;
            // 如果当前单词已遍历完，索引指向下一个单词
            if (i == word1[p1].length()) {
                p1++;
                i = 0;
            }
            j++;
            if (j == word2[p2].length()) {
                p2++;
                j = 0;
            }
        }

        // 如果刚好全遍历完，说明一致
        return p1 == word1.length && p2 == word2.length;
    }
}
