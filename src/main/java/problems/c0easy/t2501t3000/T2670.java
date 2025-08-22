package problems.c0easy.t2501t3000;

import java.util.HashSet;
import java.util.Set;

/**
 * 2670 找出不同元素数目差数组 https://leetcode.cn/problems/find-the-distinct-difference-array/description/
 * 给你一个下标从 0 开始的数组 nums ，数组长度为 n 。
 * nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，
 * 其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
 * 返回 nums 的 不同元素数目差 数组。
 * 注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。
 * 特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4,5]
 * 输出1：[-3,-1,1,3,5]
 *
 * 输入2：nums = [3,2,3,4,2]
 * 输出2：[-2,-1,0,2,3]
 */
public class T2670 {
    /**
     * 自己实现：根据题意，使用 set
     */
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> set1 = new HashSet<Integer>();
            Set<Integer> set2 = new HashSet<Integer>();
            for (int j = 0; j <= i; j++) {
                set1.add(nums[j]);
            }
            for (int j = i + 1; j < n; j++) {
                set2.add(nums[j]);
            }
            ans[i] = set1.size() - set2.size();
        }
        return ans;
    }

    /**
     * 官方解法：优化写法，减少 set 创建次数
     */
    public int[] distinctDifferenceArray1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Set<Integer> set = new HashSet<>();
        int[] sufCnt = new int[n + 1];
        // 记录所有当前索引后方拥有的不同元素数
        for (int i = n - 1; i > 0; i--) {
            set.add(nums[i]);
            sufCnt[i] = set.size();
        }
        set.clear();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
            // 再计算
            ans[i] = set.size() - sufCnt[i + 1];
        }
        return ans;
    }
}