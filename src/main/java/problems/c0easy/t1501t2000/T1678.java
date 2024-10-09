package problems.c0easy.t1501t2000;

/**
 * 1678 设计 Goal 解析器 https://leetcode.cn/problems/goal-parser-interpretation/description/
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，
 * "(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 * 示例：
 * 输入1：command = "G()(al)"
 * 输出1："Goal"
 *
 * 输入2：command = "G()()()()(al)"
 * 输出2："Gooooal"
 *
 * 输入3：command = "(al)G(al)()()G"
 * 输出3："alGalooG"
 */
public class T1678 {
    /**
     * 自己实现：根据提议模拟，一次遍历
     */
    public String interpret(String command) {
        int n = command.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    // 将 () 转为 o，索引要向前一位
                    sb.append('o');
                    i++;
                } else if (command.charAt(i + 1) == 'a') {
                    // 说明此时是 (al) i 向后跳 3位
                    sb.append("al");
                    i += 3;
                }
            }
        }

        return sb.toString();
    }
}
