package com.mkv.algorithms.greedy.knapsack;

public class FractionalKnapsackItem implements Comparable<FractionalKnapsackItem> {

	private int index;
	private int value;
	private int weight;
	private double ratio;

	int getIndex() {
		return index;
	}

	void setIndex(int index) {
		this.index = index;
	}

	int getValue() {
		return value;
	}

	void setValue(int value) {
		this.value = value;
	}

	int getWeight() {
		return weight;
	}

	void setWeight(int weight) {
		this.weight = weight;
	}

	double getRatio() {
		return ratio;
	}

	void setRatio(double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "FractionalKnapsackItem{" +
				"index=" + index +
				", value=" + value +
				", weight=" + weight +
				", ratio=" + ratio +
				'}';
	}


	@Override
	public int compareTo(FractionalKnapsackItem fractionalKnapsackItem) {
		return fractionalKnapsackItem.ratio > this.ratio ? 1 : -1;
	}
}
