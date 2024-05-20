package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.catHayashichika.CatMainHayashichika;
import com.example.demo.model.catHayashichika.FromHayashichika;
import com.example.demo.model.catHayashichika.SizeHayashichika;
import com.example.demo.model.catHayashichika.TypeHayashichika;
import com.example.demo.model.form.catHayashichika.CatHayashichikaInputForm;
import com.example.demo.model.form.catHayashichika.CatHayashichikaSearchForm;

/**
 *CatHayashichikaのインターフェース
 *@author future 
 */

public interface CatHayashichikaService {

	/**
	 * 毛種エンティティのリストを取得する
	 * 
	 * @return TypeHayashichikaEntityのリスト
	 */
	List<TypeHayashichika> getListTypeHayashichika();

	/**
	 * 体型エンティティのリストを取得する
	 * @return CatSizeEntityのリスト
	 */
	List<SizeHayashichika> getListSizeHayashichika();

	/**
	 * 原産国エンティティのリストを取得する
	 * @return CatFromEntityのリスト
	 */
	List<FromHayashichika> getListFromHayashichika();

	/**
	 * 検索条件を元にCatMainのレコードリストを取得する(Paging)
	 * 
	 * @param CatHayashichikaForm form
	 * @return CatMainのリスト
	 */
	Page<CatMainHayashichika> getPageCat(final CatHayashichikaSearchForm form, Pageable pageable);

	/**検索条件を元にCatMainのレコードを取得する
	 * @param CatHayashichikaSearchForm form
	 * @return CatMainのリスト
	 */
	List<CatMainHayashichika> getListCat(final CatHayashichikaSearchForm form);

	/**
	 * IDをキーにCatMainのレコードを取得する
	 * 
	 * @param long id
	 * @return CatMainのレコード
	 */
	CatMainHayashichika getCat(final long id);

	/**
	 * CatMainにレコードを新規登録する
	 * @param CatHayashichikaInputForm form
	 * @return CatMain
	 */
	CatMainHayashichika insertCat(final CatHayashichikaInputForm form);

	/**
	 * CatMainのレコードを更新する
	 *@param CatHayashichikaInputForm form
	 *@return CatMain
	 */
	CatMainHayashichika updateCat(final CatHayashichikaInputForm form);

	/**
	 * CatMainのレコードを倫理削除する
	 * @param long id
	 */
	void deleteCatById(final long id);

	/**
	 * CatMainのレコードを物理削除する
	 *@param ArrayList<Long> ids
	 */
	void deleteCatComp(final ArrayList<Long> ids);

}
