package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.catNihonyanagi.CatMainNihonyanagi;
import jp.co.futureantiques.webapptraining.model.form.catNihonyanagi.CatSearchForm;

/**
 * CatMainの検索条件を生成するクラス
 * @author user Nihonyanagi
 *
 */
public class CatNihonyanagiSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param CstSearchForm form
	 * @return CatMainのSpecification
	 */
	public static Specification<CatMainNihonyanagi> generateCatNihonyanagiSpecification(final CatSearchForm form){
		return new Specification<CatMainNihonyanagi>() {
			@Override
			public Predicate toPredicate(Root<CatMainNihonyanagi> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if(form.getIsDelete() == 1) {

					//削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_ON);
				}

				//検索条件が入力されている場合条件追加
				if(form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"),form.getId());
					condition = getPredicate(cb,condition,newCondition);
				}
				if(!StringUtils.isEmpty(form.getCatName())) {

					//ネコ名前を検索条件に追加
					form.setCatName(form.getCatName().trim());
					Predicate newCondition = cb.like(root.get("catName"),"%"+form.getCatName()+"%");
					condition = getPredicate(cb,condition,newCondition);
				}
				if(form.getHairId() != null && form.getHairId() != 0) {

					//被毛を条件に追加
					Predicate newCondition = cb.equal(root.get("hairId"),form.getHairId());
					condition = getPredicate(cb,condition,newCondition);
				}
				if (form.getSizeId() != null && form.getSizeId() != 0) {

					//大きさを条件に追加
					Predicate newCondition = cb.equal(root.get("sizeId"),form.getSizeId());
					condition = getPredicate(cb,condition,newCondition);
				}
				if(form.getCharacterId() != null && form.getCharacterId() != 0) {

					//性格を条件に追加
					Predicate newCondition = cb.equal(root.get("characterId"),form.getCharacterId());
					condition = getPredicate(cb,condition,newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb,condition,newCondition);
				return condition;

			}

			/**
			 * 検索条件を結合する
			 *
			 * @param cb
			 * @param condition
			 * @param newCondition
			 * @return Predicarte
			 */
			private Predicate getPredicate(CriteriaBuilder cb,Predicate condition,@NotNull Predicate newCondition) {
				if(condition != null) {

					//既に条件がある場合ANDで結合する
					condition = cb.and(condition,newCondition);
				}else {

					//条件がまだない場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}

}
