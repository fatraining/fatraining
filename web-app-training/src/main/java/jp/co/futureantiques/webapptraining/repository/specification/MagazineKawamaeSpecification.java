package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.form.magazineKawamae.MagazineKawamaeSearchForm;
import jp.co.futureantiques.webapptraining.model.magazinekawamae.MagazineMainKawamae;

/**
 * MagazineMainKawamaeの検索条件を生成するクラス
 *
 * @author  wataru kawamae
 */
public class MagazineKawamaeSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param MagazineKawamaeSearchForm form
	 * @return MagazineMainのSpecification
	 */
	public static Specification<MagazineMainKawamae> generateMagazineSpecification(final MagazineKawamaeSearchForm form) {
		return new Specification<MagazineMainKawamae>() {
			@Override
			public Predicate toPredicate(Root<MagazineMainKawamae> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getMagazineName())) {

					// 雑誌名を条件に追加
					form.setMagazineName(form.getMagazineName().trim());
					Predicate newCondition = cb.like(root.get("magazineName"), "%" + form.getMagazineName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getGenreId() != null && form.getGenreId() != 0) {

					// ジャンルを条件に追加
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getSaledNumber() != null ) {

					// 売り上げ部数を条件に追加
					Predicate newCondition = cb.greaterThanOrEqualTo(root.get("saledNumber"), form.getSaledNumber());
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