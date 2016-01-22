package org.logistic.pelasar.fi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@Entity
@Table(name="PRODUCT")
@XmlRootElement(name="product")
@XmlType(propOrder={"id"})
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PRODUCTID")
	private long id;
	@Column(name="NUMBER_OF_PRODUCTS")
	private long numberOfproducts;
	@Column(name="AMOUNT_READY")
	private long amountReady;
	@Column(name="REMARKS")
	private String remarks;
	@Column(name="STATUS")
	private String status;
	@Column(name="IMAGE")
	private String image;
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Product() {
		
	}
	public void setAmountReady(long amountReady) {
		this.amountReady = amountReady;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public long getNumberOfproducts() {
		return numberOfproducts;
	}

	public void setNumberOfproducts(long numberOfproducts) {
		this.numberOfproducts = numberOfproducts;
	}

	public long getAmountReady() {
		return amountReady;
	}
}
