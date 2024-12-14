package problems.c0easy.t1501t2000;

/**
 * 1880 检查某单词是否等于两单词之和 https://leetcode.cn/problems/check-if-word-equals-summation-of-two-words/description/
 * 字母的 字母值 取决于字母在字母表中的位置，
 * 从 0 开始 计数。即，'a' -> 0、'b' -> 1、'c' -> 2，以此类推。
 * 对某个由小写字母组成的字符串 s 而言，
 * 其 数值 就等于将 s 中每个字母的 字母值 按顺序 连接 并 转换 成对应整数。
 * 例如，s = "acb" ，依次连接每个字母的字母值可以得到 "021" ，转换为整数得到 21 。
 * 给你三个字符串 firstWord、secondWord 和 targetWord ，
 * 每个字符串都由从 'a' 到 'j' （含 'a' 和 'j' ）的小写英文字母组成。
 * 如果 firstWord 和 secondWord 的 数值之和 等于 targetWord 的数值，返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：firstWord = "acb", secondWord = "cba", targetWord = "cdb"
 * 输出1：true
 *
 * 输入2：firstWord = "aaa", secondWord = "a", targetWord = "aab"
 * 输出2：false
 *
 * 输入3：firstWord = "aaa", secondWord = "a", targetWord = "aaaa"
 * 输出3：true
 */
public class T1880 {
    /**
     * 自己实现：根据题意转换为数字并相加
     */
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder sb = new StringBuilder();
        int l1 = firstWord.length();
        for (int i = 0; i < l1; i++) {
            sb.append(firstWord.charAt(i) - 'a');
        }

        int num1 = Integer.parseInt(sb.toString());
        sb.delete(0, l1);

        int l2 = secondWord.length();
        for (int i = 0; i < l2; i++) {
            sb.append(secondWord.charAt(i) - 'a');
        }
        int num2 = Integer.parseInt(sb.toString());
        sb.delete(0, l2);

        int l3 = targetWord.length();
        for (int i = 0; i < l3; i++) {
            sb.append(targetWord.charAt(i) - 'a');
        }
        int num3 = Integer.parseInt(sb.toString());

        return num1 + num2 == num3;
    }

    /**
     * 优化解法：直接计算数值
     */
    public boolean isSumEqual1(String firstWord, String secondWord, String targetWord) {
        int num1 = helper(firstWord) + helper(secondWord);
        int num2 = helper(targetWord);

        return num1 == num2;
    }

    // 计算转化后的数字
    public int helper(String s) {
        int z = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            z += (s.charAt(i) - 'a') * Math.pow(10, s.length() - 1 - i);
        }

        return z;
    }
}
