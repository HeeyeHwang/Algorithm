package codility;

import java.util.Arrays;

public class Lesson4 {



    public int missingInteger(int[] A) {


        A = Arrays.stream(A).filter(x -> x > 0).distinct().sorted().toArray();

        int value = 1;
        for(int a : A ) {

//            System.out.println(value + " " + a + " ");
            if(a > 0) {
                if(value == a) {
                    value++;
                } else {
                    break;
                }
            }
        }

        return value;
    }

    public int[] maxCounter(int N, int[] A) {

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
