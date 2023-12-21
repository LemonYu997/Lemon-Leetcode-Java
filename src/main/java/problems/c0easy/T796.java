package problems.c0easy;

/**
 * 796 旋转字符串 https://leetcode.cn/problems/rotate-string/
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 *
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *
 * 示例：
 * 输入1：s = "abcde", goal = "cdeab"
 * 输出1：true
 *
 * 输入2：s = "abcde", goal = "abced"
 * 输出2：false
 */
public class T796 {
    /**
     * 自己实现：根据定义模拟
     * 每个字符都反转一次去比较
     */
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) {
            return false;
        }

        char[] sChars = s.toCharArray();
        for (int i = 0; i < m; i++) {
            String now = rotate(sChars, m);

            //比较和 goal 字符串是否相等
            if (now.equals(goal)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 将首字母放在最后，剩下的全体向前移动一位
     */
    private String rotate(char[] sChars, int m) {
        char temp = sChars[0];
        for (int i = 0; i < m - 1; i++) {
            sChars[i] = sChars[i + 1];
        }
        sChars[m - 1] = temp;

        return new String(sChars);
    }

    /**
     * 官方解法1：模拟
     * 假设 s 旋转 i 位，则与 goal 中的某个字符 goal[j] 对应的原 s 中字符应该是
     * s[(i+j) mod n]，在固定 i 的情况下，遍历所有 j，如果全相同，返回 true
     */
    public boolean rotateString1(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                //比较偏移的每一位是否与 goal 一致
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    //改变偏移量 再次循环
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }

        return false;
    }

    /**
     * 官方解法2：搜索子字符串
     * 字符串 s + s 包含了所有 s 可以通过旋转操作得到的字符串
     * 只需要寻找其中是否有 goal 即可
     */
    public boolean rotateString2(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}