package jp.co.futureantiques.webapptraining.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki.PokemonJsuzukiSearchForm;
import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.PokemonMainJsuzuki;


public class PokemonJsuzukiSpecification {
	/**
	 *検索条件生成の実装
	 *
	 * @param PokemonJsuzukiSearchForm form
	 * @return PokemonMainJsuzukiのSpecification
	 */
	public static Specification<PokemonMainJsuzuki> generatePokemonJsuzukiSpecification(final PokemonJsuzukiSearchForm form){
		return new Specification<PokemonMainJsuzuki>() {
			@Override
			public Predicate toPredicate(Root<PokemonMainJsuzuki>root,CriteriaQuery<?> query,CriteriaBuilder cb) {

				//検索条件
				Predicate condition = null;

				//削除フラグON用が1かどうか判定
				if(form.getIsDelete() == 1) {

					//削除フラグ=1を検索条件にする
					return cb.equal(root.get("delFlg"),1);
				}

				//条件が入力されている場合条件追加
				if(form.getId() != null) {

					//IDを条件に追加
					Predicate newCondition = cb.equal(root.get("id"),form.getId());
					condition = getPredicate(cb,condition,newCondition);
				}
				if(!StringUtils.isEmpty(form.getPokemonName())) {

					//ポケモンネームを条件に追加
					form.setPokemonName(form.getPokemonName().trim());
					final String space = " ";

					// 半角スペースと全角スペースの組み合わせのパターンを表す
					final String spacesPattern = "[\\s　]+";

					// 以上のパターンにマッチした部分を単一の半角スペースに変換する
					final String monoSpaceQuery = form.getPokemonName().replaceAll(spacesPattern, space);

					// 半角スペースでクエリをsplitする
					String[] pokemonNames = monoSpaceQuery.split("\\s");
					String pokemonName = "";
					for(int i = 0;i < pokemonNames.length;i++ ) {
						pokemonName = pokemonName + pokemonNames[i];
						Predicate newCondition = cb.or(cb.like(root.get("pokemonName"),"%" + pokemonName + "%"));
						condition = getPredicate(cb,condition,newCondition);
					}
				}

				if(form.getAreaId() != null && form.getAreaId() != 0) {

					//登場地方を条件に追加
					Predicate newCondition = cb.equal(root.get("areaId"),form.getAreaId());
					condition = getPredicate(cb,condition,newCondition);
				}

				if(form.getType1Id() != null && form.getType1Id() != 0) {

					//タイプ1を条件に追加
					Predicate newCondition =  cb.or(cb.equal(root.get("type1Id"),form.getType1Id()),cb.equal(root.get("type2Id"),form.getType1Id()));
					condition = getPredicate(cb,condition,newCondition);
				}
				if(form.getType2Id() != null && form.getType2Id() != 0) {

					//タイプ2を条件に追加
					Predicate newCondition = cb.or(cb.equal(root.get("type2Id"),form.getType2Id()),cb.equal(root.get("type1Id"),form.getType2Id()));
					condition = getPredicate(cb,condition,newCondition);
				}


				//削除フラグを条件に追加
				Predicate newCondition = cb.equal(root.get("delFlg"),0);
				condition = getPredicate(cb,condition,newCondition);
				return condition;
			}

			/**
			 *検索条件を結合する
			 *
			 *@param cd
			 *@param condition
			 *@param newCondition
			 *@returm Predicate
			 */
			private Predicate getPredicate(CriteriaBuilder cb, Predicate condition, @NotNull Predicate newCondition) {
				if (condition != null) {

					//すでに条件がある場合ANDで結合する
					condition = cb.and(condition,newCondition);
				} else {

					//条件がまだ無い場合先頭の条件になる
					condition = newCondition;
				}
				return condition;
			}
		};
	}


}
