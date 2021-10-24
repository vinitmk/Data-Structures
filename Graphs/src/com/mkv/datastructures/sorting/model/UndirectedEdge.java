package com.mkv.datastructures.sorting.model;

public class UndirectedEdge<T> {

	private WeightedNode<T> first;
	private WeightedNode<T> second;
	private int weight;

	public UndirectedEdge(WeightedNode<T> first, WeightedNode<T> second, int weight) {
		this.first = first;
		this.second = second;
		this.weight = weight;
	}

	public WeightedNode<T> getFirst() {
		return first;
	}

	void setFirst(WeightedNode<T> first) {
		this.first = first;
	}

	public WeightedNode<T> getSecond() {
		return second;
	}

	void setSecond(WeightedNode<T> second) {
		this.second = second;
	}

	public int getWeight() {
		return weight;
	}

	void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Edge (" + first.getData() + "," + second.getData() + "), weight=" + weight + "]";
	}
}
