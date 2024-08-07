package problems.c0easy.t1501t2000;

/**
 * 1534 统计好三元组 https://leetcode.cn/problems/count-good-triplets/description/
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 *
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 *
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 *
 * 示例：
 * 输入1：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * 输出1：4
 * 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 *
 * 输入2：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * 输出2：0
 * 解释：不存在满足所有条件的三元组。
 */
public class T1534 {
    /**
     * 自己实现：根据题意模拟 循环遍历
     */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 社区解法：优化循环判断
     */
    public int countGoodTriplets1(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b
                                && Math.abs(arr[i] - arr[k]) <= c) {
                            ans++;
                        }
                    }
                }
            }
        }

        return ans;
    }

    /**
     * 官方解法：枚举优化
     */
    public int countGoodTriplets2(int[] arr, int a, int b, int c) {
        int ans = 0;
        int n = arr.length;
        int[] sum = new int[1001];
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                if (Math.abs(arr[j] - arr[k]) <= b) {
                    int lj = arr[j] - a, rj = arr[j] + a;
                    int lk = arr[k] - c, rk = arr[k] + c;
                    int l = Math.max(0, Math.max(lj, lk)), r = Math.min(1000, Math.min(rj, rk));

                    if (l <= r) {
                        if (l == 0) {
                            ans += sum[r];
                        }
                        else {
                            ans += sum[r] - sum[l - 1];
                        }
                    }
                }
            }
            for (int k = arr[j]; k <= 1000; ++k) {
                ++sum[k];
            }
        }

        return ans;
    }
}