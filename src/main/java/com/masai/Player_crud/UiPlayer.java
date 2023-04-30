package com.masai.Q1;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import jakarta.persistence.Query;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UiPlayer {
	static EntityManagerFactory emf;
	static {
		emf= Persistence.createEntityManagerFactory("player_connect");
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int c=0;
	
	do {
		
		c=sc.nextInt();
		switch(c) {
		case 1:
		addPlayer(sc);
			break;
		case 2:
		playerNamesUpperCase();
			break;
		case 3:
		findMinAgePlayer();
			break;
		case 4:
		playersWithAge(sc);
			break;
		case 5:
			playersNamesStartWith(sc);
			break;
		}
	}while(c!=0);
}

private static void playersNamesStartWith(Scanner sc) {
	EntityManager em=emf.createEntityManager();
	//String l=sc.next();
	String query="SELECT p.Name FROM Player p WHERE p.Name LIKE :letter";
	Query que=em.createQuery(query);
	que.setParameter("letter","a"+"%");
	List<String> list=que.getResultList();
	list.forEach(System.out::println);
}

private static void playersWithAge(Scanner sc) {
	EntityManager em=emf.createEntityManager();
	int a=18;
	String query="select e from Player e where Age between :min and 25";
	
	Query que=em.createQuery(query);
	que.setParameter("min", a);
	List<Player> list = que.getResultList();
	list.forEach(System.out::println);
}

private static void findMinAgePlayer() {
	EntityManager em=emf.createEntityManager();
	String query="select min(p.Age) from Player p";
	Query que=em.createQuery(query);
	int age=(int) que.getSingleResult();
	System.out.println(age);
}

private static void addPlayer(Scanner sc) {
	System.out.println("enter name");
String name=sc.next();
System.out.println("enter sport name");
String sportName = sc.next();
System.out.println("enter age");
int age=sc.nextInt();

Address a=new Address("sportName", "Name", "rtNam", "portN");

Player p=new Player( name,sportName,age,a);

	EntityManager em=emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	et.begin();
	em.persist(p);
	et.commit();
	em.close();
	System.out.println("Done");
}

private static void playerNamesUpperCase() {
	EntityManager em = emf.createEntityManager();
	
	String upperQuery= "SELECT UPPER(e.Name) FROM Player e";
	
	Query query = em.createQuery(upperQuery);
	List<String> list = query.getResultList();
	list.forEach(System.out::println);
	em.close();
}
}
