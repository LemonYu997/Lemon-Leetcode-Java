package problems.c0easy.t1501t2000;

/**
 * 1790 仅执行一次字符串交换能否使两个字符串相等 https://leetcode.cn/problems/check-if-one-string-swap-can-make-strings-equal/description/
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：
 * 选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 *
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，
 * 返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：s1 = "bank", s2 = "kanb"
 * 输出1：true
 *
 * 输入2：s1 = "attack", s2 = "defend"
 * 输出2：false
 *
 * 输入3：s1 = "kelb", s2 = "kelb"
 * 输出3：true
 */
public class T1790 {
    /**
     * 自己实现：根据题意，遍历一次比对，出现超过两次不同以上返回 false，或者不能互相调换
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        // 记录两个不同的字符索引
        int i1 = -1;
        int i2 = -1;

        for (int i = 0; i < n; i++) {
            // 出现两次以上直接返回false，记录前两次出现的索引
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (i1 == -1) {
                i1 = i;
            } else if (i2 == -1) {
                i2 = i;
            } else {
                return false;
            }
        }

        // 如果一次不同都没有，返回 true
        if (i1 == -1) {
            return true;
        }
        // 如果只有一次，返回 false
        if (i2 == -1) {
            return false;
        }

        // 如果不能互换也返回 false
        return s1.charAt(i1) == s2.charAt(i2) && s1.charAt(i2) == s2.charAt(i1);
    }
}
