package app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sort_alg.*;


public class Testing {
	QuickSort q = new QuickSort();
	ShellSort s = new ShellSort();
	MergeSort m = new MergeSort();
	
	int [] tab = {1,9,10,12,7,6,5,8,12,34,21,11};
	int [] sorted_tab = {1,5,6,7,8,9,10,11,12,12,21,34};
	int [] test;
	
	@BeforeEach
	 void setUp() {
		test= tab.clone();
	}
	@Test
	void QuickSortTest()  {
		
		q.sort(test);
	    assertArrayEquals(test, sorted_tab);	    

	}
	@Test
	void ShellSortTest()  {
		
		s.sort(test);
		assertArrayEquals(test, sorted_tab);	    
		
	}
	@Test
	void MergeSortTest()  {
		
		m.sort(test);
		assertArrayEquals(test, sorted_tab);	    
		
	}
	@Test
	void ShellSortInvalidGap()  {
	
		assertThrows(InvalidParameterException.class, () -> s.sort(test,7) );	    
		
	}
	@Test
	void SequenceInvalidLen()  {
		
		assertThrows(InvalidParameterException.class, () -> Gen_Sequence.getSequence(40,2) );	    
		
	}
	@Test
	void SequenceSortInvalidType()  {
		
		assertThrows(InvalidParameterException.class, () -> Gen_Sequence.getSequence(10, -7 ) );	    
		
	}
}
