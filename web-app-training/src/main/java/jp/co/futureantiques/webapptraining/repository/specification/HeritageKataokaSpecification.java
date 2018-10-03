package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.form.heritageKataoka.HeritageSearchForm;
import jp.co.futureantiques.webapptraining.model.heritagekataoka.HeritageMainKataoka;

/**
 * HeritageMainの検索条件を生成するクラス
 *
 * @author MIKI KATAOKA
 */
public class HeritageKataokaSpecification {
	/**
	 * 検索条件生成の実装
	 *
	 * @param HeritageSearchForm form
	 * @return HeritageMainのSpecification
	 */

	public static Specification<HeritageMainKataoka> generateHeritageSpecification(final HeritageSearchForm form){
		return new Specification<HeritageMainKataoka>() {
			@Override
			public Predicate toPredicate(Root<HeritageMainKataoka> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getHeritageName())) {

					//登録名を条件に追加
					form.setHeritageName(form.getHeritageName().trim());
					Predicate newCondition = cb.like(root.get("heritageName"), "%" + form.getHeritageName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getGenreId() != null && form.getGenreId() != 0) {

					//ジャンルを条件に追加
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getLocationId() != null && form.getLocationId() != 0){

					//所在地1を条件に追加
					Predicate newCondition = cb.equal(root.get("locationId1"), form.getLocationId());
					newCondition = cb.or(newCondition,cb.equal(root.get("locationId2"), form.getLocationId()));
					newCondition = cb.or(newCondition,cb.equal(root.get("locationId3"), form.getLocationId()));
					newCondition = cb.or(newCondition,cb.equal(root.get("locationId4"), form.getLocationId()));
					newCondition = cb.or(newCondition,cb.equal(root.get("locationId5"), form.getLocationId()));
					newCondition = cb.or(newCondition,cb.equal(root.get("locationId6"), form.getLocationId()));
					newCondition = cb.or(newCondition,cb.equal(root.get("locationId7"), form.getLocationId()));
					newCondition = cb.or(newCondition,cb.equal(root.get("locationId8"), form.getLocationId()));
					condition = getPredicate(cb, condition, newCondition);

				}

				//削除フラグを条件に追加
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
				if(condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				}else {

					//条件がまだ無い場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}

}
