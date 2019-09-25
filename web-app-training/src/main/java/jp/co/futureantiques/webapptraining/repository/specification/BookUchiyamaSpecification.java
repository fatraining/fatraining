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

	/**
	 * 検索条件の生成メソッド
	 * @param form
	 * @return Specification<BookMainUchiyama>
	 */
	public static Specification<BookMainUchiyama> generateBookSpecification(final BookUchiyamaSearchForm form){
		return new Specification<BookMainUchiyama>() {
			@Override
			public Predicate toPredicate(Root<BookMainUchiyama> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//検索条件
				Predicate condition=null;
				//削除フラグ1で検索の場合
				if(form.getIsDelete()==1) {
					//削除フラグ1を検索条件に設定
					return  cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}
				//本IDで検索
				if(form.getId()!=null) {
					//本IDを検索条件に追加
					Predicate newCondition=cb.equal(root.get("id"), form.getId());
					condition=getPredicate(cb, condition, newCondition);
				}
				//本タイトルで検索
				if(!StringUtils.isEmpty(form.getBookTitle())) {
					//フォームに入力された本タイトル前後に含まれる空白文字を取り除く
					form.setBookTitle(form.getBookTitle().trim());
					//本タイトル(一部または全部)でのLIKE検索を検索条件に追加
					Predicate newCondition=cb.like(root.get("bookTitle"), "%"+form.getBookTitle()+"%");
					condition=getPredicate(cb, condition, newCondition);
				}
				//ジャンルIDで検索
				if(form.getGenreId()!=null&&form.getGenreId()!=0) {
					//ジャンルIDを検索条件に追加
					Predicate newCondition=cb.equal(root.get("genreId"), form.getGenreId());
					condition=getPredicate(cb, condition, newCondition);
				}
				//作家IDで検索
				if(form.getWriterId()!=null&&form.getWriterId()!=0) {
					//作家IDを検索条件に追加
					Predicate newCondition=cb.equal(root.get("writerId"), form.getWriterId());
					condition=getPredicate(cb, condition, newCondition);
				}
				//削除フラグ0を検索条件に追加
				Predicate newCondition=cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition=getPredicate(cb, condition, newCondition);

				return condition;
			}

			/**
			 * 検索条件を結合するメソッド
			 * @param CriteriaBuilder cb
			 * @param Predicate condition
			 * @param Predicate newCondition
			 * @return 結合後の検索条件
			 */
			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				//検索条件が既に存在する場合
				if(condition!=null) {
					//検索条件をANDで結合する
					condition=cb.and(condition, newCondition);
				}else {
					//検索条件が未定義の場合は追加条件を設定する
					condition=newCondition;
				}
				return condition;
			}
		};
	}
}
