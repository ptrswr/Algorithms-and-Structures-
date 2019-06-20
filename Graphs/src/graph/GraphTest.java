package graph;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {
	
	Graph g;
	private  ByteArrayOutputStream out = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() throws Exception {
		g = new Graph();
		g.addVertex(2);
		g.addVertex(5);
		g.addVertex(12);
		g.addVertex(4);
		g.addVertex(311);
		g.addVertex(26);
		
		
		g.addEdge(2, 5, 2.0);
		g.addEdge(2, 4, 4.0);
		g.addEdge(2, 311, 5.0);
		g.addEdge(5, 12, 1.0);
		g.addEdge(12,26, 12.0);
		g.addEdge(4, 26, 8.0);
		g.addEdge(4, 311, 7.0);
	}

	@Test
	void testGraph() {
		
		ArrayList<Integer> list =  new ArrayList<>();
		
		for( Edge  e: g.getEdges(311))
		{
			list.add( e.getTo() );
		}
		
		assertTrue( list.contains(4)  );

	}
	@Test
	void testMST() {
		System.setOut(new PrintStream(out));

		PrimMST p = new PrimMST(g);
		ArrayList<Edge> list = 	p.getMST();
		for(Edge e : list)
	    	 System.out.println(e);

		assertEquals("Edge{weight=2.0, from=2, to=5}\n" + 
				"Edge{weight=1.0, from=5, to=12}\n" + 
				"Edge{weight=4.0, from=2, to=4}\n" + 
				"Edge{weight=5.0, from=2, to=311}\n" + 
				"Edge{weight=8.0, from=4, to=26}\n", out.toString());

		
		
		
	}
	@Test
	void testdijks() {
		System.setOut(new PrintStream(out));
		ShortestPath s = new ShortestPath(g);
		s.shortestPath(4);
		s.printPath();

		
		assertEquals("4 0.0   2 4.0   5 6.0   12 7.0   311 7.0   26 8.0   ", out.toString());
		
		
		
		
	}

	@Test
	void testLowerthan0() {
	
	
		assertThrows(InvalidParameterException.class, () -> g.addEdge(2, 4, -89.0) );
	
	
	
	
}
	
	

}
