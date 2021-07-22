package dataStructure;

import java.util.Arrays;

public class MergeSort {
 //Method to mergeSort the given array
	public static int[] mergeSort(int[] array) {
		// Since we are using recursion, we have to return array when it is split to a single array.
		if(array.length <= 1) {
			return array;
		}
		int middleIdx = array.length/2;
		//lets make the array into two arrays.
		// we can loop the array and insert values to it.Here we are using copyOfRange So the index from to endIdx given -1 position gets inserted.
		int[] firstHalf = Arrays.copyOfRange(array, 0, middleIdx);
		int[] secondHalf = Arrays.copyOfRange(array, middleIdx, array.length);
		// Recursive call for mergeSort the values and return the final Sorted value.
		return join(mergeSort(firstHalf),mergeSort(secondHalf));
	}
	// Method for joining two arrays.
	public static int[] join(int[] firstHalf,int[] secondHalf) {
		// we need a new array to insert the sorted and merged values.
		int[] newArray = new int[firstHalf.length+secondHalf.length];
		// We need three variable to index through firstHalf,secondHalf and newArray during these process.
		int i = 0;
		int j = 0;
		int k = 0;
		// Loop until one arrays value gets fully assigned to newArray.
		while(i<firstHalf.length && j<secondHalf.length) {
			if(firstHalf[i] <= secondHalf[j]) {
				newArray[k] = firstHalf[i];
				k++;
				i++;
			}else {
				newArray[k++] = secondHalf[j++]; // Simplified code as in if statement.
			}
		}
		// Above loop gets ends when one of the array get fully assigned. 
		// We need two while loops for assign the rest of values to newArray.
		while(i<firstHalf.length) {
			newArray[k++] = firstHalf[i++];
		}
		while(j<secondHalf.length) {
			newArray[k++] = secondHalf[j++];
		}
		Arrays.stream(newArray).forEach(System.out::print);
		System.out.println();
		return newArray;
	}
	public static void main(String[] args) {
		int[] array = {3,5,7,1,0,9,2,4,6,8};
		int []result = mergeSort(array);
	//	Arrays.stream(result).forEach(System.out::println);
	}
}
