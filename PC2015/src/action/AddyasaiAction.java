package action;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.text.*;

import model.Result8Table;
import model.Yasai;
import model.Ryouri;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.YasaiManager;

@Result(name = "main8", value = "main8.action", type = ServletRedirectResult.class)
public class AddyasaiAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	public String update_id;
	public String id;
	public String yasai;
	public int tyouriId;
	public String ryouri;
	public String date_entry;
	public String date_up;
	public String tyouri;
	public String userId;
	public String userId_up;
	public int control;
	public int sakuzyo;
	public String errormsg;

	public ArrayList<Result8Table> outputTable;
	public List<?> resultTable;
	
	

	public String execute() throws Exception {
		this.update_id = (String) this.sessionMap.get("update_id");

		return "success";
	}

	public String insert() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		// 日付の設定
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd k:m:s");
		date_entry = String.valueOf(sdf.format(date));
		date_up = String.valueOf(sdf.format(date));

		// ユーザーIDをゲット
		this.userId = (String) this.sessionMap.get("userId");

		// 入力チェック

		// 料理のデータ作成
		Ryouri insert_ryouri_table = new Ryouri();
		insert_ryouri_table.setId(this.id);
		insert_ryouri_table.setRyouri(this.ryouri);
		insert_ryouri_table.setTyouri(this.tyouri);
		insert_ryouri_table.setDate_Entry(this.date_entry);
		insert_ryouri_table.setDate_Up(this.date_up);
		insert_ryouri_table.setUserId(this.userId);
		insert_ryouri_table.setControl(0);
		insert_ryouri_table.setDeleteFlg(0);

		// 料理テーブルに追加
		try {
			session.save(insert_ryouri_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		// 料理テーブルのデータ検索
		YasaiManager yasaimanager = new YasaiManager();
		insert_ryouri_table = yasaimanager.ryouriList();
		//料理テーブルのid取得


		// 野菜データの作成
		Yasai insert_yasai_table = new Yasai();
		insert_yasai_table.setId(this.id);
		insert_yasai_table.setYasai(this.yasai);
		insert_yasai_table.setTyouriId(0);
		insert_yasai_table.setDate_Entry(this.date_entry);
		insert_yasai_table.setDate_Up(this.date_up);
		insert_yasai_table.setUserId(this.userId);
		insert_yasai_table.setControl(0);
		insert_yasai_table.setDeleteFlg(0);

		// 野菜テーブルに追加
		try {
			session.save(insert_yasai_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return "main8";
	}

	public String delete() {
		this.update_id = (String) this.sessionMap.get("update_id");
		if (this.update_id.isEmpty()) {
			return "success";
		}
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Ryouri ryouri = (Ryouri) session.load(Ryouri.class, update_id);
			Yasai yasai = (Yasai) session.load(Yasai.class, update_id);
			session.delete(ryouri);
			session.delete(yasai);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "success";
	}

	// public ArrayList<ResultTable> tableTrans(List<?> resultTable) {
	// ArrayList<ResultTable> tempTable = new ArrayList<ResultTable>();
	//
	// Object[] obj;
	// try {
	// for (int i = 0; i < resultTable.size(); i++) {
	// ResultTable temp = new ResultTable();
	//
	// obj = (Object[]) resultTable.get(i);
	// Yasai yasai = (Yasai) obj[0];
	// Ryouri ryouri = (Ryouri) obj[1];
	//
	// temp.setId(yasai.getId());
	// temp.setYasai(yasai.getYasai());
	// temp.setTyouriId(yasai.getTyouriId());
	// temp.setDate(yasai.getDate());
	// temp.setDate_up(yasai.getDate_up());
	// temp.setUserId(yasai.getUserId());
	// temp.setUserId_up(yasai.getUserId_up());
	// temp.setControl(yasai.getControl());
	// temp.setDelete(yasai.getDelete());
	//
	// temp.setId(ryouri.getId());
	// temp.setTyouri(ryouri.getTyouri());
	// temp.setRyouri(ryouri.getRyouri());
	// temp.setDate(ryouri.getDate());
	// temp.setDate_up(ryouri.getDate_up());
	// temp.setUserId(ryouri.getUserId());
	// temp.setUserId_up(ryouri.getUserId_up());
	// temp.setControl(ryouri.getControl());
	// temp.setDelete(ryouri.getDelete());
	//
	// tempTable.add(temp);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	//
	// }
	//
	// return tempTable;
	// }

}