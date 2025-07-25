package problems.c0easy.t2501t3000;

/**
 * 2562 找出数组的串联值 https://leetcode.cn/problems/find-the-array-concatenation-value/description/
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 现定义两个数字的 串联 是由这两个数值串联起来形成的新数字。
 * 例如，15 和 49 的串联是 1549 。
 * nums 的 串联值 最初等于 0 。执行下述操作直到 nums 变为空：
 * 如果 nums 的长度大于 1，分别选中 nums 中的第一个元素和最后一个元素，将二者串联得到的值加到 nums 的 串联值 上，
 * 然后从 nums 中删除第一个和最后一个元素。例如，如果 nums 是 [1, 2, 4, 5, 6]，将 16 添加到串联值。
 * 如果 nums 中仅存在一个元素，则将该元素的值加到 nums 的串联值上，然后删除这个元素。
 * 返回执行完所有操作后 nums 的串联值。
 *
 * 示例：
 * 输入1：nums = [7,52,2,4]
 * 输出1：596
 *
 * 输入2：nums = [5,14,13,8,12]
 * 输出2：673
 */
public class T2562 {
    /**
     * 自己实现：根据题意模拟
     */
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            long temp = Long.parseLong(nums[i] + "" + nums[n - 1 - i]);
            ans += temp;
        }
        // 如果长度为奇数，则加上最后中间的数字
        if (n % 2 == 1) {
            ans += nums[n / 2];
        }

        return ans;
    }

    /**
     * 优化解法：双指针
     */
    public long findTheArrayConcVal1(int[] nums) {
        long ans = 0;
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            // 拼接数字
            int x = nums[i];
            int y = nums[j];
            while (y != 0) {
                x *= 10;
                y /= 10;
            }
            ans += x + nums[j];
            i++;
            j--;
        }
        if (i == j) {
            ans += nums[i];
        }
        return ans;
    }
}