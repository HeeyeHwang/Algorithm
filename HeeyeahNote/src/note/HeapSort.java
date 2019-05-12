package note;

public class HeapSort {

	private int[] arr;
	public HeapSort(int[] arr) {
		this.arr = arr;
	}
	
	public void sort() {
		
		buildHeap();
		
		for (int i = arr.length-1; i > 0; i--) {
			swap(0, i); // root인 max heap switch
			heapify(0, i-1);
		}

	}
	
	private void buildHeap() {
		for(int i = (arr.length -1) / 2 ; i>= 0 ; i--) {
			heapify(i, arr.length-1);
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//min heap
	void heapify(int index, int size) {

		int left = 2*index + 1;
		int right = 2*index + 2;
		int min;
		
		if(left <= size && arr[left] < arr[index]) {
			min = left;
		} else {
			min = index;
		}
		
		if(right <= size && arr[right] < arr[min]) {
			min = right;
		}
		
		
		if(min != index) {
			swap(index, min);
			heapify(min, size);
		}
	}
}
