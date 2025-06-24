package problems.c0easy.t2001t2500;

/**
 * 2460 对数组执行操作 https://leetcode.cn/problems/apply-operations-to-an-array/description/
 * 给你一个下标从 0 开始的数组 nums ，数组大小为 n ，且由 非负 整数组成。
 * 你需要对数组执行 n - 1 步操作，其中第 i 步操作（从 0 开始计数）要求对 nums 中第 i 个元素执行下述指令：
 * 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，
 * nums[i + 1] 的值变成 0 。否则，跳过这步操作。
 * 在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
 * 例如，数组 [1,0,2,0,0,1] 将所有 0 移动到末尾后变为 [1,2,1,0,0,0] 。
 * 返回结果数组。
 * 注意 操作应当 依次有序 执行，而不是一次性全部执行。
 *
 * 示例：
 * 输入1：nums = [1,2,2,1,1,0]
 * 输出1：[1,4,2,0,0,0]
 *
 * 输入2：nums = [0,1]
 * 输出2：[1,0]
 */
public class T2460 {
    /**
     * 自己实现：根据题意模拟
     */
    public int[] applyOperations(int[] nums) {
        // 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // 将 0 后移
        for (int i = 0; i < n; i++) {
            // 如果当前位为 0，则和后边一个非 0 位交换位置
            if (nums[i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }

        return nums;
    }

    /**
     * 官方解法：在第一次遍历时直接交换 0 的位置
     */
    public int[] applyOperations1(int[] nums) {
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
            // 将非 0 元素移动到数组头部
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return nums;
    }
}
