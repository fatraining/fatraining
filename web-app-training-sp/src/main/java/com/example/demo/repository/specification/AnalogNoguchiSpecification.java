package com.example.demo.repository.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.analogNoguchi.AnalogMainNoguchi;
import com.example.demo.model.form.analogNoguchi.AnalogNoguchiSearchForm;

/**
 * AnalogMainの検索条件を生成するクラス
 *
 * @author future
 */
public class AnalogNoguchiSpecification {

	/**
	 * 検索条件生成の実装
	 * 
	 * @param AnalogMainNoguchiSearchFrom form
	 * @return AnalogMainのSpecification
	 */

	public static Specification<AnalogMainNoguchi> genereteAnalogSpecification(final AnalogNoguchiSearchForm form) {
		return new Specification<AnalogMainNoguchi>() {

			@Override
			public Predicate toPredicate(Root<AnalogMainNoguchi> root, CriteriaQuery<?> query, CriteriaBuilder cd) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうかを判定
				if (form.getIsDelete() == 1) {

					//削除フラグ＝1を検索条件にする。
					return cd.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);

				}

				//条件が入力されている場合、条件追加

				if (form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cd.equal(root.get("id"), form.getId());
					condition = getPredicate(cd, condition, newCondition);

				}

				if (!StringUtils.isEmpty(form.getAnalogTitle())) {

					//ゲーム名を条件に追加
					form.setAnalogTitle(form.getAnalogTitle().trim());
					Predicate newCondition = cd.like(root.get("analogTitle"), "%" + form.getAnalogTitle() + "%");
					condition = getPredicate(cd, condition, newCondition);

				}

				if (form.getTypeId() != null && form.getTypeId() != 0) {

					//種類を条件に追加
					Predicate newCondition = cd.equal(root.get("typeId"), form.getTypeId());
					condition = getPredicate(cd, condition, newCondition);

				}

				if (form.getTargetYears() != null && form.getTargetYears() != 0) {

					//対象年齢を条件に追加
					Predicate newCondition = cd.equal(root.get("targetYears"), form.getTargetYears());
					condition = getPredicate(cd, condition, newCondition);

				}

				// 削除フラグを条件に追加
				Predicate newCondition = cd.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cd, condition, newCondition);
				return condition;

			}

			private Predicate getPredicate(CriteriaBuilder cd, Predicate condition, @NotNull Predicate newCondition) {

				if (condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cd.and(condition, newCondition);

				} else {

					//条件がまだない場合、先頭の条件になる
					condition = newCondition;

				}

				return condition;
			}
		};
	}

}
