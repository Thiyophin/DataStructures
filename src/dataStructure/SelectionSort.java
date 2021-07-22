package dataStructure;

import java.util.Arrays;

public class SelectionSort {
 public static int[] selectionSort(int[] array) {
	 for(int i=0;i<array.length;i++) {
		 for(int j=i+1;j<array.length;j++) {
			 if(array[i]>array[j]) {
				 int temp = array[j];
				 array[j] = array[i];
				 array[i] = temp;
			 }
		 }
	 }
	 return array;
 }
 public static void main(String[] args) {
	int[] array = {22,33,11,4,2,5,33,0};
	int[] result = selectionSort(array);
	Arrays.stream(result).forEach(System.out::println);
}
}
