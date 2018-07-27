package study._2017.live.coding._171104;

import java.util.Scanner;

public class Solution {

	private static int count;
	
    public void _1284_priceCompetition(int testcase, int p, int q, int r, int s, int w) {
         
        /*
         * a사 : 1l당 P요금 = W*P
         * b사 : R 이하일때 Q, R 이상일 때 Q + (W-R)*S
         *  중 minimum값 
         */
        int price, companyA, companyB;
         
        companyA = w*p;
         
        if(w < r) {
            companyB = q;
        } else {
            companyB = q + (w-r)*s;
        }
         
        price = Math.min(companyA, companyB);
         
        System.out.println("#"+testcase + " " + price);
    }
	
	public void _1215_palindrome(int testcase, int length, char[][] initArr) {

		for(int i = 0 ; i < 8 ; i++) {
			
			for(int j = 0 ; j < 8 - length + 1; j++) {
				StringBuilder rowBuilder = new StringBuilder();
				StringBuilder colBuilder = new StringBuilder();
				
				for(int k = j ; k < length+j ; k++) {
					rowBuilder.append(initArr[i][k]);
					colBuilder.append(initArr[k][i]);
				}
				
				String rowOriginal = rowBuilder.toString();
				String rowReverse = rowBuilder.reverse().toString();
				String colOriginal = colBuilder.toString();
				String colReverse = colBuilder.reverse().toString();
//				System.out.println(String.format("Row original : %s, reverse : %s", rowOriginal, rowReverse));
//				System.out.println(String.format("Column original : %s, reverse : %s", colOriginal, colReverse));
				
				if(rowOriginal.equals(rowReverse)) {
					count++;
				}
				if(colOriginal.equals(colReverse)) {
					count++;
				}
			}
		}
		
		System.out.println("#" + testcase + " " + count);
	}
	
	public void _2005_pascal(int testcase, int number) {
	
		System.out.println("#" + testcase);
	
		if(number == 1) {
			
			System.out.println(1);
		} else if(number == 2) {
			
			System.out.println(String.format("1\n1 1"));
		} else {
			
			System.out.println(String.format("1\n1 1")); //출력이 1 1 형식으로 나옴
			recursive(number, new int[]{1, 1}); // 3이상부터 연산 시작
		}
	}

	/**
	 * _2005_pascal에 사용되는 recursive function
	 * @param count 배열의 크기
	 * @param number 파스칼 삼각형의 수
	 * @param initArr 이전 단계에 완성된 배열
	 * @return 이전 단계에 완성된 배열을 바탕으로 배열 생성해 return
	 */
	public void recursive(int number, int[] initArr) {
		
		//initArr 다음 줄에 출력할 숫자 셋팅
		int arrSize = initArr.length + 1;
		int[] outArr = new int[arrSize];
		outArr[0] = outArr[arrSize-1] = 1;
		
		//outArr 완성
		for(int i = 1 ; i < arrSize-1 ; i++) {
			outArr[i] = initArr[i-1] + initArr[i];
		}
		
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < outArr.length ; i++) {
			sb.append(outArr[i]).append(" ");
		}
		
		System.out.println(sb.toString().trim()); // String의 처음과 끝의 공백 제거
		
		if(arrSize < number) {
			recursive(number, outArr); //재귀문이 파스칼 숫자를 넘어가지 않게
		}
	}

	public void _1493_newCal() {
		
		/*
		 * y가 어떤 수든 A(x)는 아래와 같이 정의
		 * A(x, y) = A(1, y) + SUM(k+1) <- k = 1 ~ x-1
		 * 
		 * y가 증가함에 따라 A(1) 초기값이 달라짐
		 *  A(1, y) = 1 + SUM(k) <- k = 1 ~ y-1
		 * 
		 * 
		 *  A(x, y) = 1 + SUM(k) {{<- k : 1 ~ y-1}} + SUM(k+1) {{<- k : 1 ~ x-1}}
		 *  
		 *  A(x,y)가 10000인것까지 구해서 map에 넣어서 검색해야 할 듯...
		 *  map은 x,y가 key인 것과 A(x,y)가 키인 것을 만들어야
		 *  
		 *
		 *  
		 */
	}
	
	public static void main(String[] args) {

		/* _1284_priceCompetition*/
//		Scanner sc = new Scanner(System.in);
//        int testcase = sc.nextInt();
//        int p, q, r, s, w;
//        for(int i = 0 ; i < testcase ; i++) {
//             
//            p = sc.nextInt();
//            q = sc.nextInt();
//            r = sc.nextInt();
//            s = sc.nextInt();
//            w = sc.nextInt();
//             
//            new Solution()._1284_priceCompetition(i+1, p, q, r, s, w);
//        }
//         
//        sc.close();
		
		
		/* _1215_palindrome*/
//		Scanner sc = new Scanner(System.in);
//
//		for (int i = 0; i < 10; i++) {
//			
//			count = 0;
//			int length = sc.nextInt();
//			char[][] initArr = new char[8][8];
//
//			sc.nextLine();
//			for (int j = 0; j < 8; j++) {
//				String line = sc.nextLine();
//				initArr[j] = line.toCharArray();
//			}
//
//			new Solution()._1215_palindrome(i + 1, length, initArr);
//		}
//		
//		sc.close();
		
		/* _2005_pascal*/
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		
		for(int i = 0 ; i < testcase ; i++) {
			int number = sc.nextInt();
			new Solution()._2005_pascal(i+1, number);
		}
		
		sc.close();
	}
}
