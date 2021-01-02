package com.mkv.datastructures.model;

public class UndirectedEdge<T> {

	private WeightedNode<T> first;
	private WeightedNode<T> second;
	private int weight;

	UndirectedEdge(WeightedNode<T> first, WeightedNode<T> second, int weight) {
		this.first = first;
		this.second = second;
		this.weight = weight;
	}

	WeightedNode<T> getFirst() {
		return first;
	}

	void setFirst(WeightedNode<T> first) {
		this.first = first;
	}

	WeightedNode<T> getSecond() {
		return second;
	}

	void setSecond(WeightedNode<T> second) {
		this.second = second;
	}

	int getWeight() {
		return weight;
	}

	void setWeight(int weight) {
		this.weight = weight;
	}
}
