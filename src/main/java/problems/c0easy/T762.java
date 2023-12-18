package problems.c0easy;

/**
 * 762 二进制表示中质数个计算置位 https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 * 计算置位位数 就是二进制表示中 1 的个数。
 *
 * 示例：
 * 输入1：left = 6, right = 10
 * 输出1：4
 * 备注：
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 *
 * 输入2：left = 10, right = 15
 * 输出2：5
 * 备注：
 * 10 -> 1010 (2 个计算置位, 2 是质数)
 * 11 -> 1011 (3 个计算置位, 3 是质数)
 * 12 -> 1100 (2 个计算置位, 2 是质数)
 * 13 -> 1101 (3 个计算置位, 3 是质数)
 * 14 -> 1110 (3 个计算置位, 3 是质数)
 * 15 -> 1111 (4 个计算置位, 4 不是质数)
 * 共计 5 个计算置位为质数的数字。
 */
public class T762 {
    /**
     * 自己实现：先转二进制字符串，再判断 1 的个数是否是质数
     */
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int count = 0;
            char[] chars = Integer.toBinaryString(i).toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    count++;
                }
            }

            //注意：1不是质数
            if (count == 0 || count == 1) {
                continue;
            }

            //判断是否为质数，遍历 2~n-1 确定是否还有其他能整除的数
            boolean flag = true;
            for (int j = 2; j < count; j++) {
                if (count % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 自己实现：使用API优化代码，并优化质数判断
     */
    public int countPrimeSetBits1(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            //API获取二进制中 1 的个数
            int count = Integer.bitCount(i);

            //注意：1不是质数
            if (count == 0 || count == 1) {
                continue;
            }

            //判断是否为质数，遍历 2~n-1 确定是否还有其他能整除的数
            //判断质数：埃氏筛选 只用判断到 根号n 即可
            boolean flag = true;
            for (int j = 2; j * j <= count; j++) {
                if (count % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }

        return ans;
    }
}
