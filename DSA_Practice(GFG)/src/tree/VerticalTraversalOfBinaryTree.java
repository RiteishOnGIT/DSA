package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

class Pair {

	Node node;
	Integer distance;

	public Pair(Node node, Integer distance) {
		super();
		this.node = node;
		this.distance = distance;
	}
}

public class VerticalTraversalOfBinaryTree {

	public static void verticalSum(Node root, Integer horizontalDistance) {

		TreeMap<Integer, ArrayList<Integer>> result = new TreeMap<Integer, ArrayList<Integer>>();

		Queue<Pair> que = new ArrayDeque<Pair>();

		que.add(new Pair(root, horizontalDistance));
		while (!que.isEmpty()) {

			Pair pair = que.poll();
			Node node = pair.node;
			Integer distance = pair.distance;
			if (result.get(distance) == null) {
				result.put(distance, new ArrayList<Integer>(List.of(node.data)));
			} else {

				ArrayList<Integer> tempList = result.get(distance);
				tempList.add(node.data);
				result.put(distance, tempList);

			}
			if (node.leftNode != null) {
				que.add(new Pair(node.leftNode, distance - 1));
			}
			if (node.rightNode != null) {
				que.add(new Pair(node.rightNode, distance + 1));
			}

		}
		
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> e : result.entrySet()) {
			e.getValue().forEach(value -> {
				resultList.add(value);
			});
		}
		System.out.println(resultList);

	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.leftNode = new Node(2);
		node.rightNode = new Node(3);
		node.leftNode.leftNode = new Node(4);
		node.leftNode.rightNode = new Node(5);
		node.rightNode.rightNode = new Node(6);
		verticalSum(node, 0);

		

		// System.out.println(resultList);

	}

}
