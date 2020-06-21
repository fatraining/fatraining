package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.alcoholishida.AlcoholMainIshida;
import jp.co.futureantiques.webapptraining.model.form.alcoholishida.AlcoholIshidaSearchForm;

/**
 * AlcoholMainIshidaの検索条件を生成するクラス
 *
 * @author t.ishida
 */
public class AlcoholIshidaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param AlcoholIshidaSearchForm form
	 * @return AlcoholMainIshidaのSpecification
	 */
	public static Specification<AlcoholMainIshida> generateAlcoholIshiawaSpecification(
			final AlcoholIshidaSearchForm form) {
		return new Specification<AlcoholMainIshida>() {
			@Override
			public Predicate toPredicate(Root<AlcoholMainIshida> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					// 削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlg"), 1);
				}

				// 条件が入力されている場合条件追加
				if (form.getId() != null) {

					// IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getAlcoholName())) {

					// お酒名を条件に追加
					form.setAlcoholName(form.getAlcoholName().trim());
					final String space = " ";

					// 半角スペースと全角スペースの組み合わせのパターンを表す
					final String spacesPattern = "[\\s　]+";

					// 以上のパターンにマッチした部分を単一の半角スペースに変換する
					final String monoSpaceQuery = form.getAlcoholName().replaceAll(spacesPattern, space);

					// 半角スペースでクエリをsplitする
					String[] alcoholNames = monoSpaceQuery.split("\\s");
					String alcoholName = "";
					for (int i = 0; i < alcoholNames.length; i++) {
						alcoholName = alcoholName + alcoholNames[i];
						Predicate newCondition = cb.or(cb.like(root.get("alcoholName"), "%" + alcoholName + "%"));
						condition = getPredicate(cb, condition, newCondition);
					}
				}

				if (form.getLiqueurId() != null && form.getLiqueurId() != 0) {

					// リキュールを条件に追加
					Predicate newCondition = cb.equal(root.get("liqueurId"), form.getLiqueurId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getIngredientId1() != null && form.getIngredientId1() != 0) {

					// 材料1を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("ingredientId1"), form.getIngredientId1()),
							cb.equal(root.get("ingredientId2"), form.getIngredientId1()),
							cb.equal(root.get("ingredientId3"), form.getIngredientId1()));
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getIngredientId2() != null && form.getIngredientId2() != 0) {

					// 材料2を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("ingredientId2"), form.getIngredientId2()),
							cb.equal(root.get("ingredientId1"), form.getIngredientId2()),
							cb.equal(root.get("ingredientId3"), form.getIngredientId2()));
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getIngredientId3() != null && form.getIngredientId3() != 0) {

					// 材料3を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("ingredientId3"), form.getIngredientId3()),
							cb.equal(root.get("ingredientId1"), form.getIngredientId3()),
							cb.equal(root.get("ingredientId2"), form.getIngredientId3()));
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
			 * @param cd
			 * @param condition
			 * @param newCondition
			 * @returm Predicate
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