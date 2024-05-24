package problems.c0easy.t1001t1500;

/**
 * 1370 上升下降字符串 https://leetcode.cn/problems/increasing-decreasing-string/description/
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 请你返回将 s 中字符重新排序后的 结果字符串 。
 *
 * 示例：
 * 输入1：s = "aaaabbbbcccc"
 * 输出1："abccbaabccba"
 *
 * 输入2：s = "rat"
 * 输出2："art"
 *
 * 输入3：s = "leetcode"
 * 输出3："cdelotee"
 *
 * 输入4：s = "ggggggg"
 * 输出4："ggggggg"
 *
 * 输入5：s = "spo"
 * 输出5："ops"
 */
public class T1370 {
    /**
     * 自己实现：使用数组统计每个字母出现的个数
     * 从小到大依次遍历，当遍历完一遍后再重新开始，每次使用一个都--
     */
    public String sortString(String s) {
        int[] dict = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            dict[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < n) {
            // 先上升
            for (int i = 0; i < 26; i++) {
                if (dict[i] > 0) {
                    sb.append((char) (i + 'a'));
                    dict[i]--;
                }
            }
            // 后下降
            for (int i = 25; i >= 0; i--) {
                if (dict[i] > 0) {
                    sb.append((char) (i + 'a'));
                    dict[i]--;
                }
            }
        }

        return sb.toString();
    }
}
