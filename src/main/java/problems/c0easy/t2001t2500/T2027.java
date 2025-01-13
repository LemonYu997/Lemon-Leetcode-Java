package problems.c0easy.t2001t2500;

/**
 * 2027 转换字符串的最少操作次数 https://leetcode.cn/problems/minimum-moves-to-convert-string/description/
 * 给你一个字符串 s ，由 n 个字符组成，
 * 每个字符不是 'X' 就是 'O' 。
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。
 * 注意，如果字符已经是 'O' ，只需要保持 不变 。
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 *
 * 示例：
 * 输入1：s = "XXX"
 * 输出1:1
 *
 * 输入2：s = "XXOX"
 * 输出2：2
 *
 * 输入3：s = "OOOO"
 * 输出3:0
 */
public class T2027 {
    /**
     * 自己实现：根据题意模拟
     */
    public int minimumMoves(String s) {
        int ans = 0;

        // 如果有连续3个以下的X，就只算一次，遇到其他字符就算另一次
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果count计数已至 3，就重置
            if (count == 3) {
                count = 0;
            }
            // 如果是当前次数第首个X，需要加一个操作次数
            if (s.charAt(i) == 'X' && count == 0) {
                ans++;
                count++;
            } else if (count < 3 && count > 0) {
                // 如果count已经开始计数，就要连续计数最多3次
                count++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：优化解法
     */
    public int minimumMoves1(String s) {
        int ans = 0;
        // 表示 ans 操作次数内最多可以转换的字符数
        int covered = -1;

        for (int i = 0; i < s.length(); i++) {
            // 当前字符为 X 且不在本次操作数内，需要进行一次新的操作
            if (s.charAt(i) == 'X' && i > covered) {
                ans++;
                covered = i + 2;
            }
        }

        return ans;
    }

    /**
     * 优化解法：减少变量
     */
    public int minimumMoves2(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            // 如果当前为 X，需要进行操作，并且直接操作三位
            if (s.charAt(i) == 'X') {
                i += 2;
                ans++;
            }
        }

        return ans;
    }
}