package com.java.pms;

import java.io.IOException;
import java.util.List;

public interface PharmacyDao {
	
	String AddPharmacyDetail(Pharmacy ph, Role role) throws IOException;
	
	String validateMe(Pharmacy pharmacy) throws IOException ;
	
	String logout(Pharmacy pharm) throws IOException;
	
	String AddRole(Role role,Pharmacy pharma2) throws IOException;
	
	String addDoctor(Doctor doctor,Role role) throws IOException;
	
	String addDisease(Diseases disease) throws IOException;
	
	
	

}
