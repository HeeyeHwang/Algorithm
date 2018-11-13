package swexpert;
import java.util.LinkedList;
import java.util.Scanner;
 
class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
    int getX() {
        return x;
    }
    int getY() {
        return y;
    }
}
 
public class Solution_181017_queue {
 
    static int[][] map;
    static boolean[][] visited;
    static LinkedList<Pos> queue;
     
    //[S/W 문제해결 기본] 7일차 - 미로1
    public static int maze1() {
         
        int x;
        int y;
        int[] xCal = new int[] {0, -1, 0, 1};
        int[] yCal = new int[] {1, 0, -1, 0};
         
        Pos curr;
        while(!queue.isEmpty()) {
             
            curr = queue.poll();
            x = curr.getX();
            y = curr.getY();
            for(int i = 0 ; i < 4 ; i++) {
                int stx = x + xCal[i];
                int sty = y + yCal[i];
                if(stx >= 0 && stx < 16 && sty >= 0 && sty < 16) {
 
                    if(!visited[stx][sty]) {
                        if(map[stx][sty] == 0) {
                            visited[stx][sty] = true;
                            queue.add(new Pos(stx, sty));
                        } else if (map[stx][sty] == 3) {
                            return 1;
                        }
                    }
                }
            }
        }
         
         
        return 0;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        for(int i = 0 ; i < 10 ; i++) {
            map = new int[16][16];
            visited = new boolean[16][16];
            queue = new LinkedList<Pos>();
            int test = sc.nextInt();
            sc.nextLine();
             
            String line;
             
            for(int j = 0 ; j < 16 ; j++) {
                line= sc.nextLine();
                for(int k = 0 ; k < 16 ; k++) {
                    map[j][k] = line.charAt(k) - 48;
                     
                    if(map[j][k] == 2) {
                        visited[j][k] = true;
                        queue.add(new Pos(j, k));
                    } else if (map[j][k] == 1) {
                        visited[j][k] = true;
                    }
                }
                 
            }
             
            System.out.printf("#%d %d\n", i+1, maze1());
        }
         
        sc.close();
    }
}