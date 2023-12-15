package problems.c0easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 559 N叉树的最大深度 https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 * 给定一个N叉树，找到其最大深度
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数
 * N叉树输入按层序遍历序列化表示，每组子节点由空值分隔
 *
 * 示例：
 * 输入1：root = [1,null,3,2,4,null,5,6]
 * 输出1:3
 *
 * 输入2：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出2:5
 */
public class T559 {
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
     * 官方解法1：深度优先搜索 DFS
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxChildDepth = 0;
        List<Node> children = root.children;

        for (Node child : children) {
            int childDepth = maxDepth(child);
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }

        return maxChildDepth + 1;
    }

    /**
     * 官方解法2：广度优先搜索 BFS
     */
    public int maxDepth1(Node root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.offer(child);
                }
                size--;
            }
            ans++;
        }

        return ans;
    }
}
