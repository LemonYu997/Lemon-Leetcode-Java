package problems.c0easy.t2501t3000;

/**
 * 2748 美丽下标对的数目 https://leetcode.cn/problems/number-of-beautiful-pairs/description/
 * 给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，
 * 如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
 * 返回 nums 中 美丽下标对 的总数目。
 * 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。
 * 换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 y 的 最大公因数 。
 *
 * 示例：
 * 输入1：nums = [2,5,1,4]
 * 输出1：5
 *
 * 输入2：nums = [11,21,12]
 * 输出2：2
 */
public class T2748 {
    /**
     * 自己实现：根据题意模拟
     */
    public int countBeautifulPairs(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // nums[i] 的第一个数字
            while (nums[i] >= 10) {
                nums[i] /= 10;
            }
            for (int j = i + 1; j < n; j++) {
                // nums[j] 的最后一个数字
                if (gcd(nums[i], nums[j] % 10) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public int gcd(int a, int b) {
        // 判断两个数是否互质，辗转相除法
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    /**
     * 官方解法：先使用哈希表统计元素数
     */
    public int countBeautifulPairs1(int[] nums) {
        int ans = 0;
        int[] cnt = new int[10];
        for (int x : nums) {
            for (int y = 1; y <= 9; y++) {
                if (gcd(x % 10, y) == 1) {
                    ans += cnt[y];
                }
                while (x >= 10) {
                    x /= 10;
                }
                cnt[x]++;
            }
        }
        return ans;
    }
}
