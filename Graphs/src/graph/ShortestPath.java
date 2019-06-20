package graph;
 
import java.util.ArrayList;
import java.util.HashMap ; 
import java.util.Map;
import java.util.TreeSet;

import interfaces.ShortestPath_I;

public class ShortestPath implements ShortestPath_I {
	public Graph graph ;
    Map<Integer, Double> distance = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ShortestPath(Graph g)
    {
    	graph=g;
    }

	
	public void shortestPath(Integer source) {

        TreeSet<Integer> openSet = new TreeSet<>();
        
        for (Integer vertex : graph.getVertices()) {
            if (source.equals(vertex)) distance.put(source, 0d);
            else distance.put(vertex, Double.POSITIVE_INFINITY);
            openSet.add(vertex);
        }
        while (!openSet.isEmpty()) {

            Integer min = 0;
            double minDis = Double.POSITIVE_INFINITY;
            for (Integer vertex : openSet) {
                if (minDis > distance.get(vertex)) {
                    minDis = distance.get(vertex);
                    min = vertex;
                }
            }

            openSet.remove(min);
            list.add(min);

            for (Edge edge : graph.getEdges(min)) {

                Double newPath = distance.get(min) + edge.getWeight();
                if (distance.get(edge.getTo()) > newPath) {
                    distance.put(edge.getTo(), newPath);
                }
            }
        }
    }
	
	public void printPath()
	{
		for(Integer i :list)
			System.out.print(i + " " +distance.get(i) + "   ");
		
	}


}
