package problems.c0easy.t501t1000;

/**
 * 953 验证外星语词典 https://leetcode.cn/problems/verifying-an-alien-dictionary/
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，
 * 只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 *
 * 示例：
 * 输入1：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出1：true
 *
 * 输入2：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出2：false
 *
 * 输入3：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出3：false
 */
public class T953 {
    /**
     * 自己实现：先遍历 words，再遍历每个字符
     */
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            boolean valid = false;
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                if (prev < curr) {
                    valid = true;
                    break;
                } else if (prev > curr) {
                    return false;
                }
            }
            if (!valid) {
                // 比较两个字符串的长度
                if (words[i - 1].length() > words[i].length()) {
                    return false;
                }
            }
        }
        return true;
    }
}
