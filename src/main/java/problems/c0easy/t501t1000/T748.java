package problems.c0easy.t501t1000;

/**
 * 748 最短补全词 https://leetcode.cn/problems/shortest-completing-word/
 * 给定一个字符串 licensePlate 和一个字符串数组 words，找到 words 中的最短补全词
 * 补全词：包含 licensePlate 中所有字母的单词，忽略 licensePlate中的数字和空格，不区分大小写
 * 如果有多个最短补全词，返回 words 第一个出现的那个
 *
 * 示例：
 * 输入1：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出1："steps"
 * 备注：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 *
 * 输入2：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出2："pest"
 * 备注：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，
 * 其中 "pest"、"stew"、和 "show" 三者最短。答案是 "pest" ，因为它是三个单词中在 words 里最靠前的那个。
 */
public class T748 {
    /**
     * 官方解法：统计字符出现次数
     */
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        //每个字符出现次数
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                cnt[Character.toLowerCase(c) - 'a']++;
            }
        }

        //最短补全词所对应的索引
        int index = -1;


        for (int i = 0; i < words.length; i++) {
            //统计每个单词的字符出现次数
            int[] wc = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                wc[c - 'a']++;
            }

            //成功标识
            boolean ok = true;
            //判断是否 licensePlate 中字符完全出现
            for (int j = 0; j < 26; j++) {
                if (wc[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }

            //判断是否最短且靠前的补全词，如果是则更新
            if (ok) {
                if (index < 0 || words[i].length() < words[index].length()) {
                    index = i;
                }
            }
        }

        return words[index];
    }
}
