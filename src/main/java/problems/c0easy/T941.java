package problems.c0easy;

/**
 * 941 有效的山脉数组 https://leetcode.cn/problems/valid-mountain-array/
 * 给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
 * 如果 arr 满足下述条件，那么它是一个山脉数组：
 *   arr.length >= 3
 *   在 0 < i < arr.length - 1 条件下，存在 i 使得
 *      arr[0] < arr[1] < ... arr[i-1] < arr[i]
 *      arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 *
 * 示例：
 * 输入1：arr = [2,1]
 * 输出1：false
 *
 * 输入2：arr = [3,5,5]
 * 输出2：false
 *
 * 输入3：arr = [0,3,2,1]
 * 输出3：true
 */
public class T941 {
    /**
     * 官方解法：线性扫描
     */
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == n - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // 刚好遍历完整个数组才行
        return i == n - 1;
    }
}
