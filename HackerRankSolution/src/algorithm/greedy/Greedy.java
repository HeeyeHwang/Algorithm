package algorithm.greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy {

	private static final Scanner scanner = new Scanner(System.in);
	
	//Marc's Cakewalk
	static long marcsCakewalk(int[] calorie) {

		Arrays.sort(calorie);
		
		long sum = 0;
		for(int i = 0; i < calorie.length; i++) {
			sum += calorie[calorie.length -1 -i]*getCalory(i);
		}
		return sum;
    }
	
	static long getCalory(int order) {
		if(order == 0) {
			return 1;
		} else {
			return 2*getCalory(order-1);
		}
	}
	
	
	public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);
        
        System.out.println(result);
        scanner.close();
    }
}

