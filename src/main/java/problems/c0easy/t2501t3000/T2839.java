package problems.c0easy.t2501t3000;

/**
 * 2839. 判断通过操作能否让字符串相等 I https://leetcode.cn/problems/check-if-strings-can-be-made-equal-with-operations-i/description/
 * 给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。
 * 你可以对两个字符串中的 任意一个 执行以下操作 任意 次：
 * 选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。
 * 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。
 *
 * 示例：
 * 输入1：s1 = "abcd", s2 = "cdab"
 * 输出1：true
 *
 * 输入2：s1 = "abcd", s2 = "dacb"
 * 输出2：false
 */
public class T2839 {
    /**
     * 自己实现：偶数位字符都可以交换，奇数位字符不能交换
     * 所以判断奇数位和偶数位字符各字母个数是否一致
     */
    public boolean canBeEqual(String s1, String s2) {
        int[] oddCnt1 = new int[26];
        int[] oddCnt2 = new int[26];
        int[] evenCnt1 = new int[26];
        int[] evenCnt2 = new int[26];

        for (int i = 0; i < 4; i++) {
            if (i % 2 == 1) {
                oddCnt1[s1.charAt(i) - 'a']++;
                oddCnt2[s2.charAt(i) - 'a']++;
            } else {
                evenCnt1[s1.charAt(i) - 'a']++;
                evenCnt2[s2.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (oddCnt1[i] != oddCnt2[i] || evenCnt1[i] != evenCnt2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * 社区解法：总共长度为4，全比较一次即可
     */
    public boolean canBeEqual1(String s1, String s2) {
        for (int i = 0; i < 2; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s1.charAt(i + 2) == s2.charAt(i + 2)) {
                // 不变
                continue;
            } else if (s1.charAt(i) == s2.charAt(i + 2) && s1.charAt(i + 2) == s2.charAt(i)) {
                // 互换后相等
                continue;
            } else {
                // 不符合
                return false;
            }
        }

        return true;
    }
}
