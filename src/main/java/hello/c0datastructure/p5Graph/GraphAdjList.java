package hello.c0datastructure.p5Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于邻接表实现的无向图类
 * 这里使用哈希表
 *
 * 常见操作：
 * 1、判断是否邻接   时间复杂度 O(1)
 * 2、添加边        时间复杂度 O(1)
 * 3、删除边        时间复杂度 O(1)
 * 4、添加顶点      时间复杂度 O(1)
 * 5、删除顶点      时间复杂度 O(n)
 * 6、初始化        时间复杂度 O(n + m)
 */
public class GraphAdjList {
    // 邻接表 key：顶点，value：该顶点的所有邻接顶点
    Map<Vertex, List<Vertex>> adjList;

    // 构造方法
    public GraphAdjList(Vertex[][] edges) {
        this.adjList = new HashMap<>();
        // 添加所有顶点和边
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    // 获取顶点数量
    public int size() {
        return adjList.size();
    }

    //添加边
    public void addEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2) {
            throw new IndexOutOfBoundsException();
        }
        // 添加边 vet1 - vet2
        adjList.get(vet1).add(vet2);
        adjList.get(vet2).add(vet1);
    }

    // 删除边
    public void removeEdge(Vertex vet1, Vertex vet2) {
        if (!adjList.containsKey(vet1) || !adjList.containsKey(vet2) || vet1 == vet2) {
            throw new IndexOutOfBoundsException();
        }
        // 删除边 vet1 - vet2
        adjList.get(vet1).remove(vet2);
        adjList.get(vet2).remove(vet1);
    }

    // 添加顶点
    public void addVertex(Vertex vet) {
        if (adjList.containsKey(vet)) {
            return;
        }
        // 在邻接表中添加一个新数组
        adjList.put(vet, new ArrayList<>());
    }

    // 删除顶点
    public void removeVertex(Vertex vet) {
        if (!adjList.containsKey(vet)) {
            throw new IndexOutOfBoundsException();
        }
        // 在邻接表中删除顶点 vet 对应的链表
        adjList.remove(vet);
        // 遍历其他顶点的链表，删除所有包含 vet 的边
        for (List<Vertex> list : adjList.values()) {
            list.remove(vet);
        }
    }

    // 打印邻接表
    public void print() {
        System.out.println("邻接表 = ");
        for (Map.Entry<Vertex, List<Vertex>> entry : adjList.entrySet()) {
            List<Integer> temp = new ArrayList<>();
            for (Vertex vertex : entry.getValue()) {
                temp.add(vertex.val);
            }
            System.out.println(entry.getKey().val + ": " + temp + ",");
        }
    }
}
