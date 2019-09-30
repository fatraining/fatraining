package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.animeNagatake.AnimeMainNagatake;
import jp.co.futureantiques.webapptraining.model.form.animeNagatake.AnimeNagatakeSearchForm;

/**
 * AnimeMainNagatakeの検索条件を生成するクラス
 *
 * @author future
 * */

public class AnimeNagatakeSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param AnimeNagatakeSerchForm form
	 * @return AnimeMainNagatakeのspecification
	 * */

	public static Specification<AnimeMainNagatake> generateAnimeSpecification(final AnimeNagatakeSearchForm form) {

		return new Specification<AnimeMainNagatake>() {

			@Override
			public Predicate toPredicate(Root<AnimeMainNagatake> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか
				if (form.getIsDelete() == 1) {

					//削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				//条件が入力されている場合条件追加
				if (form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if (!StringUtils.isEmpty(form.getAnimeTitle())) {

					//アニメタイトルを条件追加
					form.setAnimeTitle(form.getAnimeTitle().trim());
					Predicate newCondition = cb.like(root.get("animeTitle"), "%" + form.getAnimeTitle() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getGenreId() != null && form.getGenreId() != 0) {

					//ジャンルを条件に追加
					Predicate newCondition = cb.equal(root.get("genreId"), form.getGenreId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getStudioId() != null && form.getStudioId() != 0) {

					//スタジオを条件に追加
					Predicate newCondition = cb.equal(root.get("studioId"), form.getStudioId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getVoiceactorId() != null && form.getVoiceactorId() != 0) {

					//声優を条件に追加
					Predicate newCondition = cb.equal(root.get("voiceactorId"), form.getVoiceactorId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if (form.getSourceId() != null && form.getSourceId() != 0) {

					//出典を条件に追加
					Predicate newCondition = cb.equal(root.get("sourceId"), form.getSourceId());
					condition = getPredicate(cb, condition, newCondition);
				}

				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition = getPredicate(cb, condition, newCondition);
				return condition;
			}

			/**
			 * 検索条件結合する
			 *
			 *@param cb
			 *@param condition
			 *@param newCondition
			 *@return Predicate
			 * */

			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if (condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cb.and(condition, newCondition);
				} else {

					//条件がまだない場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}
}
