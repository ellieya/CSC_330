package edu.cuny.csi.csc330.examples;

import java.util.*;

public class Person extends Object {

	protected static int counter = 0; // Class level attribute

	private Integer ID;
	private String firstName;
	private String lastName;
	private Date dob;
	private String organization;
	private String cellPhone;
	private String bizPhone;

	private String address;
	private String stateCode;
	private String zip;

	String favColor = "Unknown";

	@Override
	public String toString() {
		return "Person [ID=" + ID + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", organization=" + organization
				+ ", cellPhone=" + cellPhone + ", bizPhone=" + bizPhone
				+ ", address=" + address + ", stateCode=" + stateCode
				+ ", zip=" + zip + "]";
	}

	public String getDisplayContent() {

		return "--------------------- "
				+ firstName
				+ " "
				+ lastName
				+ " -----------------------\n"
				+ toString()
				+ "\n--------------------------------------------------------\n";

	}

	public String getPreferredPrinterDevice() {
		return null;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getFavColor() {
		return favColor;
	}

	public void setFavColor(String favColor) {
		this.favColor = favColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((bizPhone == null) ? 0 : bizPhone.hashCode());
		result = prime * result
				+ ((cellPhone == null) ? 0 : cellPhone.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result
				+ ((favColor == null) ? 0 : favColor.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((organization == null) ? 0 : organization.hashCode());
		result = prime * result
				+ ((stateCode == null) ? 0 : stateCode.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bizPhone == null) {
			if (other.bizPhone != null)
				return false;
		} else if (!bizPhone.equals(other.bizPhone))
			return false;
		if (cellPhone == null) {
			if (other.cellPhone != null)
				return false;
		} else if (!cellPhone.equals(other.cellPhone))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (favColor == null) {
			if (other.favColor != null)
				return false;
		} else if (!favColor.equals(other.favColor))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	/**
	 * NOT EXPOSED TO THE CLIENT
	 * 
	 * @return
	 */
	public Integer deriveAge() {

		Calendar dob = Calendar.getInstance();
		dob.setTime(this.dob);
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

		// if birthday hasn't arrived yet
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
			age--;
		} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < dob
						.get(Calendar.DAY_OF_MONTH)) {
			age--;
		}

		return age;
	}

	public Integer getAge() {
		// perform date math on DOB and current day
		return this.deriveAge();
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public Person() {
		init();
	}

	public Person(String lastName) {
		this.lastName = lastName;
		init();
	}

	public Person(String firstName, String lastName) {
		this.lastName = lastName;
		this.firstName = firstName;
		init();
	}

	public Person(Integer ID, String firstName, String lastName) {
		this.ID = ID;
		this.lastName = lastName;
		this.firstName = firstName;
		init();
	}

	private void init() {
		++Person.counter;

		/**
		 * Other initialing STEPS
		 */
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Person person = new Person();
		person.setFirstName("David");
		System.out.println(person);

	}

}
