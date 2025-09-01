package problems.c0easy.t2501t3000;

/**
 * 2710 移除字符串中的尾随零 https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/description/
 * 给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
 *
 * 示例：
 * 输入1：num = "51230100"
 * 输出1："512301"
 *
 * 输入2：num = "123"
 * 输出2："123"
 */
public class T2710 {
    /**
     * 自己实现：根据题意模拟
     */
    public String removeTrailingZeros(String num) {
        // 如果末尾为0，则去掉
        while (num.endsWith("0")) {
            num = num.substring(0, num.length() - 1);
        }

        return num;
    }

    /**
     * 官方解法：优化实现
     */
    public String removeTrailingZeros1(String num) {
        int len = num.length();
        while (len > 0 && num.charAt(len - 1) == '0') {
            len--;
        }
        return num.substring(0, len);
    }
}
