package programmers.sort;

public class TopNumber {

	private int[] arr;
	
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
		
		if(left <= size && switchValue(arr[left], arr[index])) {
			max = left;
		} else {
			max = index;
		}
		
		if(right <= size && switchValue(arr[right], arr[max])) {
			max = right;
		}
		
		
		if(max != index) {
			swap(index, max);
			heapify(max, size);
		}
	}

	

	public String solution(int[] numbers) {
		
		arr = numbers;
		
		sort();
		
		
		StringBuilder sb = new StringBuilder();
		if(numbers[0] == 0) {
			return "0";
		} else {
			for(int number : arr) {
				sb.append(number);
			}
		}
		return sb.toString();
	}
	
	
	public boolean switchValue(int x, int y) {
		
		String xStr = String.valueOf(x);
		String yStr = String.valueOf(y);
		
		int xLength = xStr.length();
		int yLength = yStr.length();
		
		if(xStr.charAt(0) < yStr.charAt(0)) {
			return true;
		} else if (xStr.charAt(0) > yStr.charAt(0)) {
			return false;
		} else { 
			if(xLength < yLength) {
				
				int gap = yLength - xLength;
				int lastDigit = xStr.charAt(xLength -1) - '0';
				int rest = x*(int) (Math.pow(10, gap));
				x = rest + ((int)(Math.pow(10, gap) -1) / 9) * lastDigit;
				
			} else if(xLength > yLength) { // x > y
				int gap = xLength - yLength;
				int lastDigit = yStr.charAt(yLength -1) - '0';
				int rest = y*(int) (Math.pow(10, gap));
				y = rest + ((int)(Math.pow(10, gap) -1) / 9) * lastDigit;
			}
			
			if ( x < y) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static void main(String[] args) {
		
		int[] numbers = new int[] {3, 34, 30, 5,9};
		String rslt = new TopNumber().solution(numbers);
		System.out.println(rslt);
	}
}
