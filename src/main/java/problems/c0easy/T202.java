package problems.c0easy;

/**
 * 202 快乐数 https://leetcode.cn/problems/happy-number/
 * 判断给定的数n是不是快乐数
 * 快乐数：
 *      对于一个正整数，每一次将该数替换为它每个位置上数字的平方和
 *      重复这个过程直到这个数变为1，可能是无限循环但始终变不到1
 *      如果这个过程结果为1，那么这个数就是快乐数
 *
 * 示例：
 * 输入1：n = 19
 * 输出1：true
 * 解释：
 *      1^2 + 9^2 = 82
 *      8^2 + 2^2 = 68
 *      6^2 + 8^2 = 100
 *      1^2 + 0^2 + 0^2 = 1
 *
 * 输入2：n=2
 * 输出2：false
 */
public class T202 {
    public static void main(String[] args) {
        System.out.println(isHappy1(7));
    }

    /**
     * 自己实现：按定义去推测，退出条件用能确定不是快乐数的个位数确定
     */
    public static boolean isHappy1(int n) {
        while (n != 1) {
            char[] chars = Integer.toString(n).toCharArray();
            //个位数除了1和7，其他都不是
            if (chars.length < 2 && chars[0] != '1' && chars[0] != '7') {
                return false;
            }

            n = 0;
            for (char c : chars) {
                int num = Character.getNumericValue(c);
                n += num * num;
            }
        }

        return true;
    }

    /**
     * 自己实现的方法进行优化
     */
    public static boolean isHappy2(int n) {
        while (true) {
            if (n == 1 || n == 7) {
                return true;
            }
            if (n <= 9) {
                return false;
            }

            int temp = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }

            n = temp;
        }
    }
}
