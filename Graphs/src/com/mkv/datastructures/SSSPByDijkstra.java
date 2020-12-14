package com.mkv.datastructures;

import java.util.List;
import java.util.PriorityQueue;

class SSSPByDijkstra<T> {

	private List<WeightedNode<T>> nodelist;

	SSSPByDijkstra(List<WeightedNode<T>> nodelist) {
		this.nodelist = nodelist;
	}

	void addWeightedEdge(int s, int d, int w) {
		WeightedNode<T> source = nodelist.get(s);
		WeightedNode<T> destination = nodelist.get(d);
		source.getNeighbors().add(destination);
		source.getWeightMap().put(destination, w);
	}

	private void pathPrint(WeightedNode<T> node) {
		if(node.getParent()!=null) {
			pathPrint(node.getParent());
			System.out.print("->"+node.getData());
		}
		else
			System.out.print(node.getData());
	}

	void shortestPathByDijkstra(WeightedNode<T> node) {
		node.setDistance(0);
		PriorityQueue<WeightedNode<T>> queue = new PriorityQueue<>(nodelist);
		while(!queue.isEmpty()) {
			WeightedNode<T> currentNode = queue.poll();
			for(WeightedNode<T> neighbor: currentNode.getNeighbors()) {
				if(neighbor.getDistance() > currentNode.getDistance() + currentNode.getWeightMap().get(neighbor)) {
					neighbor.setDistance(currentNode.getDistance() + currentNode.getWeightMap().get(neighbor));
					neighbor.setParent(currentNode);
					//Refresh the Priority Queue since distance was recalculated
					queue.remove(neighbor);
					queue.add(neighbor);
				}
			}
		}

		for(WeightedNode<T> nodeToCheck: nodelist) {
			System.out.print("Node "+nodeToCheck.getData()+", distance: "+nodeToCheck.getDistance()+", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}
}
