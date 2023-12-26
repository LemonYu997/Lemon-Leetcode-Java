package hello.c0datastructure.p3Tree;

/**
 * 二叉树
 *
 * 常见二叉树类型：
 * 1、完美二叉树：所有层的节点都被填满
 * 2、完全二叉树：只有最底层没被填满，且叶子节点尽可能靠左填充
 * 3、完满二叉树：除了叶节点，其余所有节点都有两个子节点
 * 4、平衡二叉树：任意节点的左子树和右子树的高度之差绝对值不超过 1
 */
public class Demo0BinaryTree {
    public static void main(String[] args) {
        // 初始化二叉树
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        // 构建节点之间的引用（指针）
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        // 插入节点 在 n1 -> n2 中间插入节点 p
        TreeNode p = new TreeNode(0);
        n1.left = p;
        p.left = n2;

        // 删除节点 p
        n1.left = n2;
    }
}
