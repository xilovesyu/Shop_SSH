package com.xixi.model;

/**
 * Status entity. @author MyEclipse Persistence Tools
 */

public class Status implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -885275358332798060L;
	private Integer id;
	private String status;

	// Constructors

	/** default constructor */
	public Status() {
	}
	public Status(int id){
		this.id=id;
	}
	/** full constructor */
	public Status(String status) {
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}