package problems.c0easy.t2001t2500;

/**
 * 2243 计算字符串的数字和 https://leetcode.cn/problems/calculate-digit-sum-of-a-string/description/
 * 给你一个由若干数字（0 - 9）组成的字符串 s ，和一个整数。
 * 如果 s 的长度大于 k ，则可以执行一轮操作。在一轮操作中，需要完成以下工作：
 * 将 s 拆分 成长度为 k 的若干 连续数字组 ，使得前 k 个字符都分在第一组，
 * 接下来的 k 个字符都分在第二组，依此类推。注意，最后一个数字组的长度可以小于 k 。
 * 用表示每个数字组中所有数字之和的字符串来 替换 对应的数字组。
 * 例如，"346" 会替换为 "13" ，因为 3 + 4 + 6 = 13 。
 * 合并 所有组以形成一个新字符串。如果新字符串的长度大于 k 则重复第一步。
 * 返回在完成所有轮操作后的 s 。
 *
 * 示例：
 * 输入1：s = "11111222223", k = 3
 * 输出1："135"
 *
 * 输入2：s = "00000000", k = 3
 * 输出2："000"
 */
public class T2243 {
    /**
     * 自己实现：根据题意模拟
     */
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > k) {
            // 先转数组，将其按 k 分组
            char[] chars = sb.toString().toCharArray();
            int n = chars.length;
            // 清空字符串
            sb.delete(0, n);

            // 按 k 分组，这里要注意最后的数不足 k 个时也要单独分组
            for (int i = 0; i < n; i += k) {
                // 当前组的值
                int temp = 0;
                for (int j = i; j < i + k && j < n; j++) {
                    temp += chars[j] - '0';
                }
                // 添加当前组的值
                sb.append(temp);
            }
        }

        return sb.toString();
    }

    /**
     * 社区解法：递归
     */
    public String digitSum1(String s, int k) {
        // 退出条件
        if (s.length() <= k) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int len = s.length();
        // 分组计算
        for (int i = 0; i < len; i += k) {
            int sum = 0;
            for (int j = i; j < i + k && j < len; j++) {
                sum += (s.charAt(j) - '0');
            }
            sb.append(sum);
        }

        // 新的递归参数
        return digitSum(sb.toString(), k);
    }
}