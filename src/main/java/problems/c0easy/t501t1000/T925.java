package problems.c0easy.t501t1000;

/**
 * 925 长按键入 https://leetcode.cn/problems/long-pressed-name/
 * 使用键盘输入一个名字 name，在键入字符 c 时，按键可能会被长按，字符可能被输入 1 次或多次
 * 检查键盘输入的字符 typed，如果它对应的是名字 name，其中一些字符可能被长按，返回true
 *
 * 示例：
 * 输入1：name = "alex", typed = "aaleex"
 * 输出1：true
 *
 * 输入2：name = "saeed", typed = "ssaaedd"
 * 输出2：false
 */
public class T925 {
    /**
     * 自己实现：同时遍历两个字符串
     */
    public boolean isLongPressedName(String name, String typed) {
        int m = name.length();
        int n = typed.length();
        // 首先判断长度，typed 长度必须大于等于 name
        if (n < m) {
            return false;
        }
        int i = 0;
        int j = 0;

        // 一定要把 name 遍历完
        while (i < m) {
            // 如果 name 没遍历完，typed先遍历完了，返回false
            if (j >= n) {
                return false;
            }
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if (c1 != c2) {
                // 如果当前两个字符不一致，且 typed 也不和上一个字符一致，返回false
                if (j == 0 || (j > 1 && c2 != typed.charAt(j - 1))) {
                    return false;
                }
                // 如果 typed 当前字符和上一个字符一致，跳过该字符
                j++;
            } else {
                // 如果两个字符一致，同时++
                i++;
                j++;
            }
        }

        // 如果 typed 还没遍历完，那剩下的字符都必须和当前字符一样
        while (j < n) {
            if (typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            }
            j++;
        }

        return true;
    }

    /**
     * 官方解法：优化写法
     */
    public boolean isLongPressedName1(String name, String typed) {
        int i = 0;
        int j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}