package com.mkv.datastructures.MST;

import java.util.ArrayList;
import java.util.List;

import com.mkv.datastructures.sorting.model.DisjointSet;
import com.mkv.datastructures.sorting.model.WeightedNode;

public class DisjointSetMain {

	public static void main(String[] args) {
		List<WeightedNode<String>> nodeList = new ArrayList<>();

		nodeList.add(new WeightedNode<>("A"));
		nodeList.add(new WeightedNode<>("B"));
		nodeList.add(new WeightedNode<>("C"));
		nodeList.add(new WeightedNode<>("D"));
		nodeList.add(new WeightedNode<>("E"));
		nodeList.add(new WeightedNode<>("F"));
		nodeList.add(new WeightedNode<>("G"));
		nodeList.add(new WeightedNode<>("H"));
		nodeList.add(new WeightedNode<>("I"));
		nodeList.add(new WeightedNode<>("J"));

		DisjointSet<String> ds = new DisjointSet<>();
		ds.makeSet(nodeList);

		for(int i= 0; i<nodeList.size()-1; i++) {
			WeightedNode<String> firstNode = nodeList.get(i);
			WeightedNode<String> secondNode = nodeList.get(i+1);
			System.out.println("Checking if node "+firstNode.getData()+" and "+secondNode.getData() +" belongs to different set, if yes, will Union them...");
			System.out.println("\nFirst Set name is: " + firstNode.getData());
			firstNode.getSet().printAllNodesOfThisSet();
			System.out.println("\nSecond Set name is: " + secondNode.getData());
			secondNode.getSet().printAllNodesOfThisSet();
			if(!ds.findSet(firstNode).equals(ds.findSet(secondNode))) {
				System.out.println("\nMaking union "+firstNode.getData()+" and "+secondNode.getData() );
				DisjointSet unionedSet = ds.union(firstNode, secondNode);
				unionedSet.printAllNodesOfThisSet();
			}
			System.out.println("\n**************************************\n");
		}
	}





}
