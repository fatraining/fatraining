package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi.CharacterSearchForm;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.McuMainHayashi;

/**
 * mcuMainHayashiの検索条件を生成するクラス
 *
 * @author 林 重樹
 */
public class McuMainHayashiSpecification {
	/**
	 * 検索条件生成の実装
	 *
	 * @param CharacterSearchForm form
	 * @return mcuMainHayashiのSpecification
	 */
	public static Specification<McuMainHayashi> generateCharacterSpecification(final CharacterSearchForm form) {
		return new Specification<McuMainHayashi>() {
			@Override
			public Predicate toPredicate(Root<McuMainHayashi> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getCharacterName())) {

					// キャラクター名を条件に追加
					form.setCharacterName(form.getCharacterName().trim());
					Predicate newCondition = cb.like(root.get("characterName"), "%" + form.getCharacterName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getTypeId() != null && form.getTypeId() != 0) {

					// 人種を条件に追加
					Predicate newCondition = cb.equal(root.get("typeId"), form.getTypeId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getSexId() != null && form.getSexId() != 0) {

					// 性別を条件に追加
					Predicate newCondition = cb.equal(root.get("sexId"), form.getSexId());
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
