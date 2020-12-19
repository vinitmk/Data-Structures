package com.mkv.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedNode<T> implements Comparable<WeightedNode<T>> {
	private T data;
	private List<WeightedNode<T>> neighbors;
	private Map<WeightedNode<T>, Integer> weightMap;
	private boolean isVisited;
	private WeightedNode<T> parent;
	private int distance;

	WeightedNode(T data) {
		this.data = data;
		neighbors = new ArrayList<>();
		weightMap = new HashMap<>();
		isVisited = false;
		distance = Integer.MAX_VALUE/10;
	}

	T getData() {
		return data;
	}

	void setData(T data) {
		this.data = data;
	}

	List<WeightedNode<T>> getNeighbors() {
		return neighbors;
	}

	void setNeighbors(List<WeightedNode<T>> neighbors) {
		this.neighbors = neighbors;
	}

	Map<WeightedNode<T>, Integer> getWeightMap() {
		return weightMap;
	}

	void setWeightMap(Map<WeightedNode<T>, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	boolean isVisited() {
		return isVisited;
	}

	void setVisited(boolean visited) {
		isVisited = visited;
	}

	WeightedNode<T> getParent() {
		return parent;
	}

	void setParent(WeightedNode<T> parent) {
		this.parent = parent;
	}

	int getDistance() {
		return distance;
	}

	void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(WeightedNode<T> node) {
		return this.distance - node.distance;
	}
}
