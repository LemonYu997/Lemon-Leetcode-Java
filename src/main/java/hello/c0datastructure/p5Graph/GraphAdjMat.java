package hello.c0datastructure.p5Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于邻接矩阵实现无向图
 *
 * 常见操作：
 * 1、判断是否邻接   时间复杂度 O(1)
 * 2、添加边        时间复杂度 O(1)
 * 3、删除边        时间复杂度 O(1)
 * 4、添加顶点      时间复杂度 O(n)
 * 5、删除顶点      时间复杂度 O(n2)
 * 6、初始化        时间复杂度 O(n2)
 */
public class GraphAdjMat {
    // 顶点列表，元素代表"顶点值" 索引代表"顶点索引"
    List<Integer> vertices;
    // 邻接矩阵，行列索引对应 "顶点索引"
    List<List<Integer>> adjMat;

    // 构造方法
    public GraphAdjMat(int[] vertices, int[][] edges) {
        this.vertices = new ArrayList<>();
        this.adjMat = new ArrayList<>();
        // 添加顶点
        for (int vertex : vertices) {
            addVertex(vertex);
        }
        // 添加边，edges元素代表顶点索引
        // edges[][0] 和 edges[][1] 表示对应 vertices 索引中两个顶点的边
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }
    }

    // 获取顶点数量
    public int size() {
        return vertices.size();
    }

    // 添加顶点
    public void addVertex(int val) {
        int n = size();
        // 向顶点列表中添加新的顶点值
        vertices.add(val);
        // 在邻接矩阵中添加一行
        List<Integer> newRow = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            newRow.add(0);
        }
        adjMat.add(newRow);
        // 在邻接矩阵中添加一行
        for (List<Integer> row : adjMat) {
            row.add(0);
        }
    }

    //删除顶点
    public void removeVertex(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        // 在顶点列表中移除索引 index 的顶点
        vertices.remove(index);
        // 在邻接矩阵中删除索引 index 的行
        adjMat.remove(index);
        // 在邻接矩阵中删除索引 index 的列
        for (List<Integer> row : adjMat) {
            row.remove(index);
        }
    }

    // 添加顶点 参数 i j 对应 vertices 索引
    public void addEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IndexOutOfBoundsException();
        }
        // 在无向图中，邻接矩阵关于主对角线对称，即满足 (i, j) == (j, i)
        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    //删除边 参数 i, j 对应 vertices 元素索引
    public void removeEdge(int i, int j) {
        // 索引越界与相等处理
        if (i < 0 || j < 0 || i >= size() || j >= size() || i == j) {
            throw new IndexOutOfBoundsException();
        }
        // 在无向图中，邻接矩阵关于主对角线对称，即满足 (i, j) == (j, i)
        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    //打印邻接矩阵
    public void print() {
        System.out.print("顶点列表 = ");
        System.out.println(vertices);
        System.out.print("邻接矩阵 = ");
        System.out.println(adjMat);
    }
}
