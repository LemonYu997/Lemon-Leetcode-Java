package problems.c0easy.t501t1000;

/**
 * 557 反转字符串中的单词III https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串s，翻转字符串中的每个单词的字符顺序，同时保留空格和单词的初始顺序
 *
 * 示例：
 * 输入1：s = "Let's take LeetCode contest"
 * 输出1："s'teL ekat edoCteeL tsetnoc"
 *
 * 输入2：s = "God Ding"
 * 输出2："doG gniD"
 */
public class T557 {
    /**
     * 自己实现：根据定义
     */
    public String reverseWords(String s) {
        //分割每个单词
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        //反转后拼接
        for (String word : words) {
            sb.append(reverse(word)).append(" ");
        }

        //移除最后一个空格
        sb.deleteCharAt(sb.lastIndexOf(" "));

        return sb.toString();
    }

    //反转每个单词
    public String reverse(String word) {
        char[] chars = word.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    /**
     * 官方解法
     */
    public String reverseWords1(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        int i = 0;

        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int j = start; j < i; j++) {
                sb.append(s.charAt(start + i - 1 -j));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                sb.append(' ');
            }
        }

        return sb.toString();
    }
}
