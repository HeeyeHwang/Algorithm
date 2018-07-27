package study.data.structure.sort;

import java.util.Arrays;

public class SortClass {

	public static int[] bubbleSort(int[] target) {
		
		for(int j = target.length -1 ; j > 0 ; j--) {
			for(int i = 0 ; i < j ; i++) {
				
				int left = target[i];
				int right = target[i+1];
				
				if(left > right) {
					target[i] = right;
					target[i+1] = left;
				}
			}
		}
		
		return target;
	}
	
	public static int[] selectionSort(int[] target) {
		return target;
	}
	
	public static int[] insertionSort(int[] target) {
		return target;
	}
	
	public static void quickSort(int[] array, int left, int right) {

		int pivotIndx = partition(array, left, right);
		
		if(left < pivotIndx -1) {
			quickSort(array, left, pivotIndx-1);
		}
		if(pivotIndx < right) {
			quickSort(array, pivotIndx, right);
		}
		
	}
	
	private static int partition(int[] array, int left, int right) {
		
		int temp = 0;
		int pivot = array[ (left + right) /2];
		
		while(left < right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
		
		return left;
	}
}
