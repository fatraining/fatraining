package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.form.yuruYokoyama.YuruSearchForm;
import jp.co.futureantiques.webapptraining.model.yuruYokoyama.YuruDataYokoyama;

/**
 * yuruDateの検索条件を生成するクラス
 *
 * @author future
 */
public class YuruYokoyamaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param YuruSearchForm form
	 * @return YuruDataのSpecification
	 */
	public static Specification<YuruDataYokoyama> generateYuruSpecification(final YuruSearchForm form) {
		return new Specification<YuruDataYokoyama>() {
			@Override
			public Predicate toPredicate(Root<YuruDataYokoyama> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					// 削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), 1);
				}

				// 条件が入力されている場合条件追加
				if (form.getId() != null) {

					// IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getName())) {

					// 名前を条件に追加
					form.setName(form.getName().trim());
					Predicate newCondition = cb.like(root.get("name"), "%" + form.getName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getBelongId() != null && form.getBelongId() != 0) {

					// 所属を条件に追加
					Predicate newCondition = cb.equal(root.get("belongId"), form.getBelongId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getFromId() != null && form.getFromId() != 0) {

					// 出身を条件に追加
					Predicate newCondition = cb.equal(root.get("fromId"), form.getFromId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// 削除フラグを条件に追加
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