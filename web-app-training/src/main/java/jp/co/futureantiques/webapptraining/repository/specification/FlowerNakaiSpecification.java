package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.flowerNakai.FlowerMainNakai;
import jp.co.futureantiques.webapptraining.model.form.flowerNakai.FlowerSearchForm;

/**
 * FlowerMainの検索条件を生成するクラス
 * @author Rieko Nakai
 */

public class FlowerNakaiSpecification {

	/**
	 * 検索条件生成の実装
	 * @param FlowerSearchForm form
	 * @return FlowerMainのSpecification
	 */

	public static Specification<FlowerMainNakai> generateFlowerNakaiSpecification(final FlowerSearchForm form){
		return new Specification<FlowerMainNakai>() {
			@Override
			public Predicate toPredicate(Root<FlowerMainNakai> root,CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if(form.getIsDelete() == 1) {

					//削除フラグ ＝ 1を検索条件にする
					return cb.equal(root.get("delFlg"),1);
				}

				//条件が入力されている場合条件追加
				if(form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if(!StringUtils.isEmpty(form.getFlowerName())) {

					//花の名前を条件に追加
					form.setFlowerName(form.getFlowerName().trim());
					Predicate newCondition = cb.like(root.get("flowerName"), "%" +form.getFlowerName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if(form.getMonthId() != null && form.getMonthId() != 0) {

					//見ごろの月を条件に追加
					Predicate newCondition = cb.equal(root.get("monthId"), form.getMonthId());
					condition = getPredicate(cb,condition, newCondition);
				}

				if(form.getColorId() != null && form.getColorId() != 0) {

					//花の色を条件に追加
					Predicate newCondition = cb.equal(root.get("colorId"), form.getColorId());
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

					//条件がまだない場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};

	}

}
