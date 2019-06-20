package app;
 
import java.security.InvalidParameterException;
import java.util.Random;
import java.util.stream.IntStream;

import sort_alg.QuickSort;

public class Gen_Sequence {
	// length /100000 -> 1,5,10,20
	// type 0 - random, 0.5 - half sorted , 1 - sorted, -1 - reverse
	
	
	public static int[] getSequence(double length, double type) throws InvalidParameterException {
		if (length >20) throw new InvalidParameterException();
		if (type != 0 && type != 0.5 && type != 1 && type != -1) throw new InvalidParameterException();
		
		Random random = new Random();
		int newLength = (int)(length * 100000);
	
		IntStream tab = random.ints(newLength);
		
		if (type == 0.5) {
			int [] half_S = tab.toArray();
			int [] to_sort = new int[half_S.length/2];
			for(int i = 0; i < half_S.length / 2; i++)
			{
			 to_sort[i]=half_S[i];
			}
			QuickSort q = new QuickSort();
			q.sort(to_sort);
			for(int i = 0; i < half_S.length / 2; i++)
			{
			 half_S[i]=to_sort[i];
			}
			
			return half_S;
		} else if (type == 1) {
			QuickSort q = new QuickSort();
			int [] sorted_tab =tab.toArray().clone();
			q.sort(sorted_tab);
			return sorted_tab;
			
		} else if (type == -1) {
			QuickSort q = new QuickSort();
			int [] sorted_tab =tab.toArray().clone();
			q.sort(sorted_tab);
			for(int i = 0; i < sorted_tab.length / 2; i++)
			{
			    int temp = sorted_tab[i];
			    sorted_tab[i] = sorted_tab[sorted_tab.length - i - 1];
			    sorted_tab[sorted_tab.length - i - 1] = temp;
			}
			return sorted_tab;
		}else
			return tab.toArray();
		
	}
	

}
