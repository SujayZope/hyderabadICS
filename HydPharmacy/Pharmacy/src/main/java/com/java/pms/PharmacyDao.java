package com.java.pms;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface PharmacyDao extends Serializable  {
	
	String AddPharmacyDetail(Pharmacy ph, Role role) throws IOException;
	
	String validateMe(Pharmacy pharmacy) throws IOException;
	
	String logout(Pharmacy pharm) throws IOException;
	
	String AddRole(Role role,Pharmacy pharma2) throws IOException;
	
	String checkDoctor(Pharmacy pharma1) throws IOException;
	
	String addDisease(Diseases disease) throws IOException;
	
	List<Doctor> ShowAllDoctor();

	String addDoctor() throws IOException;
	

}
