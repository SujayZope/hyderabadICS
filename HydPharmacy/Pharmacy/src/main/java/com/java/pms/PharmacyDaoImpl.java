package com.java.pms;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.primefaces.util.IOUtils;

@ManagedBean(name = "pDao")
@SessionScoped
public class PharmacyDaoImpl implements PharmacyDao {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(PharmacyDaoImpl.class);

	private String errmsg1;
	private String errmsg2;
	private String msg;
	private String msg1;
	private String msg2;

	public String getMsg2() {
		return msg2;
	}

	public void setMsg2(String msg2) {
		this.msg2 = msg2;
	}

	public String getMsg1() {
		return msg1;
	}

	public void setMsg1(String msg1) {
		this.msg1 = msg1;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrmsg2() {
		return errmsg2;
	}

	public void setErrmsg2(String errmsg2) {
		this.errmsg2 = errmsg2;
	}

	public String getErrmsg1() {
		return errmsg1;
	}

	public void setErrmsg1(String errmsg1) {
		this.errmsg1 = errmsg1;
	}
	
	
	
	

	

	@Override
	public String AddPharmacyDetail(Pharmacy ph, Role role1) throws IOException {
		try {
			
			System.out.println("Good mornig");
			String encr = EntryptPassword.getCode(ph.getPass());
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Transaction t = session.beginTransaction();
			ph.setPass(encr);
			session.save(ph);
			role1.setPharmacy(ph);
			session.save(role1);

			t.commit();
//		System.out.println("Record Inserted...");
			LOGGER.info("Record Inserted");

			errmsg2 = "Registration Successful.....";
			return "Login.xhtml?faces-redirect=true";
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
		return "Login.xhtml?faces-redirect=true";
	}

	@Override
	public String AddRole(Role role, Pharmacy pharma2) throws IOException {
		try {
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

			System.out.println("UserId    " + pharma2.getUserId());
			Role ro = searchRoleObject(pharma2.getUserId());
			msg = "";
			msg1 = "";
			if (ro.getRoles() == null) {
				ro.setRoles(role.getRoles());
				System.out.println("Good mornig");
				SessionFactory sf = SessionHelper.getConnection();
				Session session = sf.openSession();
				ro.setStatus(Status.PENDING);
				Transaction t = session.beginTransaction();
				session.update(ro);
				t.commit();
//				System.out.println("Record Inserted...");
				LOGGER.info("Record Inserted");
				String doc = ro.getRoles().toString();
				if (doc == "Doctor") {
					// sessionMap.put("ro", ro);
					return "addDoctor.xhtml?faces-redirect=true";
				}
				msg = "Registration Successful.....";
				return "Home.xhtml?faces-redirect=true";
			 
			}else {
				msg1 = "Already Registered.....";
				return "Home.xhtml?faces-redirect=true";
			}
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
		return "Home.xhtml?faces-redirect=true";
	}

	private Role searchRoleObject(int userId) throws IOException {

		try {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(Role.class);
			cr.add(Restrictions.eq("userId", userId));
			Role user = (Role) cr.uniqueResult();
			System.out.println("Searched......");

			return user;
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
		return null;
	}

	@Override
	public String validateMe(Pharmacy pharmacy) throws IOException {

		try {
			errmsg2 = "";
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(Pharmacy.class);

			String encr = EntryptPassword.getCode(pharmacy.getPass());
			cr.add(Restrictions.eq("username", pharmacy.getUsername()));
			cr.add(Restrictions.eq("pass", encr.trim()));
			Pharmacy pharma = (Pharmacy) cr.uniqueResult();
		

			LOGGER.always();
			LOGGER.info("Record Inserted");
			if (pharma != null) {
				sessionMap.put("pharma", pharma);
				if (pharma.getLogouttime() != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String date = simpleDateFormat.format(pharma.getLogouttime());
					sessionMap.put("date", date);
				}
				errmsg1 = "";

				return "Home.xhtml?faces-redirect=true";
			}

			else {
				errmsg1 = "Wrong Username Password. Please try again..!";
				return "Login.xhtml?faces-redirect=true";
			}
		} catch (Exception e) {

			ExceptionHandler.handleException(e);
		}

		return "Login.xhtml?faces-redirect=true";
	}

	@Override
	public String logout(Pharmacy pharm) throws IOException {

		try {
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			pharm.setLogouttime(new Date());
			Transaction t = session.beginTransaction();
			session.update(pharm);
			t.commit();
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "Login.xhtml?faces-redirect=true";
		} catch (Exception e) {
			ExceptionHandler.handleException(e);
		}
		return "Login.xhtml?faces-redirect=true";
	}
	
	
	
   
	private Doctor user = new Doctor();
    private Part photo;
    
    public Doctor getUser() {
        return user;
    }
    
    public void setUser(Doctor user) {
        this.user = user;
    }
    
    public Part getPhoto() {
        return photo;
    }
    
    public void setPhoto(Part photo) {
        this.photo = photo;
    }
    
    public String checkDoctor(Pharmacy pharma1) throws IOException{
    	Map<String, Object> sMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    	Role ro = searchRoleObject(pharma1.getUserId());
	
		
		if(ro.getRoles()==Roles.Doctor) {
			sMap.put("ro", ro);
			return "doctor.xhtml?faces-redirect=true";
		}
		msg2 = "Your roll are not doctor..!";
		return "Home.xhtml?faces-redirect=true";
    }
    
	@Override
	public String addDoctor() throws IOException {
	
			try {
				
				System.out.println("good morning");
				 if (photo != null) {
					 
					 System.out.println("good night....");
				        user.setPic(IOUtils.toByteArray(photo.getInputStream()));;
				    }
				
				SessionFactory sf = SessionHelper.getConnection();
				Session session = sf.openSession();
				user.setStatus("Pending");
				
				Transaction t = session.beginTransaction();
				session.save(user);
				t.commit();
				return "Home.xhtml?faces-redirect=true";
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return "Home.xhtml?faces-redirect=true";
	}

	@Override
	public String addDisease(Diseases disease) throws IOException {
		SessionFactory sf = SessionHelper.getConnection();

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.save(disease);
		t.commit();
		return "Home.xhtml?faces-redirect=true";
	}
	
	@Override 
	public List<Doctor> ShowAllDoctor() {
		SessionFactory sf=SessionHelper.getConnection();
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Doctor.class);
		List<Doctor> docList=cr.list();
		return docList;
	}

}
