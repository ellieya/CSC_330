package edu.cuny.csi.csc330.observer;

import java.util.*;

public class EmploymentAgency implements Subject {
	
	
	//define a list of users, such as John, Joe, Jimmy, etc.
	private ArrayList<Observer> userList;
	private ArrayList<String> jobs;

	public EmploymentAgency() {
		init();
	}

	private void init() {
		userList = new ArrayList<Observer>();
		jobs = new ArrayList<String>();
	}
 
	@Override
	public void registerObserver(Observer observer) {
		userList.add(observer);
	}
 
	@Override
	public void removeObserver(Observer observer) {
		userList.remove(observer);
	}
 
	@Override
	public void notifyAllObservers() {
		for(Observer observer: userList){
			observer.update(this);  // pass in the current instance of EmploymentAgency ... 
		}
	}
 
	public void addJob(String job) {
		this.jobs.add(job);
		notifyAllObservers();
	}
 
	public ArrayList<String> getJobs() {
		return jobs;
	}
 
	public String toString(){
		return jobs.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmploymentAgency employmentAgency = new EmploymentAgency(); 
		
		employmentAgency.addJob("Java Software Engineer");
		employmentAgency.addJob("Big Data Scientist");

		System.out.println(employmentAgency); 
		
	}

}
