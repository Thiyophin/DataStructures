package dataStructure;

import java.util.Arrays;

public class InsertionSort {
//method for bubble sort
	public static int[] insertionSort(int[] array) {
		// First we have to loop from second position to end position.
		for(int i=1;i<=array.length-1;i++) {
			// Now we have to compare current value(array[i]) with previous values.if previous values are greater interchange their positions.
			int current = array[i];
			int j = i-1;
			// we check j!<0 and current Value is greater or not.
			while(j >= 0 && array[j] > current) {
				// assign greater values to next position.
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = current;
		}
		return array;
	}
	public static void main(String[] args) {
		int[] array = {32,2,41,56,12,11,22,41};
		int[] result = insertionSort(array);
	    Arrays.stream(result).forEach(System.out::println);
	}
}
