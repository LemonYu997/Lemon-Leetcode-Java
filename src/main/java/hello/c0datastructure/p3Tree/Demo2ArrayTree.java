package hello.c0datastructure.p3Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的数组表示
 *
 * 使用 null 表示空位
 */
public class Demo2ArrayTree {
    public static void main(String[] args) {
        //二叉树的数组表示，用 null 表示空位
        Integer[] tree = {1, 2, 3, 4, null, 6, 7, 8, 9, null, null, 12, null, null, 15};
    }

    // 基于数组实现的二叉树
    class ArrayBinaryTree {
        private List<Integer> tree;

        //构造方法
        public ArrayBinaryTree(List<Integer> list) {
            tree = new ArrayList<>(list);
        }

        //节点数量
        public int size() {
            return tree.size();
        }

        //获取索引为i的值
        public Integer val(int i) {
            //索引越界，返回null 表示空
            if (i < 0 || i > size()) {
                return null;
            }
            return tree.get(i);
        }

        //获取索引为 i 的节点的左子结点的索引
        public int left(int i) {
            return 2 * i + 1;
        }

        //获取索引为 i 的节点的右子节点的索引
        public int right(int i) {
            return 2 * i + 2;
        }

        //获取索引为 i 的节点的父节点的索引
        public int parent(int i) {
            return (i - 1) / 2;
        }

        //层序遍历
        public List<Integer> levelOrder() {
            List<Integer> list = new ArrayList<>();
            //直接遍历数组
            for (int i = 0; i < size(); i++) {
                if (val(i) != null) {
                    list.add(val(i));
                }
            }

            return list;
        }

        //深度优先遍历
        public void dfs(Integer i, String order, List<Integer> res) {
            //若为空，返回
            if (val(i) == null) {
                return;
            }
            // 前序遍历
            if ("pre".equals(order)) {
                res.add(val(i));
            }
            dfs(left(i), order, res);
            //中序遍历
            if ("in".equals(order)) {
                res.add(val(i));
            }
            dfs(right(i), order, res);
            //后序遍历
            if ("post".equals(order)) {
                res.add(val(i));
            }
        }

        //前序遍历
        public List<Integer> preOrder() {
            List<Integer> res = new ArrayList<>();
            dfs(0, "pre", res);
            return res;
        }

        //前序遍历
        public List<Integer> inOrder() {
            List<Integer> res = new ArrayList<>();
            dfs(0, "in", res);
            return res;
        }

        //前序遍历
        public List<Integer> postOrder() {
            List<Integer> res = new ArrayList<>();
            dfs(0, "post", res);
            return res;
        }
    }
}
