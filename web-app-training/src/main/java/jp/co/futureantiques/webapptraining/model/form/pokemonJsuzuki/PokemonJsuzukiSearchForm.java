package jp.co.futureantiques.webapptraining.model.form.pokemonJsuzuki;


import jp.co.futureantiques.webapptraining.model.pokemonJsuzuki.PokemonMainJsuzuki;
import lombok.Data;

@Data
public class PokemonJsuzukiSearchForm {


		/**ID*/
		private Integer id;

		/**ポケモンネーム*/
		private String pokemonName;

		/**登場地方ID*/
		private Integer areaId;

		/**タイプ1ID*/
		private Integer type1Id;

		/**タイプ2ID*/
		private Integer type2Id;


		/**削除フラグ*/
		private int isDelete;

		/**
		 *
		 * 各フィールドに値を設定する
		 *
		 * @param pokemonMainJsuzuki
		 */
		public void setValues(PokemonMainJsuzuki pokemonMainJsuzuki) {
			this.setId((int)pokemonMainJsuzuki.getId());
			this.setPokemonName(pokemonMainJsuzuki.getPokemonName());
			this.setAreaId(pokemonMainJsuzuki.getAreaId());
			this.setType1Id(pokemonMainJsuzuki.getType1Id());
			this.setType2Id(pokemonMainJsuzuki.getType2Id());

		}


}
