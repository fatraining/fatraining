package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.mlbUezu.MLBTeamSearchForm;
import jp.co.futureantiques.webapptraining.model.mlbUezu.MlbMainUezu;

/**
 * MLBMainUezuの検索条件を生成するクラス
 * ここで検索条件を生成しているため、ここを間違えると正常に検索結果が表示されない。
 * @author future
 */
public class MLBUezuSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param MLBTeamSearchForm form
	 * @return MLBMainUezuのSpecification
	 */
	public static Specification<MlbMainUezu> generateMLBSpecification(final MLBTeamSearchForm form) {
		return new Specification<MlbMainUezu>() {
			@Override
			public Predicate toPredicate(Root<MlbMainUezu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

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
				if (!StringUtils.isEmpty(form.getTeamName())) {

					// 球団名を条件に追加
					form.setTeamName(form.getTeamName().trim());
					Predicate newCondition = cb.like(root.get("teamName"), "%" + form.getTeamName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getLeagueId() != null && form.getLeagueId() != 0) {

					// リーグを条件に追加
					Predicate newCondition = cb.equal(root.get("leagueId"), form.getLeagueId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getDistrictId() != null && form.getDistrictId() != 0) {

					// 地区を条件に追加
					Predicate newCondition = cb.equal(root.get("districtId"), form.getDistrictId());
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