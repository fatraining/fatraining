package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;

import com.example.demo.model.form.zelda.ZeldaDeleteForm;
import com.example.demo.model.form.zelda.ZeldaInputForm;
import com.example.demo.model.form.zelda.ZeldaSearchForm;
import com.example.demo.model.zeldaikeda.CompatibleModelIkeda;
import com.example.demo.model.zeldaikeda.GenreIkeda;
import com.example.demo.model.zeldaikeda.TimeSeriesIkeda;
import com.example.demo.model.zeldaikeda.ZeldaMainIkeda;

/**
 * ZeldaIkedaのインターフェース 
 */
public interface ZeldaIkedaService {
	
	/**
	 * ジャンルエンティティのリストを取得する
	 * @return GenreIkedaのリスト
	 */
	List<GenreIkeda> getListGenreIkeda();

	/**
	 * 時系列エンティティのリストを取得する
	 * @return TimeSeriesIkedaのリスト
	 */
	List<TimeSeriesIkeda> getListTimeSeriesIkeda();

	/**
	 * 対応機種エンティティのリストを取得する
	 * @return CompatibleModelIkedaのリスト
	 */
	List<CompatibleModelIkeda> getListCompatibleModelIkeda();

	/**
	 * 検索条件を元にZeldaMainIkedaのレコードのリストを取得する(Paging)
	 * @param Pageble pageble
	 * @return ZeldaMainIkedaのリスト
	 */
	Page<ZeldaMainIkeda> getPageZelda(final ZeldaSearchForm form, Pageable pageable);

	/**検索条件を元にZeldaMainIkedaのレコードのリストを取得する
	 * @param ZeldaSearchForm form
	 * @return ZeldaMainIkedaのリスト
	 */
	List<ZeldaMainIkeda> getListZelda(final ZeldaSearchForm form);

	/**
	 * IDをキーにZeldaMainIkedaのレコードを取得する 
	 * @param long id
	 * @return ZeldaMainIkedaのレコード
	 */
	ZeldaMainIkeda getZelda(final long id);

	/**
	 * ZeldaMainにレコードを新規登録する
	 * @param ZeldaInputForm form
	 * @return ZeldaMainIkeda
	 */
	ZeldaMainIkeda insertZelda(final ZeldaInputForm form);

	/**
	 * ZeldaMainIkedaのレコードを更新する
	 *@param ZeldaInputForm form
	 *@return ZeldaMainIkeda
	 */
	ZeldaMainIkeda updateZelda(final ZeldaInputForm form);

	/**
	 * ZeldaMainIkedaのレコードを倫理削除する
	 * @param long id
	 */
	void deleteZeldaById(final long id);

	/**
	 * ZeldaMainIkedaの論理削除したレコードを復元する
	 * @pram ArrayList<Long> ids
	 */
	void revokeZeldaById(final ArrayList<Long> ids);

	/**
	 * ZeldaMainIkedaのレコードを物理削除する
	 *@param ArrayList<Long> ids
	 */
	void deleteZeldaComp(final ArrayList<Long> ids);

	/**
	 * チェックボックスが未記入の場合エラーを表示する
	 * @param ArrayList<Long> ids
	 */
	void erroZelda(final ZeldaDeleteForm form, final Model model);
}
