package com.springcore;

public class Student {
	private int studId;
	private String studName;
	private String studAdd;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudAdd() {
		return studAdd;
	}
	public void setStudAdd(String studAdd) {
		this.studAdd = studAdd;
	}
	public Student(int studId, String studName, String studAdd) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAdd = studAdd;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAdd=" + studAdd + "]";
	}
	
	
	

}
