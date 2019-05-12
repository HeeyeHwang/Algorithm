package programmers.stackqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TruckCrossingBridge {

	public static void main(String[] args) {

		TruckCrossingBridge truck = new TruckCrossingBridge();

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = new int[] {7,4,5,6 };
		
//		int rslt = truck.solution(bridge_length, weight, truck_weights);
//		System.out.println(rslt);
		
		int rslt = truck.antoherSol(bridge_length, weight, truck_weights);
		System.out.println(rslt);
	}

	
	// 풀기 완료하고 나서 다른 사람의 풀이 본 것 ! 
	public int antoherSol(int bridge_length, int weight, int[] truck_weights) {
		 Stack<Integer> truckStack = new Stack<>();
         Map<Integer, Integer> bridgeMap = new HashMap<>();

         for (int i = truck_weights.length-1; i >= 0; i--)
             truckStack.push(truck_weights[i]);
         
         System.out.println(truckStack);

         int answer = 0;
         int sum = 0;
         
         //bridge map은 key=value 가 key초에 빠지는 트럭의 무게이고, key초가 될 때를 제외하고 있는 map에 원소들은 다리 위에 있는 무게를 의미. 곧 합은 다리위의 무게!
         while(true) {
             answer++;

             bridgeMap.remove(answer);

             sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();
             System.out.printf("time : %d , sum : %d\n", answer, sum);
             if (!truckStack.isEmpty()) {
            	 if (sum + truckStack.peek() <= weight)
            		 bridgeMap.put(answer + bridge_length, truckStack.pop());
             }

             if (bridgeMap.isEmpty() && truckStack.isEmpty())
                 break;

             System.out.println(truckStack);
             System.out.println(bridgeMap);
         }
         
         
         return answer;
         
	}
	
	
	//내 풀이. 난 딱히 stack/queue를 쓰지 않은 것 같다!
	public int solution(int bridge_length, int weight, int[] truck_weights) {
	
		int time = 0;
		
		int i = 0;
		int limit = weight;
		int size = truck_weights.length;
		int[] check = new int[size];

		
		while(true) {
			
			time++;
//			System.out.printf("============== %d 초, i %d \n",time,i);
		
			// 시간경
			for(int j = 0 ; j < i ; j++) {
				if(check[j] > 0) {
					check[j] = check[j] -1;
					if(check[j] == 0) {
						limit = limit + truck_weights[j];
					}
				}
			}
			
			if( i < size) {
				int tw = truck_weights[i];
				
				if(limit - tw >= 0) {
					check[i] = bridge_length;
					limit = limit - tw;
					i++;
				}
			} else {
				if(check[size-1] == 0) {
					break;
				}
			}

//			System.out.printf("time %d / check %s / limit %d \n", time, Arrays.toString(check), limit);
		}
		
		
		return time;
	}
	
	
}
