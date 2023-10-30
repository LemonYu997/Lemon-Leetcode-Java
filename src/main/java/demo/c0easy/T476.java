package demo.c0easy;

/**
 * 476 数字的补数 https://leetcode.cn/problems/number-complement/
 * 对整数的二进制表示取反（0变1,1变0）后，再转换为十进制表示，可以得到这个整数的补数
 *
 * 示例：
 * 输入1：num = 5
 * 输出1:2
 * 备注：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 *
 * 输入2：num = 1
 * 输出2:0
 */
public class T476 {
    /**
     * 自己实现：先转为字符串，0和1互换后再转回去
     */
    public int findComplement(int num) {
        //将int转为二进制字符串
        char[] numcs = Integer.toBinaryString(num).toCharArray();

        for (int i = 0; i < numcs.length; i++) {
            if (numcs[i] == '0') {
                numcs[i] = '1';
            } else {
                numcs[i] = '0';
            }
        }

        //将二进制字符串转回int
        return Integer.parseInt(new String(numcs), 2);
    }

    /**
     * 官方解法：位运算
     */
    public int findComplement1(int num) {
        int highbit = 0;
        for (int i = 0; i <= 30; i++) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
}
