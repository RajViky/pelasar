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
@Table(name="PRODUCTIONSTATION")
@XmlRootElement(name="productionStation")
@XmlType(propOrder={"id","name","nextMachine"})
public class ProductionStation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column (name="PRODUCTION_STATION_ID")
	private long id;
	@Column (name="NAME")
	private String name;
	@Column (name="NEXT_MACHINE")
	private String nextMachine;
	
	public ProductionStation() {
		
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
	public String getNextMachine() {
		return nextMachine;
	}
	public void setNextMachine(String nextMachine) {
		this.nextMachine = nextMachine;
	}
}
