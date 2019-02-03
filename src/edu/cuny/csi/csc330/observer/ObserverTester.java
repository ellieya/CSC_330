package edu.cuny.csi.csc330.observer;

public class ObserverTester {

	public ObserverTester() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			// Create an instance of EmploymentAgency / Subject 
			EmploymentAgency agency = new EmploymentAgency();
			// add a few "anonymous" instances of JobSeeker 
			agency.registerObserver(new JobSeeker(101, "Mike Muller"));
			agency.registerObserver(new JobSeeker(102, "Chris Malluk"));
			agency.registerObserver(new JobSeeker(103, "Jeff White"));
	 
			//Each time, a new job is added, all registered JobSeekers (Observers)  get noticed.
			agency.addJob("Google SEO");
			agency.addJob("Big Data Analyst");
			agency.addJob("C# Developer");
			agency.addJob("Java Developer");
			agency.addJob("QA Manager ");
	

	}

}
