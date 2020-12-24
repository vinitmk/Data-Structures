package com.mkv.datastructures.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphTest {

	private void createAdjacencyList(int n, int[][] array) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();

		for(int i = 0; i < n; i++)
			adjList.put(i, new ArrayList<>());

		for(int[] row: array) {
			List<Integer> children = adjList.getOrDefault(row[0], new ArrayList<>());
			children.add(row[1]);
			adjList.put(row[0], children);
		}

		for(int key: adjList.keySet()) {
			System.out.println(key +"  "+ adjList.get(key).toString());
		}
	}

	public static void main(String[] args) {

		int[][] array = new int[][] {new int[] {3, 2}, new int[] {3, 0}, new int[] {2, 0}, new int[] {2, 1}};

		GraphTest main = new GraphTest();
		main.createAdjacencyList(4, array);

	}
}
