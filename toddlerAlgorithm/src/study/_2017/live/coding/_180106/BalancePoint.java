package study._2017.live.coding._180106;

import java.util.Arrays;
import java.util.Scanner;

public class BalancePoint {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int n = sc.nextInt();

			sc.nextLine();
			
			String line = sc.nextLine();
			String[] arr = line.split(" ");
			
			getBalancePoint(i+1, arr, n);
		}
	
		sc.close();
	}
	
	public static void getBalancePoint(int testcase, String[] arr, int n) {
		
		// 1 2 1 1 이면 x 좌표 1에 m 1 , x 좌표 2에 m 1
		// m1 / ( x - d1)(x-d1) = m2 / (d2 - x)(d2-x) 이거니까,
		//m2(x-d1) = m1(d2-x),
		// m2 x - m2 d1 = m1 d2 - m1 x
		// m2 + m1 x = m1d2 + m2d1
		//x = m1*d2 + m2*d1 / m1 + m2
		// m2(x^2 - 2d1 +d1*d1) = m1(d2*d2 - 2d2x + x^2)
		// m2 - m1 x^2 + 2(d2 -d1) x + d1*d1 - d2*d2 = 0;
		
		int[] xPoint = new int[n];
		int[] mass = new int[n];
		
		for(int i = 0 ; i < n ; i++) {
			xPoint[i] = Integer.parseInt(arr[i]);
		}
		for(int i = 0 ; i < n ; i++) {
			mass[i] = Integer.parseInt(arr[i+n]);
		}

		for(int i = 0 ; i < n-1 ; i++) {
			int m1 = mass[i];
			int m2 = mass[i+1];
			int d1 = xPoint[i];
			int d2 = xPoint[i+1];

			if(m1 == m2) {
				
				System.out.println("같으면 걍 중간 값!");
				double result = (d1 + d2) / 2 ;
			} else {
				double squar = Math.sqrt((m1 - m2 + 1)*d1*d1 - 2*d2*d1 + (m2-m1+1) * d2*d2);
				double x = (squar -d1 +d2 - d1) / (m1 - m2);
				double result = Math.abs(x);
				
				System.out.println(squar);
//			System.out.println(String.format("m1 : %d, m2 : %d, d1 : %d, d2 : %d, x : %d", m1, m2, d1, d2, x));
				System.out.println("result" + x);
				
			}

		}
	}
}
