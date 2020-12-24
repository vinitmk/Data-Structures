package com.mkv.datastructures.APSP;

import java.util.ArrayList;
import java.util.List;

import com.mkv.datastructures.algorithms.BellmanFord;
import com.mkv.datastructures.model.WeightedNode;

public class APSPByBellmanFordMain {

	public static void main(String[] args) {

		List<WeightedNode<String>> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode<>("A"));
		nodeList.add(new WeightedNode<>("B"));
		nodeList.add(new WeightedNode<>("C"));
		nodeList.add(new WeightedNode<>("D"));
		nodeList.add(new WeightedNode<>("E"));

		BellmanFord<String> allPathShortestPath = new BellmanFord<>(nodeList);

		allPathShortestPath.addWeightedEdge(0,2,6); //Add A-> C , weight 6
		allPathShortestPath.addWeightedEdge(1,0,3); //Add B-> A , weight 3
		allPathShortestPath.addWeightedEdge(0,3,6); //Add A-> D , weight 6
		//shortestPath.addWeightedEdge(0,3,-6); //Add A-> D , weight -6 TEST NEGATIVE WEIGHT HERE
		allPathShortestPath.addWeightedEdge(3,2,1); //Add D-> C , weight 1
		allPathShortestPath.addWeightedEdge(2,3,2); //Add C-> D , weight 2
		allPathShortestPath.addWeightedEdge(3,1,1); //Add D-> B , weight 1
		allPathShortestPath.addWeightedEdge(4,3,2); //Add E-> D , weight 2
		allPathShortestPath.addWeightedEdge(4,1,4); //Add E-> B , weight 4

		for(WeightedNode<String> node: nodeList) {
			System.out.println("Printing Dijkstra from source: "+ node.getData());
			allPathShortestPath.shortestPathByBellManFord(node);
			System.out.println("\n----------------\n");

			for(WeightedNode<String> temp: nodeList) {
				temp.setVisited(false);
				temp.setParent(null);
				temp.setDistance(Integer.MAX_VALUE/10);
			}
		}

	}

}
