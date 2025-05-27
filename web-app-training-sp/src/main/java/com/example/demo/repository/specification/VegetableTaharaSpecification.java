package com.example.demo.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.example.demo.constant.CommonConst;
import com.example.demo.model.form.vegetabletahara.VegetableTaharaSearchForm;
import com.example.demo.model.vegetabletahara.VegetableMainTahara;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;

/**
 * VegetableMainTaharaの検索条件を生成するクラス
 *
 * @author future
 */
public class VegetableTaharaSpecification {
	
	 /**
	  * 検索条件生成の実装
	  *
	  * @param VegetableTaharaSearchForm form
	  * @return VegetableMainTaharaのSpecification
	  */
	public static Specification<VegetableMainTahara> generateVegetableSpecification(final VegetableTaharaSearchForm form){
		       //↓Repositoryの補助。動的に変わるSQL文を、if文を駆使してJavaで記述している
		return new Specification<VegetableMainTahara>() {
			@Override
			public Predicate toPredicate(Root<VegetableMainTahara> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				//検索条件
				Predicate condition = null;
				
				//削除フラグON用が1かどうか判定
				if(form.getIsDelete() == 1) {
					
					//削除フラグ＝1を検索条件にする where del_flg = 1
					return cb.equal(root.get("delFlg"), CommonConst.DELETE_FLG_ON);
				}
				
				//条件が入力されている場合、条件追加
				if(form.getId() != null) {
					
					//IDを条件に追加 id = [入力されたid]
					Predicate newCondition = cb.equal(root.get("id"), form.getId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if(!StringUtils.isEmpty(form.getVegetableName())) {
					
					//野菜の名前を条件に追加 like vegetableName %[入力された野菜名]%
					form.setVegetableName(form.getVegetableName().trim());
					Predicate newCondition = cb.like(root.get("vegetableName"), "%" + form.getVegetableName() + "%");
					condition = getPredicate(cb, condition, newCondition);
				}
				
				if(form.getCategoryId() != null && form.getCategoryId() != 0) {
					
					//カテゴリーを条件に追加
					Predicate newCondition = cb.equal(root.get("categoryId"), form.getCategoryId());
					condition = getPredicate(cb, condition, newCondition);
				}
				if(form.getAreaId() != null && form.getAreaId() != 0) {
					
					//国内最大生産地を条件に追加
					Predicate newCondition = cb.equal(root.get("areaId"), form.getAreaId());
					condition = getPredicate(cb, condition, newCondition);
				}
				
				//削除フラグを条件に追加
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
			 * */
			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if(condition != null) {
					
					//すでに条件がある場合、ANDで結合する
					condition = cb.and(condition, newCondition);
					
				} else {
					
					//条件がまだない場合、先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
		
	}

}
