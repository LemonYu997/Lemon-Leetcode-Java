package problems.c0easy;

/**
 * 1013 将数组分成和相等的三个部分 https://leetcode.cn/problems/partition-array-into-three-parts-with-equal-sum/description/
 * 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i + 1 < j 且满足
 * (arr[0] + arr[1] + ... + arr[i] ==
 * arr[i + 1] + arr[i + 2] + ... + arr[j - 1]
 * == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
 * 就可以将数组三等分。
 *
 * 示例：
 * 输入1：arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出1：true
 * 备注：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 输入2：arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出2：false
 *
 * 输入3：arr = [3,3,6,5,-2,2,5,1,-9,4]
 * 输出3：true
 * 备注：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 */
public class T1013 {
    /**
     * 官方解法：
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        int s = 0;
        for (int num : arr) {
            s += num;
        }
        // 如果不能整除，直接返回 false
        if (s % 3 != 0) {
            return false;
        }
        // 目标值
        int target = s / 3;
        int n = arr.length, i = 0, cur = 0;
        // 找到第一个分割点
        while (i < n) {
            cur += arr[i];
            if (cur == target) {
                break;
            }
            i++;
        }
        // 如果找不到分割点，就返回false
        if (cur != target) {
            return false;
        }
        int j = i + 1;
        // 找到第二个分割点，注意最后一个数组要非空，所以这里 < n
        while (j + 1 < n) {
            cur += arr[j];
            // 如果找到就返回 true
            if (cur == target * 2) {
                return true;
            }
            j++;
        }
        return false;
    }
}
