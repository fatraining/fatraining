package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.thymeleaf.util.StringUtils;

import jp.co.futureantiques.webapptraining.constant.CommonConst;
import jp.co.futureantiques.webapptraining.model.GuiterFujimoto.GuiterMainFujimoto;
import jp.co.futureantiques.webapptraining.model.form.guiterFujimoto.GuiterSearchForm;

/**GuiterMainの検索条件を生成するクラス
*
*@author future Fujimoto
*/

public class GuiterFujimotoSpecification{

	/**
	 * 検索条件生成の実装
	 *
	 * @param GuiterFujimotoSearchForm form
	 * @return GuiterMainのSpecification
	 */

	public static Specification<GuiterMainFujimoto> generateGuiterSpecification(final GuiterSearchForm form){
		return new Specification<GuiterMainFujimoto>() {
			@Override
			public Predicate toPredicate(Root<GuiterMainFujimoto> root,CriteriaQuery<?> query,javax.persistence.criteria.CriteriaBuilder cb) {

					//検索条件
					Predicate condition=null;

					//削除フラグOn用が１かどうか判定
					if(form.getIsDelete()==1) {
						//削除フラグ＝１を検索条件にする
						return cb.equal(root.get("delFlg"),CommonConst.DELETE_FLG_ON);
					}

					//条件が入力されている場合条件追加
					if(form.getId()!=null) {

						//IDを条件に追加
						Predicate newCondtition =cb.equal(root.get("id"),form.getId()) ;
						condition = getPredicate(cb,condition,newCondtition);
					}
					if(!StringUtils.isEmpty(form.getName())) {
						//ギター名を条件に追加
						form.setName(form.getName().trim());
						// guiterMainFujimoto.acoName LIKE '%sdfgh%'
						Predicate newCondition=cb.like(root.get("aconame"),"%"+form.getName()+"%");
						condition=getPredicate(cb,condition,newCondition);
					}
					if (form.getCompanyId()!=null && form.getCompanyId()!=0) {
						//会社を条件に追加
						Predicate newCondition = cb.equal(root.get("companyId"), form.getCompanyId());
						condition = getPredicate(cb, condition, newCondition);
					}
						if(form.getWoodId()!=null && form.getWoodId()!=0) {
						//木材を条件に追加
							Predicate newCondition = cb.equal(root.get("woodId"), form.getWoodId());
							condition = getPredicate(cb, condition, newCondition);
						}
						//削除ふらぐを条件に追加
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