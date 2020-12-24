package com.mkv.datastructures.model;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet<T> {

	private List<WeightedNode<T>> nodes;

	private List<WeightedNode<T>> getNodes() {
		return nodes;
	}

	void setNodes(List<WeightedNode<T>> nodes) {
		this.nodes = nodes;
	}

	public DisjointSet() {
		nodes = new ArrayList<>();
	}

	public void makeSet(List<WeightedNode<T>> nodeList) {
		for(WeightedNode<T> node: nodeList) {
			DisjointSet<T> set = new DisjointSet<>();
			set.getNodes().add(node);
			node.setSet(set);
		}
	}

	public DisjointSet<T> findSet(WeightedNode<T> node) {
		return node.getSet();
	}

	public DisjointSet<T> union(WeightedNode<T> firstNode, WeightedNode<T> secondNode) {
		if(firstNode.getSet().equals(secondNode.getSet()))
			return null;
		DisjointSet<T> firstSet = firstNode.getSet();
		DisjointSet<T> secondSet = secondNode.getSet();
		if(firstSet.getNodes().size() > secondSet.getNodes().size())
			return copySet(secondSet, firstSet);
		return copySet(firstSet, secondSet);
	}

	private DisjointSet<T> copySet(DisjointSet<T> source, DisjointSet<T> destination) {
		for(WeightedNode<T> node: source.getNodes()) {
			destination.getNodes().add(node);
			node.setSet(destination);
		}
		return destination;
	}

	public void printAllNodesOfThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for(WeightedNode node: nodes) {
			System.out.print(node.getData() + "  ");
		}
		System.out.println();
	}
}
