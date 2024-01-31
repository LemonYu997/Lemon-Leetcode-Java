package problems.c0easy;

/**
 * 942 增减字符串匹配 https://leetcode.cn/problems/di-string-match/
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 * 示例：
 * 输入1：s = "IDID"
 * 输出1：[0,4,1,3,2]
 *
 * 输入2：s = "III"
 * 输出2：[0,1,2,3]
 *
 * 输入3：s = "DDI"
 * 输出3：[3,2,0,1]
 */
public class T942 {
    /**
     * 自己实现：根据题意模拟，使用双指针
     * 观察示例，当前字符为 I 时， ans[i] 是由小到大的
     * 当前字符为 D 时，ans[i] 是由大到小的
     */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0;
        int high = n;
        int[] ans = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = low;
                low++;
            } else {
                ans[i] = high;
                high--;
            }
        }
        // 最后补一位
        ans[n] = low;

        return ans;
    }
}
