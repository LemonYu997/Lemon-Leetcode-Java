package problems.c0easy.t501t1000;

/**
 * 520 检测大写字母 https://leetcode.cn/problems/detect-capital/
 * 规定以下情况是正常的：
 * 1、全部字母是大写，如 USA
 * 2、所有字母均不是大写，如 leetcode
 * 3、只有首字母大写，如 Google
 *
 * 示例：
 * 输入1：word = "USA"
 * 输出1：true
 *
 * 输入2：word = "FlaG"
 * 输出2：false
 */
public class T520 {
    /**
     * 自己实现，根据定义
     * 首字母大写，剩下的要么全大写，要么全小写
     * 首字母小写，剩下的只能全小写
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        char[] chars = word.toCharArray();
        //首字母是否大写
        boolean firstC = Character.isUpperCase(chars[0]);
        //首字母小写的话，第二个字母只能小写
        if (!firstC && Character.isUpperCase(chars[1])) {
            return false;
        }

        //判断余下字母
        for (int i = 2; i < chars.length; i++) {
            //首字母大写，剩下的要么全大写，要么全小写
            if (firstC) {
                if (Character.isUpperCase(chars[i]) != Character.isUpperCase(chars[i - 1])) {
                    return false;
                }
            } else {
                //首字母小写，剩下的只能全小写
                if (Character.isUpperCase(chars[i]) || Character.isUpperCase(chars[i - 1])) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 官方解法1：先转换再判断
     */
    public boolean detectCapitalUse1(String word) {
        //全大写或者全小写 正确
        if (word.toUpperCase().equals(word) || word.toLowerCase().equals(word)) {
            return true;
        }
        int n = word.length();
        int index = 1;
        //如果首字母大写，余下字母必须全是小写
        if (Character.isUpperCase(word.charAt(0))) {
            while (index < n && Character.isLowerCase(word.charAt(index))) {
                index++;
            }
        }

        return index == n;
    }
}
