package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.crKawanaka.CrMainKawanaka;
import jp.co.futureantiques.webapptraining.model.form.crKawanaka.CrSearchForm;

/**CrMainの検索条件を生成するクラス
 * author Misato Kawanaka
 */
public class CrKawanakaSpecification {

	/**
	 * 検索条件生成の実装
	 * @param CrSearchForm form
	 * @return CrMainのSpecification
	 */
	public static Specification<CrMainKawanaka> generateCrKawanakaSpecification(final CrSearchForm form) {
		return new Specification<CrMainKawanaka>() {
			@Override
			public Predicate toPredicate(Root<CrMainKawanaka> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					//削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), 1);
				}

				//条件が入力されている場合条件追加
				if (form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getName())) {

					//名前を条件に追加
					form.setName(form.getName().trim());
					Predicate newCondition = cb.like(root.get("name"), "%" + form.getName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getCategoryId() != null && form.getCategoryId() != 0) {

					//カテゴリーを条件に追加
					Predicate newCondition = cb.equal(root.get("categoryId"), form.getCategoryId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getDistributionId() != null && form.getDistributionId() != 0) {

					//分布を条件に追加
					Predicate newCondition = cb.equal(root.get("distributionId"), form.getDistributionId());
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCoudition = cb.equal(root.get("delFlg"), 0);
				condition = getPredicate(cb, condition, newCoudition);
				return condition;
			}

			/**
			 * 検索条件を結合する
			 * @param cb
			 * @param condition
			 * @param newCondition
			 * @return Predicate
			 */
			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if (condition != null) {

					//既に条件がある場合ANDで結合する
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
