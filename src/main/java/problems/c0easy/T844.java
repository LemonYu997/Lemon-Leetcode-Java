package problems.c0easy;

/**
 * 844 比较含退格的字符串 https://leetcode.cn/problems/backspace-string-compare/
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 如果两者相等，返回 true 。# 代表退格字符。
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例：
 * 输入1：s = "ab#c", t = "ad#c"
 * 输出1：true
 *
 * 输入2：s = "ab##", t = "c#d#"
 * 输出2：true
 *
 * 输入3：s = "a#c", t = "b"
 * 输出3：false
 */
public class T844 {
    /**
     * 自己实现：生成各自退格后的字符串，然后再比较
     */
    public boolean backspaceCompare(String s, String t) {
        String ss = getRealString(s);
        String tt = getRealString(t);

        return ss.equals(tt);
    }

    public String getRealString(String str) {
        StringBuilder sb = new StringBuilder();
        int si = 0; //s 的实际长度
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (si - 1 >= 0) {
                    //删除上一个字符，实际长度 - 1
                    sb.delete(si - 1, si);
                    si--;
                }
            } else {
                //添加当前字符，实际长度 + 1
                sb.append(str.charAt(i));
                si++;
            }
        }
        return sb.toString();
    }

    /**
     * 官方解法：双指针逆向遍历
     */
    public boolean backspaceCompare1(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        // 当前需要删除字符的数量 遇到 # 就加一
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    //遇到 #，要删除字符的数量 + 1
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    // 如果有要删除的单词，就直接跳过
                    skipS--;
                    i--;
                } else {
                    // 正常字符
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            //两个字符串都没到结尾时
            if (i >= 0 && j >= 0) {
                //比较当前两个字符是否相等
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else {
                //如果只有一个字符串走到结尾时，也不相等
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
