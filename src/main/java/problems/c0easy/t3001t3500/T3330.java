package problems.c0easy.t3001t3500;

/**
 * 3330 找到初始输入字符串 I https://leetcode.cn/problems/find-the-original-typed-string-i/description/
 * Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
 * 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。
 * 给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
 * 请你返回 Alice 一开始可能想要输入字符串的总方案数。
 *
 * 示例:
 * 输入1：word = "abbcccc"
 * 输出1：5
 *
 * 输入2：word = "abcd"
 * 输出2：1
 *
 * 输入3：word = "aaaa"
 * 输出3：4
 */
public class T3330 {
    /**
     * 自己实现：统计连续重复字符数即可
     * 因为最多只会出错一次，除了刚开始那初始的一次，之后每次遇到重复字符的总次数都要-1
     */
    public int possibleStringCount(String word) {
        int ans = 1;
        for (int i = 1; i < word.length(); i++) {
            int now = i;
            // 获取连续出现重复字符的子字符串
            while (i < word.length() && word.charAt(i) == word.charAt(i - 1)) {
                i++;
            }
            ans = ans + (i - now);
        }
        return ans;
    }

    /**
     * 官方解法：优化写法，上边那个想复杂了
     */
    public int possibleStringCount1(String word) {
        int ans = 1;
        int n = word.length();
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                ans++;
            }
        }
        return ans;
    }
}