package problems.c0easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 257 二叉树的所有路径 https://leetcode.cn/problems/binary-tree-paths/
 * 给定一个二叉树的根节点root，按任意顺序，返回所有从根节点到叶子节点的路径
 *
 * 示例：
 * 输入1：root = [1,2,3,null,5]
 * 输出1：["1->2->5","1->3"]
 *
 * 输入2：root = [1]
 * 输出2：["1"]
 */
public class T257 {
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
     * 官方解法1：深度优先搜索DFS
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            //当前节点是叶子节点
            if (root.left == null && root.right == null) {
                //把路径添加到答案中
                paths.add(pathSB.toString());
            } else {
                //当前节点不是叶子节点，继续递归遍历
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    /**
     * 官方解法2：广度优先搜索BFS
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();

        nodeQueue.offer(root);
        pathQueue.offer(Integer.toString(root.val));

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String path = pathQueue.poll();

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    pathQueue.offer(new StringBuffer(path)
                            .append("->")
                            .append(node.left.val)
                            .toString());
                }

                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    pathQueue.offer(new StringBuffer(path)
                            .append("->")
                            .append(node.right.val)
                            .toString());
                }
            }
        }
        return paths;
    }
}
