package controller;

import java.util.ArrayList;
import java.util.List;

import model.LiofTa;
import model.CoofTa;
import model.Result9Table;

import org.hibernate.classic.Session;

public class LiofTaManager extends HibernateUtil {
	public List<?> resultTable;
	public ArrayList<Result9Table> outputTable;

	public ArrayList<Result9Table> resultList() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String select = "SELECT * FROM table_like d,table_color i";
		String where1 = "WHERE d.id=i.id";
		String sql = select + " " + where1;
		try {
			resultTable = session.createSQLQuery(sql)
					.addEntity("table_like", LiofTa.class)
					.addEntity("table_color", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback(); // 障害が起こった時にその前の状態まで戻る
		}
		session.getTransaction().commit(); // Transaction処理が成功したとき結果を確立させる

		this.outputTable = tableTrans(resultTable); // テーブル取得

		return outputTable;
	}

	public ArrayList<Result9Table> resultList(String name, String food,
			String drink) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

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
			resultTable = session.createSQLQuery(sql)
					.addEntity("LiofTa", LiofTa.class)
					.addEntity("CoofTa", CoofTa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		this.outputTable = tableTrans(resultTable);
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
				tempTable.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return tempTable;
	}
}