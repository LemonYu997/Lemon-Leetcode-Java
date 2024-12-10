package problems.c0easy.t1501t2000;

/**
 * 1859 将句子排序 https://leetcode.cn/problems/sorting-the-sentence/description/
 * 一个 句子 指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。
 * 每个单词都只包含小写或大写英文字母。
 * 我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词 打乱顺序 。
 * 比方说，句子 "This is a sentence" 可以被打乱顺序得到 "sentence4 a3 is2 This1"
 * 或者 "is2 sentence4 This1 a3" 。
 * 给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子。
 *
 * 示例：
 * 输入1：s = "is2 sentence4 This1 a3"
 * 输出1："This is a sentence"
 *
 * 输入2：s = "Myself2 Me1 I4 and3"
 * 输出2："Me Myself and I"
 */
public class T1859 {
    /**
     * 自己实现：根据序号填充即可
     */
    public String sortSentence(String s) {
        String[] ss = s.split(" ");
        int n = ss.length;
        String[] array = new String[n];

        // 遍历每一个单词
        for (int i = 0; i < n; i++) {
            int m = ss[i].length();
            // 题目要求单词数只有 1~9，因此取最后一位即可
            // 计算其应对的坐标，这里要 - 1，因为数组下标从 0 开始
            int temp  = ss[i].charAt(m - 1) - '0' - 1;
            array[temp] = ss[i].substring(0, m - 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String s1 : array) {
            sb.append(s1).append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
