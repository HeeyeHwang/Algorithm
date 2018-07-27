package study._2017.live.coding._171111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InorderTraversal {

	private static int nodeCnt;
	private void _1231_inorder_traversal(int testcase, List<Node> wordList) {
		

		Node initialNode = wordList.get(0);
		Node finalNode = new Node();
		recursive(finalNode, 1, initialNode, wordList);
		
		StringBuilder sb = new StringBuilder();
		
		buildWord(sb, finalNode, finalNode.getLeftNode(), finalNode.getRightNode());
		
		System.out.println("##" + sb.toString());
		//		for(Node node : wordList) {
//			
//			if(node.getLeftNode() != null) {
//				
//				int index = Integer.valueOf(node.getLeftNode().getNodeVal()) -1;
//				String value = wordList.get(index).getNodeVal();
//				node.getLeftNode().setNodeVal(value);
//			}
//
//			if(node.getRightNode() != null) {
//				int index = Integer.valueOf(node.getRightNode().getNodeVal()) -1;
//				String value = wordList.get(index).getNodeVal();
//				node.getRightNode().setNodeVal(value);
//			}
//		}
	}

	private void buildWord(StringBuilder sb, Node root, Node left, Node right) {
		
		
		
	}
	
	
	private void recursive(Node finalNode, int count, Node initialNode, List<Node> wordList) {

//		System.out.println(String.format("[%d] initial node : %s", count, initialNode.getNodeVal()));
		
		
		if(initialNode.getLeftNode() == null && initialNode.getRightNode() == null) {
			return;
		}
		
		if(initialNode.getLeftNode() != null) {
			int index = Integer.valueOf(initialNode.getLeftNode().getNodeVal()) -1;
			String value = wordList.get(index).getNodeVal();
			initialNode.getLeftNode().setNodeVal(value);
			
			System.out.println(initialNode.getNodeVal()+ "["+count +"] left:"+initialNode.getLeftNode().getNodeVal());
			
			
			finalNode.setNodeVal(initialNode.getNodeVal());
			finalNode.setLeftNode(initialNode.getLeftNode());
			
			if(finalNode.getLeftNode() != null) {
				recursive(finalNode.getLeftNode(), ++count, wordList.get(index), wordList);
			}
		}
		
		if(initialNode.getRightNode() != null) {
			int index = Integer.valueOf(initialNode.getRightNode().getNodeVal()) -1;
			String value = wordList.get(index).getNodeVal();
			initialNode.getRightNode().setNodeVal(value);
			System.out.println(initialNode.getNodeVal()+"["+count +"] right:"+initialNode.getRightNode().getNodeVal());
			finalNode.setNodeVal(initialNode.getNodeVal());
			finalNode.setRightNode(initialNode.getRightNode());
			
			if(finalNode.getRightNode() != null) {
				recursive(finalNode.getRightNode(), ++count, wordList.get(index), wordList);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10 ; i++) {
			
			nodeCnt = sc.nextInt();
			sc.nextLine();

			List<Node> wordList = new ArrayList<Node>();
			for(int j = 0 ; j < nodeCnt ; j++) {
				
				String line = sc.nextLine();
//				System.out.println(line);
				String[] lineArr = line.split(" ");
				Node node = new Node();

				node.setNodeVal(lineArr[1]);
				if(lineArr.length == 3) {
					Node leftNode = new Node();
					leftNode.setNodeVal(lineArr[2]);
					node.setLeftNode(leftNode);
				} else if(lineArr.length == 4) {
					Node leftNode = new Node();
					leftNode.setNodeVal(lineArr[2]);
					node.setLeftNode(leftNode);
					Node rightNode = new Node();
					rightNode.setNodeVal(lineArr[3]);
					node.setRightNode(rightNode);
				}
				
				wordList.add(node);
			}
			
			new InorderTraversal()._1231_inorder_traversal(i+1, wordList);
		}
		
		sc.close();
	}
}

class Node {
	
	private String nodeVal;
	private Node leftNode;
	private Node rightNode;
	
	public String getNodeVal() {
		return nodeVal;
	}
	public void setNodeVal(String nodeVal) {
		this.nodeVal = nodeVal;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
}
