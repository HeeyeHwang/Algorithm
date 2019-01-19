package programmers.sort;

public class TopNumber {

	public void heapify(int[] arr, int index) {
		
		for(int i = 1 ; i < index ; i++) {
			
			int child = i;
			int parent;
			
			while(child > 0) {
				parent = ( child - 1 ) / 2;
				
				if(switchValue(arr[child], arr[parent])) {
					System.out.println("switch");
					int temp = arr[child];
					arr[child] = arr[parent];
					arr[parent] = temp;
				}
				
				child = parent;
			}
		}
	}

	public String solution(int[] numbers) {
		
		//heap
		heapify(numbers, numbers.length);

		for(int i = numbers.length - 1 ; i > 0 ; i--) {
			
			int temp = numbers[0];
			numbers[0] = numbers[i];
			numbers[i] = temp;
			
			heapify(numbers, i);
		}
		
		StringBuilder sb = new StringBuilder();
		if(numbers[0] == 0) {
			return "0";
		} else {
			for(int number :numbers) {
				sb.append(number);
			}
		}
		return sb.toString();
	}
	
	public String selectionSort(int[] numbers) {

		StringBuilder sb = new StringBuilder();
		
		int n = numbers.length;
		for(int i = n-1 ; i > 0 ; i--) {
			
			for(int j = 0 ; j < i ; j++) {
				
				if(switchValue(numbers[j], numbers[j+1])) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		if(numbers[0] == 0) {
			return "0";
		} else {
			for(int number : numbers) {
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
