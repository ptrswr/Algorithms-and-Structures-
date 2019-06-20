package app;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

import sort_alg.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String seqLen;
		do {
	        System.out.println("Choose sequence length:");
	        System.out.println("\t1 - 100k");
	        System.out.println("\t2 - 500k");
	        System.out.println("\t3 - 1M");
	        System.out.println("\t4 - 2M");
	        seqLen = scan.next();
		} while (!seqLen.equals("1") && !seqLen.equals("2") && !seqLen.equals("3") && !seqLen.equals("4"));
		

		String seqType;
		do {
	        System.out.println("Choose sequence initial sorting:");
	        System.out.println("\t1 - unsorted");
	        System.out.println("\t2 - 50% sorted");
	        System.out.println("\t3 - 100% sorted");
	        System.out.println("\t4 - reverse sorted");
	        seqType = scan.next();
		} while (!seqType.equals("1") && !seqType.equals("2") && !seqType.equals("3") && !seqType.equals("4"));
		

		String sortType;
		do {
	        System.out.println("Choose sequence initial sorting:");
	        System.out.println("\t1 - QuickSort");
	        System.out.println("\t2 - ShellSort");
	        System.out.println("\t3 - MergeSort");
	        sortType = scan.next();
		} while (!sortType.equals("1") && !sortType.equals("2") && !sortType.equals("3"));

		scan.close();
	
    	double[] lengthArray = {1, 5, 10, 20};
    	
    	double[] typeArray = {0, 0.5, 1, -1};

		int[] seq = Gen_Sequence.getSequence(lengthArray[Integer.parseInt(seqLen) - 1], typeArray[Integer.parseInt(seqType) - 1]);
		
		int[] sortedSeq = seq.clone();

		Instant start = Instant.now();

		if (sortType.equals("1")) {
    		new QuickSort().sort(sortedSeq);
    	} else if (sortType.equals("2")) {
    		new ShellSort().sort(sortedSeq);
    	} else {
    		new MergeSort().sort(sortedSeq);
    	}
		
		Instant finish = Instant.now();
		
		for(int i = seq.length - 100; i < seq.length; i++)
			System.out.println(sortedSeq[i] + "\t" + seq[i]);
		
		System.out.println("SORTED\t\tORIGINAL");
		System.out.println(Duration.between(start, finish).toMillis() + "ms");
	
	}

}
