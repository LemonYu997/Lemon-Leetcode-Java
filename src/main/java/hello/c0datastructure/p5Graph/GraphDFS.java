package hello.c0datastructure.p5Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 图的遍历——深度优先遍历 DFS
 * 基于递归实现
 */
public class GraphDFS {
    /**
     * 深度优先遍历
     * 使用邻接表表示图，以便获取顶点的所有邻接顶点
     */
    List<Vertex> graphDFS(GraphAdjList graph, Vertex startVet) {
        // 顶点遍历序列
        List<Vertex> res = new ArrayList<>();
        // 哈希表，用于记录已被访问过的顶点
        Set<Vertex> visited = new HashSet<>();
        dfs(graph, visited, res, startVet);
        return res;
    }

    /**
     * 递归辅助函数
     */
    void dfs(GraphAdjList graph, Set<Vertex> visited, List<Vertex> res, Vertex vet) {
        // 记录访问顶点
        res.add(vet);
        // 标记该顶点已被访问
        visited.add(vet);
        // 遍历该顶点的所有邻接顶点
        for (Vertex vertex : graph.adjList.get(vet)) {
            // 跳过已被访问的顶点
            if (visited.contains(vertex)) {
                continue;
            }
            // 递归访问邻接顶点
            dfs(graph, visited, res, vertex);
        }
    }
}
