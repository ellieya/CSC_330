package edu.cuny.csi.csc330.observer;

public class JobSeeker implements Observer {

	private int id; 
	private String name;
	 
	public JobSeeker(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public void update(Subject subject) {
		System.out.println("****" + this.name + " got notified!");
		//print job list
		System.out.println(subject);
	}
	
	
	
	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", name=" + name + "]";
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Observer jobSeeker = new JobSeeker(100, "Tom Parker");
		System.out.println(jobSeeker); 

	}

}
