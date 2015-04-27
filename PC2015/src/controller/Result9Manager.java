package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import model.LiofTa;
import model.CoofTa;
import model.Result9Table;

public class Result9Manager extends HibernateUtil {
	public List<?> result9Table;
	public ArrayList<Result9Table> outputTable;

	public ArrayList<Result9Table> resultList(String name, String food,
			String drink) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		//例外処理
		try {
			if (name.isEmpty())
				name = "%";
			if (food.isEmpty())
				food = "%";
			if (drink.isEmpty())
				drink = "%";
			String select = "SELECT * FROM table_like d, table_color i";
			String where1 = "WHERE d.id=i.id";
			String where2 = "AND (d.name LIKE '" + name + "' AND d.food LIKE '"
					+ food + "' AND d.drink LIKE '" + drink + "')";
			String sql = select + " " + where1 + " " + where2;
			result9Table = session.createSQLQuery(sql)
					.addEntity("LiofTa", LiofTa.class)
					.addEntity("CoofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(result9Table);
		return outputTable;
	}

	public ArrayList<Result9Table> tableTrans(List<?> result9Table) {
		ArrayList<Result9Table> tempTable = new ArrayList<Result9Table>();
		Object[] obj;
		try { //　例外処理
			for (int i = 0; i < result9Table.size(); i++) {
				Result9Table temp = new Result9Table();
				obj = (Object[]) result9Table.get(i);
				LiofTa liofta = (LiofTa) obj[0];
				CoofTa coofta = (CoofTa) obj[1];
				temp.setId(liofta.getId());
				temp.setName(liofta.getName());
				temp.setFood(liofta.getFood());
				temp.setDrink(liofta.getDrink());
				temp.setColorNm(coofta.getColorNm());
				temp.setTaste(coofta.getTaste());
				temp.setDay(liofta.getDay());
				temp.setNew_day(liofta.getNew_day());
				temp.setUserid(liofta.getUserid());
				temp.setNew_userid(liofta.getNew_userid());
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
