package com.java.pms;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.mail.Part;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@ManagedBean(name = "doctor")
@RequestScoped
@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "docId")
	private int docId;

	@Column(name = "docName")
	private String docName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "docAge")
	private int docAge;

	@Column(name = "docAdd")
	private String docAdd;

	@Column(name = "spec")
	private String spec;

	@Column(name = "consltCharge")
	private int consltCharge;

	@Column(name = "status")
	private String status;
	
	@Column(name = "RoleId")
	private int RoleId;
	
    @Lob
    private byte[] pic;

	

	public int getRoleId() {
		return RoleId;
	}

	public void setRoleId(int roleId) {
		RoleId = roleId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public int getDocAge() {
		return docAge;
	}

	public void setDocAge(int docAge) {
		this.docAge = docAge;
	}

	public String getDocAdd() {
		return docAdd;
	}

	public void setDocAdd(String docAdd) {
		this.docAdd = docAdd;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getConsltCharge() {
		return consltCharge;
	}

	public void setConsltCharge(int consltCharge) {
		this.consltCharge = consltCharge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	
	
}
