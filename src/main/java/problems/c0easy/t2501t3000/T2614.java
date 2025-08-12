package problems.c0easy.t2501t3000;

/**
 * 2614 对角线上的质数 https://leetcode.cn/problems/prime-in-diagonal/description/
 * 给你一个下标从 0 开始的二维整数数组 nums 。
 * 返回位于 nums 至少一条 对角线 上的最大 质数 。如果任一对角线上均不存在质数，返回 0 。
 * 注意：
 * 如果某个整数大于 1 ，且不存在除 1 和自身之外的正整数因子，则认为该整数是一个质数。
 * 如果存在整数 i ，使得 nums[i][i] = val 或者 nums[i][nums.length - i - 1]= val ，
 * 则认为整数 val 位于 nums 的一条对角线上。
 * 在上图中，一条对角线是 [1,5,9] ，而另一条对角线是 [3,5,7] 。
 *
 * 示例：
 * 输入1：nums = [[1,2,3],[5,6,7],[9,10,11]]
 * 输出1：11
 *
 * 输入2：nums = [[1,2,3],[5,17,7],[9,11,10]]
 * 输出2：17
 */
public class T2614 {
    /**
     * 自己实现：根据题意遍历即可
     */
    public int diagonalPrime(int[][] nums) {
        // 先找到所有对角线
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i][i])) {
                ans = Math.max(ans, nums[i][i]);
            }
            if (isPrime(nums[i][n - i - 1])) {
                ans = Math.max(ans, nums[i][n - i - 1]);
            }
        }
        return ans;
    }

    /**
     * 判断一个数是否为质数
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        // 检查从2到sqrt(num)的奇数是否能整除num
        // 只需检查到平方根，因为如果n有一个大于其平方根的因数，
        // 那么它必定有一个小于其平方根的对应因数
        int temp = 2;
        while (temp * temp <= n) {
            if (n % temp == 0) {
                return false;
            }
            temp++;
        }
        return true;
    }
}
