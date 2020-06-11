package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.comicMiyoshi.ComicMainMiyoshi;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiSearchForm;

/**
 * ComicMainの検索条件を生成するクラス
 * @author Miyoshi
 */
public class ComicMiyoshiSpecification {

	/**
	 * 検索条件生成の実装
	 * @param ComicMiyoshiSearchForm form
	 * @return ComicMainのSpecification
	 */
	public static Specification<ComicMainMiyoshi> generateComicMiyoshiSpecification(final ComicMiyoshiSearchForm form){
		return new Specification<ComicMainMiyoshi>() {
			@Override
			public Predicate toPredicate(Root<ComicMainMiyoshi> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

//				検索条件
				Predicate condition = null;

//				削除フラグON用が１かどうか判定
				if(form.getIsDelete() == 1) {

//					削除フラグ＝１を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);

				}

//				条件が入力されている場合条件追加
				if(form.getId() != null) {

//					IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if(!StringUtils.isEmpty(form.getComicTitle())) {

//					漫画タイトルを条件に追加
					form.setComicTitle(form.getComicTitle().trim());
					Predicate newCondition = cb.like(root.get("comicTitle"), "%" + form.getComicTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if(!StringUtils.isEmpty(form.getAuthor())) {

//					原作者名を条件に追加
					form.setAuthor(form.getAuthor().trim());
					Predicate newCondition = cb.like(root.get("author"), "%" + form.getAuthor() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if(form.getMagazineId() != null && form.getMagazineId() != 0) {

//					連載雑誌を条件に追加
					Predicate newCondition = cb.equal(root.get("magazineId"), form.getMagazineId());
					condition = getPredicate(cb, condition, newCondition);
				}

//				削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb, condition, newCondition);
				return condition;
			}

			/**
			 * 検索条件を結合する
			 * @param cb
			 * @param condition
			 * @param newCondition
			 * @return Predicate
			 */
			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if(condition != null) {

//					すでに条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				}else {

//					条件がまだない場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}