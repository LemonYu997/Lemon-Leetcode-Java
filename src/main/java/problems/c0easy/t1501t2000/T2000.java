package problems.c0easy.t1501t2000;

/**
 * 2000 反转单词前缀 https://leetcode.cn/problems/reverse-prefix-of-word/description/
 * 给你一个下标从 0 开始的字符串 word 和一个字符 ch 。找出 ch 第一次出现的下标 i ，
 * 反转 word 中从下标 0 开始、直到下标 i 结束（含下标 i ）的那段字符。如果 word 中不存在字符 ch ，则无需进行任何操作。
 *
 * 例如，如果 word = "abcdefd" 且 ch = "d" ，那么你应该 反转 从下标 0 开始、
 * 直到下标 3 结束（含下标 3 ）。结果字符串将会是 "dcbaefd" 。
 * 返回 结果字符串 。
 *
 * 示例：
 * 输入1：word = "abcdefd", ch = "d"
 * 输出1："dcbaefd"
 *
 * 输入2：word = "xyxzxe", ch = "z"
 * 输出2："zxyxxe"
 *
 * 输入3：word = "abcd", ch = "z"
 * 输出3："abcd"
 */
public class T2000 {
    /**
     * 自己实现：根据题意模拟
     * 遍历每个字符，遇到指定字符串时反转并拼接
     */
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();

        // 是否翻转过
        boolean flag = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 字符匹配并且当前还未进行过翻转
            if (c == ch && !flag) {
                flag = true;
                sb.append(c).reverse();
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    /**
     * 官方解法：找到对应字符索引并进行翻转
     */
    public String reversePrefix1(String word, char ch) {
        int index = word.indexOf(ch);

        // 如果存在该字符，就进行翻转
        if (index >= 0) {
            char[] arr = word.toCharArray();
            // 找到需要翻转部分的首尾索引
            int left = 0, right = index;
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            // 更新反转后的字符串
            word = new String(arr);
        }
        return word;
    }
}
