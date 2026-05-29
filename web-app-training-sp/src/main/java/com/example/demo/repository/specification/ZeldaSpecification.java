package com.example.demo.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.form.zelda.ZeldaSearchForm;
import com.example.demo.model.zeldaikeda.ZeldaMainIkeda;

/**
 * ZeldaMainIkedaの検索条件を生成するクラス
 */
public class ZeldaSpecification {

	/**
	 * 検索条件生成の実装
	 * @param ZeldaSearchForm form
	 * @return ZeldaMainIkedaのSpecification
	 */
	public static Specification<ZeldaMainIkeda> generateZeldaSpecification(final ZeldaSearchForm form) {
		return new Specification<ZeldaMainIkeda>() {
			@Override
			public Predicate toPredicate(Root<ZeldaMainIkeda> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					// 削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				// 条件が入力されている場合条件追加
				if (form.getZeldaId() != null) {

					// ゼルダIDを条件に追加  以降（""）の中はSearchに書いてあるものと一緒
					Predicate newCondition = cb.equal(root.get("zeldaId"), form.getZeldaId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getZeldaTitle())) {

					// ゼルダタイトルを条件に追加
					form.setZeldaTitle(form.getZeldaTitle().trim());
					Predicate newCondition = cb.like(root.get("zeldaTitle"), "%" + form.getZeldaTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getGenreId() != null && form.getGenreId() != 0) {

					// ジャンルを条件に追加
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getTimeSeriesId() != null && form.getTimeSeriesId() != 0) {

					// 時系列を条件に追加
					Predicate newCondition = cb.equal(root.get("timeSeriesId"), form.getTimeSeriesId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getCompatibleModelId() != null && form.getCompatibleModelId() != 0) {

					// 対応機種を条件に追加
					Predicate newCondition = cb.equal(root.get("compatibleModelId"), form.getCompatibleModelId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// 削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb, condition, newCondition);
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
