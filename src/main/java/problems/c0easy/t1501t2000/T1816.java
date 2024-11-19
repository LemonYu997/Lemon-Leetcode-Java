package problems.c0easy.t1501t2000;

/**
 * 1816 截断句子 https://leetcode.cn/problems/truncate-sentence/description/
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s 和一个整数 k ，
 * 请你将 s 截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
 *
 * 示例：
 * 输入1：s = "Hello how are you Contestant", k = 4
 * 输出1："Hello how are you"
 *
 * 输入2：s = "What is the solution to this problem", k = 4
 * 输出2："What is the solution"
 *
 * 输入3：s = "chopper is not a tanuki", k = 5
 * 输出3："chopper is not a tanuki"
 */
public class T1816 {
    /**
     * 自己实现：根据题意模拟
     */
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        // 拼接除了第 k 个单词
        for (int i = 0; i < k - 1; i++) {
            sb.append(words[i]).append(" ");
        }
        // 拼接第 k 个单词，不需要分隔
        sb.append(words[k - 1]);

        return sb.toString();
    }

    /**
     * 官方解法：不用先根据 " " 分割字符串，直接遍历字符串，找到截止点的索引
     */
    public String truncateSentence1(String s, int k) {
        int n = s.length();
        // 截止的索引和已遍历的单词数
        int end = 0;
        int count = 0;

        for (int i = 0; i <= n; i++) {
            // 遇到空格就将单词数+1，需要注意可能会遍历到结尾，此时也算单词数 + 1
            if (i == n || s.charAt(i) == ' ') {
                count++;
                // 找到截止点索引
                if (count == k) {
                    end = i;
                    break;
                }
            }
        }

        return s.substring(0, end);
    }
}