package com.mkv.algorithms.greedy.knapsack;

import java.util.Collections;
import java.util.List;

class FractionalKnapsack {

	void knapsackProblem(List<FractionalKnapsackItem> items, int capacity) {

		Collections.sort(items);

		int usedCapacity = 0;
		double value = 0;

		for(FractionalKnapsackItem item: items) {

			if(usedCapacity + item.getWeight() <= capacity) {
				usedCapacity += item.getWeight();
				System.out.println("Taken: "+item);
				value += item.getValue();
			}
			else {
				int remainingCapacity = capacity - usedCapacity;
				value = item.getRatio() * remainingCapacity;
				System.out.println("Taken: "+"item index = " + item.getIndex() + ",obtained value = " + value + ",used weight = " + remainingCapacity + ", ratio = " + item.getRatio()
						+ "]");
				usedCapacity += remainingCapacity;
			}

			if(capacity == usedCapacity)
				break;
		}
	}
}
