package problems.c0easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 268 丢失的数字 https://leetcode.cn/problems/missing-number/
 * 给定一个包含[0,n]中n个数的数组nums，找出[0,n]这个范围内没有出现在数组中的那个数
 *
 * 示例：
 * 输入1：nums = [3,0,1]
 * 输出1:2
 * 备注：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 *
 * 输入2：nums = [0,1]
 * 输出2:2
 *
 * 输入3：nums = [9,6,4,2,3,5,7,0,1]
 * 输出3：8
 *
 * 输入4：nums = [0]
 * 输出4:1
 */
public class T268 {
    /**
     * 自己实现
     */
    public int missingNumber(int[] nums) {
        //先排序
        Arrays.sort(nums);
        int n = nums.length;

        //哪个和索引不一致就是缺少了哪个数
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        //如果全都有就是缺少最后一个
        return n;
    }

    /**
     * 官方解法1：哈希集合
     */
    public int missingNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = - 1;

        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return missing;
    }

    /**
     * 官方解法2：数学
     * 根据[0,n]的求和公式 n * (n + 1) / 2，计算nums的和，相减即得少的那个数
     */
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        //求和理论值
        int total = n * (n + 1) / 2;
        //求和实际值
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return total - sum;
    }
}
