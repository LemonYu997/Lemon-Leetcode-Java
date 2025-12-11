package problems.c0easy.t3001t3500;

/**
 * 3019 按键变更的次数 https://leetcode.cn/problems/number-of-changing-keys/description/
 * 给你一个下标从 0 开始的字符串 s ，该字符串由用户输入。按键变更的定义是：使用与上次使用的按键不同的键。
 * 例如 s = "ab" 表示按键变更一次，而 s = "bBBb" 不存在按键变更。
 * 返回用户输入过程中按键变更的次数。
 * 注意：shift 或 caps lock 等修饰键不计入按键变更，也就是说，如果用户先输入字母 'a' 然后输入字母 'A' ，不算作按键变更。
 *
 * 示例：
 * 输入1：s = "aAbBcC"
 * 输出1：2
 *
 * 输入2：s = "AaAaAaaA"
 * 输出2：0
 */
public class T3019 {
    /**
     * 自己实现：先转为纯小写然后判断变化次数即可
     */
    public int countKeyChanges(String s) {
        int ans = 0;
        String temp = s.toLowerCase();
        for (int i = 1; i < temp.length(); i++) {
            if (temp.charAt(i) != temp.charAt(i - 1)) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 官方解法：遍历时转换
     */
    public int countKeyChanges1(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1))) {
                ans++;
            }
        }
        return ans;
    }
}
