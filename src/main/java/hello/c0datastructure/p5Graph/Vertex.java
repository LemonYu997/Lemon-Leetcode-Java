package hello.c0datastructure.p5Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 顶点类 用于邻接表实现图
 */
public class Vertex {
    public int val; //顶点值

    public Vertex(int val) {
        this.val = val;
    }

    // 输入值列表 vals，返回顶点列表 vets
    public static Vertex[] valsToVets(int[] vals) {
        Vertex[] vets = new Vertex[vals.length];
        for (int i = 0; i < vals.length; i++) {
            vets[i] = new Vertex(vals[i]);
        }
        return vets;
    }

    // 输入顶点列表 vets，返回值列表 vals
    public static List<Integer> vetsToVals(Vertex[] vets) {
        List<Integer> vals = new ArrayList<>();
        for (Vertex vet : vets) {
            vals.add(vet.val);
        }
        return vals;
    }
}
