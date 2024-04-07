package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1078 Bigram 分词 https://leetcode.cn/problems/occurrences-after-bigram/description/
 * 给出第一个词 first 和第二个词 second，
 * 考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，
 * 其中 second 紧随 first 出现，third 紧随 second 出现。
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 *
 * 示例：
 * 输入1：text = "alice is a good girl she is a good student",
 * first = "a", second = "good"
 * 输出1：["girl","student"]
 *
 * 输入2：text = "we will we will rock you", first = "we", second = "will"
 * 输出2：["we","rock"]
 */
public class T1078 {
    /**
     * 自己实现：遍历字符串单词数组，找到所有 third
     */
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        int n = words.length;
        String[] ans = new String[n];
        int index = 0;

        for (int i = 1; i + 1 < n; i++) {
            if (words[i].equals(second) && words[i - 1].equals(first)) {
                ans[index] = words[i + 1];
                index++;
            }
        }

        return Arrays.copyOfRange(ans, 0, index);
    }
}
