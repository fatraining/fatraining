package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.apexLegendsLegendTanamachi.LegendMainTanamachi;
import jp.co.futureantiques.webapptraining.model.form.apexLegendsLegendTanamachi.LegendSearchForm;

/**
 * LegendMainTanamachiの検索条件を生成するクラス
 *
 * @author future
 */
public class LegendTanamachiSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param LegendSearchForm form
	 * @return LegendMainTanamachiのspecification
	 */
	public static Specification<LegendMainTanamachi> genarateLegendSpecification(final LegendSearchForm form) {
		return new Specification<LegendMainTanamachi>() {
			@Override
			public Predicate toPredicate(Root<LegendMainTanamachi> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					//削除フラグ＝１を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合条件追加
				if (form.getLegendId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getLegendId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getLegendName())) {

					//レジェンド名を条件に追加
					form.setLegendName(form.getLegendName().trim());
					Predicate newCondition = cb.like(root.get("legendName"), "%" + form.getLegendName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getFromId() != null) {

					//出身地を条件に追加
					Predicate newCondition = cb.equal(root.get("fromId"), form.getFromId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getClassId() != null) {

					//クラスを条件に追加
					Predicate newCondition = cb.equal(root.get("classId"), form.getClassId());
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb, condition, newCondition);
				return condition;

			}
		};
	}

	/**
	 * 検索条件を結合する
	 *
	 * @param cb
	 * @param condition
	 * @param newCondition
	 * @return Predicate
	 */
	private static Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
		if (condition != null) {

			//すでに条件がある場合ANDで結合する
			condition = cb.and(condition, newCondition);
		} else {

			//条件がまだ無い場合先頭の条件になる
			condition = newCondition;
		}
		return condition;
	}
}
