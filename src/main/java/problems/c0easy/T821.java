package problems.c0easy;

/**
 * 821 字符的最短距离 https://leetcode.cn/problems/shortest-distance-to-a-character/
 * 给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
 * 返回一个整数数组 answer ，其中 answer.length == s.length
 * 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
 * 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数
 *
 * 示例：
 * 输入1：s = "loveleetcode", c = "e"
 * 输出1：[3,2,1,0,1,0,0,1,2,2,1,0]
 * 备注：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
 *
 * 输入2：s = "aaab", c = "b"
 * 输出2：[3,2,1,0]
 */
public class T821 {
    /**
     * 自己实现：中心扩散
     * 观察示例，找到结果为0的位置，向外依次扩展，
     * 每个 0 都重复此过程，留下最小值即可
     */
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        char[] chars = s.toCharArray();

        //每遇到一个 c ，就向前或向后遍历
        for (int i = 0; i < n; i++) {
            if (chars[i] == c) {
                //向后遍历，依次加1
                int countL = 0;
                ans[i] = countL;
                for (int j = i - 1; j >= 0 ; j--) {
                    // 遇到另一个 c 或者 当前值（除了0）比结果小时，结束遍历
                    // 因为ans初始化为0，这里要排除
                    if (chars[j] == c || (ans[j] <= countL && ans[j] != 0)) {
                        break;
                    }
                    countL++;
                    ans[j] = countL;
                }
                //向前遍历，依次加一，遇到另一个 c 停止
                int countR = 0;
                for (int j = i + 1; j < n; j++) {
                    if (chars[j] == c) {
                        break;
                    }
                    countR++;
                    ans[j] = countR;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：两次遍历
     */
    public int[] shortestToChar1(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        // 初始时 idx 可能不存在，用 -n 表示
        // 先从左到右遍历，遇到 c 就更新 idx
        for (int i = 0, idx = -n; i < n; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = i - idx;
        }

        // 初始时 idx 可能不存在，用 2n 表示
        // 从右向左遍历，遇到 c 就更新 idx
        for (int i = n - 1, idx = 2 * n; i >= 0; --i) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            ans[i] = Math.min(ans[i], idx - i);
        }
        return ans;
    }
}
