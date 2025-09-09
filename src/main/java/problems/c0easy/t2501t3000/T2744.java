package problems.c0easy.t2501t3000;

/**
 * 2744 最大字符串配对数目 https://leetcode.cn/problems/find-maximum-number-of-string-pairs/description/
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * 字符串 words[i] 等于 words[j] 的反转字符串。
 * 0 <= i < j < words.length
 * 请你返回数组 words 中的 最大 匹配数目。
 * 注意，每个字符串最多匹配一次。
 *
 * 示例：
 * 输入1：words = ["cd","ac","dc","ca","zz"]
 * 输出1：2
 *
 * 输入2：words = ["ab","ba","cc"]
 * 输出2：1
 *
 * 输入3：words = ["aa","ab"]
 * 输出3：0
 *
 * 提示：
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 */
public class T2744 {
    /**
     * 自己实现：根据题意遍历
     */
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 判断两个字符串是否为翻转字符串
                int len = words[i].length();
                boolean flag = true;
                for (int k = 0; k < len; k++) {
                    if (words[i].charAt(k) != words[j].charAt(len - k - 1)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }
}
