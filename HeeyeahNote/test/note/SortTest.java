package note;

import org.junit.jupiter.api.Test;

import java.util.Arrays;



public class SortTest {

	@Test
	public void heapSort() {

		int[] arr = new int[] {95, 39, 14, 19, 1, 18, 16, 7, 87, 92};

		System.out.printf("before %s \n", Arrays.toString(arr));
		
		HeapSort heapSort = new HeapSort(arr);
		heapSort.sort();
		
		System.out.printf("after  %s", Arrays.toString(arr));
	}
	
}
