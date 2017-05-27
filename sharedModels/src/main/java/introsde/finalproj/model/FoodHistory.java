package introsde.finalproj.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

import com.fasterxml.jackson.annotation.JsonProperty;
import introsde.finalproj.dao.MyDao;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class FoodHistory
{

	@Id
	@GeneratedValue
	@Field(name="_id")
	private String id;
	
	/*
	@OneToOne
	private User user;
*/
	@ElementCollection
	private List<DailyFood> dailyFood = null;

	public FoodHistory() {
	}

	@JsonProperty("dailyFood")
	public List<DailyFood> getDailyFood() {
		return dailyFood;
	}

	@JsonProperty("dailyFood")
	public void setDailyFood(List<DailyFood> dailyFood) {
		this.dailyFood = dailyFood;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	

	public static FoodHistory getOne(String id){
		EntityManager em = MyDao.instance.createEntityManager();
		FoodHistory p = em.find(FoodHistory.class, id);
		MyDao.instance.closeConnections(em);
		return p;
	}
	
	public static FoodHistory getFromUserId(String id){
		
		FoodHistory p = null;
		EntityManager em = MyDao.instance.createEntityManager();
		String qryStr = "var userId = '"+id+"';"
				+ "var history_id = db.USER.findOne({'_id':userId}).FOODHISTORY__id;"
				+ "db.FOODHISTORY.findOne({'_id':history_id})";
		try{
			
			p = (FoodHistory) em.createNativeQuery(qryStr, FoodHistory.class).getSingleResult();
		}catch(Exception e){
		}
		
		MyDao.instance.closeConnections(em);
		return p;
	}	
	
	public static FoodHistory getFromIntervalDatesAndUserId(String id, int init, int end){
		
		FoodHistory p = null;
		EntityManager em = MyDao.instance.createEntityManager();
		String qryStr = "var init = "+init+";"
				+ "var end = "+end+";"
				+ "var userId = '"+id+"';"
				+ "var history_id = db.USER.findOne({'_id':userId}).FOODHISTORY__id;"
				+ "db.FOODHISTORY.aggregate(["
				+ "{ $unwind : '$DAILYFOOD'},"
				+ "{ $match: { '_id':history_id, 'DAILYFOOD.DATE':{$gte:init, $lte:end}} },"
				+ "{ $group : {_id : history_id+'-'+init+'-'+end , DAILYFOOD:{$push:'$DAILYFOOD'}}}"
				+ "]).toArray()[0]";
		try{
			
			p = (FoodHistory) em.createNativeQuery(qryStr, FoodHistory.class).getSingleResult();
		}catch(Exception e){
		}
		
		MyDao.instance.closeConnections(em);
		return p;
	}		
	
	public static FoodHistory getFromIntervalDates(String id, int init, int end){
		
		FoodHistory p = null;
		EntityManager em = MyDao.instance.createEntityManager();
		String qryStr = "db.FOODHISTORY.aggregate( ["
				+ "{ $unwind : '$DAILYFOOD'},"
				+ "{ $match: { '_id':\""+id+"\", 'DAILYFOOD.DATE':{$gte:"+init+", $lte:"+end+"}} },"
				+ "{ $group : {_id : '"+id+"-"+init+"-"+end+"' , DAILYFOOD:{$push:'$DAILYFOOD'}}}"
				+ "]).toArray()[0]";
		try{
			p = (FoodHistory) em.createNativeQuery(qryStr, FoodHistory.class).getSingleResult();
		}catch(Exception e){
		}
		
		MyDao.instance.closeConnections(em);
		return p;
	}	

	public static FoodHistory saveFoodHistory(FoodHistory r) {
		EntityManager em = MyDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(r);
		tx.commit();
		MyDao.instance.closeConnections(em);

		return r;
	}

	public static FoodHistory updateFoodHistory(FoodHistory r) {
		EntityManager em = MyDao.instance.createEntityManager(); 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		r=em.merge(r);
		tx.commit();
		MyDao.instance.closeConnections(em);
		return r;
	}

	public static void removeFoodHistory(FoodHistory r) {
		EntityManager em = MyDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		r=em.merge(r);
		em.remove(r);
		tx.commit();
		MyDao.instance.closeConnections(em);
	}

}
