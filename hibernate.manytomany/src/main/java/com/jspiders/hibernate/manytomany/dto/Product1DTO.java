package com.jspiders.hibernate.manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Product1DTO {

	@Id
	private int id;
	private String name;
	private String category;
	private double price;
	@ManyToMany(mappedBy = "products")
	List<Customer1DTO> customers;

}