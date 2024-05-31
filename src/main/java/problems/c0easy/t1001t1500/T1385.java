package problems.c0easy.t1001t1500;

import java.util.Arrays;

/**
 * 1385 两个数组间的距离值 https://leetcode.cn/problems/find-the-distance-value-between-two-arrays/description/
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，
 * 不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 *
 * 示例：
 * 输入1：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * 输出1：2
 *
 * 输入2：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * 输出2：2
 *
 * 输入3：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * 输出3：1
 */
public class T1385 {
    /**
     * 自己实现：根据题意模拟
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        int m = arr1.length;
        int n = arr2.length;

        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (Math.abs(arr2[j] - arr1[i]) <= d) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 官方解法：二分查找
     * 找到在 arr2 中距离 arr1[i] 最近的元素，判断其之间差值是否 < d
     */
    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        // 先排序 保证二分查找生效
        Arrays.sort(arr2);
        int cnt = 0;
        for (int x : arr1) {
            int p = binarySearch(arr2, x);
            boolean ok = true;
            // 如果找到
            if (p < arr2.length) {
                ok &= arr2[p] - x > d;
            }
            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= x - arr2[p - 1] > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
