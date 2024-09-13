package com.java.pms;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ManagedBean(name = "disease")
@RequestScoped
@Entity
@Table(name = "disease")
public class Diseases {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "disId")
	private int disId;

	@Column(name = "disName")
	private String disName;

	@Column(name = "sym")
	private String sym;

	@Column(name = "charge")
	private String charge;

	public int getDisId() {
		return disId;
	}

	public void setDisId(int disId) {
		this.disId = disId;
	}

	public String getDisName() {
		return disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

	public String getSym() {
		return sym;
	}

	public void setSym(String sym) {
		this.sym = sym;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}
	
	

}
