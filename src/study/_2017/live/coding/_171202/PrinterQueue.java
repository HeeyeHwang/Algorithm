package study._2017.live.coding._171202;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrinterQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		for(int i = 0 ; i < testcase ; i++) {
			String line = sc.nextLine();
			String[] array =line.split(" ");
			
			int documentCnt = Integer.parseInt(array[0]);
			int target = Integer.parseInt(array[1]);
			
			//importance
			line = sc.nextLine();
			array = line.split(" ");
			int[] importances = new int[documentCnt];
			for(int j = 0 ; j < documentCnt ; j++) {
				importances[j] = Integer.parseInt(array[j]);
			}
			System.out.println("-----------------");
			new PrinterQueue()._1966_printer_queue(documentCnt, target, importances);
		}
		
	}
	
	private void _1966_printer_queue(int documentCnt, int target, int[] importances) {
	
		int order = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();

		for(int i = 0 ; i < documentCnt ; i++) {
			queue.add(importances[i]);
		}
		

	}

}

class Document {
	int idx;
	int importance;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
}