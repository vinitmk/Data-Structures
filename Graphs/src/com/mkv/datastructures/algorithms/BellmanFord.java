package com.mkv.datastructures.algorithms;

import java.util.List;

import com.mkv.datastructures.sorting.model.WeightedNode;

public class BellmanFord<T> {

	private List<WeightedNode<T>> nodelist;

	public BellmanFord(List<WeightedNode<T>> nodeList) {
		this.nodelist = nodeList;
		for (WeightedNode<T> aNode : nodeList) {
			aNode.setDistance(Integer.MAX_VALUE / 10);
		}
	}

	public void addWeightedEdge(int s, int d, int w) {
		WeightedNode<T> source = nodelist.get(s);
		WeightedNode<T> destination = nodelist.get(d);
		source.getNeighbors().add(destination);
		source.getWeightMap().put(destination, w);
	}

	private void pathPrint(WeightedNode<T> node) {
		if (node.getParent() != null) {
			pathPrint(node.getParent());
			System.out.print("->" + node.getData());
		} else System.out.print(node.getData());
	}

	public void shortestPathByBellManFord(WeightedNode<T> sourceNode) {
		sourceNode.setDistance(0);
		for (int i = 0; i < nodelist.size() - 1; i++) {
			for (WeightedNode<T> presentNode : nodelist) {
				for (WeightedNode<T> neighbor : presentNode.getNeighbors()) {
					if (neighbor.getDistance()
							> presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)) {
						neighbor.setDistance(
								presentNode.getDistance() + presentNode.getWeightMap().get(neighbor));
						neighbor.setParent(presentNode);
					}
				}
			}
		}

		System.out.println("Checking for Negative Cycle ...");
		for (WeightedNode<T> presentNode : nodelist) {
			for (WeightedNode<T> neighbor : presentNode.getNeighbors()) {
				// if distance of neighbor is greater than tentative new path then we have a negative cycle,
				// return from here
				if (neighbor.getDistance()
						> presentNode.getDistance() + presentNode.getWeightMap().get(neighbor)) {
					System.out.println("Negative cycle found: \n");
					System.out.println("Vertex Name: " + neighbor.getData());
					System.out.println("Old Distance: " + neighbor.getDistance());
					int newDistance = presentNode.getDistance() + presentNode.getWeightMap().get(neighbor);
					System.out.println("New distance: " + newDistance);
					return;
				}
			}
		}
		System.out.println("Negative cycle not found !");

		// Print table of node with minimum distance and shortest path from source
		System.out.println("\n\nPrinting Paths now: ");
		for (WeightedNode<T> nodeToCheck : nodelist) {
			if (nodeToCheck.getDistance() != Integer.MAX_VALUE / 10) {
				System.out.print(
						"Node " + nodeToCheck.getData() + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
				pathPrint(nodeToCheck);
			} else {
				System.out.print("No path for node " + nodeToCheck.getData());
			}
			System.out.println();
		} // end of loop
	} // end of method
}
