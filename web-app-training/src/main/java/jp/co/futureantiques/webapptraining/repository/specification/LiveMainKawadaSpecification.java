package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.liveMainKawada.LiveMainKawadaSearchForm;
import jp.co.futureantiques.webapptraining.model.liveMainKawada.LiveMainKawada;

/**
 * LiveMainKawadaの検索条件を生成するクラス
 * @author future
 *
 */
public class LiveMainKawadaSpecification {

	/**
	 * 検索条件生成の実装
	 * @param LiveMainKawadaSearchForm form
	 * @retrn LiveMainKawadaのSpecification
	 */
	public static Specification<LiveMainKawada> generateLiveSpecification(final LiveMainKawadaSearchForm form) {
		return new Specification<LiveMainKawada>() {
			@Override
			public Predicate toPredicate(Root<LiveMainKawada> root, CriteriaQuery<?> query, CriteriaBuilder cd) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が１かどうか判定
				if (form.getIsDelete() == 1) {

					//削除フラグ＝１を検索条件にする
					return cd.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合条件追加
				if (form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cd.equal(root.get("id"), form.getId());
					condition = getPredicate(cd, condition, newCondition);

				}
				if (!StringUtils.isEmpty(form.getSongTitle())) {

					//曲名を条件に追加
					form.setSongTitle(form.getSongTitle().trim());
					Predicate newCondition = cd.like(root.get("songTitle"), "%" + form.getSongTitle() + "%");
					condition = getPredicate(cd, condition, newCondition);

				}
				if (form.getAlbumId() != null && form.getAlbumId() != 0) {

					//収録アルバムを条件に追加
					Predicate newCondition = cd.equal(root.get("albumId"), form.getAlbumId());
					condition = getPredicate(cd, condition, newCondition);
				}
				if (form.getStyleId() != null && form.getStyleId() != 0) {

					//ライブスタイルを条件に追加
					Predicate newCondition = cd.equal(root.get("styleId"), form.getStyleId());
					condition = getPredicate(cd, condition, newCondition);
				}

				//削除フラグに条件を追加
				Predicate newCondition = cd.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cd, condition, newCondition);
				return condition;
			}

			/**
			 * 検索条件を結合する
			 * @param cd
			 * @param condition
			 * @param newCondition
			 * @return Predicate
			 */
			private Predicate getPredicate(CriteriaBuilder cd, Predicate condition, @NotNull Predicate newCondition) {
				if (condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cd.and(condition, newCondition);
				} else {

					//条件がまだ無い場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}
