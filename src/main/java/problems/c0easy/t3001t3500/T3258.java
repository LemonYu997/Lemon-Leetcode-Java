package problems.c0easy.t3001t3500;

/**
 * 3258 统计满足 K 约束的子字符串数量 I https://leetcode.cn/problems/count-substrings-that-satisfy-k-constraint-i/description/
 * 给你一个 二进制 字符串 s 和一个整数 k
 * 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
 * 字符串中 0 的数量最多为 k。
 * 字符串中 1 的数量最多为 k。
 * 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。
 *
 * 示例：
 * 输入1：s = "10101", k = 1
 * 输出1：12
 *
 * 输入2：s = "1010101", k = 2
 * 输出2：25
 *
 * 输入3：s = "11111", k = 1
 * 输出3：15
 */
public class T3258 {
    /**
     * 自己实现：遍历
     */
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int c0 = 0;
            int c1 = 0;
            // i~j 作为子字符串
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') {
                    c0++;
                } else {
                    c1++;
                }
                if (c0 > k && c1 > k) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

    /**
     * 官方解法：滑动窗口+前缀数组
     */
    public int countKConstraintSubstrings1(String s, int k) {
        int n = s.length();
        int[] count = new int[2];
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            count[s.charAt(j) - '0']++;
            // 当不满足时，移动左指针
            while (count[0] > k && count[1] > k) {
                count[s.charAt(i) - '0']--;
                i++;
            }
            ans += j - i + 1;
        }
        return ans;
    }
}
