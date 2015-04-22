package controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.classic.Session;

import model.DetailEat;
import model.IDofEat;
import model.Result10Table;

public class Result10Manager extends TaskUtil {
	public List<?> result10Table;
	public ArrayList<Result10Table> outputTable;

	public ArrayList<Result10Table> resultList(String eat_year, String eat_month,
			String eat_day, String eat_hour) {
		Session session = TaskUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			if (eat_year.isEmpty())
				eat_year = "%";
			if (eat_month.isEmpty())
				eat_month = "%";
			if (eat_day.isEmpty())
				eat_day = "%";
			if (eat_hour.isEmpty())
				eat_hour = "%";
			String select = "SELECT * FROM eat_detail d, eat_id i";
			String where1 = "WHERE d.id=i.id";
			String where2 = "AND (d.eat_year LIKE '" + eat_year + "' AND d.eat_month LIKE '"
					+ eat_month + "' AND d.eat_day LIKE '" + eat_day + "' AND d.eat_hour LIKE '" + eat_hour + "')";
			String sql = select + " " + where1+ " " + where2;
			result10Table = session.createSQLQuery(sql)
					.addEntity("DetailEat", DetailEat.class)
					.addEntity("IDofEat", IDofEat.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(result10Table);
		return outputTable;
	}

	public ArrayList<Result10Table> tableTrans(List<?> resultTable) {
		ArrayList<Result10Table> tempTable = new ArrayList<Result10Table>();
		Object[] obj;
		try {
			for (int i = 0; i < result10Table.size(); i++) {
				Result10Table temp = new Result10Table();
				obj = (Object[]) result10Table.get(i);
				DetailEat detaileat = (DetailEat) obj[0];
				IDofEat idofeat = (IDofEat) obj[1];
				temp.setId(detaileat.getId());
				temp.setEat_year(detaileat.getEat_year());
				temp.setEat_month(detaileat.getEat_month());
				temp.setEat_day(detaileat.getEat_day());
				temp.setEat_hour(detaileat.getEat_hour());
				temp.setEatFood(idofeat.getEatFood());
				temp.setEatCalory(idofeat.getEatCalory());
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tempTable;
	}

}
