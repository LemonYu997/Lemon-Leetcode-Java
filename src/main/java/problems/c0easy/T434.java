package problems.c0easy;

/**
 * 434 字符串中的单词数 https://leetcode.cn/problems/number-of-segments-in-a-string/
 * 统计字符串中的单词个数，单词指的是连续的不是空格的字符
 *
 * 示例：
 * 输入1："Hello, my name is John"
 * 输出1：5
 */
public class T434 {
    /**
     * 自己实现：根据定义
     */
    public int countSegments(String s) {
        String[] ss = s.split(" ");
        int count = 0;

        //判断每一个字符串是否为一个单词（有非空格字符就行）
        for (String str : ss) {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                //有非空格字符就算单词
                if (!Character.isSpaceChar(c)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    /**
     * 官方解法：遍历字符串
     */
    public int countSegments1(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }

        return count;
    }
}
