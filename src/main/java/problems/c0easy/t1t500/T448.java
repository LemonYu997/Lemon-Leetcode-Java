package problems.c0easy.t1t500;

import java.util.ArrayList;
import java.util.List;

/**
 * 448 找到所有数组中消失的数字 https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/
 * 给定一个含n个整数的数组nums，其中nums[i]在区间[1,n]内
 * 找出所有在[1,n]范围内但没有出现在nums中的数字，并以数组形式返回结果
 *
 * 示例：
 * 输入1：nums = [4,3,2,7,8,2,3,1]
 * 输出1：[5,6]
 *
 * 输入2：nums = [1,1]
 * 输出2：[2]
 */
public class T448 {
    /**
     * 自己实现：根据定义
     * 先添加再删除  会超时
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            list.add(i);
        }

        List<Integer> del = new ArrayList<>();
        for (int num : nums) {
            if (del.contains(num)) {
                continue;
            }
            del.add(num);
        }

        list.removeAll(del);

        return list;
    }

    /**
     * 官方解法：原地修改
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }

        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }

        return ret;
    }
}
