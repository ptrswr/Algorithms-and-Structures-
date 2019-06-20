package sort_alg;

import java.security.InvalidParameterException;

public class ShellSort implements Sort{
	
	public String toString() { return "ShellSort"; }

	@Override
	public void sort(int[] array) {
		// TODO Auto-generated method stub        
			sort(array, array.length / 2);
		}
		
	public void sort(int[] array, int gap) throws InvalidParameterException {
		if (gap > array.length / 2) throw new InvalidParameterException();
			
		while (gap > 0 ) {
			for (int i = gap; i < array.length; i++ ) {
				int temp = array[i];
					
				int j;
				for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
						array[j] = array[j - gap];
					}
					array[j] = temp;
				}
				gap /= 2;
			}
		} 

}
