package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.DanmachiWang.DanmachiMain;
import jp.co.futureantiques.webapptraining.model.form.DanmachiWang.DanmachiSearchForm;

/**
 * Danmachiの検索条件を生成するクラス
 *
 * @author Wang
 */
public class DanmachiSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param Danmachi form
	 * @return DanmachiのSpecification
	 */
	public static Specification<DanmachiMain> generateDanmachiSpecification(
			final DanmachiSearchForm form) {
		return new Specification<DanmachiMain>() {
			@Override
			public Predicate toPredicate(Root<DanmachiMain> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition = null;

				// 削除フラグON用が1かどうか判定
				if (form.getIsDelete() == 1) {

					// 削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlg"), 1);
				}

				// 条件が入力されている場合条件追加
				if (form.getId() != null) {

					// IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}

				if (!StringUtils.isEmpty(form.getName())) {

					// ダンまち名を条件に追加
					form.setName(form.getName().trim());
					final String space = " ";

					// 半角スペースと全角スペースの組み合わせのパターンを表す
					final String spacesPattern = "[\\s　]+";

					// 以上のパターンにマッチした部分を単一の半角スペースに変換する
					final String monoSpaceQuery = form.getName().replaceAll(spacesPattern, space);

					// 半角スペースでクエリをsplitする
					String[] names = monoSpaceQuery.split("\\s");
					String name = "";
					for (int i = 0; i < names.length; i++) {
						name = name + names[i];
						Predicate newCondition = cb.or(cb.like(root.get("name"), "%" + name + "%"));
						condition = getPredicate(cb, condition, newCondition);
					}
				}

				if (form.getFamiId() != null && form.getFamiId() != 0) {

					// ファミリを条件に追加
					Predicate newCondition = cb.equal(root.get("famiId"), form.getFamiId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if (form.getRaceId() != null && form.getRaceId() != 0) {

					// ファミリを条件に追加
					Predicate newCondition = cb.equal(root.get("raceId"), form.getRaceId());
					condition = getPredicate(cb, condition, newCondition);
				}

				// 削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"), 0);
				condition = getPredicate(cb, condition, newCondition);
				return condition;
			}
			/**
			 * 検索条件を結合する
			 *
			 * @param cd
			 * @param condition
			 * @param newCondition
			 * @returm Predicate
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
