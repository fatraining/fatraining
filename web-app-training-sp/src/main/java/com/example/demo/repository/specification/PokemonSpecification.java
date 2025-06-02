package com.example.demo.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.form.pokemon.PokemonSearchForm;
import com.example.demo.model.pokemon.PokemonMainSatoyoshi;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

/**
 * PokemonMainSatoyoshiの検索条件を生成するクラス
 *
 * @author satoyoshi
 */

public class PokemonSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param PokemonSearchForm form
	 * @return PokemonMainSatoyoshiのSpecification
	 */
	public static Specification<PokemonMainSatoyoshi> generatePokemonSpecification(final PokemonSearchForm form) {
		return new Specification<PokemonMainSatoyoshi>() {
			@Override
			public Predicate toPredicate(Root<PokemonMainSatoyoshi> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					// 削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				// 条件が入力されている場合条件追加
				if (form.getPokemonId() != null) {

					// ポケモンIDを条件に追加
					Predicate newCondition = cb.equal(root.get("pokemonId"), form.getPokemonId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getPokemonName())) {

					// ポケモン名を条件に追加
					form.setPokemonName(form.getPokemonName().trim());
					Predicate newCondition = cb.like(root.get("pokemonName"), "%" + form.getPokemonName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getType1Id() != null && form.getType1Id() != 0) {

					// タイプ1を条件に追加
					Predicate newCondition = cb.equal(root.get("type1Id"), form.getType1Id());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getType2Id() != null && form.getType2Id() != 0) {

					// タイプ2を条件に追加
					Predicate newCondition = cb.equal(root.get("type2Id"), form.getType2Id());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getAppearanceId() != null && form.getAppearanceId() != 0) {

					// 初登場シリーズを条件に追加
					Predicate newCondition = cb.equal(root.get("appearanceId"), form.getAppearanceId());
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
