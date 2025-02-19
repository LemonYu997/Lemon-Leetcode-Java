package problems.c0easy.t2001t2500;

/**
 * 2138 将字符串拆分为若干长度为 k 的组 https://leetcode.cn/problems/divide-a-string-into-groups-of-size-k/description/
 * 示例 ：
 * 字符串 s 可以按下述步骤划分为若干长度为 k 的组：
 * 第一组由字符串中的前 k 个字符组成，第二组由接下来的 k 个字符串组成，
 * 依此类推。每个字符都能够成为 某一个 组的一部分。
 * 对于最后一组，如果字符串剩下的字符 不足 k 个，
 * 需使用字符 fill 来补全这一组字符。
 * 注意，在去除最后一个组的填充字符 fill（如果存在的话）并按顺序连接所有的组后，
 * 所得到的字符串应该是 s 。
 * 给你一个字符串 s ，以及每组的长度 k 和一个用于填充的字符 fill ，
 * 按上述步骤处理之后，返回一个字符串数组，该数组表示 s 分组后 每个组的组成情况 。
 *
 * 输入1：s = "abcdefghi", k = 3, fill = "x"
 * 输出1：["abc","def","ghi"]
 *
 * 输入2：s = "abcdefghij", k = 3, fill = "x"
 * 输出2：["abc","def","ghi","jxx"]
 */
public class T2138 {
    public static void main(String[] args) {
        String s = "abcdefghij";
        String[] ans = divideString(s, 3, 'x');
        System.out.println(ans);
    }

    /**
     * 自己实现：根据题意模拟
     */
    public static String[] divideString(String s, int k, char fill) {
        int n = s.length();
        // 向上取整
        int m = (int) Math.ceil((double) n / k);
        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            // 如果剩下字符数量满足 k 个，直接填充
            if ((i + 1) * k < n) {
                ans[i] = s.substring(i * k, (i + 1) * k);
            } else {
                // 剩下不足的用 fill 补齐
                StringBuilder temp = new StringBuilder(s.substring(i * k, n));
                int count = temp.length();
                while (count < k) {
                    temp.append(fill);
                    count++;
                }
                ans[i] = temp.toString();
            }
        }

        return ans;
    }
}
