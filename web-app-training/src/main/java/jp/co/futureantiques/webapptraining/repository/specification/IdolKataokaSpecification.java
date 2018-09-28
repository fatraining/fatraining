
package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.IdolKataoka.IdolMainKataoka;
import jp.co.futureantiques.webapptraining.model.form.IdolKataoka.IdolSearchForm;

/**
 * IdolMainKataokaの検索条件を生成するクラス
 *
 * @author skataoka
 *
 */
public class IdolKataokaSpecification {


	/**
	 * 検索条件生成の実装
	 *
	 * @param IdolSearchForm form
	 * @return IdolMainKataokaのSpecification
	 */

	public static Specification<IdolMainKataoka> generateIdolSpecification(final IdolSearchForm form){
		return new Specification<IdolMainKataoka>() {

			@Override
			public Predicate toPredicate(Root<IdolMainKataoka> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					//削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), 1);
				}

				//条件が入力されている場合条件追加
				if (form.getIdolId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("idol_id"), form.getIdolId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getIdolName())) {

					//名を条件に追加
					form.setIdolName(form.getIdolName().trim());
					Predicate newCondition = cb.like(root.get("idolName"), "%" + form.getIdolName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getColorId() != null && form.getColorId() != 0) {

					//メンバーカラーを条件に追加
					Predicate newCondition = cb.equal(root.get("colorId"), form.getColorId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getGroupId() != null && form.getGroupId() != 0){

					//所属グループを条件に追加
					Predicate newCondition = cb.equal(root.get("groupId"), form.getGroupId());
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), 0);
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