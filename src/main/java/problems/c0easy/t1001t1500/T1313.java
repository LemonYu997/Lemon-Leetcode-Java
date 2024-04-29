package problems.c0easy.t1001t1500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1313 解压缩编码列表 https://leetcode.cn/problems/decompress-run-length-encoded-list/description/
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]]
 * （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，
 * 你需要从左到右连接所有子列表以生成解压后的列表。
 * 请你返回解压后的列表。
 *
 * 示例：
 * 输入1：nums = [1,2,3,4]
 * 输出1：[2,4,4,4]
 *
 * 输入2：nums = [1,1,2,3]
 * 输出2：[1,3,3]
 */
public class T1313 {
    /**
     * 自己实现：模拟，由于不确定长度，先使用 List 存储
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        // 每次跳 2 位
        for (int i = 0; i + 1 < n; i += 2) {
            // 要被插入的数据
            int num = nums[i + 1];
            // 被插入的次数
            for (int j = 0; j < nums[i]; j++) {
                list.add(num);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
