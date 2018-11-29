package bcc.impact;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dfs {

	private static LinkedList<Node> stack = new LinkedList<Node>();

	public static void main(String[] args) {

		Node service = new Node("Service");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		
		service.getChildren().add(nodeA);
		service.getChildren().add(nodeB);
		nodeB.getChildren().add(nodeC);
		nodeB.getChildren().add(nodeD);
		nodeD.getChildren().add(nodeE);
		nodeD.getChildren().add(nodeF);
		nodeC.getChildren().add(nodeG);
		nodeC.getChildren().add(nodeH);
		
		writeServiceCallData(service, 0);
//		System.out.println("rslt : " + rslt);
		
	}
	
	public static void writeServiceCallData(Node node, int depth) {

		int cnt = 0;
		System.out.println("node : " + node.getValue());
		stack.push(node);
		
		if(node.getChildren().size() == 0) {
			
			StringBuilder sb = new StringBuilder();
			for(int i = stack.size() - 1 ; i >= 0 ; i--) {
				sb.append(" - ").append(stack.get(i).getValue());
			}
			sb.append("\n");
			System.out.println(sb.toString());
			stack.pop();
			return;
		} else {
			
			for(Node child : node.getChildren()) {
				writeServiceCallData(child, depth + 1);
				cnt++;
			}
		}

		System.out.println(" el :" + stack.peek().getValue());
		if(node.getChildren().size() == cnt) {
			stack.pop();
		}
	}
}

class Node {
	private String value;
	private List<Node> children;
	private boolean visited;
	
	public Node(String value) {
		this.value = value;
		this.children = new ArrayList<Node>();
	}
	public String getValue() {
		return value;
	}
	public List<Node> getChildren() {
		return children;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [value=");
		builder.append(value);
		builder.append(", children=");
		builder.append(children);
		builder.append("]");
		return builder.toString();
	}
}
