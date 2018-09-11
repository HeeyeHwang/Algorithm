package tutorial;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

	}
	//Day 14: Scope
	void scope() {
		
	}

	// Day 13: Abstract Classes
	abstract class Book {
	    String title;
	    String author;
	    
	    Book(String title, String author) {
	        this.title = title;
	        this.author = author;
	    }
	    
	    abstract void display();
	}
	
	class MyBook extends Book {

		private String title;
	    private String author;
	    private int price;
	    
	    MyBook(String title, String author, int price) {
	    	
	    	super(title, author); //super가 왜 있어야 하는가ㅏㅏㅏㅏㅏ

	    	this.title = title;
	    	this.author = author;
	    	this.price = price;
	    }
	    
	    
	    @Override
	    void display() {
	        System.out.println("Title: "+ title + "\nAuthor: " + author + "\nPrice: " + price);
	    }
	}
	

	// Day 12: Inheritance
	class Person {
		protected String firstName;
		protected String lastName;
		protected int idNumber;

		// Constructor
		Person(String firstName, String lastName, int identification) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.idNumber = identification;
		}

		// Print person data
		public void printPerson() {
			System.out.println("Name: " + lastName + ", " + firstName + "\nID: " + idNumber);
		}
	}

	class Student extends Person {

		private int[] testScores;
		private String firstName;
		private String lastName;
		private int id;

		Student(String firstName, String lastName, int id, int[] scores) {
			super(firstName, lastName, id);

			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
			this.testScores = scores;
		}

		char calculate() {

			int sum = Arrays.stream(testScores).reduce(0, (x, y) -> x + y);
			double average = sum / testScores.length;

			if (average <= 100 && average >= 90) {
				return 'O';
			} else if (average < 90 && average >= 80) {
				return 'E';
			} else if (average < 80 && average >= 70) {
				return 'A';
			} else if (average < 70 && average >= 55) {
				return 'P';
			} else if (average < 55 && average >= 40) {
				return 'D';
			} else if (average < 40) {
				return 'T';
			}

			return 'X';
		}
		/*
		 * Class Constructor
		 * 
		 * @param firstName - A string denoting the Person's first name.
		 * 
		 * @param lastName - A string denoting the Person's last name.
		 * 
		 * @param id - An integer denoting the Person's ID number.
		 * 
		 * @param scores - An array of integers denoting the Person's test scores.
		 */
		// Write your constructor here

		/*
		 * Method Name: calculate
		 * 
		 * @return A character denoting the grade.
		 */
		// Write your method here
	}

	// Day 11: 2D Arrays
	void _2DArrays() {
		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		/*
		 * i-1,j-1 i-1,j i-1,j+1 i,j i+1,j+1 i+1,j i+1,j+1 i, j의 범위가 1 2 3 4
		 */
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i][j] + arr[i + 1][j - 1]
						+ arr[i + 1][j] + arr[i + 1][j + 1];
				if (max < sum) {
					max = sum;
				}
			}
		}
		System.out.println(max);
		scanner.close();
	}

	// Day 10: Binary Numbers
	void binaryNumbers() {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String str = Integer.toBinaryString(n);
		int index = 0;
		int count = 0;
		int maxCount = -1;
		while (str.length() > index) {
			char pre = str.charAt(index);

			if (pre == '1') {

				count++;
			} else {
				if (maxCount < count) {
					maxCount = count;
				}
				count = 0;
			}
			index++;
		}

		if (maxCount == -1) {
			maxCount = count;
		}
		if (maxCount < count) {
			maxCount = count;
		}

		System.out.println(maxCount);
		scanner.close();

	}
}
