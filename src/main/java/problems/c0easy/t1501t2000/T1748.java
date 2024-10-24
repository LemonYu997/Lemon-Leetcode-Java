package problems.c0easy.t1501t2000;

import java.util.HashMap;
import java.util.Map;

/**
 * 1748 唯一元素的和 https://leetcode.cn/problems/sum-of-unique-elements/description/
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的 和 。
 *
 * 示例：
 * 输入1：nums = [1,2,3,2]
 * 输出1：4
 *
 * 输入2：nums = [1,1,1,1,1]
 * 输出2：0
 *
 * 输入3：nums = [1,2,3,4,5]
 * 输出3：15
 */
public class T1748 {
    /**
     * 自己实现：根据题意模拟，题目要求 1 <= nums[i] <= 100，因此可以新建一个数组 int[101] 记录每个数出现的次数
     */
    public int sumOfUnique(int[] nums) {
        // 值代表 1~100 每个数存储的次数
        int[] temp = new int[101];
        int ans = 0;

        for (int num : nums) {
            temp[num]++;
        }

        for (int i = 1; i < temp.length; i++) {
            // 记录只出现 1 次的
            if (temp[i] == 1) {
                ans += i;
            }
        }

        return ans;
    }

    /**
     * 官方解法：记录每个元素的状态，一次遍历
     * 对每个元素赋予 3 个状态：
     * 0：该元素尚未被访问
     * 1：该元素被访问过一次
     * 2：该元素访问超过一次
     */
    public int sumOfUnique1(int[] nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 第一次遇到时先加上
            if (!map.containsKey(num)) {
                ans += num;
                map.put(num, 1);
            } else if (map.get(num) == 1) {
                // 第二次遇到时就减去，并将状态置为 2，之后再遇到就会什么都不处理
                ans -= num;
                map.put(num, 2);
            }
        }

        return ans;
    }
}
