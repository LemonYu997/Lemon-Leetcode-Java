package problems.c0easy.t1501t2000;

/**
 * 1588 所有奇数长度子数组的和 https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/description/
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 *
 * 示例：
 * 输入1：arr = [1,4,2,5,3]
 * 输出1：58
 *
 * 输入2：arr = [1,2]
 * 输出2：3
 *
 * 输入3：arr = [10,11,12]
 * 输出3：66
 */
public class T1588 {
    /**
     * 官方解法：暴力
     * 遍历每一个奇数子数组的和
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int start = 0; start < n; start++) {
            for (int length = 1; start + length <= n; length += 2) {
                int end = start + length - 1;
                for (int i = start; i <= end; i++) {
                    sum += arr[i];
                }
            }
        }
        return sum;
    }

    /**
     * 官方解法：前缀和
     */
    public int sumOddLengthSubarrays1(int[] arr) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int length = 1; length + start <= n; length += 2) {
                int end = start + length - 1;
                sum += prefixSum[end + 1] - prefixSum[start];
            }
        }
        return sum;
    }
}
