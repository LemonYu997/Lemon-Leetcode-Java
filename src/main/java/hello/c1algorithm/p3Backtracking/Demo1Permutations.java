package hello.c1algorithm.p3Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列问题
 * 给定一个集合，展示所有可能得排列。
 * 如：[1,2,3]，输出 [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
 */
public class Demo1Permutations {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3};
        System.out.println(permutations1(nums1));

        int[] nums2 = new int[] {1, 1, 2, 2};
        System.out.println(permutations2(nums2));
    }

    /**
     * 全排列1：无相等元素情况
     */
    public static List<List<Integer>> permutations1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack1(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }

    /**
     * state中所有元素都应该是唯一的
     * 时间复杂度 O(n!n)
     * @param selected 用来保证每个元素只能被选择一次，selected[i] 表示 choices[i] 是否已被选择
     */
    public static void backtrack1(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素
            if (!selected[i]) {
                // 尝试：做出选择，更新状态
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack1(state, choices, selected, res);
                // 回退：撤销选择，恢复到之前的状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    /**
     * 全排列2：存在相等元素
     */
    public static List<List<Integer>> permutations2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack2(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }

    /**
     * 目标：在某一轮的选择中，保证多个相等的元素仅被选择一次
     * 解决方案：在每一轮选择中开启一个哈希表 duplicated，用于记录该轮中已经尝试过的元素，并将重复元素剪枝
     * 时间复杂度 O(n^2)
     */
    public static void backtrack2(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
        // 当状态长度等于元素数量时，记录解
        if (state.size() == choices.length) {
            res.add(new ArrayList<>(state));
        }
        // 遍历所有选择
        Set<Integer> duplicated = new HashSet<>();
        for (int i = 0; i < choices.length; i++) {
            int choice = choices[i];
            // 剪枝：不允许重复选择元素 且 不允许重复选择相等元素
            if (!selected[i] && !duplicated.contains(choice)) {
                // 尝试：做出选择，更新状态
                duplicated.add(choice); //记录已经选过的元素值
                selected[i] = true;
                state.add(choice);
                // 进行下一轮选择
                backtrack2(state, choices, selected, res);
                // 回退：撤销选择，恢复到之前状态
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }
}