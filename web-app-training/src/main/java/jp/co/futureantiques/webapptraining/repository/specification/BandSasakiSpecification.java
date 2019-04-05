package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.bandSasaki.BandMainSasaki;
import jp.co.futureantiques.webapptraining.model.form.bandSasaki.BandSasakiSearchForm;

public class BandSasakiSpecification {

	public static Specification<BandMainSasaki> generateBandSpecification(final BandSasakiSearchForm form){
		return new Specification<BandMainSasaki>() {
			@Override
			public Predicate toPredicate(Root<BandMainSasaki> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate condition=null;
				if(form.getIsDelete()==1) {
					return  cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				if(form.getId()!=null) {
					Predicate newCondition=cb.equal(root.get("id"), form.getId());
					condition=getPredicate(cb, condition, newCondition);
				}

				if(!StringUtils.isEmpty(form.getBandName())) {
					form.setBandName(form.getBandName().trim());
					Predicate newCondition=cb.like(root.get("bandName"), "%"+form.getBandName()+"%");
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getMemberId()!=null&&form.getMemberId()!=0) {
					Predicate newCondition=cb.equal(root.get("memberId"), form.getMemberId());
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getBirthplaceId()!=null&&form.getBirthplaceId()!=0) {
					Predicate newCondition=cb.equal(root.get("birthplaceId"), form.getBirthplaceId());
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
