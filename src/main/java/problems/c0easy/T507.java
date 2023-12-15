package problems.c0easy;

/**
 * 507 完美数 https://leetcode.cn/problems/perfect-number/
 * 对于一个正整数，如果它和除了它自身以外的所有正因子之和相等，称之为完美数
 *
 * 给定一个整数n，如果是完美数，返回true，否则返回false
 *
 * 示例：
 * 输入1：num = 28
 * 输出1：true
 * 备注：28 = 1 + 2 + 4 + 7 + 14
 *
 * 输入2：num = 7
 * 输出2：false
 */
public class T507 {
    /**
     * 自己实现：根据定义，先获取除了它以外的所有正因子
     */
    public boolean checkPerfectNumber(int num) {
        int n = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                n += i;
            }
        }

        return num == n;
    }

    /**
     * 官方解法1：枚举，比上边的方法优化了速度
     * 少遍历了一半
     */
    public boolean checkPerfectNumber1(int num) {
        if (num == 1) {
            return false;
        }

        //从1开始
        int sum = 1;
        //如果找到了因子a，那么它对应的因子b即为 num / a
        //此时要注意不能是 a * a = num，不能重复计算
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i < num) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }

    /**
     * 官方解法2：数学
     * 题目范围的 1~10^8之内的完全数只有
     * 6,28,496,8128,33550336
     */
    public boolean checkPerfectNumber2(int num) {
        return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
    }
}
