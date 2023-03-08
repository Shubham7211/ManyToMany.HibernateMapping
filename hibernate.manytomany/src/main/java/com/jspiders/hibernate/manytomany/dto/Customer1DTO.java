package com.jspiders.hibernate.manytomany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Customer1DTO {

	@Id
	private int id;
	private String name;
	private long contact;
	private String city;
	@ManyToMany
	List<Product1DTO> products;

}