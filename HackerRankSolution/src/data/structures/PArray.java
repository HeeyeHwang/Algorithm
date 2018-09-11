package data.structures;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PArray {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("./res/DynamicArray_out")));

		String[] nq = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nq[0].trim());

		int q = Integer.parseInt(nq[1].trim());

		int[][] queries = new int[q][3];

		for (int queriesRowItr = 0; queriesRowItr < q; queriesRowItr++) {
			String[] queriesRowItems = scanner.nextLine().split(" ");

			for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
				int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
				queries[queriesRowItr][queriesColumnItr] = queriesItem;
			}
		}

		int[] result = dynamicArray(n, queries);

		for (int resultItr = 0; resultItr < result.length; resultItr++) {
			bufferedWriter.write(String.valueOf(result[resultItr]));

			if (resultItr != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();
	}

	public static int[] dynamicArray(int n, int[][] queries) {

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		List<Integer> lastList = new ArrayList<Integer>();
		int lastAnswer = 0;
		int index = 0;

		for (int i = 0; i < queries.length; i++) {

			int[] query = queries[i];
			index = (query[1] ^ lastAnswer) % n;

			if (query[0] == 1) { // 1 x y --> (x ^ lastA) % n
				if (map.containsKey(index)) {
					map.get(index).add(query[2]);
				} else {
					map.put(index, new ArrayList<Integer>());
					map.get(index).add(query[2]);
				}
			} else { // 2
				if (map.containsKey(index)) {
					List<Integer> list = map.get(index);
					lastAnswer = list.get(query[2]%list.size());

					lastList.add(lastAnswer);
				}
			}
		}

		int[] returnArr = new int[lastList.size()];
		for (int i = 0; i < lastList.size(); i++) {
			returnArr[i] = lastList.get(i);
			System.out.println(returnArr[i]);
		}

		return returnArr;

	}
}
