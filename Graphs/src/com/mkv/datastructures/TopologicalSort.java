package com.mkv.datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSort {

	private List<Integer> sort(int vertices, int[][] edges) {

		List<Integer> result = new ArrayList<>();


		// Initialize Adjacency List and In Degree
		Map<Integer, Integer> inDegree = new HashMap<>();
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		for(int i = 0; i < vertices; i++) {
			adjList.put(i, new ArrayList<>());
			inDegree.put(i, 0);
		}

		// Build graph
		for(int[] row: edges) {
			int parent = row[0];
			int child = row[1];
			adjList.get(parent).add(child);
			inDegree.put(child, inDegree.get(child) + 1);
		}

		// Find all the sources
		Queue<Integer> sources = new ArrayDeque<>();
		for(int child: inDegree.keySet()) {
			if(inDegree.get(child) == 0)
				sources.add(child);
		}

		int vertex;
		List<Integer> children;
		while(!sources.isEmpty()) {
			vertex = sources.poll();
			result.add(vertex);
			children = adjList.get(vertex);
			for(int child: children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if(inDegree.get(child) == 0)
					sources.add(child);
			}
		}

		if (result.size() != vertices)
			return new ArrayList<>();

		return result;
	}

	public static void main(String[] args) {

		TopologicalSort main = new TopologicalSort();

		List<Integer> result = main.sort(4,
				new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
		System.out.println(result);

		result = main.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
				new int[] { 2, 1 }, new int[] { 3, 1 } });
		System.out.println(result);

		result = main.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
				new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
		System.out.println(result);
	}
}
