package study._2017.mine._171209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

@SuppressWarnings({ "unused", "unused" })
public class IronRod {

	/* 10799 쇠막대기 (baekjoon)
	 * 여러 개의 쇠막대기를 레이저로 절단하려고 한다. 효율적인 작업을 위해서 쇠막대기를 아래에서 위로 겹쳐 놓고, 레이저를 위에서
	 * 수직으로 발사하여 쇠막대기들을 자른다. 쇠막대기와 레이저의 배치는 다음 조건을 만족한다.
	 * 
	 * 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다. - 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은
	 * 겹치지 않도록 놓는다. 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다. 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
	 * 아래 그림은 위 조건을 만족하는 예를 보여준다. 수평으로 그려진 굵은 실선은 쇠막대기이고, 점은 레이저의 위치, 수직으로 그려진
	 * 점선 화살표는 레이저의 발사 방향이다.
	 * 
	 * 
	 * 
	 * 이러한 레이저와 쇠막대기의 배치는 다음과 같이 괄호를 이용하여 왼쪽부터 순서대로 표현할 수 있다.
	 * 
	 * 레이저는 여는 괄호와 닫는 괄호의 인접한 쌍 ‘( ) ’ 으로 표현된다. 또한, 모든 ‘( ) ’는 반드시 레이저를 표현한다.
	 * 쇠막대기의 왼쪽 끝은 여는 괄호 ‘ ( ’ 로, 오른쪽 끝은 닫힌 괄호 ‘) ’ 로 표현된다. 위 예의 괄호 표현은 그림 위에
	 * 주어져 있다.
	 * 
	 * 쇠막대기는 레이저에 의해 몇 개의 조각으로 잘려지는데, 위 예에서 가장 위에 있는 두 개의 쇠막대기는 각각 3개와 2개의 조각으로
	 * 잘려지고, 이와 같은 방식으로 주어진 쇠막대기들은 총 17개의 조각으로 잘려진다.
	 * 
	 * 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램을 작성하시오.
	 * 
	 * 입력 한 줄에 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 공백없이 주어진다. 괄호 문자의 개수는 최대 100,000이다.
	 * 
	 * 출력 잘려진 조각의 총 개수를 나타내는 정수를 한 줄에 출력한다.
	 */
	private static int result = 0;
	
	private static void numberOfPieces(String iron) {

		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		
		char[] ironCharArr =iron.toCharArray();
		Stack<Character> ironStack = new Stack<Character>();

		//first element
		
		for(int i = 0 ; i < iron.length() ; i++) {
			
			if(ironStack.isEmpty()) {
				ironStack.push(ironCharArr[i]);
				continue;
			}
			
			char pre = ironStack.peek();
			char post = ironCharArr[i];
			if(map.containsKey(pre) && map.get(pre).equals(post)) {
				ironStack.pop(); // () 인 경우에 뽑음
				if(!ironStack.isEmpty()) {
					ironStack.push('*'); // 시작 점에서부터 괄호가 나오기 전까지 * (=laser) 필요 없어서 제거
				}
			} else {
				ironStack.push(post);
			}
		}
//		System.out.println(String.format("laser %s", ironStack));

		new IronRod().useOneStack(ironStack, map);
//		loopSelectIron(ironStack, map);
		System.out.println(result);
	}

	private void useOneStack(Stack<Character> stack, Map<Character, Character> map) {
		
		Stack<Character> nextStack = new Stack<Character>();
		Character pre = null;
		
		int laserCnt = 0;

		for(int i = 0 ; i < stack.size() ; i++) {
			Character current = stack.get(i);
		
			nextStack.push(current); 
			
			if(current.equals('*')) {
				laserCnt++;
				continue;
			}
			
			if(pre == null) {
				pre = current;
				continue;
			}

			if(map.containsKey(pre) && map.get(pre).equals(current)) {
				result += laserCnt + 1;
				nextStack.pop();
				nextStack.remove(nextStack.size()-laserCnt -1);
			} else {
				laserCnt = 0; // 매칭된 괄호 사이에 레이저 값 초기화
			}
			
			pre = current;
		}
		
		if(stack.size() == nextStack.size()) {
			return;
		}
		
		useOneStack(nextStack, map);
	}
	
	private static void loopSelectIron(Stack<Character> stack, Map<Character, Character> map) {
		
		/* 
		 * newStack엔 *을 제거하면서 괄호 체크
		 * nextStack엔 *을 유지하면서 괄호만 삭제 (다음 번 체크용)
		 */
		Iterator<Character> itr = stack.iterator();
		Stack<Character> newStack = new Stack<Character>();
		Stack<Character> nextStack = new Stack<Character>();
		Character pre = null;
		
		int laserCnt = 0;

		
		while(itr.hasNext()) {
		
			Character current = itr.next(); // save element
			
			nextStack.push(current); 
			
			if(current.equals('*')) {
				laserCnt++;
				continue;
			}
			
			if(pre == null) {
				pre = current;
				newStack.push(pre);
				continue;
			}

			if(map.containsKey(pre) && map.get(pre).equals(current)) {
				result += laserCnt + 1;
//				System.out.println(starCnt + 1);
				newStack.pop();
				
				// () 와 ** 개수만큼 pop한 후, ** 개수만큼 push
				for(int i = 0 ; i < laserCnt+2 ; i ++) {
					nextStack.pop();
				}
				for(int i = 0 ; i < laserCnt ; i++) {
					nextStack.push('*');
				}
			} else {
				laserCnt = 0; // 매칭된 괄호 사이에 레이저 값 초기화
				newStack.push(current);
			}
			
			pre = current;
		}
		
		System.out.println("newStack : "+newStack);
		System.out.println("nextStack : "+nextStack);
		
		if(newStack.isEmpty()) {
			return;
		}

		loopSelectIron(nextStack, map);
	}
	
	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = br.readLine();
			numberOfPieces(line);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		long start = System.currentTimeMillis();
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
//		numberOfPieces(input);
//		sc.close();
//		long end = System.currentTimeMillis();
//		System.out.println("------걸린시간--------");
//		System.out.println(end - start);
	}
}
