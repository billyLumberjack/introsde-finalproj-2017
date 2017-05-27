package introsde.finalproj.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.ws.rs.WebApplicationException;
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
public class ActivityHistory
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
	private List<DailyActivity> dailyActivity = null;

	public ActivityHistory() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DailyActivity> getDailyActivity() {
		return dailyActivity;
	}

	public void setDailyActivity(List<DailyActivity> dailyActivity) {
		this.dailyActivity = dailyActivity;
	}
	
	public static ActivityHistory getOne(String id)  throws WebApplicationException{
		EntityManager em = MyDao.instance.createEntityManager();
		ActivityHistory p = em.find(ActivityHistory.class, id);
		MyDao.instance.closeConnections(em);
		return p;
	}
	
	public static ActivityHistory getFromIntervalDates(String id2, int init, int end) throws WebApplicationException{
		ActivityHistory p = null;
		EntityManager em = MyDao.instance.createEntityManager();
		String qryStr;
		
		if(init != -1 && end != -1){
			qryStr = "db.ACTIVITYHISTORY.aggregate( ["
					+ "{ $unwind : '$DAILYACTIVITY'},"
					+ "{ $match: { '_id':\""+id2+"\", 'DAILYACTIVITY.DATE':{$gte:"+init+", $lte:"+end+"}} },"
					+ "{ $group : {_id : '"+id2+"-"+init+"-"+end+"' , DAILYACTIVITY:{$push:'$DAILYACTIVITY'}}}"
					+ "]).toArray()[0]";
		}
		else{
			qryStr = "db.ACTIVITYHISTORY.findOne({'_id':'"+id2+"'})";
		}
		
		
		try{
			p = (ActivityHistory) em.createNativeQuery(qryStr, ActivityHistory.class).getSingleResult();
		}catch(Exception e){
		}
		
		MyDao.instance.closeConnections(em);
		return p;
	}	
	
	public static ActivityHistory getFromUserId(String id){
		
		ActivityHistory p = null;
		EntityManager em = MyDao.instance.createEntityManager();
		String qryStr = "var userId = '"+id+"';"
				+ "var history_id = db.USER.findOne({'_id':userId}).ACTIVITYHISTORY__id;"
				+ "db.ACTIVITYHISTORY.findOne({'_id':history_id})";
		try{
			
			p = (ActivityHistory) em.createNativeQuery(qryStr, ActivityHistory.class).getSingleResult();
		}catch(Exception e){
		}
		
		MyDao.instance.closeConnections(em);
		return p;
	}		
	
	public static ActivityHistory getFromIntervalDatesAndUserId(String id, int init, int end) throws WebApplicationException{
		
		try{
			
			EntityManager em = MyDao.instance.createEntityManager();
			String qryStr;
			
			if(init != -1 && end != -1)
			{
				qryStr = "var init = "+init+";"
						+ "var end = "+end+";"
						+ "var userId = '"+id+"';"
						+ "var history_id = db.USER.findOne({'_id':userId}).ACTIVITYHISTORY__id;"
						+ "db.ACTIVITYHISTORY.aggregate(["
						+ "{ $unwind : '$DAILYACTIVITY'},"
						+ "{ $match: { '_id':history_id, 'DAILYACTIVITY.DATE':{$gte:init, $lte:end}} },"
						+ "{ $group : {_id : history_id+'-'+init+'-'+end , DAILYACTIVITY:{$push:'$DAILYACTIVITY'}}}"
						+ "]).toArray()[0]";
			}
			else
			{
				qryStr = "var userId = '"+id+"';"
						+ "var history_id = db.USER.findOne({'_id':userId}).ACTIVITYHISTORY__id;"
						+ "db.ACTIVITYHISTORY.findOne({'_id':history_id})";
			}			
			ActivityHistory p = (ActivityHistory) em.createNativeQuery(qryStr, ActivityHistory.class).getSingleResult();
			MyDao.instance.closeConnections(em);
			return p;
		}catch(Exception e){
			return null;
		}
		
		
	}		

	public static ActivityHistory saveActivityHistory(ActivityHistory r) throws WebApplicationException{
		EntityManager em = MyDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(r);
		tx.commit();
		MyDao.instance.closeConnections(em);

		return r;
	}

	public static ActivityHistory updateActivityHistory(ActivityHistory r) throws WebApplicationException{
		EntityManager em = MyDao.instance.createEntityManager(); 
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		r=em.merge(r);
		tx.commit();
		MyDao.instance.closeConnections(em);
		return r;
	}

	public static void removeActivityHistory(ActivityHistory r) throws WebApplicationException{
		EntityManager em = MyDao.instance.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		r=em.merge(r);
		em.remove(r);
		tx.commit();
		MyDao.instance.closeConnections(em);
	}

}
