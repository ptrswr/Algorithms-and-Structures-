package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import sort_alg.*;

public class Data_Results {
	public static void main(String[] args) throws  FileNotFoundException, UnsupportedEncodingException  {
		// TODO Auto-generated method stub
		double[] seqLen = {1, 5, 10, 20};
    	double[] seqType = {0, 0.5, 1, -1};
    	Sort[] sortAlgs = {new QuickSort(), new ShellSort(), new MergeSort(), new ShellSort()};
    	
    	PrintWriter writer = new PrintWriter("pomiary.txt", "UTF-8");
    	
    	 
    		for (double len : seqLen) {
    			for (double type : seqType) {
    				ArrayList<int [] > list1 = new ArrayList<>();
    				
    				for (int i = 0; i < 100; i++) {
    					 int [] seq = Gen_Sequence.getSequence(len, type);
    					list1.add(seq);
    				
    				}   				
    					int counter=0;
    					
    				for (Sort alg : sortAlgs) {
						System.out.println("alg: "+counter+" "+  alg.toString() + ", len: " + len + ", type: " + type);
						writer.println("alg: " +counter+" "+ alg.toString() + ", len: " + len + ", type: " + type);
							
						System.out.println(counter);
	    				for (int j = 0; j < 100; j++) {
	    					
	    					 int [] loaded = list1.get(j);
	    					 	int[] sequence = loaded.clone();
	    					
	    		    		Instant start = Instant.now();
	    		    		if(counter!=3)
	    		    		  alg.sort(sequence);
	    		    		else
	    		    		  ((ShellSort)alg).sort(sequence, sequence.length/4);
	    		    		
	    		    		Instant finish = Instant.now();
	    					
	    		    		System.out.print(Duration.between(start, finish).toMillis());
	    		    		writer.print(Duration.between(start, finish).toMillis());
	    		    		if (j != 99) {
	    		    			System.out.print(", ");
	    		    			writer.print(" ");
	    		    		  }
	    				}
    				
    				counter++;
    				System.out.println("");
    				System.out.println("");
    				writer.println("");
    				writer.println("");
    			}
    			
    		}
			System.out.println("");
			System.out.println("");
			writer.println("");
			writer.println("");
    	}
    	writer.close();
	}
}	

