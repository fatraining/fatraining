package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandSearchForm;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoMainShirasaka;

/**
 * JojoMainShirasakaの検索条件を生成するクラス
 *
 */
public class JojoStandSearchSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param JojoStandSearchForm form
	 * @return JojoMainShirasakaのSpecification
	 */
	public static Specification<JojoMainShirasaka> generateJojoSpecification(final JojoStandSearchForm form) {
		return new Specification<JojoMainShirasaka>() {
			@Override
			public Predicate toPredicate(Root<JojoMainShirasaka> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件(SQLのWHERE以降のコード)
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					// 削除フラグ＝1を検索条件にする
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				// 条件が入力されている場合条件追加
				if (form.getStandId() != null) {
					// IDを条件に追加（cdが演算子入っているやつ）
					//.equal(カラム名, 入力値)→カラム名と入力値が一致するやつ
					Predicate newCondition = cb.equal(root.get("standId"), form.getStandId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// スタンド名を条件に追加
				if (!StringUtils.isEmpty(form.getStandName())) {
					form.setStandName(form.getStandName().trim());
					//.like(カラム名, 入力値)→カラム名の中に入力値含まれているものがあるか
					Predicate newCondition = cb.like(root.get("standName"), "%" + form.getStandName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}

				// 性別を条件に追加
				if (form.getSexId() != null && form.getSexId() != 0) {
					Predicate newCondition = cb.equal(root.get("sexId"), form.getSexId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// 登場部を条件に追加
				if (form.getAppearanceId() != null && form.getAppearanceId() != 0) {
					Predicate newCondition = cb.equal(root.get("appearanceId"), form.getAppearanceId());
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