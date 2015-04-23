package controller;

import java.util.ArrayList;
import java.util.List;

import model.BandAccount;
import model.BandTable;
import model.BandResultTable;

import org.hibernate.classic.Session;

public class BandAllManager extends HibernateUtil{
	
	public List<?> bandResultTable;
	public ArrayList<BandResultTable> outputTable;
	
	public ArrayList<BandResultTable> resultList(String band_name,String name,String part){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String select = "SELECT * FROM band_account a,band_table t ";
		String where1 = "WHERE a.id = t.id ";
		String sql = select + " " + where1;
		
		try{
			bandResultTable = session.createSQLQuery(sql)
					.addEntity("BandAccount",BandAccount.class)
					.addEntity("BandTable",BandTable.class).list();
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		
		this.outputTable = bandTableTrans(bandResultTable);
		
		return outputTable;
	}
	public ArrayList<BandResultTable> bandTableTrans(List<?> bandResultTable){
		ArrayList<BandResultTable> tempTable = new ArrayList<BandResultTable>();
		Object[] obj;
		try{
			for(int i = 0;i < bandResultTable.size();i++){
				BandResultTable temp = new BandResultTable();
				obj = (Object[]) bandResultTable.get(i);
				BandAccount bandaccount = (BandAccount)obj[0];
				BandTable bandtable = (BandTable)obj[1];
				temp.setId(bandaccount.getId());
				temp.setName(bandaccount.getName());
				temp.setSex(bandaccount.getSex());
				temp.setAge(bandaccount.getAge());
				temp.setSchool(bandaccount.getSchool());
				temp.setFavorite_song(bandaccount.getFavorite_song());
				temp.setPart(bandaccount.getPart());
				temp.setBand_id(bandaccount.getBand_id());
				temp.setEntry_date(bandaccount.getEntry_date());
				temp.setRenewal_date(bandaccount.getRenewal_date());
				temp.setEntry_userid(bandaccount.getEntry_userid());
				temp.setRenewal_userid(bandaccount.getRenewal_userid());
				temp.setExclusion_flg(bandaccount.getExclusion_flg());
				temp.setDelete_flg(bandaccount.getDelete_flg());
				temp.setBand_name(bandtable.getBand_name());
				tempTable.add(temp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return tempTable;
	}

}
