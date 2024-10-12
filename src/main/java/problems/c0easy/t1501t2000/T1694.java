package problems.c0easy.t1501t2000;

/**
 * 1694 重新格式化电话号码 https://leetcode.cn/problems/reformat-phone-number/description/
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 *
 * 请你按下述方式重新格式化电话号码。
 *
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 *
 * 返回格式化后的电话号码。
 *
 * 示例：
 * 输入1：number = "1-23-45 6"
 * 输出1："123-456"
 *
 * 输入2：number = "123 4-567"
 * 输出2："123-45-67"
 *
 * 输入3：number = "123 4-5678"
 * 输出3："123-456-78"
 *
 * 输入4：number = "12"
 * 输出4："12"
 *
 * 输入5：number = "--17-5 229 35-39475 "
 * 输出5："175-229-353-94-75"
 */
public class T1694 {
    /**
     * 官方解法：根据题意，先获取数字，再进行拼接
     */
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        // 收集数字
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        int n = sb.length();
        int index = 0;
        StringBuilder ans = new StringBuilder();
        // 进行处理
        while (n > 0) {
            // 不是最后4个，就拼接三个数字
            if (n > 4) {
                ans.append(sb.substring(index, index + 3)).append("-");
                index += 3;
                n -= 3;
            } else {
                // 最后剩4个，2个2个拼接
                if (n == 4) {
                    ans.append(sb.substring(index, index + 2)).append("-").append(sb.substring(index + 2, index + 4));
                } else {
                    // 不足4个时，剩下的全部拼上
                    ans.append(sb.substring(index, index + n));
                }
                break;
            }
        }
        return ans.toString();
    }
}
