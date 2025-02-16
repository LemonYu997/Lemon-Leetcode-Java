package problems.c0easy.t2001t2500;

/**
 * 2129 将标题首字母大写 https://leetcode.cn/problems/capitalize-the-title/description/
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，
 * 每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 *
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 *
 * 示例：
 * 输入1：title = "capiTalIze tHe titLe"
 * 输出1："Capitalize The Title"
 *
 * 输入2：title = "First leTTeR of EACH Word"
 * 输出2："First Letter of Each Word"
 *
 * 输入3：title = "i lOve leetcode"
 * 输出3："i Love Leetcode"
 */
public class T2129 {
    /**
     * 自己实现：根据题意模拟
     */
    public String capitalizeTitle(String title) {
        // 原文长度
        int n = title.length();
        String[] words = title.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // 短单词全小写
            if (words[i].length() <= 2) {
                sb.append(words[i].toLowerCase()).append(" ");
            } else {
                // 首字母大写
                char c = Character.toUpperCase(words[i].charAt(0));
                // 剩余小写
                sb.append(c).append(words[i].substring(1).toLowerCase()).append(" ");
            }
        }

        // 只保留原文长度（最后的 “ ” 被去掉）
        return sb.toString().substring(0, n);
    }

    /**
     * 官方解法：双指针
     */
    public String capitalizeTitle1(String title) {
        StringBuilder sb = new StringBuilder(title);
        int n = title.length();
        // 单词左右边界
        int l = 0, r = 0;

        while (r < n) {
            // 找到单次右边界
            while (r < n && sb.charAt(r) != ' ') {
                r++;
            }
            // 正常单词（长度大于2的）首字母大写
            if (r - l > 2) {
                sb.setCharAt(l, Character.toUpperCase(sb.charAt(l)));
                l++;
            }
            // 剩下的所有字符全部小写
            while (l < r) {
                sb.setCharAt(l, Character.toLowerCase(sb.charAt(l)));
                l++;
            }
            // 推到下一个单词
            l = r + 1;
            r++;
        }

        return sb.toString();
    }
}
