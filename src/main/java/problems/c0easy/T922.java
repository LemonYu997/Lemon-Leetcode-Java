package problems.c0easy;

/**
 * 922 按奇偶排序数组 II https://leetcode.cn/problems/sort-array-by-parity-ii/
 * 给定一个非负整数 nums，nums 中一半整数是奇数，一半整数是偶数
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；
 * 当 nums[i] 为偶数时， i 也是 偶数 。
 *
 * 示例：
 * 输入1：nums = [4,2,5,7]
 * 输出1：[4,5,2,7]
 *
 * 输入2：nums = [2,3]
 * 输出2：[2,3]
 */
public class T922 {
    /**
     * 自己实现：双指针寻找奇偶数，填到新数组中
     */
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int j = 0;  // 奇数对应的索引
        int o = 0;  // 偶数对应的索引

        // 填入新数组
        for (int i = 0; i < n; i++) {
            // 判断当前索引本身是否为偶数
            if (i % 2 == 0) {
                // 在 nums 找到偶数
                while (o < n) {
                    if (nums[o] % 2 == 0) {
                        ans[i] = nums[o];
                        o++;
                        break;
                    }
                    o++;
                }
            } else {
                // 如果当前索引为奇数，在nums中找到奇数
                while (j < n) {
                    if (nums[j] % 2 == 1) {
                        ans[i] = nums[j];
                        j++;
                        break;
                    }
                    j++;
                }
            }
        }
        return ans;
    }

    /**
     * 官方解法：双指针原地解法
     * 在数组偶数和奇数对应的下标分别维护索引 i，j
     * 如果 nums[i] 为奇数，则将 j 向前移动（每次两位）
     * 直到遇到偶数后交换 nums[i] 和 nums[j]
     */
    public int[] sortArrayByParityII1(int[] nums) {
        int n = nums.length;
        int j = 1;  //奇数索引
        // i 是偶数索引
        for (int i = 0; i < n; i += 2) {
            // 如果当前数是奇数，在奇数索引中找到一个偶数并替换
            if (nums[i] % 2 == 1) {
                // j 遇到偶数时停止
                while (nums[j] % 2 == 1) {
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
