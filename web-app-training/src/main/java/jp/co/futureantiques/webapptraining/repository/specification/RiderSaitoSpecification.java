package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.riderSaito.RiderSaitoSearchForm;
import jp.co.futureantiques.webapptraining.model.riderSaito.RiderMainSaito;

/**
 * RiderMainsaitoの検索条件を生成するクラス
 *
 * @author future
 * */

public class RiderSaitoSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param RiderSaitoSerchForm form
	 * @return RiderMainSaitoのspecification
	 * */

	public static Specification<RiderMainSaito> generateRiderSpecification(final RiderSaitoSearchForm form) {

		return new Specification<RiderMainSaito>() {

			@Override
			public Predicate toPredicate(Root<RiderMainSaito> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか
				if (form.getIsDelete() == 1) {

					//削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合条件追加
				if (form.getRiderId() != null) {

					//仮面ライダーIDを条件に追加
					Predicate newCondition = cb.equal(root.get("rideIid"), form.getRiderId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if (!StringUtils.isEmpty(form.getRiderName())) {

					//仮面ライダー名を条件追加
					form.setRiderName(form.getRiderName().trim());
					Predicate newCondition = cb.like(root.get("riderName"), "%" + form.getRiderName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getAgeId() != null && form.getAgeId() != 0) {

					//年代を条件に追加
					Predicate newCondition = cb.equal(root.get("ageId"), form.getAgeId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getActor())) {

					//俳優を条件追加
					form.setActor(form.getActor().trim());
					Predicate newCondition = cb.like(root.get("actor"), "%" + form.getActor() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb, condition, newCondition);
				return condition;
			}

			/**
			 * 検索条件結合する
			 *
			 *@param cb
			 *@param condition
			 *@param newCondition
			 *@return Predicate
			 * */

			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if (condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				} else {

					//条件がまだない場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}
