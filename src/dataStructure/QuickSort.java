package dataStructure;

import java.util.Arrays;

public class QuickSort {
	// method to pass array,startIndex and endIndex to quickSortHelper function(also used for recursive call). 
 public static int[] quickSort(int[] array) {
	 quickSortHelper(array,0,array.length-1);
	 return array;
 }
 public static void quickSortHelper(int[] array,int startIdx,int endIdx) {
	 // check if the array is in sorted position.
	 if(startIdx >= endIdx) {
		 return;
	 }
	 // partition function start
	 // pivot can be taken from random but commonly takes from start and end position of array.
	 int pivotIdx = startIdx;
	 int leftIdx = startIdx + 1; // left index start from nextTo leftIndex.
	 int rightIdx = endIdx; // rightIndex is at end of the array to sort.
	 // Loop until leftIdx is less than equal to rightIdx. if equal to also looped then no need to check condition in the end pivotIdx value is less than rightIdxvalue(if it does we have to take previous Index to swap).
	 while(leftIdx <= rightIdx) {
		 // first condition if both leftIdx and rightIdx values are at wrong position. leftIdx should be lesser than pivotIdx value and rightIndex should be greater.
		 if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
			 swap(array,leftIdx,rightIdx);
			 // then we have increment leftIndex and decrement rightIndex.
			 leftIdx ++;
			 rightIdx --;
		 }
		 // check if leftIdx is lesser than or equal to then increment to next index.
		 if(array[leftIdx] <= array[pivotIdx]) {
			 leftIdx++;
		 }
		 // check if rightIdx is greater than or equal to then decrement to previous index.
		 if(array[rightIdx] >= array[pivotIdx]) {
			 rightIdx--;
		 }
	 }swap(array,pivotIdx,rightIdx); // Partition function ends here.
	 // Now we have recursive call quickSortHelper for right and left arrays
	 // for more optimization we can check check array has more value right array or left array and pass them first.
	 quickSortHelper(array,startIdx,rightIdx - 1);
	 quickSortHelper(array,rightIdx+1,endIdx);
 }
 // method to swap two values in given array.
 private static void swap(int[] array,int i,int j) {
	 int temp = array[i];
	 array[i] = array[j];
	 array[j] = temp;
 }
 public static void main(String[] args) {
	int[] array = {22,5,22,4,1,3,40};
	int[] result = quickSort(array);
	Arrays.stream(result).forEach(System.out::println);
}
}
