package jp.co.futureantiques.webapptraining.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.futureantiques.webapptraining.model.form.jojoShirasaka.JojoStandSearchForm;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoAppearanceShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoMainShirasaka;
import jp.co.futureantiques.webapptraining.model.jojoShirasaka.JojoSexShirasaka;

/**
 * JojoShirasakaのサービスインターフェース
 *
 *
 */
public interface JojoShirasakaService {

	/**
	 * エンティティのリストを取得する
	 *
	 */
	List<JojoSexShirasaka> getListJojoSex();


	List<JojoAppearanceShirasaka> getListJojoAppearance();

	/**
	 * 検索条件を元にJojoMainShirasakaのレコードのリストを取得する(Paging)
	 *
	 * @param JojoStandSearchForm form
	 * @param Pageable pageable
	 * @return JojoMainのリストクラスの定義
	 */
	Page<JojoMainShirasaka> getPageJojo(final JojoStandSearchForm form, final Pageable pageable);

	/**
	 * 検索条件を元にJojoMainShirasakaのレコードのリストを取得する
	 *
	 * @param JojoStandSearchForm form
	 * @return JojoMainShirasakaのリスト
	 */
	List<JojoMainShirasaka> getListJojoMain(final JojoStandSearchForm form);

	/**
	 * IDをキーにJojoMainShirasakaのレコードを取得する
	 *
	 * @param long id
	 * @return JojoMainShirasakaのレコード
	 */
	JojoMainShirasaka getJojoStand(final long id);






	/**
	 * JojoMainShirasakaにレコードを新規登録する
	 *
	 * @param JojoStandInputForm form
	 * @return MovieMain

	JojoMainShirasaka insertJojo(final JojoStandInputForm form);

	/**
	 * MovieMainのレコードを更新する
	 *
	 * @param MovieSampleInputForm form
	 * @return MovieMain

	MovieMain updateMovie(final MovieSampleInputForm form);

	/**
	 * MovieMainのレコードを論理削除する
	 *
	 * @param long id

	void deleteMovieById(final long id);

	/**
	 * MovieMainのレコードを物理削除する
	 *
	 * @param ArrayList<Long> ids

	void deleteMovieComp(final ArrayList<Long> ids);
	 */
}