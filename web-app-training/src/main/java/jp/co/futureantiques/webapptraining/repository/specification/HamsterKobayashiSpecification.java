package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.TypeKobayashi.HamsterMainKobayashi;
import jp.co.futureantiques.webapptraining.model.form.hamsterKobayashi.HamsterKobayashiSearchForm;

//HamsterMainKobayashiの検索条件を生成するクラス


public class HamsterKobayashiSpecification {

	//検索条件生成の実装


	public static Specification<HamsterMainKobayashi> generateHamsterSpecification(final HamsterKobayashiSearchForm form){
		return new Specification<HamsterMainKobayashi>() {
			@Override
			public Predicate toPredicate(Root<HamsterMainKobayashi> root, CriteriaQuery<?>query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if(form.getIsDelete() == 1) {

					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);

				}
				//条件が入力されている場合条件追加
				if(form.getId() != null) {
					//IDを条件に追加
					Predicate newCondition =
					cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getName())) {

					// ハムスター名を条件に追加
					form.setName(form.getName().trim());
					Predicate newCondition = cb.like(root.get("name"), "%" + form.getName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getTypeId() != null && form.getTypeId() != 0) {

					// 種類を条件に追加
					Predicate newCondition = cb.equal(root.get("typeId"), form.getTypeId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getGraduateId() != null && form.getGraduateId() != 0) {

					// 出身を条件に追加
					Predicate newCondition = cb.equal(root.get("graduateId"), form.getGraduateId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// 削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb, condition, newCondition);
				return condition;
			}
			//検索条件を結合する
			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if(condition != null) {
					condition = cb.and(condition, newCondition);
				}else {
					condition = newCondition;
				}
				return condition;

			}
		};
	}

}

