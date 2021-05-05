package org.kamil.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Person {

	@NotEmpty(message = "{org.kamil.model.Person.firstName.NotEmpty}")
	private String firstName;

	@NotEmpty(message = "{org.kamil.model.Person.lastName.NotEmpty}")
	private String lastName;

	@Email(message = "{org.kamil.model.Person.email.Email}")
	@NotEmpty(message = "{org.kamil.model.Person.email.NotEmpty}")
	private String email;

	@Min(value = 1, message = "{org.kamil.model.Person.age.Min}")
	private int age;

	public Person() {

	}

	public Person(String firstName, String lastName, String email, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}

}
