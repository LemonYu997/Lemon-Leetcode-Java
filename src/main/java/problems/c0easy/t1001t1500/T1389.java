package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.List;

/**
 * 1389 按既定顺序创建目标数组 https://leetcode.cn/problems/create-target-array-in-the-given-order/description/
 * 给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
 *
 * 目标数组 target 最初为空。
 * 按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i]
 * 处插入值 nums[i] 。
 * 重复上一步，直到在 nums 和 index 中都没有要读取的元素。
 * 请你返回目标数组。
 *
 * 题目保证数字插入位置总是存在。
 *
 * 示例：
 * 输入1：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * 输出1：[0,4,1,3,2]
 *
 * 输入2：nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * 输出2：[0,1,2,3,4]
 *
 * 输入3：nums = [1], index = [0]
 * 输出3：[1]
 */
public class T1389 {
    /**
     * 自己实现：使用List
     */
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        // 在 index[i] 位置插入 nums[i]，其余数向后移动
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }
        // 将 list 转为 int[]
        int[] ans = list.stream().mapToInt(Integer::intValue).toArray();
        return ans;
    }
}
