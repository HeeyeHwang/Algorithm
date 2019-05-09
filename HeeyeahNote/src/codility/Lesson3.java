package codility;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lesson3 {

	public static void main(String[] args) {

		int[]	 A = new int[]	{};
		Lesson3 lesson3 = new Lesson3();
		System.out.println(lesson3.permMissingElem(A));
	}

	public int frogJmp(int X, int Y, int D) {

		int gap = Y - X;

		if (gap % D == 0) {
			return gap / D;
		} else {
			return (gap / D) + 1;
		}
	}

	/**
	 * correctness : 100% <br/>
	 * performance :60% <br/>
	 * Detected time complexity: O(N) or O(N * log(N))
	 */
	public int permMissingElem(int[] A) {

		if (A.length == 0) {
			return 1;
		}

		Arrays.sort(A);
		int init = 0;
		for(int a : A) {
			
			init++;
			
			if(a != init) {
				return init;
			}
		}

		return A.length + 1;
	}
}
