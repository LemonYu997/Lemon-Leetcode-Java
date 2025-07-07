package problems.c0easy.t2001t2500;

/**
 * 2496 数组中字符串的最大值 https://leetcode.cn/problems/maximum-value-of-a-string-in-an-array/description/
 * 一个由字母和数字组成的字符串的 值 定义如下：
 * 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
 * 否则，值为字符串的 长度 。
 * 给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，
 * 请你返回 strs 中字符串的 最大值
 *
 * 示例：
 * 输入1：strs = ["alic3","bob","3","4","00000"]
 * 输出1：5
 *
 * 输入2：strs = ["1","01","001","0001"]
 * 输出2：1
 */
public class T2496 {
    /**
     * 自己实现：根据题意遍历一次
     */
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (String str : strs) {
            // 判断是否为数字
            boolean isNum = true;
            for (int i = 0; i < str.length(); i++) {
                // 如果不为数组则直接判断长度
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    isNum = false;
                    break;
                }
            }

            if (isNum) {
                ans = Math.max(ans, Integer.parseInt(str));
            } else {
                ans = Math.max(ans, str.length());
            }
        }

        return ans;
    }
}
