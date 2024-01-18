package hello.c1algorithm.p3Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集和问题
 * 给定一个正整数数组 nums 和一个目标正整数 target，找出所有可能得集合，使得组合中的元素和等于 target
 */
public class Demo2SubsetSum {
    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 4, 5};
        List<List<Integer>> list1 = subsetSum1(nums1, 9);
        System.out.println(list1);  //[[3, 3, 3], [4, 5]]

        int[] nums2 = new int[]{4, 4, 5};
        List<List<Integer>> list2 = subsetSum2(nums2, 9);
        System.out.println(list2);  //[[4, 5]]
    }

    /**
     * 问题1：nums 中无重复元素，每个元素可以被选择多次，返回结果不能包含重复组合
     * 例如：nums = [3, 4, 5]
     * 返回：[[3, 3, 3], [4, 5]]
     */
    public static List<List<Integer>> subsetSum1(int[] nums, int target) {
        List<Integer> state = new ArrayList<>();        // 状态（子集）
        Arrays.sort(nums);  // 对 nums 进行排序
        int start = 0;      // 遍历起始点
        List<List<Integer>> res = new ArrayList<>();    // 结果列表（子集列表）
        backtrack1(state, target, nums, start, res);
        return res;
    }

    /**
     * 引入 start，指定遍历起始点索引，防止选择重复元素
     *
     * @param start 当前遍历的起始点 ( nums 中的索引 )
     */
    public static void backtrack1(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：若子集和超过 target，直接结束循环
            // 因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }
            // 尝试：做出选择，更新 target，start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack1(state, target - choices[i], choices, i, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }

    /**
     * 问题2：nums 可能包含重复元素，每个元素只可被选择一次，返回结果不能包含重复组合
     * 例如：nums = [4, 4, 5]
     * 输出[[4, 5]]
     */
    public static List<List<Integer>> subsetSum2(int[] nums, int target) {
        List<Integer> state = new ArrayList<>();        // 状态（子集）
        Arrays.sort(nums);  // 对 nums 进行排序
        int start = 0;      // 遍历起始点
        List<List<Integer>> res = new ArrayList<>();    // 结果列表（子集列表）
        backtrack2(state, target, nums, start, res);
        return res;
    }

    /**
     * 每次遍历在下一轮选择时都从 start + 1 开始
     */
    public static void backtrack2(List<Integer> state, int target, int[] choices, int start, List<List<Integer>> res) {
        // 子集和等于 target 时，记录解
        if (target == 0) {
            res.add(new ArrayList<>(state));
            return;
        }
        // 遍历所有选择
        // 剪枝二：从 start 开始遍历，避免生成重复子集
        // 剪枝三：从 start 开始遍历，避免重复选择同一元素
        for (int i = start; i < choices.length; i++) {
            // 剪枝一：子集和超过 target 时，直接结束循环
            // 因为数组已排序，后边元素更大，子集和一定超过 target
            if (target - choices[i] < 0) {
                break;
            }
            // 剪枝四：如果该元素与左边元素相等，说明该搜索分支重复，直接跳过
            if (i > start && choices[i] == choices[i - 1]) {
                continue;
            }
            // 尝试：做出选择，更新 target，start
            state.add(choices[i]);
            // 进行下一轮选择
            backtrack2(state, target - choices[i], choices, i + 1, res);
            // 回退：撤销选择，恢复到之前的状态
            state.remove(state.size() - 1);
        }
    }
}