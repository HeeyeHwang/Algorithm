package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class BarkingDog_Egg {

	static int answer;
	static int n;
	static EggInfo[] eggs;
	static boolean[] isBroken;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();

		eggs = new EggInfo[n];
		
		for (int i = 0; i < n; i++) {
			String[] info = sc.nextLine().split(" ");
			eggs[i] = new EggInfo(i, Integer.parseInt(info[0]), Integer.parseInt(info[1]));
		}

		solution(n);
		
		sc.close();
	}
	
	static void solution(int n) {
		
		if( n == 1) {
			System.out.println(0);
			return;
		}

		isBroken = new boolean[n];
		/*
		 * 계란을 깨고, 마지막까지 한번 끝났을 때의 값을 return 
		 */
		
		dfs(0);
		
//		int currIndex = 0;
//		while(currIndex < n) {
//			
//			EggInfo currEgg;
//			EggInfo nextEgg;
//			
//			if(!isBroken[currIndex]) {
//				currEgg = eggs[currIndex];
//			} else {
//				System.out.println("continue,, " + currIndex);
//				currIndex++;
//				continue;
//			}
//			System.out.println("["+ currIndex+"]==="+currEgg.toString()+"=====" + Arrays.toString(isBroken));
//			
//			// currEgg의 무게와 다른 Egg의 내구도의 차가 제일 작으면서, 무게보단 낮거나 같은 
//			nextEgg = pickProperEgg(currIndex);
//
//			System.out.println(nextEgg.toString());
//			int currIsBroken = currEgg.s - nextEgg.w;
//			int nextIsBroken = nextEgg.s - currEgg.w;
//			
//			if(currIsBroken <= 0) {
//				isBroken[currIndex] = true;
//			}
//			currEgg.setS(currIsBroken);
//			
//			if(nextIsBroken <= 0) {
//				isBroken[nextEgg.getI()] = true;
//			}
//			nextEgg.setS(nextIsBroken);
//			
//			printEgg();
//			currIndex++;
//		}
//		
//		int answer = 0;
//		for(int i = 0 ; i < n ; i++) {
//			if(isBroken[i]) answer++; 
//		}
			
		System.out.println(answer);
	}
	
	static void dfs(int index) {
		
		System.out.println("index : " +index );
		if(index == n) {
			//calculate!
			int count = 0;
			for(int i = 0 ; i < n ; i++) {
				if(isBroken[i]) count++; 
			}
			
			if(answer > count)
				answer = count;
			
			return;
		}
		
		EggInfo curr = null;

		while (index < n) {

			System.out.println("-index : " +index);
			System.out.println(Arrays.toString(isBroken));
			if (!isBroken[index]) {
				curr = eggs[index];
				break;
			}
			index++;
		}
		
		System.out.println("# " +curr.toString());
		
		if(curr == null) {
			System.out.println("this case?");
			int count = 0;
			for(int i = 0 ; i < n ; i++) {
				if(isBroken[i]) count++; 
			}
			
			if(answer > count)
				answer = count;
			return;
		}

		EggInfo[] backup = null;
		backup = Arrays.copyOf(eggs, n);
		
		for(int i = 0 ; i < n ; i++) {
	
			if(i == index || isBroken[i]) {
				System.out.println("skip");
				continue;
			}

			EggInfo next = eggs[i];
			
			System.out.println(curr.toString());
			System.out.println(next.toString());
			int currS = curr.s - next.w;
			int nextS = next.s - curr.w;
			
			curr.setS(currS);
			next.setS(nextS);
			
			if(currS <= 0) {
				isBroken[curr.getI()] = true;
			}
			if(nextS <= 0) {
				isBroken[next.getI()] = true;
			}
			
			System.out.println(Arrays.toString(isBroken));
			System.out.println("--------------------------");
			dfs(index+1);
			
			isBroken = new boolean[n];
			eggs = Arrays.copyOf(backup, n);
		}
	}
	
	static void printEgg() {
		for(int i = 0 ; i < n ; i++) {
			System.out.print(eggs[i].toString());
		}
		System.out.println("=======================================");
	}
	
	static EggInfo pickProperEgg(int currIndex) {

		EggInfo properEgg = null;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < n ; i++) {
			
			if(i == currIndex) {
				continue;
			}
			
			EggInfo curr = eggs[i];
			if(!isBroken[i] && min > curr.s) {
				properEgg = curr;
				min = curr.s;
			}
		}
		
		return properEgg;
	}
}

class EggInfo {
	int i;
	int s;
	int w;
	public EggInfo(int i, int s, int w) {
		this.i = i;
		this.s = s;
		this.w = w;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	@Override
	public String toString() {
		return "EggInfo [i=" + i + ", s=" + s + ", w=" + w + "]";
	}
}
