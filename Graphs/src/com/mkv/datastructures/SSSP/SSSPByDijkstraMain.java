package com.mkv.datastructures.SSSP;

import java.util.ArrayList;
import java.util.List;

import com.mkv.datastructures.algorithms.Dijkstra;
import com.mkv.datastructures.model.WeightedNode;

public class SSSPByDijkstraMain {

	public static void main(String[] args) {

		List<WeightedNode<String>> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode<>("A"));
		nodeList.add(new WeightedNode<>("B"));
		nodeList.add(new WeightedNode<>("C"));
		nodeList.add(new WeightedNode<>("D"));
		nodeList.add(new WeightedNode<>("E"));

		Dijkstra<String> shortestPath = new Dijkstra<>(nodeList);

		shortestPath.addWeightedEdge(0,2,6); //Add A-> C , weight 6
		shortestPath.addWeightedEdge(0,3,3); //Add A-> D , weight 3
		shortestPath.addWeightedEdge(1,0,3); //Add B-> A , weight 3
		shortestPath.addWeightedEdge(2,3,2); //Add C-> D , weight 2
		shortestPath.addWeightedEdge(3,2,1); //Add D-> C , weight 1
		shortestPath.addWeightedEdge(3,1,1); //Add D-> B , weight 1
		shortestPath.addWeightedEdge(4,1,4); //Add E-> B , weight 4
		shortestPath.addWeightedEdge(4,3,2); //Add E-> D , weight 2

		System.out.println("Printing Dijkstra from source: E");
		shortestPath.shortestPathByDijkstra(nodeList.get(4));

	}
}
