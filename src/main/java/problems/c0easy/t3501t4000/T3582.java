package problems.c0easy.t3501t4000;

/**
 * 3582 为视频标题生成标签 https://leetcode.cn/problems/generate-tag-for-video-caption/description/
 * 给你一个字符串 caption，表示一个视频的标题。
 * 需要按照以下步骤 按顺序 生成一个视频的 有效标签 ：
 * 1、将 所有单词 组合为单个 驼峰命名字符串 ，并在前面加上 '#'。驼峰命名字符串
 * 指的是除第一个单词外，其余单词的首字母大写，且每个单词的首字母之后的字符必须是小写。
 * 2、移除 所有不是英文字母的字符，但 保留 第一个字符 '#'。
 * 3、将结果 截断 为最多 100 个字符。
 * 对 caption 执行上述操作后，返回生成的 标签 。
 *
 * 示例：
 * 输入1：caption = "Leetcode daily streak achieved"
 * 输出1："#leetcodeDailyStreakAchieved"
 *
 * 输入2： caption = "can I Go There"
 * 输出2："#canIGoThere"
 *
 * 输入3：caption = "hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 * 输出3："#hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"
 */
public class T3582 {
    /**
     * 社区解法：根据题意模拟
     */
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder("#");
        int len = caption.length();
        for (int i = 0; i < len && sb.length() < 100; i++) {
            char c = caption.charAt(i);
            if (Character.isLetter(c)) {
                if (sb.length() > 1 && !Character.isLetter(caption.charAt(i - 1))) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }
}
