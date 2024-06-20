package problems.c0easy.t1001t1500;

/**
 * 1446 连续字符 https://leetcode.cn/problems/consecutive-characters/description/
 * 给你一个字符串 s ，字符串的「能量」定义为：
 * 只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串 s 的 能量。
 *
 * 示例：
 * 输入1：s = "leetcode"
 * 输出1:2
 *
 * 输入2：s = "abbcccddddeeeeedcba"
 * 输出2：5
 */
public class T1446 {
    /**
     * 自己实现：遍历一次，统计连续相同字符的最长字数
     */
    public int maxPower(String s) {
        int ans = 1;
        int temp = 1;
        for (int i = 1; i < s.length(); i++) {
            // 相同字符出纳加次数
            if (s.charAt(i) == s.charAt(i - 1)) {
                temp++;
            } else {
                // 重置次数
                ans = Math.max(ans, temp);
                temp = 1;
            }
        }

        //最后还要比较一次
        ans = Math.max(ans, temp);
        return ans;
    }
}
