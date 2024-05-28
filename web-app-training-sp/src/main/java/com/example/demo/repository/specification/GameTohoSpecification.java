package com.example.demo.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.form.game.GameTohoSearchForm;
import com.example.demo.model.game.GameMainToho;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

/**
 * GameMainTohoの検索条件を生成するクラス
 *
 *@author future
 */

public class GameTohoSpecification {
	/**
	 * 検索条件生成の実装
	 * 
	 * @param GameTohoSearchForm form
	 * @return GameMainTohoのSpecification
	 */
	
	public static Specification<GameMainToho> generateGameTohoSpecification(final GameTohoSearchForm form) {
		return new Specification<GameMainToho>() {
			@Override
			public Predicate toPredicate(Root<GameMainToho> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getGameTitle())) {

					// ゲーム名を条件に追加
					form.setGameTitle(form.getGameTitle().trim());
					Predicate newCondition = cb.like(root.get("gameTitle"), "%" + form.getGameTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getGenreId() != null && form.getGenreId() != 0) {

					// ジャンルを条件に追加
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getEvaluationId() != null && form.getEvaluationId() != 0) {

					// 評価を条件に追加
					Predicate newCondition = cb.equal(root.get("evaluationId"), form.getEvaluationId());
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
