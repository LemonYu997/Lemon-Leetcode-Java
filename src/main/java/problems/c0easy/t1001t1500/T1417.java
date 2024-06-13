package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.List;

/**
 * 1417 重新格式化字符串 https://leetcode.cn/problems/reformat-the-string/description/
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。
 * 也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 * 输入1：s = "a0b1c2"
 * 输出1："0a1b2c"
 *
 * 输入2：s = "leetcode"
 * 输出2：""
 *
 * 输入3：s = "1229857369"
 * 输出3：""
 *
 * 输入4：s = "covid2019"
 * 输出4："c2o0v1i9d"
 *
 * 输入5：s = "ab123"
 * 输出5："1a2b3"
 */
public class T1417 {
    /**
     * 官方解法：双指针，先统计数字和字母次数是否满足条件
     * 差值不能大于 1
     */
    public String reformat(String s) {
        int numCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numCount++;
            }
        }
        int letterCount = s.length() - numCount;
        if (Math.abs(numCount - letterCount) > 1) {
            return "";
        }
        int i = 0;  // 数字索引
        int j = 0;  // 字母索引
        // 判断那个次数更多，次数多的先排（即从 0开始）
        if (numCount > letterCount) {
            j++;
        } else {
            i++;
        }

        char[] ans = new char[s.length()];

        char[] chars = s.toCharArray();
        for (int k = 0; k < chars.length; k++) {
            if (Character.isDigit(chars[k])) {
                ans[i] = chars[k];
                i += 2;
            } else {
                ans[j] = chars[k];
                j += 2;
            }
        }

        return new String(ans);
    }
}
