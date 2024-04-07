package problems.c0easy.t501t1000;

import java.util.*;

/**
 * 590 N叉树的后序遍历 https://leetcode.cn/problems/n-ary-tree-postorder-traversal/
 * 给定一个n叉树的根节点root，返回其节点值的后序遍历
 * N叉树在输入中按层序遍历进行序列化表示，每组节点由空值null分割
 *
 * 示例：
 * 输入1：root = [1,null,3,2,4,null,5,6]
 * 输出1：[5,6,3,2,4,1]
 *
 * 输入2：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出2：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 */
public class T590 {
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
     * 自己实现：递归
     * 先遍历子节点，再向上遍历
     */
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, ans);
        return ans;
    }

    public void helper(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        //先遍历子节点，再向上遍历
        for (Node child : root.children) {
            helper(child, ans);
        }
        ans.add(root.val);
    }

    /**
     * 自己实现：迭代 先前序遍历再反转
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        //栈：先入先出
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            ans.add(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
