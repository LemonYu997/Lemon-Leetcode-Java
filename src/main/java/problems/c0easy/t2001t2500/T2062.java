package problems.c0easy.t2001t2500;

/**
 * 2062 统计字符串中的元音子字符串 https://leetcode.cn/problems/count-vowel-substrings-of-a-string/description/
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，
 * 且必须包含 全部五种 元音。
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 *
 * 示例：
 * 输入1：word = "aeiouu"
 * 输出1：2
 *
 * 输入2：word = "unicornarihan"
 * 输出2：0
 *
 * 输入3：word = "cuaieuouac"
 * 输出3：7
 *
 * 输入4：word = "bbaeixoubb"
 * 输出4：0
 */
public class T2062 {
    /**
     * 他人解法：滑动窗口
     */
    public int countVowelSubstrings(String word) {
        char[] chars = word.toCharArray();
        int ans = 0;
        // 滑动窗口，每次都从当前子字符串的下一个位置开始
        for (int l = 0, r = 0; l < chars.length; l = r + 1) {
            r = l;
            // 跳过非元音字符
            if (!isVowel(chars[l])) {
                continue;
            }
            int[] cnt = new int[26];

            // 找到当前连续元音的结束位置
            while (r < chars.length && isVowel(chars[r])) {
                r++;
            }

            // 统计有效子串
            int start = l;
            for (int end = l; end < r; end++) {
                cnt[chars[end] - 'a']++;

                // 确保[start, end]中的元音只会出现一次
                while (cnt[chars[start] - 'a'] > 1) {
                    cnt[chars[start] - 'a']--;
                    start++;
                }

                // 如果包含所有元音再计数
                if (cnt['a' - 'a'] > 0 && cnt['e' - 'a'] > 0 && cnt['i' - 'a'] > 0 && cnt['o' - 'a'] > 0 && cnt['u' - 'a'] > 0) {
                    ans += start - l + 1;
                }
            }
        }

        return ans;
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
