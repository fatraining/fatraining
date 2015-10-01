package dao;

import java.util.List;

import model.Staff;
import model.Company;

import org.hibernate.Session;

public class StaffDao extends HibernateUtil {
	
	public List<?> searchResult() {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM staff s,company c";
		String where = "WHERE s.companyID=c.companyID";
		String sql = select + " " + where;
		try{
			resultTable = session.createSQLQuery(sql).addEntity("staff",Staff.class).addEntity("company",Company.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return resultTable;
	}

}	