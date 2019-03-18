package swexpert;

import java.util.Arrays;
import java.util.Scanner;


/**
 * TODO not yet solved XP
 * @author heeye
 */
public class D0211_VerifyProblem {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i < testcase ; i++) {
			
			String[] matrix = sc.nextLine().split(" ");
			int row = Integer.parseInt(matrix[0]);
			int col = Integer.parseInt(matrix[1]);
			char[][] command = new char[row][col];
			for(int j = 0; j < row ; j++	 ) {
				command[j] = sc.nextLine().toCharArray();
			}
			
			String answer = verifyProblem(row, col, command);
			System.out.printf("#%d %s\n", i+1, answer);
		}
		
		sc.close();
	}
	
	static String verifyProblem(int row, int col, char[][] commands) {
		System.out.println("==============================");
		System.out.println(row);
		System.out.println(col);
		for(char[] co : commands) {
			System.out.println(Arrays.toString(co));
		}
		System.out.println(" - - - - - - - - - - - - - - -");
		
		
		int memory = 0;
		boolean[][] visited = new boolean[row][col];
		int currRow = 0;
		int currCol = 0;
//		visited[currRow][currCol] = true;

		for(boolean[] vi : visited) {
			System.out.println(Arrays.toString(vi));
		}
		
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				
				System.out.printf("i, j = %d, %d\n",i,j);
				if(visited[currRow][currCol]) {
					System.out.println("False");
					return "NO";
				}
				
				visited[currRow][currCol] = true;
				
				char c = commands[i][j];

				if('0' <= c && c <= '9') {
					memory = c - '0';
					continue;
				}
				
				switch (c) {
				case '>':
					currRow = (currRow + 1) % col;
					break;
				case '<':
					currRow = (currRow - 1) % col;
					break;
				case '^':
					currCol = (currCol - 1) % row;
					break;
				case 'v':
					currCol = (currCol + 1) % row;
					break;
				case '_':
					if(memory == 0) {
						currRow = (currRow + 1) % col;
					} else {
						currRow = (currRow - 1) % col;
					}
					break;
				case '|':
					if(memory == 0) {
						currCol = (currCol + 1) % row;
					} else {
						currCol = (currCol - 1) % row;
					}
					break;
				case '?':
					
					break;
				case '.':
					//skip
					break;
				case '@':
					return "YES";
				case '+':
					memory++;
					break;
				case '-':
					memory--;
					break;
				default:
					break;
				}
				
				System.out.printf("r, c = %d, %d = %d \n", currRow, currCol, memory);
			}
		}
		
		return "NO";
	}
}

//3
//2 6
//6>--v.
//.^--_@
//2 6
//5>--v.
//.^--_@
//2 6
//.>--v.
//.^--?@