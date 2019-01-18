package note;

import java.util.Arrays;

public class QuickSort {
	
	public void quickSort(int[] array, int left, int right) {

		int pivotIndx = partition(array, left, right);
		
		if(left < pivotIndx -1) {
			quickSort(array, left, pivotIndx-1);
		}
		if(pivotIndx < right) {
			quickSort(array, pivotIndx, right);
		}
		
	}
	
	private int partition(int[] array, int left, int right) {
		
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
	
	public static void main(String[] args) {
		
		int[] array = new int[] {7, 3, 4, 11, 78, 9, 0, 27};
		int left = 0;
		int right = array.length - 1;
		
		QuickSort sort = new QuickSort();
		sort.quickSort(array, left, right);
		
		System.out.println(Arrays.toString(array));
	}
}
