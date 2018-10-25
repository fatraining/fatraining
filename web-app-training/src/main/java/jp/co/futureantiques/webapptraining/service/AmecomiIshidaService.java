package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.amecomiishida.AmecomiCharIshida;
import jp.co.futureantiques.webapptraining.model.amecomiishida.CompanyIshida;
import jp.co.futureantiques.webapptraining.model.amecomiishida.SideIshida;
import jp.co.futureantiques.webapptraining.model.form.amecomiIshida.AmecomiIshidaSearchForm;

/**
 * @author ishida
 * AmecomiIshidaのサービスインターフェース
 */
public interface AmecomiIshidaService {

	/**
	 * CompanyIshidaエンティティのリストを取得
	 * @return CompanyIshidaのリスト
	 */
	List<CompanyIshida> getListCompanyIshida();

	/**
	 * SideIshidaエンティティのリストを取得
	 * @return SideIshidaのリスト
	 */
	List<SideIshida> getListSideIshida();

	/**
	 * 検索条件をもとにAmecomiCharIshidaのレコードのリストを取得する（Paging)
	 * @param AmecomiIshidaSearchForm form
	 * @param Pageble pageable
	 * @return AmecomiCharIshidaのリスト
	 */
	Page<AmecomiCharIshida> getPageAmecomiIshida(final AmecomiIshidaSearchForm form,final Pageable pageable);

	/**
	 * 検索条件をもとにAmecomiCharIshidaのレコードのリストを取得する
	 * @param AmecomiIshidaSearchForm form
	 * @return AmecomiCharIshidaのリスト
	 */
	List<AmecomiCharIshida> getListAmecomiIshida(final AmecomiIshidaSearchForm form);

	/**
	 * IDをキーにレコードを取得する
	 * @param long id
	 * @return AmecomiCharIshidaのレコード
	 */
	AmecomiCharIshida getAmecomiIshida(final long id);

//	/**
//	 * IDをもとにレコードを論理削除する。
//	 * @param long id
//	 */
//	void deleteAmecomiCharIshidaById(final long id);

}