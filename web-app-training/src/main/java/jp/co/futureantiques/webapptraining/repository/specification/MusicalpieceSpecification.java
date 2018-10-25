package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.form.musicalpieceSearch.MusicalpieceSearchMainForm;
import jp.co.futureantiques.webapptraining.model.musicalpieceSearch.ArianaMainRuike;

//ArianaMainRuikeの検索条件を生成するクラス

public class MusicalpieceSpecification {

	//検索条件の実装
	public static Specification<ArianaMainRuike> generateArianaSpecification(final MusicalpieceSearchMainForm form) {
		return new Specification<ArianaMainRuike>() {

			@Override
			public Predicate toPredicate(Root<ArianaMainRuike> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				//  if (form.getIsDelete() == 1) {
				// 削除フラグ＝1を検索条件にする
				//return cb.equal(root.get("delFlg"), 1);
			//}



				// 条件が入力されている場合条件追加
				if (form.getSingleId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("singleId"), form.getSingleId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (!StringUtils.isEmpty(form.getSingleTitle())) {

					//シングルタイトルを条件に追加
					form.setSingleTitle(form.getSingleTitle().trim());
					Predicate newCondition = cb.like(root.get("singleTitle"), "%" + form.getSingleTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				//アルバム名を追加
				if (form.getAlbumId() != null && form.getAlbumId() != 0) {
					Predicate newCondition = cb.equal(root.get("albumId"), form.getAlbumId());
					condition = getPredicate(cb, condition, newCondition);

				}
				//コラボアーティスト名を追加
				if (form.getColaboId() != null && form.getColaboId() != 0) {
					Predicate newCondition = cb.equal(root.get("colaboId"), form.getColaboId());
					condition = getPredicate(cb, condition, newCondition);
				}
					// 削除フラグを条件に追加
					Predicate newCondition = cb.equal(root.get("delFlg"), 0);
					condition = getPredicate(cb, condition, newCondition);
					return condition;

			}
			//検索条件を結合する

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



