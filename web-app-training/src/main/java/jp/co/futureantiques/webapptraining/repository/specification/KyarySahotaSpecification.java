package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.kyarySahota.KyarySahotaSearchForm;
import jp.co.futureantiques.webapptraining.model.kyarySahota.KyaryMainSahota;

/**
 * KyaryMainSahotaの検索条件を生成するクラス
 *
 * @author futureantiques
 */
public class KyarySahotaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param KyarySahotaSearchForm form
	 * @return KyaryMainSahotaのSpecification
	 */
	public static Specification<KyaryMainSahota> generateKyarySahotaSpecification(final KyarySahotaSearchForm form){
		return new Specification<KyaryMainSahota>() {
			@Override
			public Predicate toPredicate(Root<KyaryMainSahota> root,CriteriaQuery<?> query,CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if(form.getIsDelete() == 1) {

					//削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合条件追加
				if(form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"),form.getId());
					condition = getPredicate(cb,condition,newCondition);
				}
				if(!StringUtils.isEmpty(form.getSongTitle())) {

					//曲名を条件に追加
					form.setSongTitle(form.getSongTitle().trim());
					Predicate newCondition = cb.like(root.get("songTitle"), "%" + form.getSongTitle() + "%");
					condition = getPredicate(cb,condition,newCondition);
				}
				if(form.getNameId() != null && form.getNameId() != 0) {

					//CD名を条件に追加
					Predicate newCondition = cb.equal(root.get("nameId"),form.getNameId());
					condition = getPredicate(cb,condition,newCondition);
				}
				if(form.getTypeId() != null && form.getTypeId() != 0) {

					//CD形態を条件に追加
					Predicate newCondition = cb.equal(root.get("typeId"),form.getTypeId());
					condition = getPredicate(cb,condition,newCondition);
					return condition;
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
				 * @return Predicate
				 */
				private Predicate getPredicate(CriteriaBuilder cb,Predicate condition,@NotNull Predicate newCondition) {
					if(condition != null) {

						//すでに条件がある場合ANDで結合する
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
