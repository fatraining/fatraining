package training2016.action;

import java.util.List;

import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletRedirectResult;

import training2016.dao.CopyDao;
import training2016.model.Copy;
import training2016.model.CopySearchCondition;

/**
 * コピー削除Action
 *
 * @author minoguchi
 */
@Results({
	@Result(name = "backToSearch", value = "copySearch!redisplay", type = ServletRedirectResult.class)
})
public class CopyDeleteAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	/** 画面タイトル */
	private String titlename = "コピーを忘れる？";

	/** 検索結果リスト */
	private List<Copy> resultList;

	/**
	 * executeメソッド。
	 *
	 * @return 結果
	 */
	public String execute() throws Exception {
		String[] deleteId = this.getValueFromSession("deleteId");

		CopyDao dao = new CopyDao();
		CopySearchCondition cond = new CopySearchCondition();
		cond.setIds(deleteId);
		//削除フラグ確認
		cond.setDeleteFlag("0");
		this.resultList = dao.select(cond);
		if (resultList == null || resultList.isEmpty()) {
			this.addActionError("みつからないよ");
		}
		return "success";
	}

	/**
	 * deleteメソッド。
	 *
	 * @return 結果
	 */
	public String delete() {
		String[] deleteId = this.getValueFromSession("deleteId");

		// 取得して削除
		CopyDao dao = new CopyDao();
		CopySearchCondition cond = new CopySearchCondition();
		cond.setIds(deleteId);
		this.resultList = dao.select(cond);
		for (Copy target : this.resultList) {
			//排他チェック
			if(target.isExclusiveflag()){
				this.addActionError("ほかの人がデータを使用中だよ");
				return "err";
			}
		}

		for (Copy target : this.resultList) {
			//排他フラグON
			target.setExclusiveflag(true);
			dao.update(target);
			//削除フラグON
			target.setDeleteflag(true);
			dao.update(target);
			//排他フラグOFF
			target.setExclusiveflag(false);
			dao.update(target);
		}

		// 削除し終わったらセッションから消す
		this.putValueToSession("deleteId", null);

		return "backToSearch";
	}

	/**
	 * 検索画面に戻る
	 *
	 * @return
	 */
	public String back() {
		return "backToSearch";
	}

	/**
	 * resultListを返す
	 *
	 * @return resultList
	 */
	public List<Copy> getResultList() {
		return this.resultList;
	}

	/**
	 * titleを返す
	 *
	 * @return title
	 */
	public String getTitleName() {
		return this.titlename;
	}
}
