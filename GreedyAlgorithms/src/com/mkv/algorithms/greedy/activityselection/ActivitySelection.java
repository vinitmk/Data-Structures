package com.mkv.algorithms.greedy.activityselection;

import java.util.Collections;
import java.util.List;

class ActivitySelection {

	void selectActivity(List<Activity> activityList) {

		if(activityList.size() > 0) {
			Collections.sort(activityList);

			for(Activity act: activityList)
				System.out.println(act);

			Activity previousActivity = activityList.get(0);

			System.out.println("\n\nRecommended Schedule:\n" + previousActivity);

			for(int i = 1; i < activityList.size(); i++) {
				Activity currentActivity = activityList.get(i);
				if(currentActivity.getStartTime() >= previousActivity.getEndTime()) {
					System.out.println(currentActivity);
					previousActivity = currentActivity;
				}
			}
		}
	}
}
