package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import model.Company;
import model.Staff;

public class StaffDao extends HibernateUtil {
	
	public List<?> searchResult() {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {staff.*}, {company.*} FROM staff,company";
		String where = "WHERE staff.companyID = company.id";
		String sql = select + " " + where;
		try{
			resultTable = session.createSQLQuery(sql)
					.addEntity("staff",Staff.class)
					.addEntity("company",Company.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		return resultTable;
	}
	public List<?> searchResult(String sName,String prefecture,String cName){
		List<?> resultTable = null;
		//DB接続
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		try{
			if(sName.isEmpty()){
				sName="%";
			}
			if(prefecture.isEmpty()){
				prefecture="%";
			}
			if(cName.isEmpty()){
				cName="%";
			}
			String select = "SELECT {staff.*},{company.*} FROM staff,company";
			String where1 = "WHERE staff.companyID = company.id";
			String where2 = "AND (staff.name LIKE '" + sName + "' AND staff.prefecture LIKE '"
					+ prefecture + "' AND company.name LIKE '" + cName + "')";
			String sql = select + " " + where1 + " " + where2 ;
			resultTable = session.createSQLQuery(sql)
					.addEntity("staff", Staff.class)
					.addEntity("company", Company.class).list();
		}catch (Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return resultTable;	
	}
	
	public Company companyList() {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//　table_hobbyのリストをすべて表示
		try {
			String sql = "SELECT * FROM company";
			resultTable = session.createSQLQuery(sql)
					.addEntity("company", Company.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		//　company_tableで生成したIDを取得(昇順)
		return (Company) resultTable.get(resultTable.size() - 1);
	}
	
	
	public void insert(String sName, String sPrefecture, String sPhonenumber,
			String cName, String cPrefecture, String cPhonenumber,
			String registeredPerson,String updateBy) {
		//　DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 登録、更新日時表示
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		String registrationDate = String.valueOf(sdf.format(date));
		String updateDate = String.valueOf(sdf.format(date));

		Company insertCompany = new Company();
		
		// table_profileにインサート
		insertCompany.setName(cName);
		insertCompany.setPrefecture(cPrefecture);
		insertCompany.setPhoneNumber(cPhonenumber);
		insertCompany.setRegistrationDate(registrationDate);
		insertCompany.setUpdateDate(updateDate);
		insertCompany.setRegisteredPerson(registeredPerson);
		insertCompany.setUpdateBy(updateBy);
		insertCompany.setD_flag(0);
		insertCompany.setE_flag(0);

		try {
			session.save(insertCompany);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		StaffDao StaffController = new StaffDao();
		insertCompany = StaffController.companyList();
		
		Staff insertStaff = new Staff();
		// my_sName_tableで生成したIDを取得しsName_idにセットする
		insertStaff.setCompanyID(insertCompany.getId());
		// table_mysNameにインサート
		insertStaff.setName(sName);
		insertStaff.setPrefecture(sPrefecture);
		insertStaff.setPhoneNumber(sPhonenumber);
		insertStaff.setRegistrationDate(registrationDate);
		insertStaff.setUpdateDate(updateDate);
		insertStaff.setRegisteredPerson(registeredPerson);
		insertStaff.setUpdateBy(updateBy);
		insertStaff.setE_flag(0);
		insertStaff.setD_flag(0);

		try {
			session.save(insertStaff);

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}
	
	public void delete(String delete_id) {
		//　DB接続
		Session session = HibernateUtil.getSessionFactory()
				.getCurrentSession();
		session.beginTransaction();
		
		// 分割
		String[] strAry = delete_id.split(", ");
		for (int i = 0; i < strAry.length; i++) {
			try {
				Staff staff = (Staff) session.load(Staff.class,
						Integer.parseInt(strAry[i]));
				Company company = (Company) session.load(Company.class,
						staff.getCompanyID());
				session.delete(company);
				session.delete(staff);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}
}	