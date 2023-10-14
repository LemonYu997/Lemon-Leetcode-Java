package demo.c0easy;

/**
 * 338 比特位计数 https://leetcode.cn/problems/counting-bits/
 * 给定一个整数n，对于0 <= i <= n中的每一个i，计算其二进制表示中1的个数
 * 返回一个长度为 n + 1的数组ans作为答案
 *
 * 示例：
 * 输入1：n = 2
 * 输出1：[0,1,1]
 * 备注：
 *      0 --> 0
 *      1 --> 1
 *      2 --> 10
 *
 * 输入2：n = 5
 * 输出2：[0,1,1,2,1,2]
 * 备注：
 *      0 --> 0
 *      1 --> 1
 *      2 --> 10
 *      3 --> 11
 *      4 --> 100
 *      5 --> 101
 */
public class T338 {
    /**
     * 自己实现：将int转为二进制字符串
     */
    public int[] countBits(int n) {
        //答案集
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            //将int转为bit字符串
            char[] cs = Integer.toBinaryString(i).toCharArray();
            int count = 0;
            for (char c : cs) {
                if (c == '1') {
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }

    /**
     * 官方解法1：位运算
     */
    public int[] countBits1(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = countOnes(i);
        }
        return ans;
    }

    public int countOnes(int x) {
        int count = 0;
        while (x > 0) {
            x &= (x - 1);
            count++;
        }
        return count;
    }
}
