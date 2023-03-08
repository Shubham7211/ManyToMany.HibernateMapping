package com.jspiders.hibernate.manytomany.dao;

import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.jspiders.hibernate.manytomany.dto.Customer1DTO;
import com.jspiders.hibernate.manytomany.dto.Product1DTO;



public class CustomerProduct1DAO {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("ManyToMany1");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			
			openConnection();
			
			transaction.begin();
			
			Product1DTO product1 = new Product1DTO();
			product1.setId(1);
			product1.setName("T-Shirts");
			product1.setCategory("Clothing");
			product1.setPrice(1500);
			
			Product1DTO product2 = new Product1DTO();
			product2.setId(2);
			product2.setName("Perfume");
			product2.setCategory("Grooming");
			product2.setPrice(2500);
			
			Product1DTO product3 = new Product1DTO();
			product3.setId(3);
			product3.setName("AC");
			product3.setCategory("Electronics");
			product3.setPrice(25000);
			
			Customer1DTO customer1 = new Customer1DTO();
			customer1.setId(1);
			customer1.setName("Shahrukh");
			customer1.setContact(9875641203L);
			customer1.setCity("Delhi");
			
			Customer1DTO customer2 = new Customer1DTO();
			customer2.setId(2);
			customer2.setName("Salman");
			customer2.setContact(9875641203L);
			customer2.setCity("Mumbai");
			
			Customer1DTO customer3 = new Customer1DTO();
			customer3.setId(3);
			customer3.setName("Amir");
			customer3.setContact(9875641203L);
			customer3.setCity("Mumbai");
			
			List<Product1DTO> products1 = Arrays.
					asList(product1, product2);
			customer1.setProducts(products1);
			manager.persist(customer1);
			
			List<Product1DTO> products2 = Arrays.
					asList(product2, product3);
			customer2.setProducts(products2);
			manager.persist(customer2);
			
			List<Product1DTO> products3 = Arrays.
					asList(product1, product3);
			customer3.setProducts(products3);
			manager.persist(customer3);
			
			List<Customer1DTO> customers1 = Arrays.
					asList(customer1, customer3);
			product1.setCustomers(customers1);
			manager.persist(product1);
			
			List<Customer1DTO> customers2 = Arrays.
					asList(customer1, customer2);
			product2.setCustomers(customers2);
			manager.persist(product2);
			
			List<Customer1DTO> customers3 = Arrays.
					asList(customer2, customer3);
			product3.setCustomers(customers3);
			manager.persist(product3);
			
			transaction.commit();
			
		} finally {
			closeConnection();
		}
	}
}