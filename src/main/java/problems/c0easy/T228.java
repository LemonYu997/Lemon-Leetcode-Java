package problems.c0easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 228 汇总区间 https://leetcode.cn/problems/summary-ranges/
 * 给定一个无重复元素的有序整数数组nums
 *
 * 返回恰好覆盖数组中所有数字的最小有序区间范围列表，即nums的每个元素都恰好被某个区间范围所覆盖
 * 不存在属于某个范围但不属于nums的数字x
 *
 * 示例：
 * 输入1：nums = [0,1,2,4,5,7]
 * 输出1：["0->2","4->5","7"]
 * 备注：区间范围是：
 *      [0,2] --> "0->2"
 *      [4,5] --> "4->5"
 *      [7,7] --> "7"
 *
 * 输入2：nums = [0,2,3,4,6,8,9]
 * 输出2：["0","2->4","6","8->9"]
 */
public class T228 {
    /**
     * 官方解法：一次遍历
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            ret.add(temp.toString());
        }

        return ret;
    }
}
