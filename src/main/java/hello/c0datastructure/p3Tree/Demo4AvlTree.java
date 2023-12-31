package hello.c0datastructure.p3Tree;

/**
 * 平衡二叉搜索树 AVL https://www.hello-algo.com/chapter_tree/avl_tree/
 *
 */
public class Demo4AvlTree {
    //AVL 节点类
    class TreeNode {
        public int val;         //节点值
        public int height;      //节点高度
        public TreeNode left;   //左子结点
        public TreeNode right;  //右子节点
        public TreeNode(int x) {
            val = x;
        }
    }

    //根节点
    private TreeNode root;

    //获取节点高度
    int height(TreeNode node) {
        //空节点高度为 -1，叶节点高度为 0
        return node == null ? -1 : node.height;
    }

    //更新节点高度
    void updateHeight(TreeNode node) {
        //节点高度等于最高子树高度 + 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    //节点平衡因子 节点左子树高度 - 右子树高度，空节点平衡因子为 0
    int balanceFactor(TreeNode node) {
        //空节点平衡因子为 0
        if (node == null) {
            return 0;
        }
        //节点平衡因子 = 左子树高度 - 右子树高度
        return height(node.left) - height(node.right);
    }

    //右旋
    TreeNode rightRotate(TreeNode node) {
        TreeNode child = node.left;
        TreeNode grandChild = child.right;
        //以 child 为原点，将 node 向右旋转
        child.right = node;
        node.left = grandChild;
        //更新节点高度
        updateHeight(node);
        updateHeight(child);
        //返回旋转后子树的节点
        return child;
    }

    //左旋操作
    TreeNode leftRotate(TreeNode node) {
        TreeNode child = node.right;
        TreeNode grandChild = child.left;
        //以 child 为原点，将 node 向左旋转
        child.left = node;
        node.right = grandChild;
        //更新节点的高度
        updateHeight(node);
        updateHeight(child);
        // 返回旋转后子树的根节点
        return child;
    }

    /**
     * 四种旋转情况对应的平衡因子
     * 失衡节点的平衡因子    |   子节点平衡因子    |    旋转方法
     *  > 1 左偏树         |       >= 0       |      右旋
     *  > 1 左偏树         |       < 0        |    先左旋后右旋
     *  < -1 右偏树        |       <= 0       |      左旋
     *  < -1 右偏树        |       > 0        |    先右旋后左旋
     */
    TreeNode rotate(TreeNode node) {
        //获取节点的平衡因子
        int balanceFactor = balanceFactor(node);
        //左偏树
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                // 右旋
                return rightRotate(node);
            } else {
                //先左旋后右旋
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //右偏树
        if (balanceFactor < -1) {
            if (balanceFactor(node.right) <= 0) {
                //左旋
                return leftRotate(node);
            } else {
                //先右旋再左旋
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
        //平衡树 无需旋转
        return node;
    }

    //插入节点
    void insert(int val) {
        root = insertHelper(root, val);
    }

    //递归插入节点 辅助方法
    TreeNode insertHelper(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        // 1、查找插入节点的位置
        if (val < node.val) {
            node.left = insertHelper(node.left, val);
        } else if (val > node.val) {
            node.right = insertHelper(node.right, val);
        } else {
            //重复节点不插入，直接返回
            return node;
        }
        //更新节点高度
        updateHeight(node);
        //2、执行旋转操作，使该子树恢复平衡
        node = rotate(node);
        //返回子树的根节点
        return node;
    }

    //删除节点
    void remove(int val) {
        root = removeHelper(root, val);
    }

    //递归删除节点 辅助方法
    TreeNode removeHelper (TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        //1、查找节点并删除
        if (val < node.val) {
            node.left = removeHelper(node.left, val);
        } else if (val > node.val) {
            node.right = removeHelper(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                TreeNode child = node.left != null ? node.left : node.right;
                //子节点数量 = 0，直接删除 node 并返回
                if (child == null) {
                    return null;
                } else {
                    // 子节点数量 = 1，直接删除 node
                    node = child;
                }
            } else {
                //子节点数量 = 2，将中序遍历的下个节点删除，并用该节点替换当前节点
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.right = removeHelper(node.right, temp.val);
                node.val = temp.val;
            }
        }
        // 更新节点高度
        updateHeight(node);
        // 2、执行旋转操作，使该子树重新回复平衡
        node = rotate(node);
        // 返回子树的根节点
        return node;
    }
}
