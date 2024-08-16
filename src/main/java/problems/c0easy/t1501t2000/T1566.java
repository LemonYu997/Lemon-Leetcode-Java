package problems.c0easy.t1501t2000;

/**
 * 1566 重复至少 K 次且长度为 M 的模式 https://leetcode.cn/problems/detect-pattern-of-length-m-repeated-k-or-more-times/description/
 * 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 * 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。
 * 模式由其长度和重复次数定义。
 * 如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。
 *
 * 示例：
 * 输入1：arr = [1,2,4,4,4,4], m = 1, k = 3
 * 输出1：true
 *
 * 输入2：arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
 * 输出2：true
 *
 * 输入3：arr = [1,2,1,2,1,3], m = 2, k = 3
 * 输出3：false
 *
 * 输入4：arr = [1,2,3,1,2], m = 2, k = 2
 * 输出4：false
 */
public class T1566 {
    /**
     * 自己实现：跟具题意遍历
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for (int i = 0; i <= n - m * k; i++) {
            int offset;
            for (offset = 0; offset < m * k; offset++) {
                if (arr[i + offset] != arr[i + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }
        return false;
    }
}
