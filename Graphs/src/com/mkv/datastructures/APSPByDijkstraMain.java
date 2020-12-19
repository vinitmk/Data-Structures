package com.mkv.datastructures;

import java.util.ArrayList;
import java.util.List;

public class APSPByDijkstraMain<T> {

	public static void main(String[] args) {

		List<WeightedNode<String>> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode<>("A"));
		nodeList.add(new WeightedNode<>("B"));
		nodeList.add(new WeightedNode<>("C"));
		nodeList.add(new WeightedNode<>("D"));
		nodeList.add(new WeightedNode<>("E"));

		Dijkstra<String> allPairShortestPath = new Dijkstra<>(nodeList);

		allPairShortestPath.addWeightedEdge(0,2,6); //Add A-> C , weight 6
		allPairShortestPath.addWeightedEdge(0,3,3); //Add A-> D , weight 3
		allPairShortestPath.addWeightedEdge(1,0,3); //Add B-> A , weight 3
		allPairShortestPath.addWeightedEdge(2,3,2); //Add C-> D , weight 2
		allPairShortestPath.addWeightedEdge(3,2,1); //Add D-> C , weight 1
		allPairShortestPath.addWeightedEdge(3,1,1); //Add D-> B , weight 1
		allPairShortestPath.addWeightedEdge(4,1,4); //Add E-> B , weight 4
		allPairShortestPath.addWeightedEdge(4,3,2); //Add E-> D , weight 2

		for(WeightedNode<String> node: nodeList) {

			System.out.println("Printing Dijkstra from source: "+ node.getData());
			allPairShortestPath.shortestPathByDijkstra(node);
			System.out.println("\n----------------\n");

			for(WeightedNode<String> temp: nodeList) {
				temp.setVisited(false);
				temp.setParent(null);
				temp.setDistance(Integer.MAX_VALUE/10);
			}
		}

	}
}
