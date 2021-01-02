package com.mkv.datastructures.MST;

import java.util.ArrayList;
import java.util.List;

import com.mkv.datastructures.algorithms.Kruskal;
import com.mkv.datastructures.model.WeightedNode;

public class KruskalMain {

	public static void main(String[] args) {

		List<WeightedNode<String>> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode<>("A"));
		nodeList.add(new WeightedNode<>("B"));
		nodeList.add(new WeightedNode<>("C"));
		nodeList.add(new WeightedNode<>("D"));
		nodeList.add(new WeightedNode<>("E"));
		nodeList.add(new WeightedNode<>("F"));
		nodeList.add(new WeightedNode<>("G"));
/*		nodeList.add(new WeightedNode<>("H"));
		nodeList.add(new WeightedNode<>("I"));
		nodeList.add(new WeightedNode<>("J"));*/

		Kruskal<String> minimumSpanningTree = new Kruskal<>(nodeList);

		//Add A<-> B , weight 10
		minimumSpanningTree.addWeightedUndirectedEdge(0,1,10);
		//Add A<-> C , weight 20
		minimumSpanningTree.addWeightedUndirectedEdge(0,2,20);
		minimumSpanningTree.addWeightedUndirectedEdge(1,2,30);
		minimumSpanningTree.addWeightedUndirectedEdge(1,3,5);
		minimumSpanningTree.addWeightedUndirectedEdge(2,3,15);
		minimumSpanningTree.addWeightedUndirectedEdge(2,4,6);
		minimumSpanningTree.addWeightedUndirectedEdge(3,4,8);

		minimumSpanningTree.addWeightedUndirectedEdge(1,5,9);
		minimumSpanningTree.addWeightedUndirectedEdge(5,6,16);
		minimumSpanningTree.addWeightedUndirectedEdge(3,6,7);

		System.out.println("Running Kruskal's Algo on the graph: ");
		minimumSpanningTree.kruskalMST();
	}
}
