package problems.c0easy.t1501t2000;

import java.util.Arrays;

/**
 * 1502 判断能否形成等差数列 https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence/description/
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 *
 * 示例：
 * 输入1：arr = [3,5,1]
 * 输出1：true
 *
 * 输入2：arr = [1,2,4]
 * 输出2：false
 */
public class T1502 {
    /**
     * 自己实现：先排序再判断
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int pre = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            // 如果相邻两数差不一致就返回 false
            if (arr[i] - arr[i - 1] != pre) {
                return false;
            }
        }
        return true;
    }

    /**
     * 官方解法：换一种比较方法 arr[i] * 2 != arr[i - 1] + arr[i + 1]
     */
    public boolean canMakeArithmeticProgression1(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
