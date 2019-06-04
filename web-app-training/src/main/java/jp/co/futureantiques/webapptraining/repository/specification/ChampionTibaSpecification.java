package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;

public class ChampionTibaSpecification {

	public static Specification<ChampionMainTiba> generateChampionSpecification(final ChampionTibaSearchForm form){
		return new Specification<ChampionMainTiba>() {
			@Override
			public Predicate toPredicate(Root<ChampionMainTiba> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate condition=null;
				if(form.getIsDelete()==1) {
					return  cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				if(form.getId()!=null) {
					Predicate newCondition=cb.equal(root.get("id"), form.getId());
					condition=getPredicate(cb, condition, newCondition);
				}

				if(!StringUtils.isEmpty(form.getChampionName())) {
					form.setChampionName(form.getChampionName().trim());
					Predicate newCondition=cb.like(root.get("championName"), "%"+form.getChampionName()+"%");
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getClassId()!=null&&form.getClassId()!=0) {
					Predicate newCondition=cb.equal(root.get("classId"), form.getClassId());
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getCountryId()!=null&&form.getCountryId()!=0) {
					Predicate newCondition=cb.equal(root.get("countryId"), form.getCountryId());
					condition=getPredicate(cb, condition, newCondition);
				}



				Predicate newCondition=cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition=getPredicate(cb, condition, newCondition);
				return condition;
			}

			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if(condition!=null) {
					condition=cb.and(condition, newCondition);
				}else {
					condition=newCondition;
				}
				return condition;
			}
		};
	}
}
