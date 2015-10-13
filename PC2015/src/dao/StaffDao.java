package dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import model.Company;
import model.Staff;

/**
 * データベースアクセスクラス
 */
public class StaffDao extends HibernateUtil {
	/**
	 * 全件検索処理<br>
	 * List&lt;[0]Staff(Object),[1]Company(Object)&gt;の形で返す
	 */
	public List<?> searchResult() {
		//検索処理結果取得変数の初期化
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT {staff.*}, {company.*} FROM staff,company";
		String where = "WHERE staff.companyID = company.id AND staff.d_flag=0";
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
	/**
	 * 条件一致検索<br>
	 * List&lt;[0]Staff(Object),[1]Company(Object)&gt;の形で返す
	 */
	public List<?> searchResult(String sName,String prefecture,String cName){
		//検索処理結果取得変数の初期化
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
			String where1 = "WHERE staff.companyID = company.id AND staff.d_flag=0";
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
	/**
	 * 一番最後に追加したCompanyの行データを取得
	 */
	public Company companyList() {
		List<?> resultTable = null;
		// DB接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			String sql = "SELECT * FROM company";
			resultTable = session.createSQLQuery(sql)
					.addEntity("company", Company.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return (Company) resultTable.get(resultTable.size() - 1);
	}
	
	/**
	 * 追加処理
	 */
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
		
		//Companyデータの追加
		Company insertCompany = new Company();
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
		
		//追加したCompanyデータの取得
		StaffDao StaffController = new StaffDao();
		insertCompany = StaffController.companyList();
		
		//Staffデータの追加
		Staff insertStaff = new Staff();
		insertStaff.setCompanyID(insertCompany.getId());
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
	
	/**
	 * 削除処理
	 */
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
				//session.delete(company);
				staff.setD_flag(1);
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}
		}
		session.getTransaction().commit();
	}
}	