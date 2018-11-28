package programmers.dfs.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TargetNumber {

	private int count = 0;
	
	public int solution(int[] numbers, int target) {
        
        Node root = new Node(numbers[0]);

        setTreeData(root, numbers, 1);

        dfs(root, new LinkedList<Node>(), target);
        
        return count;
    }
	
	public void dfs(Node node, LinkedList<Node> stack, int target) {
		
		stack.push(node);

		if(node.getChildren().size() == 0) {
			int sum = 0;
			for(int i = 0 ; i < stack.size() ; i++) {
				sum += stack.get(i).getValue();
				System.out.printf("%d + ", stack.get(i).getValue());
			}
			if(sum == target) {
				System.out.println("\n OK~");
				count++;
			} else {
				System.out.println("\n fail~");
			}
			System.out.println(stack.size());
			stack.pop();
		} else {
			for(Node el : node.getChildren()) {
				dfs(el, stack, target);
			}
		}
		
	}
	
	
	public void setTreeData(Node node, int[] numbers, int idx) {
		
		int abs = numbers[idx];
		node.getChildren().add(new Node(abs));
		node.getChildren().add(new Node(-1*abs));
		
		if(idx == numbers.length -1) {
			return;
		} else {
			for(Node el : node.getChildren()) {
				setTreeData(el, numbers, idx + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		TargetNumber main = new TargetNumber();
		
		int[] numbers = new int[]{1, 1, 1, 1, 1};
		int target = 3;
		int rslt = main.solution(numbers, target);
		System.out.println(rslt);
	}
}

class Node {
	private int value;
	private List<Node> children;
	
	public Node(int value) {
		this.value = value;
		this.children = new ArrayList<Node>();
	}
	public int getValue() {
		return value;
	}
	public List<Node> getChildren() {
		return children;
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