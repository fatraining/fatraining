package controller;

import java.util.ArrayList;
import java.util.List;

import model.CoofTa;
import model.LiofTa;
import model.Result9Table;

import org.hibernate.classic.Session;

public class LiofTaManager extends TaskUtil{
	public List<?> resultTable;
	public ArrayList<Result9Table> outputTable;

	public ArrayList<Result9Table> resultList(String name, String food, String drink) {
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM table_color d,table_like i";
		String where1 = "WHERE d.id=i.color";
		String sql = select + " " + where1;

		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_color", CoofTa.class)
					.addEntity("table_like", LiofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();

		this.outputTable = tableTrans(resultTable);

		return outputTable;
	}

	public ArrayList<Result9Table> tableTrans(List<?> resultTable) {
		ArrayList<Result9Table> tempTable = new ArrayList<Result9Table>();
		Object[] obj;
		try {
			for (int i = 0; i < resultTable.size(); i++) {
				Result9Table temp = new Result9Table();
				obj = (Object[]) resultTable.get(i);
				CoofTa coofta = (CoofTa) obj[0];
				LiofTa liofta = (LiofTa) obj[1];
				temp.setId(liofta.getId());
				temp.setName(liofta.getName());
				temp.setFood(liofta.getFood());
				temp.setDrink(liofta.getDrink());
				temp.setColor(coofta.getColorNm());
				temp.setTaste(coofta.getTaste());
//				temp.setDate_of_registration(coofta.getDate_of_registration());
//				temp.setUpdate_date(coofta.getUpdate_date());
//				temp.setRegistration_userid(coofta.getRegistration_userid());
//				temp.setUpdate_userid(coofta.getUpdate_userid());
//				temp.setTime_stamp(coofta.getTime_stamp());
//				temp.setDelete(coofta.getDelete());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}
