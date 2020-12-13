package com.mkv.datastructures;

import java.util.Random;

public class SSSPByBFSMain {

	public static void main(String[] args) {
		int size = 10;

		SSSPByBFS<String> shortestPath = new SSSPByBFS<>();

		for(int i = 0; i < size; i++)
			shortestPath.createGraphNodes("V"+i, i);

		shortestPath.addUndirectedEdge(0,1);
		shortestPath.addUndirectedEdge(0,3);
		shortestPath.addUndirectedEdge(1,2);
		shortestPath.addUndirectedEdge(1,4);
		shortestPath.addUndirectedEdge(2,5);
		shortestPath.addUndirectedEdge(2,9);
		shortestPath.addUndirectedEdge(3,6);
		shortestPath.addUndirectedEdge(4,7);
		shortestPath.addUndirectedEdge(5,8);
		shortestPath.addUndirectedEdge(6,7);
		shortestPath.addUndirectedEdge(7,8);
		shortestPath.addUndirectedEdge(8,9);

		Random r = new Random();
		shortestPath.shortestPathBFSByIndex(r.nextInt(10));
	}
}
