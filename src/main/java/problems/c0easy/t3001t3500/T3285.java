package problems.c0easy.t3001t3500;

import java.util.ArrayList;
import java.util.List;

/**
 * 3285 找到稳定山的下标 https://leetcode.cn/problems/find-indices-of-stable-mountains/description/
 * 有 n 座山排成一列，每座山都有一个高度。给你一个整数数组 height ，
 * 其中 height[i] 表示第 i 座山的高度，再给你一个整数 threshold 。
 * 对于下标不为 0 的一座山，如果它左侧相邻的山的高度 严格大于 threshold ，
 * 那么我们称它是 稳定 的。我们定义下标为 0 的山 不是 稳定的。
 * 请你返回一个数组，包含所有 稳定 山的下标，你可以以 任意 顺序返回下标数组。
 *
 * 示例：
 * 输入1：height = [1,2,3,4,5], threshold = 2
 * 输出1：[3,4]
 *
 * 输入2：height = [10,1,10,1,10], threshold = 3
 * 输出2：[1,3]
 *
 * 输入3：height = [10,1,10,1,10], threshold = 10
 * 输出3：[]
 */
public class T3285 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                ans.add(i);
            }
        }
        return ans;
    }
}
