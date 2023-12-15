package problems.c0easy;

/**
 * 367 有效的完全平方数 https://leetcode.cn/problems/valid-perfect-square/
 * 给定一个正整数num，如果num是一个完全平方数，则返回true，否则返回false
 * 完全平方数：可以写成某个整数的平方的整数
 *
 * 示例：
 * 输入1：num = 16
 * 输出1：true
 *
 * 输入2：num = 14
 * 输出2：false
 */
public class T367 {
    /**
     * 自己实现：暴力解法，会超时
     */
    public boolean isPerfectSquare(int num) {
        long n = 1;
        //这里用long，防止越界
        long square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            n++;
            square = n * n;
        }
        return false;
    }

    /**
     * 官方解法：二分查找
     * num的平方根 n 肯定满足 1 <= n <= num，将其作为边界进行二分查找
     */
    public boolean isPerfectSquare1(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;

            //更新左右边界，计算新的中间值
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
