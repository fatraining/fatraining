package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.yugiohOkugawa.YugiohOkugawaSearchForm;
import jp.co.futureantiques.webapptraining.model.yugiohOkugawa.YugiohMainOkugawa;

/**
 * YugiohMainの検索条件を生成するクラス
 * @author Okugawa
 *
 */
public class YugiohOkugawaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param YugiohOkugawaSearchForm form
	 * @return YugiohMainOkugawaのSpecification
	 */
	public static Specification<YugiohMainOkugawa>generateYugiohSpecification(final YugiohOkugawaSearchForm form){
		return new Specification<YugiohMainOkugawa>() {
			@Override
			public Predicate toPredicate(Root<YugiohMainOkugawa> root,CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件(SQLのWHERE以降のコード)
				Predicate condition = null;

				//削除フラグON用が1かどうかで判定
				if(form.getIsDelete() == 1) {

					//削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合条件追加
				if(form.getId() != null) {
					//IDを条件に追加(cdが演算子に入っているやつ
					//.equal(カラム名, 入力値)→カラム名と入力値が一致するやつ
					Predicate newCondition = cb.equal(root.get("id"),form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if(!StringUtils.isEmpty(form.getName())) {

					//キャラクター名を条件に追加
					form.setName(form.getName().trim());
					Predicate newCondition = cb.like(root.get("name"),"%"+form.getName()+"%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if(form.getSeriesId() != null && form.getSeriesId() != 0) {

					//シリーズを条件に追加
					Predicate newCondition = cb.equal(root.get("seriesId"),form.getSeriesId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if(form.getDeckId() != null && form.getDeckId() != 0) {

					//デッキを条件に追加
					Predicate newCondition = cb.equal(root.get("deckId"), form.getDeckId());
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb, condition, newCondition);
				return condition;
			}
			/**
			 * 検索条件を結合する
			 *
			 * @param cb
			 * @param condition
			 * @param newCondition
			 * @return Predicate
			 */
			private Predicate getPredicate(CriteriaBuilder cb,Predicate condition, @NotNull Predicate newCondition) {
				if(condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				}else {

					//条件がまだ無い場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}
