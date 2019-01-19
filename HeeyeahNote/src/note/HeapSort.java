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
	
	public void buildHeap() {
		for(int i = (arr.length -1) / 2 ; i>= 0 ; i--) {
			heapify(i, arr.length-1);
		}
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void heapify(int index, int size) {

		int left = 2*index + 1;
		int right = 2*index + 2;
		int max;
		
		if(left <= size && arr[left] < arr[index]) {
			max = left;
		} else {
			max = index;
		}
		
		if(right <= size && arr[right] < arr[max]) {
			max = right;
		}
		
		
		if(max != index) {
			swap(index, max);
			heapify(max, size);
		}
	}
}
