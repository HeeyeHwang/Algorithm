package codility;

import java.util.Arrays;

public class Lesson4 {

    public static void main(String[] args) {

        Lesson4 lesson = new Lesson4();

        lesson.solution(1, new int[]{1});
    }

    public int[] solution(int N, int[] A) {

        int[] output = new int[N];
        int maxCounter = 0;

        for(int i = 0 ; i < A.length ; i++) {

            int el = A[i];
            int currCounter = 0;

            if( el < N + 1) {
                System.out.println("a");
                currCounter = ++output[el-1];
            } else if(el == N+1) {

                Arrays.fill(output, maxCounter);
            }

            if(maxCounter < currCounter) {
                maxCounter = currCounter;
            }
            System.out.println("========================");
            System.out.println(Arrays.toString(output));
        }


        return output;
    }
}
