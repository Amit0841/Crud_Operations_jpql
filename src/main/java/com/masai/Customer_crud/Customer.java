package com.masai.Q2;

import java.util.jar.Attributes.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name ="findCustomerById" ,query="select c from Customer c where customerId = :id")
@NamedNativeQuery(name = "printAll", query = "SELECT * FROM Customer", resultClass = Customer.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	private int budget;
	
	public Customer(String name, String address, int budget) {
		super();
		this.name = name;
		this.address = address;
		this.budget = budget;
	}
	public Customer() {
		super();
	}
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", budget=" + budget
				+ "]";
	}
	
}
