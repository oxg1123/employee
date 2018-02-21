package com.oxg.app.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Employee implements Serializable {
	
	@Id private Integer id;
	private String firstName;
	private String lastName;
	private String position;
	private String office;
	private String sex;
	private Integer age;
	private String startDate;
	private Integer salary;
	
	
	private final static long serialVersionUID = -3077421469608314840L;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Employee() {
	}

	/**
	 * 
	 * @param office
	 * @param position
	 * @param id
	 * @param startDate
	 * @param lastName
	 * @param sex
	 * @param age
	 * @param salary
	 * @param firstName
	 */
	public Employee(Integer id, String firstName, String lastName, String position, String office, String sex,
			Integer age, String startDate, Integer salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.office = office;
		this.sex = sex;
		this.age = age;
		this.startDate = startDate;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	@Id
	public void setId(Integer id) {
		this.id = id;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(id).append(firstName).append(lastName).append(position).append(office)
				.append(sex).append(age).append(startDate).append(salary).toHashCode();
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Employee) == false) {
			return false;
		}
		Employee rhs = ((Employee) other);
		return new EqualsBuilder().append(id, rhs.id).append(firstName, rhs.firstName).append(lastName, rhs.lastName)
				.append(position, rhs.position).append(office, rhs.office).append(sex, rhs.sex).append(age, rhs.age)
				.append(startDate, rhs.startDate).append(salary, rhs.salary)
				.isEquals();
	}

}