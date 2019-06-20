package bst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
 
public class Bst_Test {
	
		Bst b; 
		private  ByteArrayOutputStream out = new ByteArrayOutputStream();

		
		@BeforeEach
		 void setUp() {
			b= new Bst();
			b.insert(7);
			b.insert(3);
			b.insert(10);
			b.insert(5);
			b.insert(4);
			b.insert(1);
			b.insert(9);
			b.insert(12);
			b.insert(8);
			
		 }
	   
		@Test
	 	 public void build()   {
		 
			
		 	assertEquals(8, b.root.right.left.left.value );
	 	}
		@Test
		public void deletTeree()   {
			
			
			b.delete(3);
			
			assertEquals(4, b.root.left.value);
		}
		@Test
		public void upperTree()   {
			
			
			
			assertEquals(7, b.upper(5) );
		}
		@Test
		public void lowerTree()   {
			
			
			
			assertEquals(9, b.lower(10) );
		}
		@Test
		void alreadyExists() throws RuntimeException{
	 		
	 		
	 		assertThrows(RuntimeException.class, () -> b.insert(7) );
	 	}	
		@Test
		void noGreaterElement() throws NoSuchElementException{
			
			
			assertThrows(NoSuchElementException.class, () -> b.upper(12) );
		}	
		@Test
		void noSmallerElement() throws NoSuchElementException{
			
			
			assertThrows(NoSuchElementException.class, () -> b.lower(1) );
		}	
		@Test
		void noSuchElement() throws NoSuchElementException{
			
			
			assertThrows(NoSuchElementException.class, () -> b.delete(20) );
		}	
		@Test
		void print() {
			System.setOut(new PrintStream(out));
			
			b.printTree(1);
			assertEquals(" 7 3 1 5 4 10 9 8 12", out.toString());
			out.reset();
			b.printTree(2);
			assertEquals(" 1 4 5 3 8 9 12 10 7", out.toString());
			out.reset();
			b.printTree(3);
			assertEquals(" 1 3 4 5 7 8 9 10 12", out.toString());
			out.reset();
		}	
		
	}


