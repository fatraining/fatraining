package jp.co.futureantiques.webapptraining.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto.SaizeriyaKurimotoInputForm;
import jp.co.futureantiques.webapptraining.model.form.saizeriyaKurimoto.SaizeriyaKurimotoSearchForm;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.CategoryKurimoto;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.PriceKurimoto;
import jp.co.futureantiques.webapptraining.model.saizeriyaKurimoto.SaizeriyaMenuMainKurimoto;

//SaizeriyaKurimotoのサービスインターフェース
//@author kurimoto

public interface SaizeriyaKurimotoService {

	//カテゴリエンティティのリストを取得する
	//@return CategoryEntityのリスト

	List<CategoryKurimoto> getListCategoryKurimoto();

	//価格帯エンティティのリストを取得する
	//@return PriceEntityのリスト

	List<PriceKurimoto> getListPriceKurimoto();

	//検索条件を元にMenuKurimotoのレコードのリストを取得する(Paging)
	//@param SaizeriyaKurimotoSearchForm form
	//@param Pageable pageable
	//@return MenuKurimotoのリスト

	Page<SaizeriyaMenuMainKurimoto> getPageSaizeriyaKurimoto(final SaizeriyaKurimotoSearchForm form, final Pageable pageable);

	//検索条件を元にMenuKurimotoのレコードのリストを取得する
	//@param SaizeriyaKurimotoSearchForm form
	//@return MenuKurimotoのリスト

	List<SaizeriyaMenuMainKurimoto> getListSaizeriyaKurimoto(final SaizeriyaKurimotoSearchForm form);

	//IDをキーにMenuKurimotoのレコードを取得する
	//@param long id
	//@return MenuKurimotoのレコード

	SaizeriyaMenuMainKurimoto getSaizeriyaKurimoto(final long id);

	//MenuKurimotoにレコードを新規登録する
	//@param SaizeriyaKurimotoInputForm form
	//@return MenuKurimoto

	SaizeriyaMenuMainKurimoto insertSaizeriyaKurimoto(final SaizeriyaKurimotoInputForm form);

	//MenuKurimotoのレコードを更新する
	//@param SaizeriyaKurimotoInputForm form
	//@return MenuKurimoto

	<SaizeriyaInputForm> SaizeriyaMenuMainKurimoto updateSaizeriyaKurimoto(final SaizeriyaKurimotoInputForm form);

	//MenuKurimotoのレコードを論理削除する
	//@param long id

	void deleteSaizeriyaKurimotoById(final long id);

	//MenuKurimotoのレコードを物理削除する
	//@param ArrayList<Long> ids

	void deleteSaizeriyaKurimotoComp(final ArrayList<Long> ids);
}