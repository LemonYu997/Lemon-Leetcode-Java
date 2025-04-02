package problems.c0easy.t2001t2500;

/**
 * 2264 字符串中最大的 3 位相同数字 https://leetcode.cn/problems/largest-3-same-digit-number-in-string/description/
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，
 * 则认为该整数是一个 优质整数 ：
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 *
 * 示例：
 * 输入1：num = "6777133339"
 * 输出1："777"
 *
 * 输入2：num = "2300019"
 * 输出2："000"
 *
 * 输入3：num = "42352338"
 * 输出3：""
 */
public class T2264 {
    /**
     * 自己实现：遍历，前后与当前字符都一致则记录，并比较是否为最大数字
     */
    public String largestGoodInteger(String num) {
        int max = -1;
        int n = num.length();

        for (int i = 1; i < n; i++) {
            // 因为从 i = 1 开始，因此 i - 1 绝对 >= 0
            if (i + 1 < n
                    && num.charAt(i - 1) == num.charAt(i)
                    && num.charAt(i) == num.charAt(i + 1)) {
                if (num.charAt(i) - '0' > max) {
                    max = num.charAt(i) - '0';
                }
            }
        }

        if (max == -1) {
            return "";
        }
        // 如果不存在，则返回空
        return "" + max + max + max;
    }

    /**
     * 优化解法：依次判断999,888，...，000是否存在即可
     */
    public String largestGoodInteger1(String num) {
        for (char c = '9'; c >= '0'; c--) {
            String s = "" + c + c + c;
            if (num.contains(s)) {
                return s;
            }
        }
        return "";
    }

    /**
     * 再优化：打表
     */
    public String largestGoodInteger2(String num) {
        if (num.contains("999")) {
            return "999";
        } else if (num.contains("888")) {
            return "888";
        } else if (num.contains("777")) {
            return "777";
        } else if (num.contains("666")) {
            return "666";
        } else if (num.contains("555")) {
            return "555";
        } else if (num.contains("444")) {
            return "444";
        } else if (num.contains("333")) {
            return "333";
        } else if (num.contains("222")) {
            return "222";
        } else if (num.contains("111")) {
            return "111";
        } else if (num.contains("000")) {
            return "000";
        }
        return "";
    }
}
