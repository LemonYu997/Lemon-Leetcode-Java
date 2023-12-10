package demo.c0easy;

/**
 * 717 1 比特与 2 比特字符 https://leetcode.cn/problems/1-bit-and-2-bit-characters/
 * 有两种特殊字符：
 *  第一种字符可以用一比特 0 表示
 *  第二种字符可以用两比特（10 或 11）表示
 * 给定一个以0为结尾的二进制数组 bits，如果最后一个字符必须是一个一比特字符，返回true
 *
 * 示例：
 * 输入1：bits = [1, 0, 0]
 * 输出1：true
 * 备注：唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 *
 * 输入2：bits = [1,1,1,0]
 * 输出2：false
 * 备注：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 */
public class T717 {
    /**
     * 自己实现：根据定义
     * 首先最后一位必须为0
     * 正序遍历，遇到1，下一位必须是1或0，可以直接走两步，遇到0，走一步
     */
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if (bits[n - 1] == 1) {
            return false;
        }

        //遇到1，下一位必须是1或0，可以直接走两步，遇到0，走一步
        for (int i = 0; i < n; i++) {
            //如果刚好只剩一位，且为0，则返回真
            if (i == n - 1) {
                return true;
            }
            if (bits[i] == 1) {
                i++;
            }
        }

        return false;
    }

    /**
     * 官方解法1：正序遍历
     * 遇到1跳两步，遇到0跳一步，判断最后索引是否为最后一位(n - 1)
     */
    public boolean isOneBitCharacter1(int[] bits) {
        int n = bits.length;
        int i = 0;

        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i++;
            }
        }

        return i == n - 1;
    }
}
