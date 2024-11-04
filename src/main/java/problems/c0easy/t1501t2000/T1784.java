package problems.c0easy.t1501t2000;

/**
 * 1784 检查二进制字符串字段 https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description/
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，
 * 返回 true 。否则，返回 false 。
 *
 * 示例：
 * 输入1：s = "1001"
 * 输出1：false
 *
 * 输入2：s = "110"
 * 输出2：true
 */
public class T1784 {
    /**
     * 自己实现：根据题意模拟，记录多个 1 出现是否中断
     */
    public boolean checkOnesSegment(String s) {
        // 判断初始值是否为 1
        int count = s.charAt(0) == '1' ? 1 : 0;

        for (int i = 1; i < s.length(); i++) {
            // 记录间断的 1 出现的次数
            if (s.charAt(i) == '1' && s.charAt(i - 1) != '1') {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 官方解放：变换思路，只要字符串中存在 01 即不符合条件
     */
    public boolean checkOnesSegment1(String s) {
        return !s.contains("01");
    }
}
