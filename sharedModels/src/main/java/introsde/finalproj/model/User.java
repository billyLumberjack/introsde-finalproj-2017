package introsde.finalproj.model;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import introsde.finalproj.dao.MyDao;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@XmlRootElement(name = "user")
public class User
{
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Field(name="_id")
	@JsonProperty
	private String id;

	@JsonProperty
	private String username;
	
	@JsonProperty
	private String password;
	
	@JsonProperty
	private HealthData healthData;		

	@JsonProperty
	@OneToOne(/*mappedBy="user", */cascade = CascadeType.ALL)
	private FoodHistory foodHistory;

	@JsonProperty
	@OneToOne(/*mappedBy="user", */cascade = CascadeType.ALL)
	private ActivityHistory activityHistory;


	
	

	/*
	public static List<User> getAll(){
		EntityManager em = MyDao.instance.createEntityManager();
		List<User> list = em.createNamedQuery("User.findAll", User.class).getResultList();
		MyDao.instance.closeConnections(em);

		return list;
	}
	*/

	public static User getOne(String id){
		EntityManager em = MyDao.instance.createEntityManager();
		User p = em.find(User.class, id);
		MyDao.instance.closeConnections(em);
		return p;
	}

	public static User get(String id){
		User p = null;
		EntityManager em = MyDao.instance.createEntityManager();
		String qryStr = "db.USER.findOne({'_id':'"+id+"'})";
		try{
			p = (User) em.createNativeQuery(qryStr, User.class).getSingleResult();
		}catch(Exception e){
		}
		
		MyDao.instance.closeConnections(em);
		return p;
	}		
	
	
	public static User getOneWithoutDailyDetails(String id){
		User p = null;
		EntityManager em = MyDao.instance.createEntityManager();
		String qryStr = "db.USER.findOne({'_id':'"+id+"'},{'FOODHISTORY__id':0, 'ACTIVITYHISTORY__id':0})";
		try{
			p = (User) em.createNativeQuery(qryStr, User.class).getSingleResult();
		}catch(Exception e){
		}
		
		MyDao.instance.closeConnections(em);
		return p;
	}	
	
	public static User getFromIntervalDatesAndId(String id, int init, int end){
		User u = getOneWithoutDailyDetails(id);
		u.setFoodHistory(
				FoodHistory.getFromIntervalDatesAndUserId(id, init, end)
				);
		u.setActivityHistory(
				ActivityHistory.getFromIntervalDatesAndUserId(id, init, end)
				);
		return u;
	}		

	public static User saveUser(User u) {
		EntityManager em = MyDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();
		MyDao.instance.closeConnections(em);

		return u;
	}

	public User updateUser(User u) {
		EntityManager em = MyDao.instance.createEntityManager(); 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		u=em.merge(u);
		tx.commit();
		MyDao.instance.closeConnections(em);
		return u;
	}

	public static void removeUser(User u) {
		EntityManager em = MyDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		u=em.merge(u);
		em.remove(u);
		tx.commit();
		MyDao.instance.closeConnections(em);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FoodHistory getFoodHistory() {
		return foodHistory;
	}

	public void setFoodHistory(FoodHistory foodHistory) {
		this.foodHistory = foodHistory;
	}

	public ActivityHistory getActivityHistory() {
		return activityHistory;
	}

	public void setActivityHistory(ActivityHistory activityHistory) {
		this.activityHistory = activityHistory;
	}

	public HealthData getHealthData() {
		return healthData;
	}

	public void setHealthData(HealthData healthData) {
		this.healthData = healthData;
	}

}
