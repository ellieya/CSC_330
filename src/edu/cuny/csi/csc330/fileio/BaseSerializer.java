package edu.cuny.csi.csc330.fileio;

import java.util.*;

public abstract class BaseSerializer {

	protected Person createDummyObject() {

		Person person = new Person();
		
	   	person.setCellNumber("917.663.4925");
	   	person.setDob( new Date() ); 
	   	person.setFirstName("Jim");
	   	person.setLastName("Jones");
	   	person.setEmailAddress("jim.jones@verizon.net");
	   	person.setId(101010);

		return person;

	}
	
	protected Person createDummyObject(List<String> people) {

		Person person = new Person();
		
	   	person.setCellNumber(people.get(4));
	   	person.setDob( new Date() ); 
	   	person.setFirstName(people.get(1));
	   	person.setLastName(people.get(2));
	   	person.setEmailAddress(people.get(3));
	   	int id = Integer.valueOf(people.get(0) ); 
	   	person.setId( id );

		return person;

	}

}
