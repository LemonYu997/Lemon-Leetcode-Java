package problems.c0easy.t2501t3000;

/**
 * 2843 统计对称整数的数目 https://leetcode.cn/problems/count-symmetric-integers/description/
 * 给你两个正整数 low 和 high 。
 * 对于一个由 2 * n 位数字组成的整数 x ，如果其前 n 位数字之和与后 n 位数字之和相等，则认为这个数字是一个对称整数。
 * 返回在 [low, high] 范围内的 对称整数的数目 。
 *
 * 示例：
 * 输入1：low = 1, high = 100
 * 输出1：9
 *
 * 输入2：low = 1200, high = 1230
 * 输出2：4
 *
 * 1 <= low <= high <= 104
 */
public class T2843 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            // 其位数必须是偶数
            int len = String.valueOf(i).length();
            if (len % 2 == 0) {
                // 计算前 n 位和后 n 位之和
                int count = 0;
                int temp = i;
                int sumA = 0;
                int sumB = 0;
                while (temp > 0) {
                    // 前 n 位之和
                    if (count < len / 2) {
                        sumA += temp % 10;
                        temp /= 10;
                    } else {
                        sumB += temp % 10;
                        temp /= 10;
                    }
                    count++;
                }
                if (sumA == sumB) {
                    ans++;
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：分情况讨论，因为题目要求 1 <= low <= high <= 10^4，所以最高只有4位数
     * 如果是 2 位数，则其必须是 11 的倍数
     * 如果是 4 位数，则分别计算前后两位的和
     */
    public int countSymmetricIntegers1(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (i < 100 && i % 11 == 0) {
                ans++;
            } else if (i >= 1000 && i < 10000) {
                int left = i / 1000 + (i % 1000) / 100;
                int right = (i % 100) / 10 + i % 10;
                if (left == right) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

