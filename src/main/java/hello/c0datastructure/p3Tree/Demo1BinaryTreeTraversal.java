package hello.c0datastructure.p3Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的遍历
 *
 * 常见遍历方式：
 * 1、层序遍历：BFS，从顶部到底部逐层遍历，每层都从左到右访问
 * 2、前序遍历：DFS，先访问根节点，再访问左子树，再访问右子树
 * 3、中序遍历：DFS，先访问左子树，再访问根节点，最后访问右子树
 * 4、后序遍历：DFS，先遍历左子树，再遍历右子树，最后访问根节点
 */
public class Demo1BinaryTreeTraversal {
    /**
     * 层序遍历：使用队列实现
     * 按层遍历，先入先出，从根节点先入队
     * 每个节点出队时，其子节点入队
     */
    List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //初始化一个列表，保存遍历结果
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            //出队
            TreeNode node = queue.poll();
            //保存节点值
            list.add(node.val);
            if (node.left != null) {
                //左子结点入队
                queue.offer(node.left);
            }
            if (node.right != null) {
                //右子节点入队
                queue.offer(node.right);
            }
        }
        return list;
    }

    List<Integer> list = new ArrayList<>();

    //前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //访问优先级：根节点 -> 左子树 -> 右子树
        list.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问优先级：左子树 -> 根节点 -> 右子树
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    //后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        // 访问优先级：左子树 -> 右子树 -> 根节点
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }
}
