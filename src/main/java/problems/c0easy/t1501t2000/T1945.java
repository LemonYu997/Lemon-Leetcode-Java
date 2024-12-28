package problems.c0easy.t1501t2000;

/**
 * 1945 字符串转化后的各位数字之和 https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/description/
 * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。你的任务是通过一种特殊处理将字符串转为整数，
 * 然后通过重复对它的数位求和 k 次来进行转换。更具体地说，执行以下步骤：
 *
 * 用字母在字母表中的位置 替换 该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。
 * 接着，将整数 转换 为其 各位数字之和 。
 * 共重复 转换 操作（第 2 步） k 次 。
 * 例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
 *
 * 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * 转换 #2：17 ➝ 1 + 7 ➝ 8
 * 返回执行上述 操作 后得到的 结果整数。
 *
 * 示例：
 * 输入1：s = "iiii", k = 1
 * 输出1：36
 *
 * 输入2：s = "leetcode", k = 2
 * 输出2：6
 *
 * 输入3：s = "zbax", k = 2
 * 输出3：8
 */
public class T1945 {
    /**
     * 自己实现：根据题意模拟
     */
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        // 先将字符转为数字字符串
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }

        // 先执行一次位数合并操作，将字符串转为数字
        int ans = 0;
        String temp = sb.toString();
        for (int i = 0; i < temp.length(); i++) {
            ans += temp.charAt(i) - '0';
        }

        // 在执行剩下 k - 1 次操作
        for (int i = 1; i < k; i++) {
            int num = 0;
            while (ans > 0) {
                num += ans % 10;
                ans /= 10;
            }
            ans = num;
        }

        return ans;
    }

    /**
     * 优化解法：在第一次转换数字字符串的时候直接相加位数
     */
    public int getLucky1(String s, int k) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;
            // 有时候 num 会是两位数，这里需要加两次
            ans += num % 10;
            num /= 10;
            ans += num % 10;
        }

        // 在执行剩下 k - 1 次操作
        for (int i = 1; i < k; i++) {
            int num = 0;
            while (ans > 0) {
                num += ans % 10;
                ans /= 10;
            }
            ans = num;
        }

        return ans;
    }
}
