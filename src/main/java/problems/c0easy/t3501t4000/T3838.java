package problems.c0easy.t3501t4000;

/**
 * 3838 带权单词映射 https://leetcode.cn/problems/weighted-word-mapping/description/
 * 给你一个字符串数组 words，其中每个字符串表示一个由小写英文字母组成的单词。
 * 同时给你一个长度为 26 的整数数组 weights，其中 weights[i] 表示第 i 个小写英文字母的权重。
 * 单词的 权重 定义为其所有字符权重的 总和。
 * 对于每个单词，将其权重对 26 取模，并将结果按字母倒序映射到一个小写英文字母（0 -> 'z', 1 -> 'y', ..., 25 -> 'a'）。
 * 返回一个由所有单词映射后的字符按顺序连接而成的字符串。
 *
 * 示例：
 * 输入1：words = ["abcd","def","xyz"], weights = [5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2]
 * 输出1："rij"
 *
 * 输入2：words = ["a","b","c"], weights = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
 * 输出2："yyy"
 *
 * 输入3：words = ["abcd"], weights = [7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5]
 * 输出3："g"
 */
public class T3838 {
    /**
     * 自己实现：根据题意模拟
     */
    public String mapWordWeights(String[] words, int[] weights) {
        // 结果字符串长度是固定的
        char[] chars = new char[words.length];

        for (int i = 0; i < words.length; i++) {
            // 每个单词根据权重求和
            String word = words[i];
            int sum = 0;
            for (int j = 0; j < word.length(); j++) {
                sum += weights[word.charAt(j) - 'a'];
            }
            // 要倒序映射字符
            chars[i] = (char) ('z' - sum % 26);
        }

        return new String(chars);
    }
}
