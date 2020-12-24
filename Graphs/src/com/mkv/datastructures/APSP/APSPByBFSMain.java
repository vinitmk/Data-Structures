package com.mkv.datastructures.APSP;

import com.mkv.datastructures.algorithms.BFS;
import com.mkv.datastructures.model.GraphNode;

public class APSPByBFSMain {

	public static void main(String[] args) {
		int size = 10;
		BFS<String> allPairShortestPath = new BFS<>();

		for(int i = 0; i < size; i++)
			allPairShortestPath.createGraphNodes("V"+i, i);

		allPairShortestPath.addUndirectedEdge(0,1);
		allPairShortestPath.addUndirectedEdge(0,3);
		allPairShortestPath.addUndirectedEdge(1,2);
		allPairShortestPath.addUndirectedEdge(1,4);
		allPairShortestPath.addUndirectedEdge(2,5);
		allPairShortestPath.addUndirectedEdge(2,9);
		allPairShortestPath.addUndirectedEdge(3,6);
		allPairShortestPath.addUndirectedEdge(4,7);
		allPairShortestPath.addUndirectedEdge(5,8);
		allPairShortestPath.addUndirectedEdge(6,7);
		allPairShortestPath.addUndirectedEdge(7,8);
		allPairShortestPath.addUndirectedEdge(8,9);

		for(int j = 0; j < size; j++) {
			allPairShortestPath.shortestPathBFSByIndex(j);
			System.out.println("\n----------------\n");

			// Resetting All Graph Nodes as not visited and Setting Parent as null
			for(GraphNode<String> graphNode:allPairShortestPath.getNodeList()){
				graphNode.setParent(null);
				graphNode.setVisited(false);
			}

		}
	}
}
