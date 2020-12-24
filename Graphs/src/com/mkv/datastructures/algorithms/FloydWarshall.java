package com.mkv.datastructures.algorithms;

import java.util.List;

import com.mkv.datastructures.model.WeightedNode;

public class FloydWarshall<T> {

	private List<WeightedNode<T>> nodeList;

	public FloydWarshall(List<WeightedNode<T>> nodeList) {
		this.nodeList = nodeList;
	}

	public void addWeightedEdge(int source, int destination, int weight) {
		WeightedNode<T> first = nodeList.get(source);
		WeightedNode<T> second = nodeList.get(destination);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, weight);
	}

	public void shortestPathByFloydWarshall() {

		int size = nodeList.size();
		int[][] weights = new int[size][size];

		for (int i = 0; i < size; i++) {
			WeightedNode<T> first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode<T> second = nodeList.get(j);
				// Dividing by 10 to avoid overflow while adding
				if (i == j)
					weights[i][j] = 0;
				else
					weights[i][j] = first.getWeightMap().getOrDefault(second, Integer.MAX_VALUE / 10);
			}
		}

		for (int k = 0; k < size; k++)
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++)
					if (weights[i][j] > weights[i][k] + weights[k][j])
						weights[i][j] = weights[i][k] + weights[k][j];

		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node " + nodeList.get(i).getData() + ": ");
			for (int j = 0; j < size; j++) {
				System.out.print(weights[i][j] + " ");
			}
			System.out.println();
		}
	}
}
