package problems.c0easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1018 可被 5 整除的二进制前缀 https://leetcode.cn/problems/binary-prefix-divisible-by-5/description/
 * 给定一个二进制数组 nums ( 索引从0开始 )。
 * 我们将 xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。
 *
 * 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
 * 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 * 示例：
 * 输入1：nums = [0,1,1]
 * 输出1：[true,false,false]
 *
 * 输入2：nums = [1,1,1]
 * 输出2：[false,false,false]
 */
public class T1018 {
    /**
     * 自己实现：遍历 nums，计算每一位实际对应的数，判断其是否能被 5 整除
     * 结果：num会溢出，因为 nums 可能很长
     */
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            long num = 0;
            // 计算当前位具体数
            for (int j = i, k = 0; j >= 0; j--, k++) {
                num += Math.pow(2, k) * nums[j];
            }
            if (num % 5 == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    /**
     * 官方解法：只保留余数，防止溢出
     */
    public List<Boolean> prefixesDivBy5I(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix = ((prefix << 1) + nums[i]) % 5;
            ans.add(prefix == 0);
        }
        return ans;
    }
}
