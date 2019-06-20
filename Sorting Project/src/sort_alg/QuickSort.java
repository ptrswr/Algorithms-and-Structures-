package sort_alg;

public class QuickSort implements Sort{

	
	@Override
	public void sort(int[] array) {
	// TODO Auto-generated method stub
		sort(array, 0, array.length - 1);
	}
	
	public String toString() { return "QuickSort"; }
	
	private void sort(int[] array, int start, int end) {
		int i = start;
		int j = end;
		int pivot = array[(end + start) / 2];
		do {
			while (array[i] < pivot && i < end) i++;
			while (array[j] > pivot && j > start) j--;
				if (i <= j) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
					i++;
					j--;
				}
			} while (i <= j);
			
			if(j > start) sort(array, start, j);
			if(i < end) sort(array, i, end);
		}
	}
			


