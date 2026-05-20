package com.example.demo.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.form.municipalityPopulationIkebe.MunicipalityPopulationSearchForm;
import com.example.demo.model.municipalityPopulationIkebe.MunicipalityPopulationIkebeMain;


/**
 * MunicipalityPopulationの検索条件を生成するクラス
 * 
 * @author FUTURE2024
 */
public class MunicipalityPopulationSpecification {
	
	
	/**
	 * 検索条件生成の実装
	 * @param MunicipalityPopulationSearchForm
	 * @return MunicipalityPopulationIkebeMainのSpecification
	 */
	public static Specification<MunicipalityPopulationIkebeMain> generatemunicipalityPopulationSpecification(final MunicipalityPopulationSearchForm form) {
		return new Specification<MunicipalityPopulationIkebeMain>() {
			@Override
			public Predicate toPredicate(Root<MunicipalityPopulationIkebeMain> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getMunicipality())) {

					// 市区町村名を条件に追加
					form.setMunicipality(form.getMunicipality().trim());
					Predicate newCondition = cb.like(root.get("Municipality"), "%" + form.getMunicipality() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getMunicipalityId() != null && form.getMunicipalityId() != 0) {

					// 市区町村区分を条件に追加
					Predicate newCondition = cb.equal(root.get("MunicipalityId"), form.getMunicipalityId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getPopulationId() != null && form.getPopulationId() != 0) {

					// 人口を条件に追加
					Predicate newCondition = cb.equal(root.get("PopulationId"), form.getPopulationId());
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
