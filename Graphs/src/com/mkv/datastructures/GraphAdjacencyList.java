package com.mkv.datastructures;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {

	private int size;
	private List<ArrayList<Integer>> outerList;

	private GraphAdjacencyList(int size) {
		this.size = size;
		outerList = new ArrayList<>(size);
		for(int i = 0; i < size; i++)
			outerList.add(new ArrayList<>());
	}

	private void addEdges(int u, int v) {
		outerList.get(u).add(v);
		outerList.get(v).add(u);
	}

	private void printGraph() {
		for(int i = 0; i < outerList.size(); i++)
			System.out.println(i +" -> "+ outerList.get(i).toString());
	}

	public static void main(String[] arg) {

		GraphAdjacencyList main = new GraphAdjacencyList(5);

		main.addEdges(0, 1);
		main.addEdges(0, 4);
		main.addEdges(1, 2);
		main.addEdges(1, 3);
		main.addEdges(1, 4);
		main.addEdges(2, 3);
		main.addEdges(3, 4);

		main.printGraph();
	}
}
