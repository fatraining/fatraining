package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.mcuMainHayashi.CharacterSearchForm;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.McuMainHayashi;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.SexHayashi;
import jp.co.futureantiques.webapptraining.model.mcuHayashi.TypeHayashi;

	/**
	 * mcuMainHayashiのサービスインターフェース
	 *
	 * @author 林 重樹
	 */
	public interface McuMainHayashiService {

		/**
		 * 人種のエンティティのリストを取得する
		 *
		 * @return TypeHayashiEntityのリスト
		 */
		List<TypeHayashi> getListTypeHayashi();

		/**
		 * 性別のエンティティのリストを取得する
		 *
		 * @return SexHayashiEntityのリスト
		 */
		List<SexHayashi> getListSexHayashi();

		/**
		 * 検索条件を元にmcuMainHayashiのレコードのリストを取得する(Paging)
		 *
		 * @param CharacterSearchForm form
		 * @param Pageable pageable
		 * @return mcuMainHayashiのリスト
		 */
		Page<McuMainHayashi> getPageMcuMainHayashi(final CharacterSearchForm form, final Pageable pageable);

		/**
		 * 検索条件を元にmcuMainHayashiのレコードのリストを取得する
		 *
		 * @param CharacterSearchForm form
		 * @return mcuMainHayashiのリスト
		 */
		List<McuMainHayashi> getListMcuMainHayashi(final CharacterSearchForm form);

		/**
		 * IDをキーにmcuMainHayashiのレコードを取得する
		 *
		 * @param long id
		 * @return mcuMainHayashiのレコード
		 */
		McuMainHayashi getMcuMainHayashi(final long id);

		/**
		 * mcuMainHayashiにレコードを新規登録する
		 *
		 * @param characterInputForm form
		 * @return mcuMainHayashi
		 */
	//	McuMainHayashi insertMcuMainHayashi(final mcuMainHayashiInputForm form);

		/**
		 * mcuMainHayashiのレコードを更新する
		 *
		 * @param characterInputForm form
		 * @return mcuMainHayashi
		 */
	//	McuMainHayashi updateMcuMainHayashi(final mcuMainHayashiInputForm form);

		/**
		 * McuMainHayashiのレコードを論理削除する
		 *
		 * @param long id
		 */
	//	void deleteMcuMainHayashiById(final long id);

		/**
		 * mcuMainHayashiのレコードを物理削除する
		 *
		 * @param ArrayList<Long> ids
		 */
	//	void deleteMcuMainHayahiComp(final ArrayList<Long> ids);
	}



