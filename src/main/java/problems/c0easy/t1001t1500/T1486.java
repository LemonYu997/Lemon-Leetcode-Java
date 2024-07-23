package problems.c0easy.t1001t1500;

/**
 * 1486 数组异或操作 https://leetcode.cn/problems/xor-operation-in-an-array/description/
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 * 示例：
 * 输入1：n = 5, start = 0
 * 输出1：8
 *
 * 输入2：n = 4, start = 3
 * 输出2：8
 *
 * 输入3：n = 1, start = 7
 * 输出3：7
 *
 * 输入4：n = 10, start = 5
 * 输出4：2
 */
public class T1486 {
    /**
     * 自己实现：根据题意模拟
     */
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++) {
            ans ^= start + 2 * i;
        }
        return ans;
    }
}
