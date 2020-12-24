package com.mkv.datastructures.model;

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

	public WeightedNode(T data) {
		this.data = data;
		neighbors = new ArrayList<>();
		weightMap = new HashMap<>();
		isVisited = false;
		distance = Integer.MAX_VALUE/10;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<WeightedNode<T>> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<WeightedNode<T>> neighbors) {
		this.neighbors = neighbors;
	}

	public Map<WeightedNode<T>, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(Map<WeightedNode<T>, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean visited) {
		isVisited = visited;
	}

	public WeightedNode<T> getParent() {
		return parent;
	}

	public void setParent(WeightedNode<T> parent) {
		this.parent = parent;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(WeightedNode<T> node) {
		return this.distance - node.distance;
	}
}
