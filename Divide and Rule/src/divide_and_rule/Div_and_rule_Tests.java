package divide_and_rule;

import org.junit.jupiter.api.BeforeEach;     
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
 
public class Div_and_rule_Tests {
	
	private Div_and_rule div = new Div_and_rule();
	ArrayList<Integer> list;
	
	@BeforeEach
	 void setUp() {
	     	list = new ArrayList<>();
	     	list.add(1);
	     	list.add(2);
			list.add(3);
		
	    
	 }

	 	@Test
	 	void smaller_K() throws IllegalArgumentException  {
		 
	 		
		 	assertEquals(2, div.alg(2,list) );
	 	}
	 	@Test
	 	void invalid_K_n1() throws IllegalArgumentException{
	 		 
	 		
	 		
	 		assertThrows(IllegalArgumentException.class, () -> div.alg(-1, list));
	 	}
	 	@Test
	 	void invalid_K_n2() throws IllegalArgumentException{
	 		
	 		
	 		
	 		assertThrows(IllegalArgumentException.class, () -> div.alg(list.size()+1, list));
	 	}
	 	@Test
	 	void invalid_List_n1() throws IllegalArgumentException{
	 		
	 		
	 		
	 		assertThrows(NullPointerException.class, () -> div.alg(35, null));
	 	}
	 	@Test
	 	void invalid_List_n2() throws IllegalArgumentException{
	 		
	 		list.clear();
	 		
	 		assertThrows(NullPointerException.class, () -> div.alg(35, list));
	 	}
	 	@Test
	 	void greater_K() throws IllegalArgumentException {
		 
	 		
		 	assertEquals(7, div.alg(9,list) );
	 	}
	 	

}
