package problems.c0easy.t501t1000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 589 N叉树的前序遍历 https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 * 给定一个n叉树的根节点root，返回其节点值的前序遍历
 *
 * 示例：
 * 输入1：root = [1,null,3,2,4,null,5,6]
 * 输出1：[1,3,5,6,2,4]
 *
 * 输入2：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出2：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
public class T589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 官方解法1：递归
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }


    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        //先遍历根节点，再依次遍历每一个子节点
        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }

    /**
     * 官方解法2：迭代
     */
    public List<Integer> perorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return  res;
        }

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }

        return res;
    }
}
