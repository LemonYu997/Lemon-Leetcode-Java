package problems.c0easy.t2001t2500;

/**
 * 2259 移除指定数字得到的最大结果 https://leetcode.cn/problems/remove-digit-from-number-to-maximize-result/description/
 * 给你一个表示某个正整数的字符串 number 和一个字符 digit 。
 * 从 number 中 恰好 移除 一个 等于 digit 的字符后，找出并返回按 十进制 表示 最大 的结果字符串。生成的测试用例满足 digit 在 number 中出现至少一次。
 *
 * 示例：
 * 输入1：number = "123", digit = "3"
 * 输出1："12"
 *
 * 输入2：number = "1231", digit = "1"
 * 输出2："231"
 *
 * 输入3：number = "551", digit = "5"
 * 输出3："51"
 */
public class T2259 {
    /**
     * 自己实现：遍历所有可能
     * 如果 number 位数过长会出现越界的情况
     */
    public String removeDigit(String number, char digit) {
        int n = number.length();
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                StringBuilder temp = new StringBuilder(number);
                max = Math.max(max, Integer.parseInt(temp.deleteCharAt(i).toString()));
            }
        }

        return String.valueOf(max);
    }

    /**
     * 自己实现：找到每一值为 digit 的位，并找到下一位大于当前位的时候
     * 如果没有下一位就相当于最后一位，直接删除
     */
    public String removeDigit1(String number, char digit) {
        int n = number.length();
        StringBuilder sb = new StringBuilder(number);
        // 要删除的索引位置
        int index = -1;

        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                index = i;
                // 如果下一位比当前位大，则可以直接退出，如果不满足，则继续遍历（相当于继续往后推）
                if (i < n - 1 && number.charAt(i + 1) > number.charAt(i)) {
                    break;
                }
            }
        }
        return sb.deleteCharAt(index).toString();
    }
}
