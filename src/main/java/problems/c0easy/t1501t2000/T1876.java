package problems.c0easy.t1501t2000;

/**
 * 1876 长度为三且各字符不同的子字符串 https://leetcode.cn/problems/substrings-of-size-three-with-distinct-characters/description/
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * 子字符串 是一个字符串中连续的字符序列。
 *
 * 示例：
 * 输入1：s = "xyzzaz"
 * 输出1:1
 *
 * 输入2：s = "aababcabc"
 * 输出2:4
 */
public class T1876 {
    /**
     * 自己实现：找到每一个长度为 3 的字符串，并判断其是否有重复字符
     */
    public int countGoodSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i) != s.charAt(i + 2) &&
                    s.charAt(i + 1) != s.charAt(i + 2)) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 社区解法：滑动窗口
     */
    public int countGoodSubstrings1(String s) {
        if (s.length() < 3) {
            return 0;
        }

        // 窗口
        StringBuffer window = new StringBuffer();
        int ans = 0;
        // 窗口范围
        int l = 0;
        int r = 1;
        // 预处理
        window.append(s.charAt(l));
        window.append(s.charAt(r));

        // 滑动
        while (l < r && r < s.length() - 1) {
            // 向右滑动
            while (r - l < 2) {
                r++;
                window.append(s.charAt(r));
            }

            // 判断
            if (window.charAt(0) != window.charAt(1) &&
                    window.charAt(2) != window.charAt(1) &&
                    window.charAt(0) != window.charAt(2)) {
                ans++;
            }
            // 左边界滑动
            window.deleteCharAt(0);
            l++;
        }

        return ans;
    }
}