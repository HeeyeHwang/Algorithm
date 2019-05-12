package programmers.level1test;

public class Level1Test {

    public int solution1(int num) {

        int answer = -1;

        long procNum = num;
        int count = 0;

        while(count < 500) {

            if(procNum == 1 ) {
                return count;
            }


            if(procNum % 2 == 0) {
                procNum = procNum / 2;
            } else {
                procNum = procNum * 3 + 1;
            }

//            System.out.println("count : " + count + " num : "  + procNum);
            count++;
        }

        return -1;
    }

    public long solution2(long n) {
        long answer = 0;

        Double rslt = Math.sqrt(n);

        if(rslt % 1 == 0) {
            return (long)Math.pow(rslt+1, 2);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
//        int rslt = new Level1Test().solution1(626331);
        long rslt = new Level1Test().solution2(3);

        System.out.println(rslt);
    }
}
