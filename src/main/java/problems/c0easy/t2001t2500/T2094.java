package problems.c0easy.t2001t2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2094 找出 3 位偶数 https://leetcode.cn/problems/finding-3-digit-even-numbers/description/
 * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
 * 你需要找出 所有 满足下述条件且 互不相同 的整数：
 * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
 * 该整数不含 前导零
 * 该整数是一个 偶数
 * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
 * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
 *
 * 示例：
 * 输入1：digits = [2,1,3,0]
 * 输出1：[102,120,130,132,210,230,302,310,312,320]
 *
 * 输入2：digits = [2,2,8,8,2]
 * 输出2：[222,228,282,288,822,828,882]
 *
 * 输入3：digits = [3,7,5]
 * 输出3：[]
 */
public class T2094 {
    /**
     * 官方解法：根据题意模拟，遍历
     */
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        // 存储结果，去重
        Set<Integer> set = new HashSet<>();

        // 遍历得到三位数
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 组合成三位数，且前置位不为0
                    if (i != j && j != k && i != k && digits[i] != 0) {
                        // 判断末位是否为偶数，末位为偶数即该数就是偶数
                        if (digits[k] % 2 == 0) {
                            int temp = digits[i] * 100 + digits[j] * 10 + digits[k];
                            set.add(temp);
                        }
                    }
                }
            }
        }

        // 构建返回数组
        int[] ans = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            ans[index++] = num;
        }
        // 题目要求排序后返回
        Arrays.sort(ans);
        return ans;
    }
}
