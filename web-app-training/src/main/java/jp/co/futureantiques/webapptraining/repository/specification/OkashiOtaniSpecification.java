package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.okashiotani.OkashiOtaniSearchForm;
import jp.co.futureantiques.webapptraining.model.okashiotani.OkashiMainOtani;

/**
 * OkashiMainの検索条件を生成するクラス
 *
 * @author future
 */
public class OkashiOtaniSpecification {


	/**
	 * 検索条件生成の実装
	 *
	 * @param OkashiSampleSearchForm form
	 * @return OkashiMainのSpecification
	 */
	public static Specification<OkashiMainOtani> generateOkashiOtaniSpecification(final OkashiOtaniSearchForm form) {
		return new Specification<OkashiMainOtani>() {
			@Override
			public Predicate toPredicate(Root<OkashiMainOtani> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					// 削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				// 条件が入力されている場合条件追加
				if (form.getId() != null) {

					// IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getOkashiName())) {

					// お菓子名を条件に追加
					form.setOkashiName(form.getOkashiName().trim());
					Predicate newCondition = cb.like(root.get("okashiName"), "%" + form.getOkashiName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getTypeId() != null && form.getTypeId() != 0) {

					// 種類を条件に追加
					Predicate newCondition = cb.equal(root.get("typeId"), form.getTypeId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getMakerId() != null && form.getMakerId() != 0) {

					// 俳メーカーを条件に追加
					Predicate newCondition = cb.equal(root.get("makerId"), form.getMakerId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// 削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
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
			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if (condition != null) {

					// すでに条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				} else {

					// 条件がまだ無い場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}

}
