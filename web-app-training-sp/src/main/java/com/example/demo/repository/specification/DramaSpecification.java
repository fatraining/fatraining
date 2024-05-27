package com.example.demo.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.drama.DramaMainNakaniwa;
import com.example.demo.model.form.drama.DramaSearchForm;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

/**
 * DramaMainNakaniwaの検索条件を生成するクラス
 */

public class DramaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param DramaSearchForm form
	 * @return DramaMainNakaniwaのSpecification
	 */
	public static Specification<DramaMainNakaniwa> generateDramaSpecification(final DramaSearchForm form) {
		return new Specification<DramaMainNakaniwa>() {
			@Override
			public Predicate toPredicate(Root<DramaMainNakaniwa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getDramaTitle())) {

					// ドラマ名を条件に追加
					form.setDramaTitle(form.getDramaTitle().trim());
					Predicate newCondition = cb.like(root.get("dramaTitle"), "%" + form.getDramaTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);

				}
				if (form.getGenreId() != null && form.getGenreId() != 0) {

					// ジャンルを条件に追加
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getCountryId() != null && form.getCountryId() != 0) {

					// 製作国を条件に追加
					Predicate newCondition = cb.equal(root.get("countryId"), form.getCountryId());
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
