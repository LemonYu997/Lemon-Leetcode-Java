package hello.c0datastructure.p3Tree;

/**
 * 二叉搜索树 https://www.hello-algo.com/chapter_tree/binary_search_tree/
 * 对于根节点，左子树中所有节点的值 < 根节点的值 < 右子树中所有节点的值
 * 任意节点中的左、右子树也是二叉搜索树，同样满足条件
 * 不允许出现重复节点
 * 中序遍历 升序 时间复杂度O(n)
 */
public class Demo3BinarySearchTree {

    public class BinarySearchTree {
        //根节点
        private TreeNode root;

        //查找节点 二分查找 时间复杂度O(log n)
        TreeNode search(int num) {
            TreeNode cur = root;
            //循环查找，越过叶节点后跳出
            while (cur != null) {
                // 目标节点在 cur 的右子树中
                if (cur.val < num) {
                    cur = cur.right;
                } else if (cur.val > num) {
                    //目标节点在 cur 的左子树中
                    cur = cur.left;
                } else {
                    //找到目标节点，跳出循环
                    break;
                }
            }
            return cur;
        }

        //插入节点 时间复杂度O(log n)
        void insert(int num) {
            // 若树为空，则初始化根节点
            if (root == null) {
                root = new TreeNode(num);
                return;
            }
            TreeNode cur = root, pre = null;
            //循环查找，越过叶节点后跳出
            while (cur != null) {
                //找到重复节点，直接返回
                if (cur.val == num) {
                    return;
                }
                pre = cur;
                //插入位置在 cur 的右子树中
                if (cur.val < num) {
                    cur = cur.right;
                } else {
                    //插入位置在 cur 的左子树中
                    cur = cur.left;
                }
            }
            //插入节点
            TreeNode node = new TreeNode(num);
            if (pre.val < num) {
                pre.right = node;
            } else {
                pre.left = node;
            }
        }

        //删除节点 时间复杂度O(log n)
        void remove(int num) {
            //若树为空，直接提前返回
            if (root == null) {
                return;
            }
            TreeNode cur = root, pre = null;
            //循环查找，越过叶节点后跳出
            while (cur != null) {
                //找到待删除节点，跳出循环
                if (cur.val == num) {
                    break;
                }
                pre = cur;
                //待删除节点在 cur 的右子树中
                if (cur.val < num) {
                    cur = cur.right;
                } else {
                    // 待删除节点在 cur 的左子树中
                    cur = cur.left;
                }
            }
            //若无待删除节点，则直接返回
            if (cur == null) {
                return;
            }
            //子节点数量 = 0 or 1
            if (cur.left == null || cur.right == null) {
                //当子节点数量 = 0 / 1时，child = null / 该子节点
                TreeNode child = cur.left != null ? cur.left : cur.right;
                //删除节点 cur
                if (cur != root) {
                    if (pre.left == cur) {
                        pre.left = child;
                    } else {
                        pre.right = child;
                    }
                } else {
                    //若删除节点为根节点，则重新指定根节点
                    root = child;
                }
            } else {
                //子节点数量 = 2 获取中序遍历中 cur 的下一个节点
                TreeNode tmp = cur.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                //递归删除节点 tmp
                remove(tmp.val);
                //用tmp覆盖cur
                cur.val = tmp.val;
            }
        }
    }
}
