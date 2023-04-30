package com.masai.Q2;

import java.util.List;
import java.util.Scanner;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CustomerUi {
static EntityManagerFactory emf;

static {
	emf=Persistence.createEntityManagerFactory("player_connect");
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=0;
		
		do {
			
			c=sc.nextInt();
			switch(c) {
			case 1:
			addCustomer(sc);
				break;
			case 2:
			findCustomerById(sc);
				break;
			case 3:
			printAllCustomer();
				break;
			
			}
		}while(c!=0);	

	}

	private static void printAllCustomer() {
		EntityManager em=emf.createEntityManager();
		Query que=em.createNamedQuery("printAll");
		List<Customer> list = que.getResultList();
		list.forEach(System.out::print);
		
	}

	private static void findCustomerById(Scanner sc) {
		EntityManager em=emf.createEntityManager();
		Query que = em.createNamedQuery("findCustomerById");
		System.out.println("Enter Id");
		int a=sc.nextInt();
		que.setParameter("id", a);
		Customer c= (Customer) que.getSingleResult();
		System.out.println(c);
	}

	private static void addCustomer(Scanner sc) {
		EntityManager em=emf.createEntityManager();
		
		System.out.println("enter name");
		String name=sc.next();
		System.out.println("enter address");
		String address = sc.next();
		System.out.println("enter budget");
		int budget=sc.nextInt();
		Customer cus= new Customer(name,address,budget);
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(cus);
		et.commit();
		em.close();
	}

}
