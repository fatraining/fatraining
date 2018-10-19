package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.resipeishikawa.ResipeIshikawaSearchForm;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.GenreIshikawa;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.ResipeMainIshikawa;
import jp.co.futureantiques.webapptraining.model.resipeishikawa.VegetableIshikawa;


/**
 * ResipeIshikawaのサービスインターフェース
 *
 * @author t.ishikawa
 */
public interface ResipeIshikawaService {

	/**
	 *野菜エンティティのリストを取得する
	 *
	 *@return Vegetableエンティティのリスト
	 */
	List<VegetableIshikawa> getListVegetable();

	/**
	 *ジャンルエンティティのリストを取得する
	 *
	 *@return Genreエンティティのリスト
	 */
	List<GenreIshikawa>getListGenre();

	/**
	 *検索結果を元にResipeMainのレコードリストを取得する(paging)
	 *
	 *@param resipeIshikawaSearchForm form
	 *@param Pageable pageable
	 *@return ResipeMainのリスト
	 */
	Page<ResipeMainIshikawa> getPageResipe(final ResipeIshikawaSearchForm form,final Pageable pageable);

	/**
	 *検索結果を元にresipeMainのレコードリストを取得する
	 *
	 *@param resipeIshikawaSearchForm form
	 *@return ResipeMainのリスト
	 *
	 */
	List<ResipeMainIshikawa> getListResipe(final ResipeIshikawaSearchForm form);

	/**
	 *IDをキーにresipeMainのレコードを取得する
	 *
	 *@param long  id
	 *@return ResipeMainのレコード
	 */
	ResipeMainIshikawa getResipe(final long id);
}
