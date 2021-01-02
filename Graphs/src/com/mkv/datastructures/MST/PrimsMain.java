package com.mkv.datastructures.MST;

import java.util.ArrayList;
import java.util.List;

import com.mkv.datastructures.algorithms.Prims;
import com.mkv.datastructures.model.WeightedNode;

public class PrimsMain {

	public static void main(String[] args) {

		List<WeightedNode<String>> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode<>("A"));
		nodeList.add(new WeightedNode<>("B"));
		nodeList.add(new WeightedNode<>("C"));
		nodeList.add(new WeightedNode<>("D"));
		nodeList.add(new WeightedNode<>("E"));

		Prims<String> minimumSpanningTree = new Prims<>(nodeList);
		minimumSpanningTree.addWeightedUndirectedEdge(0,1,10); //Add undirected Edge between A-B with Weight 10
		minimumSpanningTree.addWeightedUndirectedEdge(0,2,20); //Add undirected Edge between A-C with Weight 20
		minimumSpanningTree.addWeightedUndirectedEdge(1,2,30); //Add undirected Edge between B-C with Weight 30
		minimumSpanningTree.addWeightedUndirectedEdge(1,3,5);  //Add undirected Edge between B-D with Weight 5
		minimumSpanningTree.addWeightedUndirectedEdge(2,3,15); //Add undirected Edge between C-D with Weight 15
		minimumSpanningTree.addWeightedUndirectedEdge(2,4,6);  //Add undirected Edge between C-E with Weight 6
		minimumSpanningTree.addWeightedUndirectedEdge(3,4,8);  //Add undirected Edge between D-E with Weight 8

		System.out.println("Printing Prim's Algo from source: E");
		minimumSpanningTree.primsMST(nodeList.get(4));
	}
}
