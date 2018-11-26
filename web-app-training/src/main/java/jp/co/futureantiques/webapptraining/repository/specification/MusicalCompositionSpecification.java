package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.musicalcompositiontakei.MusicalCompositionSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalcomposition.takei.MusicalCompositionMainTakei;

/**
 * MusicalCompositionSearchMainの検索条件を生成するクラス
 *
 * @author takei
*/

public class MusicalCompositionSpecification {


	public static Specification<MusicalCompositionMainTakei> generateMusicalCompositionSpecification (final MusicalCompositionSearchMainForm form) {
		return new Specification<MusicalCompositionMainTakei>() {

		@Override
		public Predicate toPredicate(Root<MusicalCompositionMainTakei> root, CriteriaQuery<?> query, CriteriaBuilder cb) {


		//検索条件
		Predicate condition = null;


		// 削除フラグON用が1かどうか判定
		if(form.getIsDelete()==1){

			// 削除フラグ＝1を検索条件にする
			return cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_ON);
		}


		// 条件が入力されている場合条件追加
		if (form.getId() != null) {

			// IDを条件に追加
			Predicate newCondition = cb.equal(root.get("id"), form.getId());
			condition=getPredicate(cb, condition, newCondition);
			}
		//if (!StringUtils.isEmpty(form.getTitle())) {
		if (!StringUtils.isEmpty(form.getTitle())) {

			form.setTitle(form.getTitle().trim());
			Predicate newCondition=cb.like(root.get("title"), "%" + form.getTitle() + "%");
			condition = getPredicate(cb, condition, newCondition);
			}

		if(form.getGenreId()!=null && form.getGenreId() != 0) {
			Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
			   condition = getPredicate(cb, condition, newCondition);
			   }

		if(form.getAlbumId() != null && form.getAlbumId() != 0) {
			Predicate newCondition = cb.equal(root.get("albumId"), form.getAlbumId());
			   condition = getPredicate(cb, condition, newCondition);
			   }

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
		 * @retu
		 */

		private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, Predicate newCondition) {
			if(condition !=null) {
				// すでに条件がある場合ANDで結合する

				condition=cb.and(condition,newCondition);

			}else {

				condition=newCondition;
			}
			return condition;
		}
		};

	}
}
