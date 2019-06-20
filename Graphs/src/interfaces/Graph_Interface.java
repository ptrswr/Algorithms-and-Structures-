package interfaces;

import java.util.HashSet; 
import java.util.Set;


public interface Graph_Interface {
	
	public void addEdge(Integer v1, Integer v2, Double weight);
	public void addVertex(Integer v);
	public void removeVertex(Integer v);
	public Set<? extends Edge_IF> getEdges(Integer v); 
	public HashSet<Integer> getVertices(); 
	public void printGraph();
	
}
