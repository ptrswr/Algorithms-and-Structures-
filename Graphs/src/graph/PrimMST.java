package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

import interfaces.MST_I;

public class PrimMST implements MST_I {


    private Graph graph;

    public PrimMST(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<Edge> getMST() {
        ArrayList<Edge> list = new ArrayList<>();

        Integer start = getVertex();
        if (start == null) return list;

        HashSet<Integer> mst = new HashSet<>();
        
        PriorityQueue<Edge> q = new PriorityQueue<>();
        mst.add(start);
        
        q.addAll(graph.getEdges(start));

        while (!q.isEmpty()) {
            Edge minEdge = q.remove(); // najlżejsza krawędź
            Integer vertex = minEdge.getTo();
            if (mst.contains(vertex)) continue; // jeżeli jest już w mst to kolejna krawedz

            q.addAll(graph.getEdges(vertex));

            list.add(minEdge);
            mst.add(vertex); // dodać do mst

        }
        return list;
    }
   
    private Integer getVertex() {

        if (graph.getVertices().size() > 0)
            return graph.getVertices().iterator().next();

        return null;
    }
}
