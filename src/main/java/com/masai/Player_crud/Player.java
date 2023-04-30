package com.masai.Q1;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "player_new")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Pid;
	private String Name;
	private String SportName;
	private int Age;
	@Embedded
	private Address Address;
	public Player( String name, String sportName, int age, com.masai.Q1.Address address) {
		super();
		
		Name = name;
		SportName = sportName;
		Age = age;
		Address = address;
	}

	public Address getAddress() {
		return Address;
	}

	public void setAddress(Address address) {
		Address = address;
	}

	public Player() {
		super();
	}
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSportName() {
		return SportName;
	}
	public void setSportName(String sportName) {
		SportName = sportName;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	@Override
	public String toString() {
		return "Player [Pid=" + Pid + ", Name=" + Name + ", SportName=" + SportName + ", Age=" + Age + "]";
	}
	
}
