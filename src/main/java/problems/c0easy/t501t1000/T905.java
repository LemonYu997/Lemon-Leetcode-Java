package problems.c0easy.t501t1000;

/**
 * 905 按奇偶排序数组 https://leetcode.cn/problems/sort-array-by-parity/
 * 给定一个整数数组 nums，将 nums 中的所有偶数元素移动到数组前面，后跟所有奇数元素
 * 返回满足此条件的任意数组为答案
 *
 * 示例：
 * 输入1：nums = [3,1,2,4]
 * 输出1：[2,4,3,1]
 *
 * 输入2：nums = [0]
 * 输出2：[0]
 */
public class T905 {
    /**
     * 自己实现：根据题意，新建一个数组，使用双指针
     * 判断每一个数字的奇偶并填入
     */
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int l = 0;
        int r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                ans[l] = nums[i];
                l++;
            } else {
                ans[r] = nums[i];
                r--;
            }
        }

        return ans;
    }

    /**
     * 官方解法：原地交换
     */
    public int[] sortArrayByParity1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // 在左侧找到一个奇数
            while (left < right && nums[left] % 2 == 0) {
                left++;
            }
            // 在右侧一个偶数
            while (left < right && nums[right] % 2 == 1) {
                right--;
            }
            // 交换奇数和偶数
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}
