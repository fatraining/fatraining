package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.championTiba.ChampionMainTiba;
import jp.co.futureantiques.webapptraining.model.form.championTiba.ChampionTibaSearchForm;

/**
 * ChanpionMainTibaの検索条件を生成するクラス
 * ここで検索条件を生成しているため、ここを間違えると正常に検索結果が表示されない。
 * @author future
 */
public class ChampionTibaSpecification {

	/**
	 * 検索条件生成の実装
	 *
	 * @param ChampionTibaSearchForm form
	 * @return ChampionMainTibaのSpecification
	 */
	public static Specification<ChampionMainTiba> generateChampionSpecification(final ChampionTibaSearchForm form){
		return new Specification<ChampionMainTiba>() {
			@Override
			public Predicate toPredicate(Root<ChampionMainTiba> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

				// 検索条件
				Predicate condition=null;

				// 削除フラグON用が1かどうか判定
				if(form.getIsDelete()==1) {

					// 削除フラグ＝1を検索条件にする
					return  cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}

				// 条件が入力されている場合条件追加
				if(form.getId()!=null) {

					// IDを条件に追加
					Predicate newCondition=cb.equal(root.get("id"), form.getId());
					condition=getPredicate(cb, condition, newCondition);
				}
				if(!StringUtils.isEmpty(form.getChampionName())) {

					// チャンピオン名を条件に追加
					form.setChampionName(form.getChampionName().trim());
					Predicate newCondition=cb.like(root.get("championName"), "%"+form.getChampionName()+"%");
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getClassId()!=null&&form.getClassId()!=0) {

					// 階級を条件に追加
					Predicate newCondition=cb.equal(root.get("classId"), form.getClassId());
					condition=getPredicate(cb, condition, newCondition);
				}
				if(form.getCountryId()!=null&&form.getCountryId()!=0) {

					// 国名を条件に追加
					Predicate newCondition=cb.equal(root.get("countryId"), form.getCountryId());
					condition=getPredicate(cb, condition, newCondition);
				}


				// 削除フラグを条件に追加
				Predicate newCondition=cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_OFF);
				condition=getPredicate(cb, condition, newCondition);
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
				if(condition!=null) {
					condition=cb.and(condition, newCondition);
				}else {
					condition=newCondition;
				}
				return condition;
			}
		};
	}
}
