package problems.c0easy.t1t500;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100 相同的树 https://leetcode.cn/problems/same-tree/
 * 给定两棵树的根节点 p 和 q，编写一个函数来检验这两棵树是否相同
 * 如果两个树在结构上相同，并且节点具有相同值，则认为是相同的
 *
 * 示例：
 * 输入1：p = [1,2,3], q = [1,2,3]
 * 输出1：true
 *
 * 输入2：p = [1,2], q = [1,null,2]
 * 输出2：false
 *
 * 输入3：p = [1,2,1], q = [1,1,2]
 * 输出3：false
 */
public class T100 {
    //定义好的树
    class TreeNode {
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
     * 官方解法1：深度优先搜索 DFS Depth First Search 一直向下遍历，走到底后回头，然后换一条路
     * 首先判断两个树的根节点是否相同，如果根节点不同则一定不同
     * 如果根节点相同，先判断左子树是否相同，再判断右子树是否相同
     * 可以用递归实现
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            //如果当前节点都为空，认为是相等
            //如果当前节点是根节点，且都为空，这里就会直接返回
            return true;
        } else if (p == null || q == null) {
            //如果一个为空一个不为空，不相等
            return false;
        } else if (p.val != q.val) {
            //值不相等
            return false;
        } else {
            //再判断其左子树和右子树
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        }
    }

    /**
     * 官方解法2：广度优先搜索 BFS Breadth First Search 一层一层搜索，维护一个队列，先进先出
     * 首先将两个二叉树的根节点分别介入两个队列，每次从两个队列各取出一个节点，进行以下操作
     * 1、比较两个节点值，如果值不相等则两个二叉树一定不相等
     * 2、如果两个节点值相同，判断两个节点的子节点是否为空，如果不一致则不相同
     * 3、如果子节点结构一致，将两个节点的非空子节点分别加入两个队列，优先加入左节点，再加入右节点
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        //先判断首节点
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        //定义两个队列
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        //添加首节点
        queue1.offer(p);
        queue2.offer(q);

        //遍历队列中的节点是否完全相同
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }

            //比较左节点和右节点的结构
            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;

            //如果两个左节点只有一个为空，就一定不相同
            if (left1 == null ^ left2 == null) {
                return false;
            }
            //如果两个右节点只有一个为空，就一定不相同
            if (right1 == null ^ right2 == null) {
                return false;
            }

            //将不为空的节点入队
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
