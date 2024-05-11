package problems.c0easy.t1001t1500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1346 检查整数及其两倍数是否存在 https://leetcode.cn/problems/check-if-n-and-its-double-exist/description/
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，
 * 满足 N 是 M 的两倍（即，N = 2 * M）。
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *
 * 示例：
 * 输入1：arr = [10,2,5,3]
 * 输出1：true
 *
 * 输入2：arr = [7,1,14,11]
 * 输出2：true
 *
 * 输入3：arr = [3,1,7,11]
 * 输出3：false
 */
public class T1346 {
    /**
     * 自己实现：暴力循环，遍历两次
     */
    public boolean checkIfExist(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] == arr[i] * 2 && j != i) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 官方解法：排序 + 双指针
     */
    public boolean checkIfExist1(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0, j = 0; i < n; i++) {
            // 跳过比目标小的值
            while (j < n && arr[i] * 2 > arr[j]) {
                j++;
            }
            if (j < n && i != j && arr[i] * 2 == arr[j]) {
                return true;
            }
        }
        for (int i = n - 1, j = n - 1; i >= 0; i--) {
            while (j >= 0 && arr[i] * 2 < arr[j]) {
                j--;
            }
            if (j >= 0 && i != j && arr[i] * 2 == arr[j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 官方解法：使用哈希表
     */
    public boolean checkIfExist2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            // 如果 set 中存在当前数的两倍 或者等于当前数的一半时
            if (set.contains(2 * i) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
