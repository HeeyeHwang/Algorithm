package baekjoon;

import java.util.Scanner;

public class P1927_MinHeap {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i <n ; i++) {
			arr[i] = sc.nextInt();
		}
		
		minHeapWithArray(arr);
		
		sc.close();
	}

	enum TYPE {
		TOP_DOWN,
		BOTTOM_UP;
	}

	public static int[] heapArr = new int[100001];
	
	public static void minHeapWithArray(int[] arr) {

		int heapSize = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			int el = arr[i];
			
			if(el == 0) {
				if(heapSize == 0) {
					System.out.println(0);
				} else {
					System.out.println(heapArr[1]);
					heapArr[1] = heapArr[heapSize];
					heapArr[heapSize] = 0;
					heapSize--;
					// sort top down
					sortHeap(TYPE.TOP_DOWN, heapSize);
				}
				continue;
			}
			
			heapArr[heapSize+1] = el;
			heapSize++;
			
			//sort bottom up
			sortHeap(TYPE.BOTTOM_UP, heapSize);
		}
	}
	
	public static void sortHeap(TYPE type, int heapSize) {
		
		if(type == TYPE.TOP_DOWN) {
			int curr = 1;
			while(curr <= heapSize) {
				int leftChild = 2*curr;
				int rightChild = 2*curr + 1;

				if(leftChild > heapSize) {
					break;
				}
				
				if(leftChild <= heapSize && rightChild <= heapSize && heapArr[curr] > heapArr[leftChild] && heapArr[curr] > heapArr[rightChild]) {
					if(heapArr[leftChild] < heapArr[rightChild]) {
						int temp = heapArr[curr];
						heapArr[curr] = heapArr[leftChild];
						heapArr[leftChild] = temp;
						curr = leftChild;
					} else {
						int temp = heapArr[curr];
						heapArr[curr] = heapArr[rightChild];
						heapArr[rightChild] = temp;
						curr = rightChild;
					}
				} else if (leftChild <= heapSize && heapArr[curr] > heapArr[leftChild]) {
					int temp = heapArr[curr];
					heapArr[curr] = heapArr[leftChild];
					heapArr[leftChild] = temp;
					curr = leftChild;
				} else if (rightChild <= heapSize && heapArr[curr] > heapArr[rightChild]) {
					int temp = heapArr[curr];
					heapArr[curr] = heapArr[rightChild];
					heapArr[rightChild] = temp;
					curr = rightChild;
				} else {
					break;
				}
			}
			
		} else if (type == TYPE.BOTTOM_UP) {
			int curr = heapSize, parent = 1;
			do {
				parent = curr / 2;

				if (heapArr[parent] > heapArr[curr]) {
					// swap
					int temp = heapArr[parent];
					
					heapArr[parent] = heapArr[curr];
					heapArr[curr] = temp;
					curr = parent;
				} else {
					break;
				}
			} while (parent > 0);
		
			
		}
	}
}
