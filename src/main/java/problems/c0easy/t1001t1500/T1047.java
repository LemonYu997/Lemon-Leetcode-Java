package problems.c0easy.t1001t1500;

/**
 * 1047 删除字符串中的所有相邻重复项 https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/description/
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 *
 * 示例：
 * 输入1："abbaca"
 * 输出1："ca"
 */
public class T1047 {
    /**
     * 官方解法：使用栈
     */
    public String removeDuplicates(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果当前字符和上一个字符相同，删除上一个字符
            if (top >= 0 && stack.charAt(top) == c) {
                stack.deleteCharAt(top);
                top--;
            } else {
                // 不一致则添加当前字符
                stack.append(c);
                top++;
            }
        }
        return stack.toString();
    }
}
