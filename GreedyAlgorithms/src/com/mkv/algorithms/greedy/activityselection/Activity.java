package com.mkv.algorithms.greedy.activityselection;

public class Activity implements Comparable<Activity> {

	private String activityName;
	private int startTime;
	private int endTime;

	Activity(String activityName, int startTime, int endTime) {
		this.activityName = activityName;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	String getActivityName() {
		return activityName;
	}

	void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	int getStartTime() {
		return startTime;
	}

	void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	int getEndTime() {
		return endTime;
	}

	void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Activity{" +
				"activityName='" + activityName + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				'}';
	}

	@Override
	public int compareTo(Activity activity) {
		return this.getEndTime() - activity.getEndTime();


	}
}
