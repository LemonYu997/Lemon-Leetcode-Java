package problems.c0easy.t2001t2500;

/**
 * 2299 强密码检验器 II https://leetcode.cn/problems/strong-password-checker-ii/description/
 * 如果一个密码满足以下所有条件，我们称它是一个 强 密码：
 * 它有至少 8 个字符。
 * 至少包含 一个小写英文 字母。
 * 至少包含 一个大写英文 字母。
 * 至少包含 一个数字 。
 * 至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
 * 它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
 * 给你一个字符串 password ，如果它是一个 强 密码，返回 true，否则返回 false 。
 *
 * 示例：
 * 输入1：password = "IloveLe3tcode!"
 * 输出1：true
 *
 * 输入2：password = "Me+You--IsMyDream"
 * 输出2：false
 *
 * 输入3：password = "1aB!"
 * 输出3：false
 */
public class T2299 {
    /**
     * 自己实现：遍历每个字符判断
     */
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        // 4 个判断指标 小写字符、大写字符、数字、特殊字符
        boolean hasLow = false;
        boolean hasUp = false;
        boolean hasNum = false;
        boolean hasSpec = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            // 如果存在连续两个相同字符直接返回false
            if (i != 0 && c == password.charAt(i - 1)) {
                return false;
            }

            // 判断四个指标
            if (c >= 'a' && c <= 'z') {
                hasLow = true;
            } else if (c >= 'A' && c <= 'Z') {
                hasUp = true;
            } else if (c >= '0' && c <= '9') {
                hasNum = true;
            } else {
                hasSpec = true;
            }
        }

        return hasLow && hasUp && hasNum && hasSpec;
    }
}
