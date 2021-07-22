package dataStructure;

import java.util.Arrays;

public class BubbleSort {
   public static int[] bubbleSort(int[] array) {
	   for(int i=array.length-1; i>=0; i--) {
		   for(int j=0; j<i ; j++) {
			   if(array[j]>array[j+1]) {
				   int temp = array[j+1];
				   array[j+1] = array[j];
				   array[j] = temp;
			   }
		   }
	   }
	   return array;
   }
	public static void main(String[] args) {
	int[] array = {11,2,33};
	int[]result = bubbleSort(array);
	Arrays.stream(result).forEach(System.out::println);
}
}
