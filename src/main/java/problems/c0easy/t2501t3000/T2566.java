package problems.c0easy.t2501t3000;

/**
 * 2566 替换一个数字后的最大差值 https://leetcode.cn/problems/maximum-difference-by-remapping-a-digit/description/
 * 给你一个整数 num 。你知道 Danny Mittal 会偷偷将 0 到 9 中的一个数字 替换 成另一个数字。
 * 请你返回将 num 中 恰好一个 数字进行替换后，得到的最大值和最小值的差为多少。
 *
 * 注意：
 * 当 Danny 将一个数字 d1 替换成另一个数字 d2 时，Danny 需要将 num 中所有 d1 都替换成 d2 。
 * Danny 可以将一个数字替换成它自己，也就是说 num 可以不变。
 * Danny 可以将数字分别替换成两个不同的数字分别得到最大值和最小值。
 * 替换后得到的数字可以包含前导 0 。
 * Danny Mittal 获得周赛 326 前 10 名，让我们恭喜他。
 *
 * 示例：
 * 输入1：num = 11891
 * 输出1：99009
 *
 * 输入2：num = 90
 * 输出2：99
 */
public class T2566 {
    public static void main(String[] args) {
        minMaxDifference(11891);
    }

    /**
     * 自己实现：
     * 找到最大位非 9 数字，将其全部替换为 9 即为最大值
     * 找到最大位非 0 数字，将其全部替换为 0 即为最小值
     */
    public static int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char maxC = 0;
        char minC = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9' && maxC == 0) {
                maxC = s.charAt(i);
            }
            if (s.charAt(i) != '0' && minC == 0) {
                minC = s.charAt(i);
            }
        }

        // 获取最大值和最小值
        int max = Integer.parseInt(s.replace(maxC, '9'));
        int min = Integer.parseInt(s.replace(minC, '0'));
        return max - min;
    }

    /**
     * 官方解法：优化写法
     */
    public static int minMaxDifference1(int num) {
        String s = Integer.toString(num);
        String t = s;
        int pos = 0;
        // 找到第一个非 9 数字
        while (pos < s.length() && s.charAt(pos) == '9') {
            pos++;
        }
        if (pos < s.length()) {
            s = s.replace(s.charAt(pos), '9');
        }
        t = t.replace(t.charAt(0), '0');
        return Integer.parseInt(s) - Integer.parseInt(t);
    }

}
