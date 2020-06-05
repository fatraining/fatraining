package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.comicYanai.ComicMainYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.GenreYanai;
import jp.co.futureantiques.webapptraining.model.comicYanai.PubcoYanai;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiInputForm;
import jp.co.futureantiques.webapptraining.model.form.comicYanai.ComicYanaiSearchForm;
import jp.co.futureantiques.webapptraining.repository.comicYanai.ComicMainYanaiRepository;
import jp.co.futureantiques.webapptraining.repository.comicYanai.GenreYanaiRepository;
import jp.co.futureantiques.webapptraining.repository.comicYanai.PubcoYanaiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ComicYanaiSpecification;
import jp.co.futureantiques.webapptraining.service.ComicYanaiService;

/** ComicYanaiserviceの実装クラス
 * @author yanai
 *
 */
@Service
public class ComicYanaiServiceImpl implements ComicYanaiService {

	/** ComicMainYanaiリポジトリ*/
	private final ComicMainYanaiRepository comicMainYanaiRepository;
	/**GenreYanaiのリポジトリ */
	private final GenreYanaiRepository genreYanaiRepository;
	/**PubcoYanaiのリポジトリ*/
	private final PubcoYanaiRepository pubcoYanaiRepository;

	/**コンストラクタ
	 *
	 * @param comicMainYanaiRepository
	 * @param genreYanaiRepository
	 * @param pubcoYanaiRepository
	 */
	ComicYanaiServiceImpl(ComicMainYanaiRepository comicMainYanaiRepository, GenreYanaiRepository genreYanaiRepository,
			PubcoYanaiRepository pubcoYanaiRepository) {
		this.comicMainYanaiRepository = comicMainYanaiRepository;
		this.genreYanaiRepository = genreYanaiRepository;
		this.pubcoYanaiRepository = pubcoYanaiRepository;
	}

	@Override
	public List<GenreYanai> getListGenre() {
		//GenreYanaiテーブルのレコードをID順に取得する
		return genreYanaiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public List<PubcoYanai> getListPubco() {
		// PubcoYanaiテーブルのレコードをID順に取得する
		return pubcoYanaiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<ComicMainYanai> getPageComic(ComicYanaiSearchForm form, Pageable pageable) {
		// 検索条件を生成しConicMainYanaiテーブルのレコードを取得する
		return comicMainYanaiRepository.findAll(ComicYanaiSpecification.generateComicYanaiSpecification(form),
				pageable);
	}

	@Override
	public List<ComicMainYanai> getListComic(ComicYanaiSearchForm form) {
		// 検索条件を生成しComicMainYanaiテーブルのレコードを取得する
		return comicMainYanaiRepository.findAll(ComicYanaiSpecification.generateComicYanaiSpecification(form));
	}

	@Override
	public ComicMainYanai getComic(long id) {
		// ComicMainYanaiテーブルを主キー検索する
		return comicMainYanaiRepository.findOne(id);
	}

	@Override
	public ComicMainYanai insertComic(ComicYanaiInputForm form) {
		// ComicMainYanaiテーブルに新規でデータを登録する
		final ComicMainYanai comicMainYanai = form.convertToComicMainYanaiForInsert();
		return comicMainYanaiRepository.save(comicMainYanai);
	}

	@Override
	public ComicMainYanai updateComic(ComicYanaiInputForm form) {
		// 更新対象のレコードを取得する。
		ComicMainYanai comicMainYanai = comicMainYanaiRepository.findOne((long) form.getId());
		if (comicMainYanai != null) {

			// 更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(comicMainYanai.getUpdateDate()))) {

				// チェックOKの場合、更新
				comicMainYanai = form.convertToComicMainYanaiForUpdate(comicMainYanai);
				return comicMainYanaiRepository.saveAndFlush(comicMainYanai);
			}
		}

		return null;
	}

	@Override
	public void deleteComicById(long id) {
		// 更新対象のレコードを取得する
		ComicMainYanai comicMainYanai = comicMainYanaiRepository.findOne(id);
		if (comicMainYanai != null) {

			// 更新対象のレコードが存在する場合、削除フラグを1にする
			comicMainYanaiRepository.delete(id);
		}
	}

	@Override
	public void deleteComicComp(ArrayList<Long> ids) {
		// 対象のレコードを削除する
		comicMainYanaiRepository.deleteComp(ids);
	}

}
