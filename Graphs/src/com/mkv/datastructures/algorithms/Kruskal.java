package com.mkv.datastructures.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mkv.datastructures.sorting.model.DisjointSet;
import com.mkv.datastructures.sorting.model.UndirectedEdge;
import com.mkv.datastructures.sorting.model.WeightedNode;


public class Kruskal<T> {

	private List<WeightedNode<T>> nodeList;
	private List<UndirectedEdge<T>> edgeList;

	public Kruskal(List<WeightedNode<T>> nodeList) {
		this.nodeList = nodeList;
		this.edgeList = new ArrayList<>();
	}

	public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
		UndirectedEdge<T> undirectedEdge = new UndirectedEdge<>(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
		WeightedNode<T> first = undirectedEdge.getFirst();
		WeightedNode<T> second = undirectedEdge.getSecond();
		first.getNeighbors().add(second);
		second.getNeighbors().add(first);
		first.getWeightMap().put(second, weight);
		second.getWeightMap().put(first, weight);
		edgeList.add(undirectedEdge);
	}

	public void kruskalMST() {

		// make disjoint sets for each node
		DisjointSet<T> ds = new DisjointSet<>();
		ds.makeSet(nodeList);

	/*	Comparator<UndirectedEdge<T>> comparator = new Comparator<UndirectedEdge<T>>() {
			@Override
			public int compare(UndirectedEdge<T> firstEdge, UndirectedEdge<T> secondEdge) {
				return firstEdge.getWeight() - secondEdge.getWeight();
			}
		};*/

		// Lambda version of above code
		Comparator<UndirectedEdge<T>> comparator = Comparator.comparingInt(UndirectedEdge::getWeight);

		edgeList.sort(comparator);

		int cost = 0;
		for(UndirectedEdge<T> edge: edgeList) {
			WeightedNode<T> first = edge.getFirst();
			WeightedNode<T> second = edge.getSecond();

			if(!first.getSet().equals(second.getSet())) {
				ds.union(first, second);
				cost += edge.getWeight();
				System.out.println("Taken " + edge);
			}
		}
		System.out.println("\nTotal cost of MST: " + cost);
	}
}
