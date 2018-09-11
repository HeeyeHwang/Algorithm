package study._2017.live.coding._171118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	/** _2805_crop_harvest 절대값으로 푼 코드
	 *   for (int j = 0; j < N; j++)
         for (int k = 0; k < N; k++)
         {
            scanf("%1d", &t);
            if (abs(j - N / 2) + abs(k - N / 2) <= N / 2) Answer += t;
         }
	 */
	
	
	/**
	 * stack 문제
	 * 왼쪽 괄호만 stack에 넣어서, 매칭되면 pop 하고!
	 * @param testcase
	 * @param parenthesesArr
	 * @param length
	 * 
	 * 
	 * #include<vector>
#include<iostream>
using namespace std;
int main()
{
   int t = 0;
   int size = 0;
   vector<char> v;
   char input;
   while (t++ < 10)
   {
      cin >> size;
      for (int i = 0; i < size; i++)
      {
         cin >> input;
         if (v.size() == 0)
         {
            v.push_back(input); continue;
         }

         if (v.back() == '(' && input == ')')
         {
            v.pop_back();
         }
         else if (v.back() == '[' && input == ']')
         {
            v.pop_back();
         }
         else if (v.back() == '{' && input == '}')
         {
            v.pop_back();
         }
         else if (v.back() == '<' && input == '>')
         {
            v.pop_back();
         }
         else
         {
            v.push_back(input);
         }
      }

      cout << "#" << t << " " << (v.size() > 0 ? 0 : 1) << endl;
      v.clear();
   }
   return 0;
}
	 * 
	 */
	private void _1218_parentheses_mating(int testcase, String parenthesesArr, int length) {
		
		int result = 1;
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('<', '>');
		map.put('{', '}');
		
		List<Character> list = new ArrayList<Character>();
		for(int i = 0 ; i < length ; i++) {
			list.add(parenthesesArr.charAt(i));
		}
		
		
		int index = 0;
		while(true) {

			if(list.size() == 0 ) {
				break;
			}

			//			System.out.println(String.format("list size : %d, %s", list.size(), list));
			if(list.size() == 2) {
				index = 0;
			}

			
			if(map.containsKey(list.get(index))) {
//				System.out.println(list.get(index));
				if(map.containsKey(list.get(index+1))) {
					index++;
					continue;
				} else {
					if(map.get(list.get(index)).equals(list.get(index+1))) {
//						System.out.println(String.format("remove index : %d, %d .... %s", index, index+1, String.valueOf(list.get(index))+ String.valueOf(list.get(index+1))));
						list.remove(index);
						list.remove(index);
						index = 0;
					} else {

						result = 0;
						break;
					}
				}
			}
			
			
			index++;
		}
		
		System.out.println("#" + testcase + " " + result);
	}
	
	
	/**
	 * Queue로 풀어야 하는 문제임
	 */
	private void _baekjoon_1158_josephus() {
		/*
		 * 1 2 3 4 5 6 7
		 * 
		 * 3
		 * 
		 * 1 2 4 5 6 7
		 * 4번이 1번이 됨
		 * 
		 * 6
		 * 
		 * 1 2 4 5 7
		 * 7번이 1번 
		 *2
		 * 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
//		int[] people = new int[n];
		List<Integer> peopleList = new ArrayList<Integer>();
		int[] josephus = new int[n];
			
		for(int i = 0 ; i < n ; i++) {
//			people[i] = i+1;
			peopleList.add(i+1);
		}
		
		//start
		int startIndex = 0;
		int pickIndex = 0;
		for(int i = 0 ; i < n ; i ++) {
			
			if(i == 0) {
				josephus[i] = peopleList.get(m-1); // 1 2 3 4 5 6 7
				peopleList.remove(m-1); // 1 2 4 5 6 7
				continue; //값이 넘어가면 나눈 나머지값으로 인덱스 찾아서 pick
			}

			//remove
			josephus[i] = peopleList.get(pickIndex);
			
			startIndex = m -1; // 2 index
			pickIndex = startIndex + m -1; // 4 index
			
			// 1 2 4 5 7
		}
		
		
		//end
		sc.close();
	}

	
	
	
	private void _2930_heap() {

		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();

		for (int i = 0; i < testcase; i++) {
			int calCount = sc.nextInt();
			sc.nextLine();
			
			//start
			int[] heap = new int[calCount];
			for (int j = 0; j < calCount; j++) {
				String line = sc.nextLine();

				if (line.length() > 1) {
					_2930_plus_operation(Integer.parseInt(line.split(" ")[1]), heap);
				} else {
					_2930_print_max(Integer.parseInt(line), heap);
				}
			}
			
			
			//end
			System.out.println("#" + i+1 + " ");
		}

	}

	private void _2930_plus_operation(int number, int[] heap) {
		
		boolean temp = true;
		int index = 0;
		while(temp) {

			if(heap[index] == 0) {
				break;
			}
			
			if(number < heap[index]) {
				index++;
			} else {
				
			}
		}
		
	}

	private void _2930_print_max(int number, int[] heap) {

	}

	public static void main(String[] args) {

//		new Solution()._2930_heap();
		
		/* _1218_parentheses_mating*/
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i++) {
			int length = sc.nextInt();
			sc.nextLine();
			String parentheses = sc.nextLine();
			
			new Solution()._1218_parentheses_mating(i+1, parentheses, length);
		}
	}
}
