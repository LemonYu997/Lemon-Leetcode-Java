package problems.c0easy.t1001t1500;

import java.util.HashMap;
import java.util.Map;

/**
 * 1287 有序数组中出现次数超过25%的元素 https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/description/
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，
 * 它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 *
 * 示例：
 * 输入1：arr = [1,2,2,6,6,6,6,7,10]
 * 输出1：6
 */
public class T1287 {
    /**
     * 自己实现：即找到出现次数最多的数
     * 使用 Map 即可
     */
    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                ans = entry.getKey();
                max = entry.getValue();
            }
        }
        return ans;
    }

    /**
     * 官方解法1：因为数组有序，找到连续数字出现次数 > 数组长度的 25% 即可
     */
    public int findSpecialInteger1(int[] arr) {
        int n = arr.length;
        int limit = n / 4;
        int count = 1;
        int cur = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] == cur) {
                count++;
            } else {
                cur = arr[i];
                count = 1;
            }
            // 题目保证一定存在
            if (count > limit) {
                return cur;
            }
        }
        return 0;
    }

    /**
     * 官方解法2：二分查找
     */
    public int findSpecialInteger2(int[] arr) {
        int n = arr.length;
        int span = n / 4 + 1;
        int ans = -1;
        for (int i = 0; i < n; i += span) {
            int left = lowerBound(arr, arr[i]);
            int right = upperBound(arr, arr[i]);
            if (right - left >= span) {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

    private int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
