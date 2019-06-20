package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import interfaces.Graph_Interface;

public class Graph implements Graph_Interface {
	
	private HashMap<Integer, Set<Edge> > vertexMap = new HashMap<>();
	
	HashSet<Edge> edges = new HashSet<>();
	
	

	@Override
	public void addVertex(Integer v) {
		// TODO Auto-generated method stub
        vertexMap.put(v, new HashSet<>());

	}

 

	@Override
    public void addEdge(Integer v1, Integer v2, Double weight) {
		// TODO Auto-generated method stub

        if(!vertexMap.containsKey(v1) || !vertexMap.containsKey(v2))return;
        
        Edge edge = new Edge(v1, v2, weight);
        vertexMap.get(v1).add(edge);
        edges.add(edge);

    
        Edge edge2 = new Edge(v2, v1, weight);
        vertexMap.get(v2).add(edge2);
    }



	@Override
	public void removeVertex(Integer v) {
		// TODO Auto-generated method stub
    	vertexMap.remove(v);
    }

	@Override
    public HashSet<Integer> getVertices() {
        return new HashSet<>(vertexMap.keySet());
    }
	
	@Override
    public Set<Edge> getEdges(Integer v) {
		// TODO Auto-generated method stub

    	return vertexMap.get(v);
    }

    public int size() {
        return vertexMap.size();
    }

    public void printGraph() 
    {        
        for(Integer v:  getVertices()) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Edge e: getEdges(v)){ 
                System.out.print(" -> "+e.getTo()); 
            } 
            System.out.println("\n"); 
        } 
    } 

}

