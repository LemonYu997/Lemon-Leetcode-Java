package problems.c0easy.t1501t2000;

/**
 * 1539 第 k 个缺失的正整数 https://leetcode.cn/problems/kth-missing-positive-number/description/
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 *
 * 请你找到这个数组里第 k 个缺失的正整数。
 *
 * 示例：
 * 输入1：arr = [2,3,4,7,11], k = 5
 * 输出1：9
 *
 * 输入2：arr = [1,2,3,4], k = 2
 * 输出2：6
 */
public class T1539 {
    /**
     * 官方解法：枚举
     * 用一个变量 current 表示当前应该出现的数，从 1 开始递增
     */
    public int findKthPositive(int[] arr, int k) {
        int missCount = 0;   // 缺失个数
        int lastMiss = -1;   // 最后一个缺失的数
        int current = 1;    // 当前整数
        int ptr = 0;    // arr指针
        // 找到缺失的第 k 个数
        for (missCount = 0; missCount < k; current++) {
            // 一致时指针向前移动
            if (current == arr[ptr]) {
                ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
            } else {
                missCount++;
                lastMiss = current;
            }
        }

        return lastMiss;
    }

    /**
     * 社区解法：转化思路
     * 1、如果数组中没有小于 k 的数，那么第 k 个缺失的数字是 k
     * 2、如果有一个 <= k 的数字，k++
     * 3、最后返回 k
     */
    public int findKthPositive1(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            }
        }
        return k;
    }
}
