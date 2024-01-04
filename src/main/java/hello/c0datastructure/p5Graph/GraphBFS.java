package hello.c0datastructure.p5Graph;

import java.util.*;

/**
 * 图的遍历——广度优先遍历 BFS
 * 使用队列实现
 */
public class GraphBFS {
    /**
     * 广度优先遍历
     * 使用邻接表表示图，获取指定顶点的所有邻接顶点
     */
    List<Vertex> graphBFS(GraphAdjList graph, Vertex startVet) {
        // 顶点遍历序列
        List<Vertex> res = new ArrayList<>();
        // 哈希表，用于记录已被访问过的顶点
        Set<Vertex> visited = new HashSet<>();
        visited.add(startVet);
        // 队列用于实现 BFS
        Queue<Vertex> que = new LinkedList<>();
        que.offer(startVet);
        // 以顶点 vet 为起点，循环直至访问完所有顶点
        while (!que.isEmpty()) {
            // 队首顶点出队
            Vertex vet = que.poll();
            res.add(vet);   // 记录访问顶点
            // 遍历所有该顶点的邻接顶点
            for (Vertex vertex : graph.adjList.get(vet)) {
                // 跳过已被访问的顶点
                if (visited.contains(vertex)) {
                    continue;
                }
                // 只入队未访问的顶点
                que.offer(vertex);
                // 标记该顶点已被访问
                visited.add(vertex);
            }
        }
        // 返回顶点的遍历序列
        return res;
    }
}
