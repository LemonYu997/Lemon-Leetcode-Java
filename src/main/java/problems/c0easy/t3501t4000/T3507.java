package problems.c0easy.t3501t4000;

import java.util.ArrayList;
import java.util.List;

/**
 * 3507 移除最小数对使数组有序 I https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-i/description/
 * 给你一个数组 nums，你可以执行以下操作任意次数：
 * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
 * 用它们的和替换这对元素。
 * 返回将数组变为 非递减 所需的 最小操作次数 。
 * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
 *
 * 示例：
 * 输入1：nums = [5,2,3,1]
 * 输出1：2
 *
 * 输入2：nums = [1,2,2]
 * 输出2：0
 */
public class T3507 {
    /**
     * 官方解法：根据题意模拟
     */
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int count = 0;

        while (list.size() > 1) {
            boolean isAscending = true;
            int minSum = Integer.MAX_VALUE;
            int targetIndex = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);

                if (list.get(i) > list.get(i + 1)) {
                    isAscending = false;
                }

                if (sum < minSum) {
                    minSum = sum;
                    targetIndex = i;
                }
            }

            if (isAscending) {
                break;
            }

            count++;
            list.set(targetIndex, minSum);
            list.remove(targetIndex + 1);
        }
        return count;
    }
}
