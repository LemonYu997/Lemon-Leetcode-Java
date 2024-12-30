package problems.c0easy.t1501t2000;

/**
 * 1957 删除字符使字符串变好 https://leetcode.cn/problems/delete-characters-to-make-fancy-string/description/
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 *
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 *
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 *
 * 示例：
 * 输入1：s = "leeetcode"
 * 输出1："leetcode"
 *
 * 输入2：s = "aaabaaaa"
 * 输出2："aabaa"
 *
 * 输入3：s = "aab"
 * 输出3："aab"
 */
public class T1957 {
    /**
     * 自己实现：遍历一遍，统计当前字符次数，如果超过2次就跳过，遇到新字符就重置次数
     */
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        // 上一个字符
        char pre = s.charAt(0);
        sb.append(pre);
        // 当前字符统计次数
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                count++;
                // 如果超过2个，就跳过当前字符
                if (count > 2) {
                    continue;
                } else {
                    // 如果不足2个，就添加当前字符
                    sb.append(s.charAt(i));
                }
            } else {
                // 如果当前字符是新字符，就重置
                pre = s.charAt(i);
                sb.append(pre);
                count = 1;
            }
        }

        return sb.toString();
    }
}
