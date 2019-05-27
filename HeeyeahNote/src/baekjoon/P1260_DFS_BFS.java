package baekjoon;

import java.util.*;

/**
 * dfs, bfs practice 겸사겸사
 */
public class P1260_DFS_BFS {

    static List<Integer>[] graph;
    static int n;
    static int m;
    static boolean[] visited;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        int v = scanner.nextInt();

        graph = new List[n+1];

        for(int i = 0 ; i < m ; i++) {

            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            if(graph[v1] == null) {
                graph[v1] = new ArrayList<Integer>();
            }
            if(graph[v2] == null) {
                graph[v2] = new ArrayList<Integer>();
            }

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        System.out.println("recursive");
        visited = new boolean[n+1];
        recursive(v);

        System.out.println("\ndfs");
        visited = new boolean[n+1];
        dfs(v);

        System.out.println("\nbfs");
        visited = new boolean[n+1];
        bfs(v);

        scanner.close();
    }


    static void recursive(int v) { //recursive

        visited[v] = true;

        System.out.print(" " + v);

        for(int i = 1 ; i <= n ; i++) {

            if(graph[v].contains(i) && !visited[i]) {
                recursive(i);
            }
        }

    }


    static void dfs(int v) { //stack

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(v);
        visited[v] = true;

        System.out.print(" " + v);

        boolean flag = false;

        while(!stack.isEmpty()) {
            int vv = stack.peek();

            flag = false;

            for(int i = 1; i <= n ;i++) {

                if(graph[vv].contains(i) && !visited[i]) {
                    stack.push(i);

                    System.out.print(" " + i);

                    visited[i] = true;
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                stack.pop();
            }

        }


    }


    static void bfs(int v) { //queue

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {

            v = queue.poll();

            System.out.print( " "+v);

            for(int i = 1 ; i <=n ; i++) {
                if(graph[v].contains(i) && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
