package problems.c0easy.t2501t3000;

/**
 * 2678 老人的数目 https://leetcode.cn/problems/number-of-senior-citizens/description/
 * 给你一个下标从 0 开始的字符串 details 。details 中每个元素都是一位乘客的信息，
 * 信息用长度为 15 的字符串表示，表示方式如下：
 *
 * 前十个字符是乘客的手机号码。
 * 接下来的一个字符是乘客的性别。
 * 接下来两个字符是乘客的年龄。
 * 最后两个字符是乘客的座位号。
 * 请你返回乘客中年龄 严格大于 60 岁 的人数。
 *
 * 示例：
 * 输入1：details = ["7868190130M7522","5303914400F9211","9273338290F4010"]
 * 输出1：2
 *
 * 输入2：details = ["1313579440F2036","2921522980M5644"]
 * 输出2：0
 */
public class T2678 {
    /**
     * 自己实现：根据题意取值即可
     */
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 优化解法：直接取数
     */
    public int countSeniors1(String[] details) {
        int ans = 0;
        for (String detail : details) {
            int a = detail.charAt(11) - '0';
            int b = detail.charAt(12) - '0';
            if (a * 10 + b > 60) {
                ans++;
            }
        }
        return ans;
    }
}
