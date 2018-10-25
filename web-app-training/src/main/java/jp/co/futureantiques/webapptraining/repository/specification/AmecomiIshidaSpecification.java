package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.amecomiishida.AmecomiCharIshida;
import jp.co.futureantiques.webapptraining.model.form.amecomiIshida.AmecomiIshidaSearchForm;

/**
 * AmecomiCharの検索条件を生成するクラス
 * @author ishida
 *
 */
public class AmecomiIshidaSpecification {

	/**
	 * 検索条件生成の実装
	 * @param AmecomiIshidaSearchForm form
	 * @return AmecomiCharのSpecification
	 */
	public static Specification<AmecomiCharIshida> generateAmecomiIshidaSpecification(final AmecomiIshidaSearchForm form){
		return new Specification<AmecomiCharIshida>() {
			@Override
			public Predicate toPredicate(Root<AmecomiCharIshida> root, CriteriaQuery<?> query, CriteriaBuilder cd) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if(form.getIsDelete() == 1 ) {

					// 削除フラグ＝1を検索条件にする
					return cd.equal(root.get("delFlg"), 1);
				}

				// IDが入力されている場合条件に追加
				if(form.getId() != null) {

					Predicate newCondition =cd.equal(root.get("id"), form.getId());
					condition = getPredicate(cd, condition, newCondition);
				}

				//キャラ名が入力されている場合条件に追加
				if(!StringUtils.isEmpty(form.getCharName())) {
					form.setCharName(form.getCharName().trim());
					Predicate newCondition = cd.like(root.get("charName"), "%" + form.getCharName() + "%");
					condition = getPredicate(cd, condition, newCondition);
				}

				// 出版社が入力されている場合条件に追加
				if(form.getCompanyId() !=null && form.getCompanyId() != 0) {

					Predicate newCondition = cd.equal(root.get("companyId"), form.getCompanyId());
					condition = getPredicate(cd, condition, newCondition);
				}

				// サイドが入力されている場合条件に追加
				if(form.getSideId() !=null && form.getSideId() != 0) {
					Predicate newCondition =cd.equal(root.get("sideId"), form.getSideId());
					condition = getPredicate(cd, condition, newCondition);
				}

				// 削除フラグを条件に追加
				Predicate newCondition =cd.equal(root.get("delFlg"), 0);
				condition = getPredicate(cd, condition, newCondition);
				return condition;
			}

			/**
			 * 検索条件を結合する
			 * @param cd
			 * @param condition
			 * @param newCondition
			 * @return Predicate
			 */
			private Predicate getPredicate(CriteriaBuilder cd,Predicate condition,@NotNull Predicate newCondition) {
				if(condition != null){

					//既に条件がある場合、ANDで結合する
					condition = cd.and(condition,newCondition);
				}else {
					//まだ条件がない場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}
