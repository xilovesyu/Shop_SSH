package com.xixi.model;

/**
 * Sorder entity. @author MyEclipse Persistence Tools
 */

public class Sorder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3517615153890069726L;
	private Integer id;
	private String name;
	private Double price;
	private Integer number;
//	private Integer pid;
	private Product product;

	// Constructors

	/** default constructor */
	public Sorder() {
	}

	/** minimal constructor */
	public Sorder(Integer number) {
		this.number = number;
	}

	/** full constructor */
	public Sorder(Integer id, String name, Double price, Integer number,
			Product product) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.number = number;
		this.product = product;
	}


	// Property accessors

	public Integer getId() {
		return this.id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

}