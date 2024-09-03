package problems.c0easy.t1501t2000;

/**
 * T1592 重新排列单词间的空格 https://leetcode.cn/problems/rearrange-spaces-between-words/description/
 * 给你一个字符串 text ，该字符串由若干被空格包围的单词组成。
 * 每个单词由一个或者多个小写英文字母组成，并且两个单词之间至少存在一个空格。
 * 题目测试用例保证 text 至少包含一个单词 。
 *
 * 请你重新排列空格，使每对相邻单词之间的空格数目都 相等 ，
 * 并尽可能 最大化 该数目。如果不能重新平均分配所有空格，
 * 请 将多余的空格放置在字符串末尾 ，这也意味着返回的字符串应当与原 text 字符串的长度相等。
 *
 * 返回 重新排列空格后的字符串 。
 *
 * 示例：
 * 输入1：text = "  this   is  a sentence "
 * 输出1："this   is   a   sentence"
 *
 * 输入2：text = " practice   makes   perfect"
 * 输出2："practice   makes   perfect "
 *
 * 输入3：text = "hello   world"
 * 输出3："hello   world"
 *
 * 输入4：text = "  walks  udp package   into  bar a"
 * 输出4："walks  udp  package  into  bar  a "
 *
 * 输入5：text = "a"
 * 输出5："a"
 */
public class T1592 {
    /**
     * 官方解法：根据题意模拟
     */
    public String reorderSpaces(String text) {
        int len = text.length();
        String[] words = text.trim().split("\\s+");
        // 计算空格数 总长度 - 单词长度
        int cntSpace = len;
        for (String word : words) {
            cntSpace -= word.length();
        }

        StringBuilder sb = new StringBuilder();
        // 如果只有一个单词，将所有空格拼在后边
        if (words.length == 1) {
            sb.append(words[0]);
            for (int i = 0; i < cntSpace; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        // 计算每个单词间隙可以分得的空格数
        int perSpace = cntSpace / (words.length - 1);
        // 最后剩余的空格数
        int restSpace = cntSpace % (words.length - 1);

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                for (int j = 0; j < perSpace; j++) {
                    sb.append(' ');
                }
            }
            sb.append(words[i]);
        }
        for (int i = 0; i < restSpace; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}
