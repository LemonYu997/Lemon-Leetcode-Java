package problems.c0easy.t2501t3000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2899 上一个遍历的整数 https://leetcode.cn/problems/last-visited-integers/description/
 * 给你一个整数数组 nums ，其中 nums[i] 要么是一个正整数，要么是 -1 。
 * 我们需要为每个 -1 找到相应的正整数，我们称之为最后访问的整数。
 * 为了达到这个目标，定义两个空数组：seen 和 ans。
 * 从数组 nums 的头部开始遍历。
 * 如果遇到正整数，把它添加到 seen 的 头部。
 * 如果遇到 -1，则设 k 是到目前为止看到的 连续 -1 的数目(包括当前 -1)，
 * 如果 k 小于等于 seen 的长度，把 seen 的第 k 个元素添加到 ans。
 * 如果 k 严格大于 seen 的长度，把 -1 添加到 ans。
 * 请你返回数组 ans。
 *
 * 示例：
 * 输入1：nums = [1,2,-1,-1,-1]
 * 输出1：[2,1,-1]
 *
 * 输入2：nums = [1,-1,2,-1,-1]
 * 输出2：[1,2,1]
 */
public class T2899 {
    /**
     * 自己实现：根据题意模拟
     */
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> seen = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        for (int num : nums) {
            if (num > 0) {
                seen.add(num);
                k = 0;
            } else {
                ans.add(++k > seen.size() ? -1 : seen.get(seen.size() - k)); // 倒数第 k 个
            }
        }
        return ans;
    }
}
