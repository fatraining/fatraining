package controller;

import java.util.ArrayList;
import java.util.List;

import model.LiofTa;
import model.CoofTa;
import model.Result9Table;

import org.hibernate.classic.Session;

public class LiofTaManager extends TaskUtil {
	public List<?> result9Table;
	public ArrayList<Result9Table> outputTable;

	public ArrayList<Result9Table> resultList() {
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String select = "SELECT * FROM table_like d,table_color i";
		String where1 = "WHERE d.id=i.id";
		String sql = select + " " + where1;

		try {
			result9Table = session.createSQLQuery(sql)
					.addEntity("table_like", LiofTa.class)
					.addEntity("table_color", CoofTa.class).list();
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
		try {
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
