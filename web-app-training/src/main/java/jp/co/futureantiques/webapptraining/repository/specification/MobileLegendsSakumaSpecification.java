package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.mobileLegendsSakuma.MobileLegendsSakumaSearchForm;
import jp.co.futureantiques.webapptraining.model.mobileLegendsSakuma.MobileLegendsMainSakuma;

/**
 * MobileLegendsMainの検索条件を生成するクラス
 *
 * @author Sakuma
 *
 */
public class MobileLegendsSakumaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param MobileLegendsSakumaSearchForm form
	 * @return MobileLegendsMainSakumaのSpecification
	 */

	public static Specification<MobileLegendsMainSakuma>generateMobileLegendsSpecification(final MobileLegendsSakumaSearchForm form){
		return new Specification<MobileLegendsMainSakuma>() {

			@Override
			public Predicate toPredicate(Root<MobileLegendsMainSakuma> root,CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件(SQLのWHERE以降のコード)
				Predicate condition = null;

				//削除フラグON用が1かどうかで判定
				if(form.getIsDelete() == 1) {

					//削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合、条件追加
				if(form.getId() != null) {
					//IDを条件に追加(cdが演算子に入っているもの)
					//.equal(カラム名, 入力値)→カラム名と入力値が一致するやつ
					Predicate newCondition = cb.equal(root.get("id"),form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if(!StringUtils.isEmpty(form.getMobaleChara())) {

					//キャラクター名を条件に追加
					form.setMobaleChara(form.getMobaleChara().trim());
					Predicate newCondition = cb.like(root.get("mobaleChara"),"%"+form.getMobaleChara()+"%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if(form.getType1Id() != null && form.getType1Id() != 0) {

					//タイプ1を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("type1Id"),form.getType1Id()),cb.equal(root.get("type2Id"), form.getType1Id()));
					condition = getPredicate(cb, condition, newCondition);
				}

				if(form.getType2Id() != null && form.getType2Id() != 0) {

					//タイプ2を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("type2Id"),form.getType2Id()),cb.equal(root.get("type1Id"), form.getType2Id()));
					condition = getPredicate(cb, condition, newCondition);
				}

				if(form.getFeature1Id() != null && form.getFeature1Id() != 0) {

					//特徴1を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("feature1Id"),form.getFeature1Id()),cb.equal(root.get("feature2Id"), form.getFeature1Id()));
					condition = getPredicate(cb, condition, newCondition);
				}

				if(form.getFeature2Id() != null && form.getFeature2Id() != 0) {

					//特徴2を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("feature2Id"),form.getFeature2Id()),cb.equal(root.get("feature1Id"), form.getFeature2Id()));
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_OFF);
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
			private Predicate getPredicate(CriteriaBuilder cb,Predicate condition, @NotNull Predicate newCondition) {
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
