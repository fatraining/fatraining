package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.Ryouri;
import model.Yasai;

import org.apache.struts2.config.Result;
import org.apache.struts2.dispatcher.ServletRedirectResult;
import org.hibernate.HibernateException;
import org.hibernate.classic.Session;

import controller.HibernateUtil;
import controller.YasaiManager;

/**
 * @author a_yoshida
 *
 */
@Result(name = "yasaiSearch", value = "yasaiSearch.action", type = ServletRedirectResult.class)
public class YasaiAddAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	// テーブル内のカラム名の宣言
	public String yasai;
	public String ryouri;
	public String date_entry;
	public String date_up;
	public String tyouri;
	public String userId;

	// 削除チェックボックス
	public String delete_id;

	// 画面表示時に実行
	public String execute() throws Exception {
		// YasaiSearchActionのdelete_idを呼び出し
		this.delete_id = (String) this.sessionMap.get("delete_id");

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

		// ユーザーID設定
		this.userId = (String) this.sessionMap.get("userId");

		// 入力チェック

		// 料理のデータ作成
		Ryouri insert_ryouri_table = new Ryouri();
		insert_ryouri_table.setRyouri(this.ryouri);
		insert_ryouri_table.setTyouri(this.tyouri);
		insert_ryouri_table.setDate_Entry(this.date_entry);
		insert_ryouri_table.setDate_Up(this.date_up);
		insert_ryouri_table.setUserId(this.userId);

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

		// 野菜データの作成
		Yasai insert_yasai_table = new Yasai();
		insert_yasai_table.setYasai(this.yasai);

		// 料理テーブルのid取得し、野菜テーブルの調理idにいれる
		insert_yasai_table.setTyouriId(insert_ryouri_table.getId());
		insert_yasai_table.setDate_Entry(this.date_entry);
		insert_yasai_table.setDate_Up(this.date_up);
		insert_yasai_table.setUserId(this.userId);

		// 野菜テーブルに追加
		try {
			session.save(insert_yasai_table);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		session.getTransaction().commit();
		return "yasaiSearch";
	}

	// 検索結果内の値を削除
	public String delete() {
		this.delete_id = (String) this.sessionMap.get("delete_id");
		// delete_idが空だとそのままmain8にもどる
		if (this.delete_id.isEmpty()) {
			return "yasaiSearch";
		}
		// DBと接続
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Yasai yasai = (Yasai) session.load(Yasai.class, delete_id);
			Ryouri ryouri = (Ryouri) session.load(Ryouri.class,
					yasai.getTyouriId());
			session.delete(yasai);
			session.delete(ryouri);
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		return "yasaiSearch";
	}

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

