package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.bookUchiyama.BookMainUchiyama;
import jp.co.futureantiques.webapptraining.model.form.bookUchiyama.BookUchiyamaSearchForm;

public class BookUchiyamaSpecification {

	public static Specification<BookMainUchiyama> generateBookSpecification(final BookUchiyamaSearchForm form){
		return new Specification<BookMainUchiyama>() {
			@Override
			public Predicate toPredicate(Root<BookMainUchiyama> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate condition=null;
				if(form.getIsDelete()==1) {
					return  cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				if(form.getId()!=null) {
					Predicate newCondition=cb.equal(root.get("id"), form.getId());
					condition=getPredicate(cb, condition, newCondition);
				}

				if(!StringUtils.isEmpty(form.getBookTitle())) {
					form.setBookTitle(form.getBookTitle().trim());
					Predicate newCondition=cb.like(root.get("bookTitle"), "%"+form.getBookTitle()+"%");
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getGenreId()!=null&&form.getGenreId()!=0) {
					Predicate newCondition=cb.equal(root.get("genreId"), form.getGenreId());
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getWriterId()!=null&&form.getWriterId()!=0) {
					Predicate newCondition=cb.equal(root.get("writerId"), form.getWriterId());
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
