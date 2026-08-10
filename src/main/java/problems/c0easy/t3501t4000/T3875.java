package problems.c0easy.t3501t4000;

/**
 * 3875 构造奇偶一致的数组 I https://leetcode.cn/problems/construct-uniform-parity-array-i/description/
 * 给你一个长度为 n 的数组 nums1，其中包含 互不相同 的整数。
 * 你需要构造另一个长度为 n 的数组 nums2，使得 nums2 中的元素要么全部为 奇数，要么全部为 偶数。
 * 对于每个下标 i，你必须从以下两种选择中 任选其一（顺序不限）：
 *
 * nums2[i] = nums1[i]
 * nums2[i] = nums1[i] - nums1[j]，其中 j != i
 * 如果能够构造出满足条件的数组，则返回 true；否则，返回 false。
 *
 * 示例：
 * 输入1：nums1 = [2,3]
 * 输出1：true
 *
 * 输入2：nums1 = [4,6]
 * 输出2：true
 */
public class T3875 {
    /**
     * 社区解法：如果 nums1 已经全是奇数或者偶数了，那nums2一定可以构建成功
     * 如果nums1 奇数偶数都有，偶数-奇数=奇数，因此也可以构建成功
     */
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}
