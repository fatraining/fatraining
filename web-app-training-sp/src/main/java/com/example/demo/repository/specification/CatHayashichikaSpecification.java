package com.example.demo.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.catHayashichika.CatMainHayashichika;
import com.example.demo.model.form.catHayashichika.CatHayashichikaSearchForm;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

/**
 * CatMainHayashichikaの検索条件を生成するクラス
 * @author future
 */

public class CatHayashichikaSpecification {

	/**
	 * 検索条件の実装
	 * 
	 * @param CatHayashichikaSearchForm form
	 * @return CatMainHayashichikaのSpecification
	 */
	public static Specification<CatMainHayashichika> generateCatSpecification(final CatHayashichikaSearchForm form) {
		return new Specification<CatMainHayashichika>() {
			@Override
			public Predicate toPredicate(Root<CatMainHayashichika> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用か1かどうか判定
				if (form.getIsDelete() == 1) {

					//削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlag"), CommonConst.DELETE_FLG_ON);
				}
				
				//条件が入力されている場合条件追加
				if (form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getCatName())) {

					//猫種名を条件に追加
					form.setCatName(form.getCatName().trim());
					Predicate newCondition = cb.like(root.get("catName"), "%" + form.getCatName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getTypeId() != null && form.getTypeId() != 0) {

					//毛種を条件に追加
					Predicate newCondition = cb.equal(root.get("typeId"), form.getTypeId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getSizeId() != null && form.getSizeId() != 0) {

					//体型を条件に追加
					Predicate newCondition = cb.equal(root.get("sizeId"), form.getSizeId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getFromId() != null && form.getFromId() != 0) {

					//原産国を条件に追加
					Predicate newCondition = cb.equal(root.get("fromId"), form.getFromId());
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlag"), CommonConst.DELETE_FLG_OFF);
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

					//既に条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				} else {
					
					//条件がまだない場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}
