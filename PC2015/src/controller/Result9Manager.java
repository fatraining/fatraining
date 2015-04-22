package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import model.LiofTa;
import model.CoofTa;
import model.Result9Table;

public class Result9Manager extends TaskUtil {
	public List<?> resultTable;
	public ArrayList<Result9Table> outputTable;

	public ArrayList<Result9Table> resultList(String name, String food,
			String drink) {
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if (name.isEmpty())
				name = "%";
			if (food.isEmpty())
				food = "%";
			if (drink.isEmpty())
				drink = "%";
			String select = "SELECT * FROM table_color d, table_like i";
			String where1 = "WHERE d.id=i.color";
//			String where2 = "AND (i.name LIKE '" + name + "' AND i.food LIKE '"
//					+ food + "' AND i.drink LIKE '" + drink + "')";
			String sql = select + " " + where1/* + " " + where2*/;
			resultTable = session.createSQLQuery(sql)
					.addEntity("CoofTa", CoofTa.class)
					.addEntity("LiofTa", LiofTa.class).list();
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
				// temp.setDate_of_registration(coofta.getDate_of_registration());
				// temp.setUpdate_date(coofta.getUpdate_date());
				// temp.setRegistration_userid(coofta.getRegistration_userid());
				// temp.setUpdate_userid(coofta.getUpdate_userid());
				// temp.setTime_stamp(coofta.getTime_stamp());
				// temp.setDelete(coofta.getDelete());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempTable;
	}

}
