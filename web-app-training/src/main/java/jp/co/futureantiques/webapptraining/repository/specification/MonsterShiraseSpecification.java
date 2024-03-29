package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.monsterShirase.MonsterShiraseSearchForm;
import jp.co.futureantiques.webapptraining.model.monsterShirase.MonsterMainShirase;

/**
 * MonsterShiraseの検索条件を生成するクラス
 * @author Shirase
 */

public class MonsterShiraseSpecification {
	/**
	 * 検索条件生成実装
	 *
	 * @param MonsterShiraseSearchForm form
	 * @return MonsterMainShiraseのSpecification
	 */
	public static Specification<MonsterMainShirase> generateMonsterShiraseSpecification(final MonsterShiraseSearchForm form) {
		return new Specification<MonsterMainShirase>() {
			@Override
			public Predicate toPredicate(Root<MonsterMainShirase> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判断
				if (form.getIsDelete() == 1) {

					//削除フラグ=1を検索する
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				// 条件が入力されている場合条件追加
				// IDを条件に追加
				if (form.getId() != null) {
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// モンスター名を条件に追加
				if (!StringUtils.isEmpty(form.getName())) {
					form.setName(form.getName().trim());
					Predicate newCondition = cb.like(root.get("name"), "%" + form.getName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				// 素材名を条件に追加
				if (!StringUtils.isEmpty(form.getMaterial())) {
					form.setName(form.getName().trim());
					Predicate newCondition = cb.like(root.get("material"), "%" + form.getMaterial() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				// ジャンルIDを条件に追加
				if (form.getGenreId() != null && form.getGenreId() != 0) {
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// 初登場作品IDを条件に追加
				if (form.getTitleId() != null && form.getTitleId() != 0) {
					Predicate newCondition = cb.equal(root.get("titleId"), form.getTitleId());
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

					//すでに条件がある場合ANDで結合
					condition = cb.and(condition, newCondition);
				} else {

					//条件がまだない場合
					condition = newCondition;
				}
				return condition;
			}
		};
	}

}
