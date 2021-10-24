package com.mkv.datastructures.APSP;

import java.util.ArrayList;
import java.util.List;

import com.mkv.datastructures.algorithms.FloydWarshall;
import com.mkv.datastructures.sorting.model.WeightedNode;

public class APSPByFloydWarshallMain {

	public static void main(String[] args) {

		List<WeightedNode<String>> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode<>("A"));
		nodeList.add(new WeightedNode<>("B"));
		nodeList.add(new WeightedNode<>("C"));
		nodeList.add(new WeightedNode<>("D"));

		FloydWarshall<String> allPairShortestPath = new FloydWarshall<>(nodeList);
		allPairShortestPath.addWeightedEdge(0, 3, 1);// Add A-> D , weight 1
		allPairShortestPath.addWeightedEdge(0, 1, 8);// Add A-> B , weight 8
		allPairShortestPath.addWeightedEdge(1, 2, 1);// Add B-> C , weight 1
		allPairShortestPath.addWeightedEdge(2, 0, 4);// Add C-> A , weight 4
		allPairShortestPath.addWeightedEdge(3, 1, 2);// Add D-> B , weight 2
		allPairShortestPath.addWeightedEdge(3, 2, 9);// Add D-> C , weight 9

		System.out.println("Printing Floyd-Warshall from each source:");
		allPairShortestPath.shortestPathByFloydWarshall();
	}

}
