package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.novelOkudaira.NovelOkudairaSearchForm;
import jp.co.futureantiques.webapptraining.model.novelOkudaira.NovelMainOkudaira;

/**
 * NovelMainOkudairaの検索条件を生成するクラス
 *
 * @author future
 */
public class NovelOkudairaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param NovelSearchForm form
	 * @return NovelMainOkudairaのSpecification
	 */
	public static Specification<NovelMainOkudaira> generateNovelSpecification(final NovelOkudairaSearchForm form) {
		return new Specification<NovelMainOkudaira>() {
			@Override
			public Predicate toPredicate(Root<NovelMainOkudaira> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getNovelTitle())) {

					// 小説名を条件に追加
					form.setNovelTitle(form.getNovelTitle().trim());
					Predicate newCondition = cb.like(root.get("novelTitle"), "%" + form.getNovelTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getGenreId() != null && form.getGenreId() != 0) {

					// ジャンルを条件に追加
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getWriterId() != null && form.getWriterId() != 0) {

					// 作者を条件に追加
					Predicate newCondition = cb.equal(root.get("writerId"), form.getWriterId());
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