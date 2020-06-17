package jp.co.futureantiques.webapptraining.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jp.co.futureantiques.webapptraining.model.comicMiyoshi.ComicMainMiyoshi;
import jp.co.futureantiques.webapptraining.model.comicMiyoshi.MagazineMiyoshi;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiInputForm;
import jp.co.futureantiques.webapptraining.model.form.comicMiyoshi.ComicMiyoshiSearchForm;
import jp.co.futureantiques.webapptraining.repository.comicMiyoshi.ComicMainMiyoshiRepository;
import jp.co.futureantiques.webapptraining.repository.comicMiyoshi.MagazineMiyoshiRepository;
import jp.co.futureantiques.webapptraining.repository.specification.ComicMiyoshiSpecification;
import jp.co.futureantiques.webapptraining.service.ComicMiyoshiService;

/**
 * ComicMiyoshiのサービス実装クラス
 * @author Miyoshi
 */
@Service
public class ComicMiyoshiServiceImpl implements ComicMiyoshiService {

	/** ComicMainMiyoshiリポジトリ */
	private final ComicMainMiyoshiRepository comicMainMiyoshiRepository;

	/** MagazineMiyoshiリポジトリ */
	private final MagazineMiyoshiRepository magazineMiyoshiRepository;

	/**
	 * コンストラクタ
	 * @param ComicMainMiyoshiRepository comicMainMiyoshiRepository
	 * @param MagazineMiyoshiRepository  magazineMiyoshiRepository
	 */
	@Autowired
	public ComicMiyoshiServiceImpl(ComicMainMiyoshiRepository comicMainMiyoshiRepository,
			MagazineMiyoshiRepository magazineMiyoshiRepository) {
		this.comicMainMiyoshiRepository = comicMainMiyoshiRepository;
		this.magazineMiyoshiRepository = magazineMiyoshiRepository;
	}

	@Override
	public List<MagazineMiyoshi> getListMagazineMiyoshi() {

		//MagazineMiyoshiテーブルのレコードをID順に取得する
		return magazineMiyoshiRepository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}

	@Override
	public Page<ComicMainMiyoshi> getPageComic(final ComicMiyoshiSearchForm form, final Pageable pageable) {

		//検索条件を生成しComicMainMiyoshiテーブルのレコードを取得する
		return comicMainMiyoshiRepository.findAll(
				ComicMiyoshiSpecification.generateComicMiyoshiSpecification(form), pageable);
	}

	@Override
	public List<ComicMainMiyoshi> getListComic(final ComicMiyoshiSearchForm form) {

		//検索条件を生成しComicMainMiyoshiテーブルのレコードを取得する
		return comicMainMiyoshiRepository.findAll(
				ComicMiyoshiSpecification.generateComicMiyoshiSpecification(form));
	}

	@Override
	public ComicMainMiyoshi getComic(final long id) {

		//ComicMainMiyoshiテーブルを主キー検索する
		return comicMainMiyoshiRepository.findOne(id);
	}

	@Override
	public ComicMainMiyoshi insertComic(final ComicMiyoshiInputForm form) {

		//ComicMainMiyoshiテーブルに新規でデータを登録する
		final ComicMainMiyoshi comicMainMiyoshi = form.convertToComicMainMiyoshiForInsert();
		return comicMainMiyoshiRepository.save(comicMainMiyoshi);
	}

	@Override
	public ComicMainMiyoshi updateComic(final ComicMiyoshiInputForm form) {

		//更新対象のレコードを取得する
		ComicMainMiyoshi comicMainMiyoshi = comicMainMiyoshiRepository.findOne((long) form.getId());
		if (comicMainMiyoshi != null) {

			//更新対象のレコードが存在する場合排他チェック
			if (form.getUpdateDate().equals(String.valueOf(comicMainMiyoshi.getUpdateDate()))) {

				//チェックOKの場合、更新
				comicMainMiyoshi = form.convertToComicMainMiyoshiForUpdate(comicMainMiyoshi);
				return comicMainMiyoshiRepository.saveAndFlush(comicMainMiyoshi);
			}
		}
		return null;
	}

	@Override
	public void deleteComicById(final long id) {

		//更新対象のレコードを取得する
		ComicMainMiyoshi comicMainMiyoshi = comicMainMiyoshiRepository.findOne(id);
		if (comicMainMiyoshi != null) {

			//更新対象のレコードが存在する場合、削除フラグを1にする
			comicMainMiyoshiRepository.delete(id);
		}
	}

	@Override
	public void deleteComicComp(final ArrayList<Long> ids) {

		//対象のレコードを削除する
		comicMainMiyoshiRepository.deleteComp(ids);
	}

}
