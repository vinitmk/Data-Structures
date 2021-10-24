package com.mkv.datastructures.algorithms;

import java.util.List;
import java.util.PriorityQueue;

import com.mkv.datastructures.sorting.model.WeightedNode;

public class Prims<T> {

	private List<WeightedNode<T>> nodeList;

	public Prims(List<WeightedNode<T>> nodeList) {
		this.nodeList = nodeList;
	}

	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		WeightedNode<T> first = nodeList.get(firstIndex);
		WeightedNode<T> second = nodeList.get(secondIndex);

		first.getNeighbors().add(second);
		second.getNeighbors().add(first);

		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
	}

	public void primsMST(WeightedNode<T> node) {

		for(WeightedNode<T> n: nodeList)
			n.setDistance(Integer.MAX_VALUE);

		// Setting source as 0
		node.setDistance(0);

		PriorityQueue<WeightedNode<T>> queue = new PriorityQueue<>(nodeList);

		while (!queue.isEmpty()) {
			WeightedNode<T> presentNode = queue.poll(); // Removes the vertex with minimum distance

			for (WeightedNode<T> neighbor : presentNode.getNeighbors()) {

/*				if vertex is not processed, only then enter in if-else
				If known weight of this adjacent vertex is more than current edge,
				then update adjacent vertex distance and parent
*/
				if(queue.contains(neighbor)) {

					if(neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
						// Refresh the Priority Queue
						queue.remove(neighbor);
						queue.add(neighbor);
					}
				}
			}
		}
		int cost = 0;
		// print table of node with minimum distance and shortest path from source
		for (WeightedNode<T> nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck.getData() + ", key: " + nodeToCheck.getDistance());
			if(nodeToCheck.getParent() != null)
				System.out.print(", Parent: " + nodeToCheck.getParent().getData());
			System.out.println();
			cost += nodeToCheck.getDistance();
		}
		System.out.println("\nTotal cost of MST: " + cost);
	}
}
