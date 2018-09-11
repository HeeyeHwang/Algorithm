package study._2017.live.coding._171216;

import java.util.Scanner;

public class OneNumber {

	public static void main(String[] args) {

		//1 <= n <= 1000
		/*
		 * n = 1 일 때
		 * 1
		 * 
		 * n = 2 일 때
		 * 1 2
		 * n = 3 일 때
		 *  1 2 3
		 *  ~ n = 9 일 때 1 2 3 4 5 6 7 8 9
		 *  n = 10
		 *  1 2 3 ... 9 10
		 *  n = 11
		 *  1 2 ... 9 10 11
		 *  n = 99
		 *  1 2 ... 98 99
		 *  n = 100
		 *  1 2 ... 98 99
		 *  n = 101 ~ 110
		 *  1 2 .... 98 99 
		 *	n = 111
		 *  1 2 ... 98 99 
		 *  111 
		 *  0 ~ 99 : 1 2 3 4 5 ... 97 98 99 : 99
		 *  100 ~ 199 :111 123 135 147 159 : 5
		 *  200 ~ 299 :222 (210) 234 246 258 : 5
		 *  300 ~ 399 :333 (321) 345 357 369 : 5
		 *  400 ~ 499 :444 (432) (420) 456 479 : 5
		 *  500 ~ 599 :555 (543) (531) 567 579 : 5
		 *  600 ~ 699 :666 (654) (642) (630) 678 : 5
		 *  700 ~ 799 :777 (765) (753) (741) 789 : 5 
		 *  800 ~ 899 :888 (876) (864) (852) (840) : 5
		 *  900 ~ 999 :999 (987) (975) (963) (951) : 5
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		oneNumber(n);
		sc.close();
	}
	
	private static void oneNumber(int n) {
		
		if( n < 100) {
			System.out.println(n);
			return;
		}
		
		if( n == 1000) {
			n = 999;
		}
		
		boolean test = true;
		
		int seat100 = n / 100;

		int count = 99;
		for(int i = 1 ; i <= seat100 ; i++) {
			int interval = 0;
			while(test) {
				int makeSeat10 = i + interval;
				int makeSeat1 = makeSeat10 + interval;
				
				if(makeSeat10 > 9 || makeSeat1 > 9) {
//					System.out.println(String.format("10 위 10의 자리 %d, 1의 자리 %d", makeSeat10, makeSeat1));
					break;
				} else {
					StringBuilder sb = new StringBuilder();
					int ask = Integer.parseInt(sb.append(i).append(makeSeat10).append(makeSeat1).toString());
//					System.out.println("ask : "+ ask);
					
					if(ask > n) {
//						System.out.println("ask 가 n보다 큼!");
						break;
					}
					count++;
				}
				interval++;
			}
			
			interval = -1;
			while(test) {
				int makeSeat10 = i + interval;
				int makeSeat1 = makeSeat10 + interval;
				
				if(makeSeat10 < 0 || makeSeat1 < 0) {
//					System.out.println(String.format("0 아래 10의 자리 %d , 의 자리 %d", makeSeat10, makeSeat1));
					break;
				} else {
					StringBuilder sb = new StringBuilder();
					int ask = Integer.parseInt(sb.append(i).append(makeSeat10).append(makeSeat1).toString());
//					System.out.println("--ask : "+ ask);
					
					if(ask > n) {
//						System.out.println("ask가 n보다 큼! ~~");
						break;
					}
					count++;
				}
				interval--;
			}
//			System.out.println("--------------------------------");
		}
		
		System.out.println(count);
	}
}
