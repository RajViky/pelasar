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
@Table(name="PALLET")
@XmlRootElement(name="pallet")
@XmlType(propOrder={"palletId","name","palletLocation","productId"})
public class Pallet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column (name="PALLET_ID")
	private long id;
	@Column (name="NAME")
	private String name;
	@Column (name="PALLET_LOCATION")
	private String palletLocation;
	@Column (name="PRODUCTIDS")
	private long[] productId;
	
	public String getPalletLocation() {
		return palletLocation;
	}

	public void setPalletLocation(String palletLocation) {
		this.palletLocation = palletLocation;
	}

	public long[] getProductId() {
		return productId;
	}

	public void setProductId(long[] productId) {
		this.productId = productId;
	}
	
	public Pallet() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
