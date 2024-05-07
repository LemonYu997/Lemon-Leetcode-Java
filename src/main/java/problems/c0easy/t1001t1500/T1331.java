package problems.c0easy.t1001t1500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331 数组序号转换 https://leetcode.cn/problems/rank-transform-of-an-array/description/
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *
 * 示例：
 * 输入1：arr = [40,10,20,30]
 * 输出1：[4,1,2,3]
 *
 * 输入2：arr = [100,100,100]
 * 输出2：[1,1,1]
 *
 * 输入3：arr = [37,12,28,9,100,56,80,5,12]
 * 输出3：[5,3,4,2,8,6,7,1,3]
 */
public class T1331 {
    /**
     * 官方解法：排序+哈希表
     */
    public int[] arrayRankTransform(int[] arr) {
        // 复制一个新数组并排序
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        // key 存数值， value 存排序序号
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[arr.length];

        // 按排序顺序放入 map，相同数跳过
        for (int a : sortedArr) {
            if (!map.containsKey(a)) {
                // map.size()可视为排序序号
                map.put(a, map.size() + 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}
