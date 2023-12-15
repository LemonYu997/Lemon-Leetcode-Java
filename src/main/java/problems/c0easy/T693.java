package problems.c0easy;

/**
 * 693 交替位二进制数 https://leetcode.cn/problems/binary-number-with-alternating-bits/
 * 给定一个正整数，检查其二进制表示是否总为0、1交替出现，即相邻二进制位不同
 *
 * 示例：
 * 输入1：n = 5
 * 输出1：true
 * 备注：5 的二进制表示是：101
 *
 * 输入2：n = 7
 * 输出2：false
 * 备注：7 的二进制表示是：111
 *
 * 输入3：n = 11
 * 输出3：false
 * 备注：11 的二进制表示是：1011
 */
public class T693 {
    /**
     * 自己实现：调API
     */
    public boolean hasAlternatingBits(int n) {
        if (n == 1) {
            return true;
        }

        //调API实现
        String s = Integer.toBinaryString(n);

        //和上一位进行比较即可，因为只用判断相邻两位，所以不需要进行反转
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 官方解法1：位运算遍历每一位
     */
    public boolean hasAlternatingBits1(int n) {
        //上一位的值
        int prev = -1;

        while (n != 0) {
            //且运算，得到当前最低位的值（因为1的二进制码是 000...0001）
            int u = n & 1;
            //异或运算，只有相等才会输出0，如果为0说明和上一位相同
            //初始时上一位是-1，二进制为 111...111。此时不管和 1 异或还是和 0 异或都不会为 0
            if ((prev ^ u) == 0) {
                return false;
            }
            //更新上一位的值
            prev = u;
            //向右移动一位
            n = n >> 1;
        }

        return true;
    }

    /**
     * 官方解法2：位运算推测
     * 如果一个数是 1010101，那么它向右移动一位是 0101010，两者异或为 1111111，
     * 再将其加 1 为 1000000，用 01111111 & 10000000 为 0
     */
    public boolean hasAlternatingBits2(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
