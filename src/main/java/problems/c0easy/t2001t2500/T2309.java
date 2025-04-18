package problems.c0easy.t2001t2500;

/**
 * 2309 兼具大小写的最好英文字母 https://leetcode.cn/problems/greatest-english-letter-in-upper-and-lower-case/description/
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。
 * 返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 *
 * 示例：
 * 输入1：s = "lEeTcOdE"
 * 输出1："E"
 *
 * 输入2：s = "arRAzFif"
 * 输出2："R"
 *
 * 输入3：s = "AbCdEfGhIjK"
 * 输出3：""
 */
public class T2309 {
    /**
     * 自己实现：记录每个字母是否都存在大小写即可
     */
    public String greatestLetter(String s) {
        // flag[i][0] 表示第 i 个字母是否存在小写 flag[i][1] 表示其是否存在大写
        int[][] flag = new int[26][2];

        // 记录
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                flag[c - 'a'][0] = 1;
            } else {
                flag[c - 'A'][1] = 1;
            }
        }

        // 要返回字母表中最靠后的字母
        for (int i = 25; i >= 0; i--) {
            // 如果同时存在该字母大小写，则记录到答案中 大写
            if (flag[i][0] == 1 && flag[i][1] == 1) {
                return String.valueOf((char) (i + 'A'));
            }
        }

        return "";
    }

    /**
     * 官方解法：使用位运算标记，int整型有32位可以覆盖26个字母
     */
    public String greatestLetter1(String s) {
        int lower = 0;
        int upper = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                lower |= 1 << (c - 'a');
            } else {
                upper |= 1 << (c - 'A');
            }
        }

        for (int i = 25; i >= 0; i--) {
            if ((lower & upper & (1 << i)) != 0) {
                return String.valueOf((char) (i + 'A'));
            }
        }

        return "";
    }

    /**
     * 社区解法：遍历26个字母字符串中是否存在即可
     */
    public String greatestLetter2(String s) {
        int a = 'A';
        int z = 'Z';

        // 倒序遍历26个字母，找到字母表中最大的字母
        for (int i = z; i >= a; i--) {
            // 大小写都是否存在
            if (s.indexOf((char) i) >= 0 && s.indexOf((char) (i + 32)) >= 0) {
                return String.valueOf((char) i);
            }
        }

        return "";
    }
}
