package jp.co.futureantiques.webapptraining.repository.specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.radioKashima.RadioKashimaSearchForm;
import jp.co.futureantiques.webapptraining.model.radioKashima.RadioMainKashima;

/**
 * RadioMainの検索条件を生成するクラス
 * @author anzai
 *
 */
public class RadioKashimaSpecification {

	/**
	 * 検索条件生成実装
	 *
	 * @param RadioKashimaSearchForm form
	 * @return RadioMainのSpecification
	 */
	public static Specification<RadioMainKashima> generateRadioKashimaSpecification(final RadioKashimaSearchForm form){
		return new Specification<RadioMainKashima>() {
			@Override
			public Predicate toPredicate(Root<RadioMainKashima> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判断
				if(form.getIsDelete() == 1) {

					//削除フラグ=1を検索する
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合条件追加
				if(form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if(!StringUtils.isEmpty(form.getProgramName())) {

					//ラジオ番組名を条件に追加
					form.setProgramName(form.getProgramName().trim());
					Predicate newCondition = cb.like(root.get("programName"), "%"+form.getProgramName()+"%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if(form.getKeystationId() != null && form.getKeystationId() != 0) {

					//放送局を条件に追加
					Predicate newCondition = cb.equal(root.get("keystationId"), form.getKeystationId());
					condition = getPredicate(cb, condition, newCondition);
				}


				//削除フラグを条件に追加
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
				if(condition != null) {

					//すでに条件がある場合ANDで結合
					condition = cb.and(condition, newCondition);
				}else {

					//条件がまだない場合
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}


