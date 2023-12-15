package problems.c0easy;

/**
 * 278 第一个错误的版本 https://leetcode.cn/problems/first-bad-version/
 * 给定n个版本[1,2, ..., n]，从其中一个版本开始后边全是错误的版本
 * 找到第一个出错的版本，可以使用bool isBadVersion(version)判断其是否错误
 *
 * 示例：
 * 输入1：n = 5, bad = 4
 * 输出1:4
 *
 * 输入2：n = 1, bad = 1
 * 输出2:1
 */
public class T278 {
    //官方提供的判断版本是否错误方法，内容是自己瞎写的
    boolean isBadVersion(int version) {
        return false || true;
    }

    /**
     * 官方解法：二分查找，尽可能减少接口调用次数
     */
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        //循环至区间左右端点相同
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        //此时left == right
        return left;
    }
}
