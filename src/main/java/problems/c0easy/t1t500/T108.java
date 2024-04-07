package problems.c0easy.t1t500;

import java.util.Random;

/**
 * 108 将有序数组转换为二叉搜索树 https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * 给定一个整数数组nums，其中元素已经按升序排列，将其转换为一个高度平衡二叉搜索树
 * 高度平衡二叉树：每个节点的左右两个子树的高度差的绝对值不超过1
 * 二叉搜索树：其中序遍历是升序的
 *
 * 示例：
 * 输入1：nums = [-10,-3,0,5,9]
 * 输出1：[0,-3,9,-10,null,5]
 * 备注：[0,-10,5,null,-3,null,9] 也将被视为正确答案
 *
 * 输入2：nums = [1,3]
 * 输出2：[3,1]
 * 备注：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树
 */
public class T108 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 官方解法1：中序遍历，总是选择中间位置的左边的数字作为根节点
     * 则根节点的下标为 mid = (left + right) / 2，此时的除法为整数除法
     */
    public TreeNode sortedArrayToBST1(int[] nums) {
        return helper1(nums, 0, nums.length - 1);
    }

    public TreeNode helper1(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        //总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        //根节点及其每个子树的根节点（递归到的时候）
        TreeNode root = new TreeNode(nums[mid]);
        //左子树
        root.left = helper1(nums, left, mid - 1);
        //右子树
        root.right = helper1(nums, mid + 1, right);

        return root;
    }

    /**
     * 官方解法2：中序遍历，总是选择中间位置的右边的数字作为根节点
     * mid = (left + right + 1) / 2
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper2(nums, 0, nums.length - 1);
    }

    public TreeNode helper2(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        //总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper2(nums, left, mid - 1);
        root.right = helper2(nums, mid + 1, right);
        return root;
    }

    /**
     * 官方解法3：中序遍历，选择任意一个中间位置数字作为根节点
     * mid = (left + right) / 2 或者 mid = (left + right + 1) / 2
     */
    public TreeNode sortedArrayToBST3(int[] nums) {
        return helper3(nums, 0, nums.length - 1);
    }

    Random rand = new Random();

    public TreeNode helper3(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        //选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper3(nums, left, mid - 1);
        root.right = helper3(nums, mid + 1, right);

        return root;
    }
}
