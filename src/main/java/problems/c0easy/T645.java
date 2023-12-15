package problems.c0easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 645 错误的集合 https://leetcode.cn/problems/set-mismatch/
 * 集合s包含从1到n的整数，但是其中缺少了一个数字，并且有一个数字重复
 * 找出重复出现的整数和丢失的整数
 *
 * 示例：
 * 输入1：nums = [1,2,2,4]
 * 输出1：[2,3]
 *
 * 输入2：nums = [1,1]
 * 输出2：[1,2]
 */
public class T645 {
    /**
     * 官方解法：哈希表
     */
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        //放入map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //遍历1~n，如果map中出现次数为0，说明是缺少的，如果map中出现次数为2，说明是重复的
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                ans[0] = i;
            } else if (count == 0) {
                ans[1] = i;
            }
        }

        return ans;
    }

    /**
     * 评论解法：数学
     * sum(nums)- sum(set(nums))，原数组求和 - 去重后求和，即为重复的数字
     * sum(1~n) - sum(set(nums))，理论和 - 去重后求和，即为缺失的数字
     */
    public int[] findErrorNums1(int[] nums) {
        int n = nums.length;
        //重复标识 0表示未计算，1表示已计算
        int[] cnts = new int[n + 1];
        //理论和
        int total = (1 + n) * n / 2;
        int sum = 0;    //实际和
        int set = 0;    //去重后的和

        for (int num : nums) {
            sum += num;
            if (cnts[num] == 0) {
                set += num;
            }
            cnts[num] = 1;
        }

        return new int[]{sum - set, total - set};
    }
}
