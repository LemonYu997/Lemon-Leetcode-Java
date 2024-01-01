package problems.c0easy;

/**
 * 859 亲密字符串 https://leetcode.cn/problems/buddy-strings/
 * 给定两个字符串 s 和 goal，只要可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 * 示例：
 * 输入1：s = "ab", goal = "ba"
 * 输出1：true
 *
 * 输入2：s = "ab", goal = "ab"
 * 输出2：false
 *
 * 输入3：s = "aa", goal = "aa"
 * 输出3：true
 */
public class T859 {
    /**
     * 自己实现：使用数组 int[26] 对每个字符计数 （因为只包含小写字母）
     * 先判断 s 和 goal 长度是否相等
     * 判断
     */
    public boolean buddyStrings(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        //先判断 s 和 goal 长度是否相等
        if (m != n) {
            return false;
        }

        // 分两种情况，如果 s 和 goal 一致
        if (s.equals(goal)) {
            //只要判断 s 中有两个重复字符，就可以互相替换，返回 true 即可
            int[] chars = new int[26];
            for (int i = 0; i < m; i++) {
                chars[s.charAt(i) - 'a']++;
                if (chars[s.charAt(i)- 'a'] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            //如果 s 和 goal 不一致
            //同时遍历两个字符串，找到不一致的字符（只能两个），然后判断是否能替换
            char[] sc = new char[2];    // s 中和 goal 不一致的字符
            char[] gc = new char[2];    // goal 中和 s 中不一致的字符
            int count = 0;  // 不一致字符的索引数 最多两个 即最大值 1
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    count++;    //计数
                    if (count > 2) {
                        return false;
                    }
                    //char[] 索引从0开始
                    sc[count - 1] = s.charAt(i);
                    gc[count - 1] = goal.charAt(i);
                }
            }

            //只能有两个不一致的字符，然后判断是否能替换
            if (count == 2 && sc[0] == gc[1] && sc[1] == gc[0]) {
                return true;
            } else {
                return false;
            }
        }
    }
}
