package jp.co.futureantiques.webapptraining.repository.specification;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.dramaHashiyama.DramaMainHashiyama;
import jp.co.futureantiques.webapptraining.model.form.dramaHashiyama.DramaSearchForm;

/**
 * DramaMainHashiyamaの検索条件を生成するクラス
 *
 * @author hashiyama
 *
 */
public class DramaHashiyamaSpecification {


	/**
	 * 検索条件生成の実装
	 *
	 * @param DramaSearchForm form
	 * @return DramaMainHashiyamaのSpecification
	 */

	public static Specification<DramaMainHashiyama> generateDramaSpecification(final DramaSearchForm form){
		return new Specification<DramaMainHashiyama>() {

			@Override
			public Predicate toPredicate(Root<DramaMainHashiyama> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
			if (form.getIsDelete() == 1) {

					//削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), 1);
				}

				//条件が入力されている場合条件追加
				if (form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getDramaTitle())) {

					//ドラマ名を条件に追加
					form.setDramaTitle(form.getDramaTitle().trim());
					Predicate newCondition = cb.like(root.get("dramaTitle"), "%" + form.getDramaTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getActorId() != null && form.getActorId() != 0) {

					//主演俳優を条件に追加
					Predicate newCondition = cb.equal(root.get("actorId"), form.getActorId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getChannelId() != null && form.getChannelId() != 0){

					//テレビ局を条件に追加
					Predicate newCondition = cb.equal(root.get("channelId"), form.getChannelId());
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), 0);
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
				if(condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				}else {

					//条件がまだ無い場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}