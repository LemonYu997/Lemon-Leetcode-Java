package problems.c0easy.t2501t3000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2848 与车相交的点 https://leetcode.cn/problems/points-that-intersect-with-cars/description/
 * 给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。
 * 对于任意下标 i，nums[i] = [starti, endi] ，
 * 其中 starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
 * 返回数轴上被车 任意部分 覆盖的整数点的数目。
 *
 * 示例：
 * 输入1：nums = [[3,6],[1,5],[4,7]]
 * 输出1：7
 *
 * 输入2：nums = [[1,3],[5,8]]
 * 输出2：7
 *
 * 提示：
 * 1 <= nums.length <= 100
 * nums[i].length == 2
 * 1 <= starti <= endi <= 100
 */
public class T2848 {
    /**
     * 自己实现：因为 1 <= starti <= endi <= 100，统计 100以内的数字出现次数即可
     */
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] temp = new int[101];

        for (List<Integer> list : nums) {
            for (int i = list.get(0); i <= list.get(1); i++) {
                temp[i] = 1;
            }
        }

        return Arrays.stream(temp).sum();
    }

    /**
     * 官方解法：
     */
    public int numberOfPoints1(List<List<Integer>> nums) {
        int C = 0;
        // 得到所有区间的最大值
        for (List<Integer> num : nums) {
            C = Math.max(C, num.get(1));
        }

        // 统计出现的次数
        int[] count = new int[C + 1];
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                count[i]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= C; i++) {
            if (count[i] > 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 社区解法：set去重
     */
    public int numberOfPoints2(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> num : nums) {
            for (int i = num.get(0); i <= num.get(1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}