package problems.c0easy.t501t1000;

import java.util.HashMap;
import java.util.Map;

/**
 * 697 数组的度 https://leetcode.cn/problems/degree-of-an-array/
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值
 * 在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例：
 * 输入1：nums = [1,2,2,3,1]
 * 输出1：2
 * 备注：输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 *
 * 输入2：nums = [1,2,2,3,1,4,2]
 * 输出2：6
 * 备注：数组的度是 3 ，因为元素 2 重复出现 3 次。
 */
public class T697 {
    /**
     * 官方解法：使用Map。
     * 使用一个int[3]存储每个数字的出现次数、起始出现位置、结束出现位置
     * 其中最短子数组即为找到 (结束索引 - 起始索引) 的最小值
     */
    public int findShortestSubArray(int[] nums) {
        //其中int[0]存放出现次数，int[1]存放起始索引，int[2]存放结束索引
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //已记录过的元素，更新次数和结束索引
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[0]++;
                map.get(nums[i])[2] = i;
            } else {
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        int maxNum = 0; //最大次数
        int minLen = 0; //最短长度
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            //出现次数更多的元素，更新最大次数和最小长度
            if (value[0] > maxNum) {
                maxNum = value[0];
                minLen = value[2] - value[1] + 1;
            } else if (value[0] == maxNum) {
                //如果出现次数一致，找到最小长度值
                minLen = Math.min(value[2] - value[1] + 1, minLen);
            }
        }

        return minLen;
    }
}
