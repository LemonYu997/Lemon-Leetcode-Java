package problems.c0easy.t1501t2000;

/**
 * 1576 替换所有的问号 https://leetcode.cn/problems/replace-all-s-to-avoid-consecutive-repeating-characters/description/
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，
 * 请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 *
 * 注意：你 不能 修改非 '?' 字符。
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，
 * 请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 *
 * 示例：
 * 输入1：s = "?zs"
 * 输出1："azs"
 *
 * 输入2：s = "ubv?w"
 * 输出2："ubvaw"
 */
public class T1576 {
    /**
     * 官方解法：遍历扫描
     */
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                // 题目只需要不连续重复，因此只用判断前后字符是否重复即可，只需要 abc 三个字符选择填充即可
                for (char ch = 'a'; ch <= 'c'; ch++) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}
