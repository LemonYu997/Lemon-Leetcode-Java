package problems.c0easy.t2001t2500;

import java.util.*;

/**
 * 2231 按奇偶性交换后的最大数字 https://leetcode.cn/problems/largest-number-after-digit-swaps-by-parity/description/
 * 给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。
 * 返回交换 任意 次之后 num 的 最大 可能值。
 *
 * 示例：
 * 输入1：num = 1234
 * 输出1：3412
 *
 * 输入2：num = 65875
 * 输出2：87655
 */
public class T2231 {
    /**
     * 自己实现：即将奇数或偶数分开，分别倒序排列再组合在一起即可
     * */
    public int largestInteger(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int n = chars.length;
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int temp = chars[i] - '0';
            if (temp % 2 == 1) {
                odds.add(temp);
            } else {
                evens.add(temp);
            }
        }

        odds.sort(Collections.reverseOrder());
        evens.sort(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int temp = chars[i] - '0';
            // 如果当前数为奇数或偶数，替换为排序后最大的那个
            if (temp % 2 == 1) {
                chars[i] = (char) (odds.remove(0) + '0');
            } else {
                chars[i] = (char) (evens.remove(0) + '0');
            }
        }

        return Integer.parseInt(new String(chars));
    }

    /**
     * 官方解法：优化，原地选择排序
     */
    public int largestInteger1(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int n = chars.length;

        // 选择排序
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 只有两个下标对应的数值奇偶相同才进行判断
                // 由于数字对应的 char 在 ascii 码值中相减也不影响判断
                if ((chars[i] - chars[j]) % 2 == 0 && chars[i] < chars[j]) {
                    char temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                }
            }
        }

        return Integer.parseInt(new String(chars));
    }
}
